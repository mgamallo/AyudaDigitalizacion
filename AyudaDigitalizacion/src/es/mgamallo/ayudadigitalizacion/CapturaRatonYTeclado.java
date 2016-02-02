package es.mgamallo.ayudadigitalizacion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;



public class CapturaRatonYTeclado implements NativeKeyListener,
		NativeMouseInputListener {

	protected static final String LS = System.getProperty("line.separator");
	
	public static boolean barraEspaciadoraOn = true;
	
	int teclaActual = 0;
	int teclaAnterior = 0;
	
	String html = "";
	
	public CapturaRatonYTeclado() {
		// TODO Auto-generated constructor stub

		 GlobalScreen.getInstance().addNativeKeyListener(this);
         GlobalScreen.getInstance().addNativeMouseListener(this);
         GlobalScreen.getInstance().addNativeMouseMotionListener(this);
         
         System.out.println("Hola captura");
         
         try {
			GlobalScreen.registerNativeHook();
			
			System.out.println("Capturando");
			
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * try { GlobalScreen.registerNativeHook(); } catch (NativeHookException
		 * e) { // TODO Auto-generated catch block
		 * System.err.println("There was a problem registering the native hook."
		 * ); System.err.println(e.getMessage()); //e.printStackTrace(); }
		 */
	}

	// Métodos de ratón
	// **********************************************************

	@Override
	public void nativeMouseClicked(NativeMouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == 3 && Inicio.editando){
			siguienteDocumento();
		}
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mousepressed");
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mousereleased");
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mousedragged");
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mousemoved");
	}

	// Métodos de teclado
	// *************************************************************

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		 System.out.println("NativeKeyPressed " + e.getKeyCode());
		 System.out.println("Tecla ... " + ((char) e.getKeyCode()));

		 // Tecla asterisco
		 if(e.getKeyCode() == 106){
			 System.out.println(e.getKeyChar());
		 }
		 
			//	Tecla fin
			if(e.getKeyCode() == 35){

			
			}
			
			// Tecla F1
			if(e.getKeyCode() == 112){
				siguienteDocumento();
			}

		

			/*
			//  Flecha arriba
			if(e.getKeyCode() == 38){
				Dispatch.call(GestionJacobXedoc.bandejaXedoc1, "Navigate","javascript:" +  CadenasJavascriptXedoc.pruebaTabla() );
				
			}
			
			
			//  Flecha derecha
			if(e.getKeyCode() == 39){
			}
			
			//  Flecha abajo
			if(e.getKeyCode() == 40){
			}
			
			//  Flecha izquierda
			if(e.getKeyCode() == 37){
			}
			*/

	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
	//	 System.out.println("NativeKeyReleased " + arg0.getKeyCode());
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
	//	 System.out.println("NativeKeyTyped " + arg0.getKeyCode());
	}

	private void siguienteDocumento(){
		int index = Inicio.listaPdfs.getSelectedIndex() + 1;
		if(index > 0 && index < Inicio.listaModeloJpgs.size()){
			Inicio.listaPdfs.setSelectedIndex(index);
			
			maquetaJpg();
		}
	}
	
	private void maquetaJpg(){
		int indice = Integer.valueOf(Inicio.listaPdfs.getSelectedValue().toString());
		
		String proximoIndice = "";
    	if(indice > 999 && indice < 10000 ){
    		proximoIndice += "0";
    	}
    	else if(indice > 99 && indice < 1000 ){
    		proximoIndice += "00";
    	}
    	else if(indice > 9 && indice < 100 ){
    		proximoIndice += "000";
    	}
    	else if(indice < 10 ){
    		proximoIndice += "0000";
    	}
		
		
    	proximoIndice += indice;
		String ruta = Inicio.rutaHermes + "\\Index_" + proximoIndice + ".jpg";
		
		
		
		Inicio.ayuda1.reseteaCampos();
		
		html = "<html> <body> <img src='" + ruta 
				+ "' width='750px'> </body> </html>";

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new VentanaSetUp().setVisible(true);
            	Inicio.webBrowser.setHTMLContent(html);
            }
        });
		
		
		Inicio.ayuda1.imagenExtraida = true;

		Inicio.ayuda1.actualizaCampos(indice);
	}
	

	static public void main(String arg[]){
		CapturaRatonYTeclado capt = new CapturaRatonYTeclado();
		/*
		 GlobalScreen.getInstance().addNativeKeyListener(capt);
         GlobalScreen.getInstance().addNativeMouseListener(capt);
         GlobalScreen.getInstance().addNativeMouseMotionListener(capt);
         
         System.out.println("Hola");
         
         try {
			GlobalScreen.registerNativeHook();
			
			System.out.println("Capturando");
			
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
