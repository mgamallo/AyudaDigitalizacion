package es.mgamallo.ayudadigitalizacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

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
	
	static LeerExcel leerExcel;
	
	static DefaultListModel listaModelNombresComunes = new DefaultListModel();
	static DefaultListModel listaModelHabituales1 = new DefaultListModel();
	static DefaultListModel listaModelHabituales2 = new DefaultListModel();
	static DefaultListModel listaModelNombresServicio = new DefaultListModel();
	static DefaultListModel listaModelTodosLosNombres = new DefaultListModel();
	static DefaultComboBoxModel comboModelNombres = new DefaultComboBoxModel();
	static DefaultListModel listaModelServicios = new DefaultListModel();
	// static DefaultComboBoxModel listaModelServicios = new DefaultComboBoxModel();
	
	String[][] tablaDocumentos;
	String[] listaServicios;
	String[] listaNombresDocumentos;
	String[][] tablaHabituales;
	
	public String proximoIndice = "";
	public int filaDondeEscribir = 1;
	
	
	public Inicio(){
		NativeInterface.open();
		
		
		SwingUtilities.invokeLater(new Runnable() {   
		      public void run() {   

		    	
		    	leerExcel = new LeerExcel();
		//    	leerExcel.leer("DocumentosPerseo.xls");
		//    	leerExcel.leerAyuda("Ayuda Documentos.xls");
		    	
		    	leerExcel.leer(DOCUMENTOS_XLS);
		    	leerExcel.leerAyuda(HERMES_XLS);
		    	
		    	proximoIndice = leerExcel.proximoIndice;
		    	filaDondeEscribir = leerExcel.ultimaFila;
		    	
		    	setDefaultsModels();
	    	
		    	
		    	VentanaSetUp ayuda1 = new VentanaSetUp(proximoIndice, filaDondeEscribir);  
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
		
		// DefaultListModel de todos los nombres
		listaModelTodosLosNombres.addElement("");
		comboModelNombres.addElement("");
		for (int i = 0; i < listaNombresDocumentos.length; i++) {
			listaModelTodosLosNombres.addElement(listaNombresDocumentos[i]);
			comboModelNombres.addElement(listaNombresDocumentos[i]);
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

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Inicio inicio = new Inicio();
			
	}

}
