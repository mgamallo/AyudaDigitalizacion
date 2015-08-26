package es.mgamallo.ayudadigitalizacion;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class PdfToImage {
	
	public BufferedImage bufferedImage;

	public PdfToImage(String ruta, String indice){
		try {
			//String sourceDir = "F:/Desarrollo/git/AyudaDigitalizacion/AyudaDigitalizacion/ocr.pdf";
			String sourceDir = ruta;
			
			String destinationDir = Inicio.rutaImagenesTemp;
		
	        File sourceFile = new File(sourceDir);
	        File destinationFile = new File(destinationDir);

	        // String fileName = sourceFile.getName().replace(".pdf", "");
	        
	        String fileName = indice;
	        
	        if (sourceFile.exists()) {
	            if (!destinationFile.exists()) {
	                destinationFile.mkdir();
	                System.out.println("Folder created in: "+ destinationFile.getCanonicalPath());
	            }

	            RandomAccessFile raf = new RandomAccessFile(sourceFile, "r");
	            FileChannel channel = raf.getChannel();
	            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
	            PDFFile pdf = new PDFFile(buf);

	            int pageNumber = 1;// which PDF page to be convert
	            PDFPage page = pdf.getPage(pageNumber);

	            // image dimensions 
	            int width = 1200;
	            int height = 1400;
	            
	            // imagenes rectificadas
	            width = (int) page.getBBox().getWidth();
	            height = (int) page.getBBox().getHeight();
	            
	            // create the image
	            Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(), (int) page.getBBox().getHeight());
	            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	            // width & height, // clip rect, // null for the ImageObserver, // fill background with white, // block until drawing is done
	            Image image = page.getImage(width, height, rect, null, true, true );
	            Graphics2D bufImageGraphics = bufferedImage.createGraphics();
	            bufImageGraphics.drawImage(image, 0, 0, null);

	            File imageFile = new File( destinationDir + fileName + /*pageNumber + */ ".jpg" );// change file format here. Ex: .png, .jpg, .jpeg, .gif, .bmp

	            ImageIO.write(bufferedImage, "jpg", imageFile);

	            System.out.println(imageFile.getName() +" File created in: "+ destinationFile.getCanonicalPath());
	        } else {
	        	System.err.println(sourceFile.getName() +" File not exists");
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
