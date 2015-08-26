package es.mgamallo.ayudadigitalizacion;

import java.util.ArrayList;

public class Modelo {

	String identificador =""; 
	
	String rutaImagen;
	String nombreNormalizado;
	
	ModeloPdf pdf = new ModeloPdf();
	ModeloOcr ocr = new ModeloOcr();
}

class ModeloPdf{

	ArrayList servicios = new ArrayList();
	String metadatos[] = new String[5];
	
	Fisica fisica = new Fisica();
	
	String observaciones = "";
	
}

class ModeloOcr{
	String metadatos[] = new String[4];
	String identificaNhc = "@";
	String identificaCIP = "@";
	String identificaNSS = "@";
	String urgOdocumentacion = "Documentación";
}

class Fisica{
	String apariencia="Ninguna";
	String color="Ninguno";
	String orientacion = "Vertical";
	String formato = "A4";
}