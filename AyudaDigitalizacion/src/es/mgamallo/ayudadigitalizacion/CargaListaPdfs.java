package es.mgamallo.ayudadigitalizacion;
import java.io.File;


public class CargaListaPdfs {

	String[] nombrePdfs;	//S�lo el nombre
	String[] rutaPdfs;		//path + nombre
	String rutaCarpeta;
	boolean cargado = false;
	
	

	
	CargaListaPdfs() {
		
		AbrirCarpeta carpeta = new AbrirCarpeta();
		
		if(carpeta.eligeDirectorio == true){
			cargado = true;
			File[] ficheros = carpeta.getPdfs();
			
			int tama�oDir = ficheros.length;
			nombrePdfs = new String[tama�oDir];
			rutaPdfs = new String[tama�oDir];
			rutaCarpeta = carpeta.nombreCarpeta;
		
			for(int i=0;i<tama�oDir;i++){
				nombrePdfs[i] = ficheros[i].getName();
				rutaPdfs[i] = ficheros[i].getAbsolutePath();
			}
		}
	}
	
	
	
	String[] getNombresPdfs(){
		return nombrePdfs;
	}
	
	String[] getRutaPdfs(){
		return rutaPdfs;
	}
	
	String getRutaCarpeta(){
		return rutaCarpeta;
	}
	
}
