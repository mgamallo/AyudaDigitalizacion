package es.mgamallo.ayudadigitalizacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class VentanaDialogoRevisar extends javax.swing.JDialog {

    /**
     * Creates new form NewJFrame
     */
    public VentanaDialogoRevisar() {
    	new AyudaIndex(true, false);
    	Inicio.leerArchivos();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	barraMenu = new JMenuBar();
    	jMenu1 = new JMenu();
    	jMenuItem1 = new JMenuItem("Lista secuencial de documentos");
        
        setJMenuBar(barraMenu);
        barraMenu.add(jMenu1);
        jMenu1.add(jMenuItem1);
        
        jMenu1.setText("Lista de documentos");
        jMenuItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				botonSeleccionarActionPerformed(e, true);
			}
		});
        
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        etiquetaNombresNormalizados = new javax.swing.JLabel();
        comboNombresNormalizados = new javax.swing.JComboBox();
        etiquetaMetadatos = new javax.swing.JLabel();
        comboMetadatos = new javax.swing.JComboBox();
        botonSeleccionar = new javax.swing.JButton();
        
        etiquetaNombresExistentes = new javax.swing.JLabel();
        comboNombresExistentes = new javax.swing.JComboBox();
        botonCambiarNombre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 340));
        setPreferredSize(new java.awt.Dimension(400, 340));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(400, 179));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 179));

        etiquetaNombresNormalizados.setText("Nombres Normalizados");

        
        etiquetaMetadatos.setText("Metadatos");

        

        

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt, false);
            }
        });
        
        
        comboNombresNormalizados.setModel(Inicio.comboModelNombresEditar);
        comboNombresNormalizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        
        comboMetadatos.setModel(Inicio.comboModelMetadatos);
        comboMetadatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        
        comboNombresExistentes.setModel(Inicio.comboModelNombresExistentes);
        comboNombresExistentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        
        
        comboNombresNormalizados.setSelectedIndex(0);
        comboMetadatos.setSelectedIndex(0);
        comboNombresExistentes.setSelectedIndex(0);
        
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            	.addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonSeleccionar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiquetaNombresNormalizados)
                        .addComponent(etiquetaMetadatos)
                        .addComponent(comboNombresNormalizados, 0, 364, Short.MAX_VALUE)
                        .addComponent(comboMetadatos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaNombresNormalizados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboNombresNormalizados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaMetadatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMetadatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        etiquetaNombresExistentes.setText("Nombres existentes en la base de datos");


        botonCambiarNombre.setText("Cambiar Nombre");
        botonCambiarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Intentando cambiar nombre...");
				botonCambiarNombrePerformer(e);
				
			}
		});
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaNombresExistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(361, 361, 361))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonCambiarNombre)
                            .addComponent(comboNombresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaNombresExistentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboNombresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCambiarNombre)
                .addGap(0, 56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }// </editor-fold>//GEN-END:initComponents

    private void botonCambiarNombrePerformer(java.awt.event.ActionEvent e){
    	String docs[] = new String[2];
    	docs[0] = Inicio.comboModelNombresEditar.getSelectedItem().toString();
    	docs[1] = Inicio.comboModelNombresExistentes.getSelectedItem().toString();
    	
    	ArrayList<Integer> numerosModelo = new ArrayList<Integer>();
    	
    	if(!docs[0].equals("") && !docs[1].equals("")){
    		
    		Inicio.leerArchivos();
    		
        	String ayuda[][] = Inicio.leerExcel.getTablaHermesAyuda();
        	String ocr[][] = Inicio.leerExcel.getTablaHermesOCR();
        	
        //	System.out.println(ayuda.length);
        	
        	for(int i=0;i<ayuda.length;i++){
        		if(ayuda[i][1].equals(docs[1])){
        			numerosModelo.add(i);
        		//	System.out.println("Numero modelo... " + i);
        		}
        	}
    		
        	int numeroDeCambios = EscribeExcel.actualizarNombres(numerosModelo,docs[0]);
        	if(numeroDeCambios != -1){
    			JOptionPane.showMessageDialog(this, numeroDeCambios + " cambios realizados.");
    			new AyudaIndex(false, false);
    			dispose();
        	}
        	else{
        		JOptionPane.showMessageDialog(this, "Fichero en uso. No se puede guardar el cambio.");
        	}
    	}
    }
    
    
    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt, boolean mostrarListaSecuencial) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        // TODO add your handling code here:
    	
    	String docs[] = new String[2];
    	docs[0] = Inicio.comboModelNombresEditar.getSelectedItem().toString().toLowerCase();
    	docs[1] = Inicio.comboModelMetadatos.getSelectedItem().toString();

    	
    	Set<Integer> conjunto = new TreeSet<Integer>();
    	
    	
    	if(!mostrarListaSecuencial){
    		
        	for(int z=0;z < 2;z++){
            	if(Inicio.indiceGeneralAyuda.containsKey(docs[z])){
            		System.out.println("Clave encontrada");
            		for(int i=0;i<Inicio.indiceGeneralAyuda.get(docs[z]).indices.size();i++){
            			conjunto.add(Integer.valueOf(Inicio.indiceGeneralAyuda.get(docs[z]).indices.get(i)));
            		}
            	}
        	}
        	
    	}
    	else{
    		
    		int tama�o = Inicio.leerExcel.getTablaHermesAyuda().length;
    		
    		System.out.println(tama�o);
    		
    		for(int i=1;i<=tama�o;i++){
    			conjunto.add(i);
    		}
    	}

    	

    	
    	if(conjunto.size() == 0){
    		JOptionPane.showMessageDialog(this, "Documento y/o clave no encontrada" );
    	}
    	else{
     		
    		DefaultListModel listaModeloJpgs = new DefaultListModel();
    		
    		Inicio.rutasJpgs = new String[conjunto.size()];
    		
    	    Iterator<Integer> it = conjunto.iterator();
    	    int z=0;
    		
    	    while(it.hasNext()){
    			int indice = it.next();
    			
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
    			
    			listaModeloJpgs.addElement(proximoIndice);
    			Inicio.rutasJpgs[z] = ruta;
    			z++;
    		}
    		
    		
    		Inicio.listaModeloJpgs = listaModeloJpgs;
    		Inicio.listaPdfs.setModel(listaModeloJpgs);
    		
    		Inicio.listaPdfs.setSelectedIndex(0);
    		int indice = Integer.valueOf(Inicio.listaPdfs.getSelectedValue().toString());
    		
    		
    		String html = "<html> <body> <img src='" + Inicio.rutasJpgs[0] 
    				+ "' width='750px'> </body> </html>";
 			
    		
    		Inicio.webBrowser.setVisible(true);
    		Inicio.webBrowser.setHTMLContent(html);
    		System.out.println(Inicio.rutasJpgs[0]);
    		
    		Inicio.ayuda1.actualizaCampos(indice);
    		
    		Inicio.editando = true;
    		
        	dispose();
    	}
    	
    	

    	
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void comboNombresNormalizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNombresNormalizadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNombresNormalizadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDialogoRevisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDialogoRevisar();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCambiarNombre;
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JMenuBar barraMenu; 
    private javax.swing.JMenu jMenu1; 
    private javax.swing.JMenuItem jMenuItem1; 
    private javax.swing.JComboBox comboMetadatos;
    private javax.swing.JComboBox comboNombresExistentes;
    private javax.swing.JComboBox comboNombresNormalizados;
    private javax.swing.JLabel etiquetaMetadatos;
    private javax.swing.JLabel etiquetaNombresExistentes;
    private javax.swing.JLabel etiquetaNombresNormalizados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
