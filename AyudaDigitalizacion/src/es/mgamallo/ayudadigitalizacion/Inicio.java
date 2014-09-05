package es.mgamallo.ayudadigitalizacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class Inicio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NativeInterface.open();
		
		
		SwingUtilities.invokeLater(new Runnable() {   
		      public void run() {   
		    	VentanaSetUp ayuda1 = new VentanaSetUp();  
		    	ayuda1.setPdf();
		  		ayuda1.setVisible(true);
		      }   
		    });   
		
		

		NativeInterface.runEventPump();
	}

}
