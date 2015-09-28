package es.mgamallo.ayudadigitalizacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class Inicio {

	/**
	 * @param args
	 */
	
	static final String rutaImagenes = "Hermes/ImagenesPdfs/";
	static final String rutaImagenesTemp = "Hermes/ImagenesPdfs/temp/";
	
	static final String RUTA ="j:/digitalización/00 documentacion/10 Registrar docs"; 
	static final String RUTAB ="H:/DIGITALIZACIÓN/00 DOCUMENTACION/10 Registrar docs";
	
	static final String DOCUMENTOS_XLS = "Documentos.xls";
	static final String HERMES_XLS = "Hermes.xls";
	
	static public String rutaHermes = ":\\DIGITALIZACIÓN\\00 DOCUMENTACION\\99 Nombres Normalizados\\Hermes\\ImagenesPdfs";
	
	static public String rutaHermes_TXT = ":\\DIGITALIZACIÓN\\00 DOCUMENTACION\\99 Nombres Normalizados\\Hermes.txt";
	static public String rutaHermes_XLS = ":\\DIGITALIZACIÓN\\00 DOCUMENTACION\\99 Nombres Normalizados\\Hermes.xls";
	
	static public String rutaFirmados = ":\\digitalización\\00 documentacion\\03 Firmado";
	static public String unidadHDDvirtual = "";
	
	static LeerExcel leerExcel;
	
	static DefaultListModel listaModelNombresComunes = new DefaultListModel();
	static DefaultListModel listaModelHabituales1 = new DefaultListModel();
	static DefaultListModel listaModelHabituales2 = new DefaultListModel();
	static DefaultListModel listaModelNombresServicio = new DefaultListModel();
	static DefaultListModel listaModelTodosLosNombres = new DefaultListModel();
	static DefaultComboBoxModel comboModelNombres = new DefaultComboBoxModel();
	static DefaultComboBoxModel comboModelNombresEditar = new DefaultComboBoxModel();
	static DefaultComboBoxModel comboModelMetadatos= new DefaultComboBoxModel();
	static DefaultComboBoxModel comboModelNombresExistentes = new DefaultComboBoxModel();
	static DefaultListModel listaModelServicios = new DefaultListModel();
	static DefaultListModel listaModeloJpgs = new DefaultListModel();
	// static DefaultComboBoxModel listaModelServicios = new DefaultComboBoxModel();
	
	static public javax.swing.JList listaPdfs;
    static public JWebBrowser webBrowser;
    
    static public boolean editando = false;
	
	static public TreeMap<String, Indices> indiceGeneralAyuda = new TreeMap<String, Indices>();
	
	String[][] tablaDocumentos;
	String[] listaServicios;
	String[] listaNombresDocumentos;
	String[][] tablaHabituales;
	
	static public String proximoIndice = "";
	static public int filaDondeEscribir = 1;
	
	static public VentanaSetUp ayuda1;
	
	public Inicio(){
		NativeInterface.open();
		
		
		SwingUtilities.invokeLater(new Runnable() {   
		      public void run() {   

		    	
		    	unidadHDDvirtual = detectaUnidadHDD();  
		    	rutaHermes_TXT = unidadHDDvirtual + rutaHermes_TXT;
		    	rutaHermes = unidadHDDvirtual + rutaHermes;
		    	  
		    	leerArchivos();
		    	
		    	/*
			    Iterator<String> it = indiceGeneralAyuda.keySet().iterator();
				while(it.hasNext()){
				  String key = (String) it.next();
				  System.out.println("Clave: " + key + " ->"); 
				  for(int i=0;i<indiceGeneralAyuda.get(key).indices.size();i++){
					  System.out.println("   Valor: " + indiceGeneralAyuda.get(key).indices.get(i));
				  }
				  
				}
		    	*/
		    	
		    	setDefaultsModels();
	    	
		    	
		    	ayuda1 = new VentanaSetUp(proximoIndice, filaDondeEscribir);  
		    	// ayuda1.setPdf();
		  		ayuda1.setVisible(true);
		      }   
		    });   
		
		

		NativeInterface.runEventPump();
	}
	
	private void setDefaultsModels() {

		listaServicios = leerExcel.getServicios();
		listaNombresDocumentos = leerExcel.getNombres();
		tablaHabituales = leerExcel.getHabituales();
		tablaDocumentos = leerExcel.getTabla();

		listaModelTodosLosNombres.removeAllElements();
		listaModelNombresComunes.removeAllElements();
		listaModelHabituales1.removeAllElements();
		listaModelHabituales2.removeAllElements();
		listaModelServicios.removeAllElements();
		comboModelNombres.removeAllElements();
		comboModelNombresEditar.removeAllElements();
		comboModelMetadatos.removeAllElements();
		comboModelNombresExistentes.removeAllElements();
		
		// DefaultListModel de todos los nombres
		listaModelTodosLosNombres.addElement("");
		comboModelNombres.addElement("");
		comboModelNombresEditar.addElement("");
		for (int i = 0; i < listaNombresDocumentos.length; i++) {
			listaModelTodosLosNombres.addElement(listaNombresDocumentos[i]);
			comboModelNombres.addElement(listaNombresDocumentos[i]);
			comboModelNombresEditar.addElement(listaNombresDocumentos[i]);
			if (tablaHabituales[i][0].toLowerCase().equals("s")) {
				listaModelNombresComunes.addElement(listaNombresDocumentos[i]);
			} else if (tablaHabituales[i][1].toLowerCase().equals("s")) {
				listaModelHabituales1.addElement(listaNombresDocumentos[i]);
			} else if (tablaHabituales[i][2].toLowerCase().equals("s")) {
				listaModelHabituales2.addElement(listaNombresDocumentos[i]);
			}
		}

		for (int i = 0; i < listaServicios.length; i++) {
			listaModelServicios.addElement(listaServicios[i]);
		}
		listaModelServicios.addElement("Todos");

	}

	private static String detectaUnidadHDD(){
		
		ArrayList<String> unidades = new ArrayList<String>();
		
		File[] hdds = File.listRoots();
		for(int i=0;i<hdds.length;i++){
			unidades.add(hdds[i].getAbsolutePath().substring(0,1));
		}
		
		
		String posibleRuta = "h" + rutaFirmados;
		File ruta = new File(posibleRuta);
		if(ruta.exists()){
			return "h";
		}
		else{
			posibleRuta = "j" + rutaFirmados;
			ruta = new File(posibleRuta);
			if(ruta.exists())
				return "j";
			
		}
	
		for(int i=0;i<unidades.size();i++){
			posibleRuta = unidades.get(i) + rutaFirmados;
			ruta = new File(posibleRuta);
			if(ruta.exists()){
				return unidades.get(i);
			}
			
		}
		
		
		
		
		JOptionPane.showMessageDialog(null, "Problemas con la unidad de disco");
		
		return null;
	}
	
	public static void leerArchivos(){
    	Inicio.leerExcel = new LeerExcel();
//    	leerExcel.leer("DocumentosPerseo.xls");
//    	leerExcel.leerAyuda("Ayuda Documentos.xls");
    	
    	Inicio.leerExcel.leer(Inicio.DOCUMENTOS_XLS);
    	Inicio.leerExcel.leerAyuda(Inicio.HERMES_XLS);
    	
    	Inicio.proximoIndice = Inicio.leerExcel.proximoIndice;
    	Inicio.filaDondeEscribir = Inicio.leerExcel.ultimaFila;
    	
    	Inicio.indiceGeneralAyuda = Txt.leerIndiceTxt(rutaHermes_TXT);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Inicio inicio = new Inicio();
			
	}

}
