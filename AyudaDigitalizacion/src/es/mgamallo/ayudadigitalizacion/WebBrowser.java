package es.mgamallo.ayudadigitalizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class WebBrowser {
	
	public JFrame frame;
	public JPanel webBrowserPanel = new JPanel(new BorderLayout());
	public JWebBrowser webBrowser;

	public WebBrowser(){
		
	}
	
	public WebBrowser(final String nombreFrame, final String html){

	    SwingUtilities.invokeLater(new Runnable() {   
		      public void run() {   
		    	frame = new JFrame(nombreFrame);

		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
		        frame.getContentPane().add(createContent(html), BorderLayout.CENTER);   
		        frame.setSize(860, 600);   
		        frame.setMinimumSize(new Dimension(800,300));
		        frame.setLocationByPlatform(true); 
		        
		        // webBrowserPanel.setBackground(color);
		        	        
		       frame.setVisible(true); 
		      }   
		    });   
	}
	
	public JComponent createContent( String html) {  
		  
	    JPanel contentPane = new JPanel(new BorderLayout());   
	    
	    //webBrowserPanel.setBorder(BorderFactory.createTitledBorder("Digitalización"));   
	    webBrowser = new JWebBrowser();
	    //webBrowser.navigate("http://www.google.es");
	    webBrowser.navigate("http://ianuschop");  
	    
	    // webBrowser.navigate(html);
	    
	    //webBrowser.navigate("D:\\Desarrollo\\git\\AyudaDigitalizacion\\AyudaDigitalizacion\\arreglar.pdf");
	    System.out.println("Pdf");
	    
	    webBrowser.setBarsVisible(false);
	    webBrowser.setMenuBarVisible(false);
	    // System.out.println(webBrowser.getBrowserType());
	    webBrowser.setJavascriptEnabled(true);
	    
	    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);   
	    contentPane.add(webBrowserPanel, BorderLayout.CENTER); 
   
	    
	    return contentPane;   
  }   

}
