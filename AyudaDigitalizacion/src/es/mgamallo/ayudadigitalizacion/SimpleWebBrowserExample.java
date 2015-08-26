package es.mgamallo.ayudadigitalizacion;

/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 *
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * @author Christopher Deckers
 */
public class SimpleWebBrowserExample {
	
  protected static final String LS = System.getProperty("line.separator");

  public static JComponent createContent() {
    JPanel contentPane = new JPanel(new BorderLayout());
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
    webBrowserPanel.setBorder(BorderFactory.createTitledBorder("Native Web Browser component"));
    final JWebBrowser webBrowser = new JWebBrowser();
    // webBrowser.navigate("http://ianuschop.sergas.local/ianus_chp_pro/jsps/login.jsp");
   
    webBrowser.navigate("http://www.google.es");
    
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    contentPane.add(webBrowserPanel, BorderLayout.CENTER);
    // Create an additional bar allowing to show/hide the menu bar of the web browser.
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
    JCheckBox menuBarCheckBox = new JCheckBox("Menu Bar", webBrowser.isMenuBarVisible());
    menuBarCheckBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        // webBrowser.setMenuBarVisible(e.getStateChange() == ItemEvent.SELECTED);
    	  final JTextArea configurationTextArea = new JTextArea(
    		       // "document.bgColor = '#FFFF00';" 
    			  "alert('Hola');" + LS +
    			 "var login = document.getElementById('login');" + LS +
    			 "var password = document.getElementById('password');" + LS +
    			 "login.value = 'mgamgul1';" + LS +
    			  "password.value = 'archivo0';" + LS +
    			 // "var aceptar = document.getElementsByTagName('input');" + LS +
    			  // "for(var i=0;i<aceptar.length;i++){" + LS +
    			  //	"alert('input numero ' + i + 'vale '+ aceptar[i].value);" + LS +
    			  //	"}" + LS +
    			 // "alert(aceptar[3].type);" + LS +
    			  "aceptar();" + LS +
    			 // "aceptar[3].click();" + LS +
    			  "");
    	  
    	  
    	 // webBrowser.executeJavascript(configurationTextArea.getText());
    	  webBrowser.navigate("javascript:alert('hola')");
      }
    });
    buttonPanel.add(menuBarCheckBox);
    contentPane.add(buttonPanel, BorderLayout.SOUTH);
    return contentPane;
  }

  /* Standard main method to try that test as a standalone application. */
  public static void main(String[] args) {
    NativeInterface.open();
    UIUtils.setPreferredLookAndFeel();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("DJ Native Swing Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createContent(), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      }
    });
    NativeInterface.runEventPump();
  }

}
