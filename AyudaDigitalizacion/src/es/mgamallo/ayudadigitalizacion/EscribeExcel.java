package es.mgamallo.ayudadigitalizacion;


import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.biff.CountryCode;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class EscribeExcel {


	public boolean escribir(String archivoDestino, Modelo modelo, int fila, boolean editando){
		
		boolean exito = false;

		try{
			WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setEncoding("ISO-8859-1");
            wbSettings.setLocale(new Locale("es", "ES"));
            wbSettings.setExcelDisplayLanguage("ES"); 
            wbSettings.setExcelRegionalSettings("ES"); 
            wbSettings.setCharacterSet(CountryCode.SPAIN.getValue());
	
            Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino));
            
            //	Hoja ayuda pdf
            
            Sheet hoja = archivoExcel.getSheet(0);
            
            int numC = 11;
 
            
            //	System.out.println(listaUsers[i]);
            
            
            WritableWorkbook libroEscritura = Workbook.createWorkbook(new File(archivoDestino), archivoExcel);
            
            archivoExcel.close();
            
            WritableSheet hojaE = libroEscritura.getSheet(0);
            
            jxl.write.Label texto;
            jxl.write.Number numero;
            
            texto = new jxl.write.Label(0,fila,modelo.identificador);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(1,fila,modelo.nombreNormalizado);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(2,fila,modelo.pdf.metadatos[0]);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(3,fila,modelo.pdf.metadatos[1]);
            hojaE.addCell(texto);            
            texto = new jxl.write.Label(4,fila,modelo.pdf.metadatos[2]);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(5,fila,modelo.pdf.metadatos[3]);
            hojaE.addCell(texto);                 
            texto = new jxl.write.Label(6,fila,modelo.pdf.metadatos[4]);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(7,fila,modelo.pdf.fisica.apariencia);
            hojaE.addCell(texto);                 
            texto = new jxl.write.Label(8,fila,modelo.pdf.fisica.color);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(10,fila,modelo.pdf.observaciones);
            hojaE.addCell(texto);
            
            String cadena = "";
            for(int i=0;i < modelo.pdf.servicios.size();i++){
            	cadena += modelo.pdf.servicios.get(i);
            	if(i != (modelo.pdf.servicios.size()-1)){
            		cadena += ",";
            	}
            }
            
            texto = new jxl.write.Label(9,fila,cadena);
            hojaE.addCell(texto);
            
            if(!editando){
                texto = new jxl.write.Label(0,fila+1,"ultimo");
                hojaE.addCell(texto);
            }
            
            //	hoja OCR
            hojaE = libroEscritura.getSheet(1);
            
            texto = new jxl.write.Label(0,fila,modelo.identificador);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(1,fila,modelo.nombreNormalizado);
            hojaE.addCell(texto);
            
            if(modelo.pdf.servicios.size() > 1){
                texto = new jxl.write.Label(2,fila,"0");
                hojaE.addCell(texto);
            }
            else if(modelo.pdf.servicios.size() == 1){
                texto = new jxl.write.Label(2,fila,modelo.pdf.servicios.get(0).toString());
                hojaE.addCell(texto);            	
            }
            texto = new jxl.write.Label(3,fila,modelo.pdf.fisica.orientacion);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(4,fila,modelo.pdf.fisica.formato);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(5,fila,modelo.ocr.urgOdocumentacion);
            hojaE.addCell(texto);           
            
            texto = new jxl.write.Label(6,fila,modelo.ocr.metadatos[3]);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(7,fila,modelo.ocr.metadatos[1]);
            hojaE.addCell(texto);            
            texto = new jxl.write.Label(8,fila,modelo.ocr.metadatos[2]);
            hojaE.addCell(texto);
            texto = new jxl.write.Label(9,fila,modelo.ocr.metadatos[0]);
            hojaE.addCell(texto);                 

            texto = new jxl.write.Label(10,fila,modelo.ocr.identificaNhc);
            hojaE.addCell(texto);                 
            texto = new jxl.write.Label(11,fila,modelo.ocr.identificaCIP);
            hojaE.addCell(texto); 
            texto = new jxl.write.Label(12,fila,modelo.ocr.identificaNSS);
            hojaE.addCell(texto); 
            
            if(!editando){
                texto = new jxl.write.Label(0,fila+1,"ultimo");
                hojaE.addCell(texto);
            }

            
            
            /*
            numero = new jxl.write.Number(indicePantallaIanus+1,numFilaUser,InicioIanus.coordenadas.coordenadas[0].x); 
            hojaE.addCell(numero);
            */
            
            
            libroEscritura.write();
            libroEscritura.close();
            
            exito = true;
	
		}catch(Exception ioe){
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fichero en uso. No se puede guardar el modelo");
			return false;
		}
		
		return exito;
	}
	
	public static int actualizarNombres(ArrayList<Integer> numerosModelo, String nombreActualizado){
	
		boolean exito = false;

		int numeroDeCambios = 0;
		
		try{
			WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setEncoding("ISO-8859-1");
            wbSettings.setLocale(new Locale("es", "ES"));
            wbSettings.setExcelDisplayLanguage("ES"); 
            wbSettings.setExcelRegionalSettings("ES"); 
            wbSettings.setCharacterSet(CountryCode.SPAIN.getValue());
	
            Workbook archivoExcel = Workbook.getWorkbook(new File(Inicio.HERMES_XLS));
            
            //	Hoja ayuda pdf
            
            Sheet hoja = archivoExcel.getSheet(0);
            
            int numC = 11;
 
            
            //	System.out.println(listaUsers[i]);
            
            
            WritableWorkbook libroEscritura = Workbook.createWorkbook(new File(Inicio.HERMES_XLS), archivoExcel);
            
            archivoExcel.close();
            
            WritableSheet hojaE = libroEscritura.getSheet(0);
            
            jxl.write.Label texto;
            jxl.write.Number numero;
            
            for(int i=0;i<numerosModelo.size();i++){
            //	System.out.println(numerosModelo.get(i) + "   " + nombreActualizado);
            	texto = new jxl.write.Label(1,numerosModelo.get(i)+1,nombreActualizado);
                hojaE.addCell(texto);
            }

            
            //	hoja OCR
            hojaE = libroEscritura.getSheet(1);
            
            for(int i=0;i<numerosModelo.size();i++){
            	texto = new jxl.write.Label(1,numerosModelo.get(i)+1,nombreActualizado);
                hojaE.addCell(texto);
                numeroDeCambios++;
            }
            
            
            
            /*
            numero = new jxl.write.Number(indicePantallaIanus+1,numFilaUser,InicioIanus.coordenadas.coordenadas[0].x); 
            hojaE.addCell(numero);
            */
            
            
            libroEscritura.write();
            libroEscritura.close();
            
            exito = true;
	
		}catch(Exception ioe){
			// ioe.printStackTrace();
			
			return -1;
		}
		
		return numeroDeCambios;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
