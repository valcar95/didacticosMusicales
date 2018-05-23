/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Aplicacion.ControladorPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class UIProveedores extends javax.swing.JFrame {

    /**
     * Creates new form UIProveedores
     */
    private static ControladorPrincipal controlador;

    public UIProveedores(ControladorPrincipal cp) {
        initComponents();

        telefonoLabel.setVisible(false);
        telefonoTXT.setVisible(false);
        sitioWebLabel.setVisible(false);
        sitioWebTXT.setVisible(false);
        guardarProveedorbtn.setVisible(false);
        guardarCambiobtn.setVisible(false);
        materialesLabel.setVisible(false);
        jScrollPane2.setVisible(false);
        materialLabel.setVisible(false);
        materialTXT.setVisible(false);
        precioLabel.setVisible(false);
        precioTXT.setVisible(false);
        tiempoEntregaLabel.setVisible(false);
        tiempoEntregaTXT.setVisible(false);
        agregarMaterialbtn.setVisible(false);
        eliminarProveedorbtn.setVisible(false);
        buscarbtn.setVisible(true);
        buscarMaterialbtn.setVisible(false);

        controlador = cp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nuevobtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscarbtn = new javax.swing.JButton();
        nombreLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        sitioWebLabel = new javax.swing.JLabel();
        nombreTXT = new javax.swing.JTextField();
        telefonoTXT = new javax.swing.JTextField();
        sitioWebTXT = new javax.swing.JTextField();
        materialesLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        materialesList = new javax.swing.JList<>();
        guardarProveedorbtn = new javax.swing.JButton();
        guardarCambiobtn = new javax.swing.JButton();
        agregarMaterialbtn = new javax.swing.JButton();
        vistaPrincipalbtn = new javax.swing.JButton();
        materialLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        tiempoEntregaLabel = new javax.swing.JLabel();
        materialTXT = new javax.swing.JTextField();
        tiempoEntregaTXT = new javax.swing.JTextField();
        precioTXT = new javax.swing.JTextField();
        eliminarProveedorbtn = new javax.swing.JButton();
        buscarMaterialbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ingresar Nuevo Proveedor");

        nuevobtn.setText("nuevo");
        nuevobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevobtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Modificar/Buscar Proveedor");

        buscarbtn.setText("buscar");
        buscarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarbtnActionPerformed(evt);
            }
        });

        nombreLabel.setText("Nombre:");

        telefonoLabel.setText("Telefono:");

        sitioWebLabel.setText("Sitio Web:");

        sitioWebTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sitioWebTXTActionPerformed(evt);
            }
        });

        materialesLabel.setText("Materiales:");

        materialesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Madera", "Cartón", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(materialesList);

        guardarProveedorbtn.setText("Guardar Proveedor");
        guardarProveedorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProveedorbtnActionPerformed(evt);
            }
        });

        guardarCambiobtn.setText("Guardar Cambio");
        guardarCambiobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiobtnActionPerformed(evt);
            }
        });

        agregarMaterialbtn.setText("Agregar Material");
        agregarMaterialbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMaterialbtnActionPerformed(evt);
            }
        });

        vistaPrincipalbtn.setText("Vista Principal");
        vistaPrincipalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaPrincipalbtnActionPerformed(evt);
            }
        });

        materialLabel.setText("Material:");

        precioLabel.setText("Precio:");

        tiempoEntregaLabel.setText("Tiempo de Entrega:");

        eliminarProveedorbtn.setText("Eliminar Proveedor");
        eliminarProveedorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProveedorbtnActionPerformed(evt);
            }
        });

        buscarMaterialbtn.setText("Buscar Material");
        buscarMaterialbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMaterialbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(nuevobtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscarbtn)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(telefonoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sitioWebLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sitioWebTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefonoTXT)
                                .addComponent(nombreTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(79, 79, 79))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(guardarProveedorbtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardarCambiobtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(precioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tiempoEntregaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(materialTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(precioTXT)
                            .addComponent(tiempoEntregaTXT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(materialesLabel)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(vistaPrincipalbtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eliminarProveedorbtn)
                                    .addComponent(agregarMaterialbtn)
                                    .addComponent(buscarMaterialbtn))
                                .addGap(32, 32, 32)))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevobtn)
                    .addComponent(buscarbtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreLabel)
                            .addComponent(nombreTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materialesLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefonoLabel)
                            .addComponent(telefonoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sitioWebLabel)
                            .addComponent(sitioWebTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardarProveedorbtn)
                            .addComponent(guardarCambiobtn))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(materialLabel)
                            .addComponent(materialTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precioLabel)
                            .addComponent(precioTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tiempoEntregaLabel)
                            .addComponent(tiempoEntregaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarMaterialbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarMaterialbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarProveedorbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vistaPrincipalbtn)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarbtnActionPerformed
        // TODO add your handling code here:
        guardarProveedorbtn.setVisible(false);
        guardarCambiobtn.setVisible(true);
        buscarbtn.setVisible(true);
        String nombre = nombreTXT.getText();
        controlador.getProveedores().buscarProveedor(nombre);
        String telefono = controlador.getProveedores().darTelefono();
        String webSite = controlador.getProveedores().darwebSite();
        DefaultListModel<String> materialesLista = new DefaultListModel<>();
        materialLabel.setVisible(true);
        materialTXT.setVisible(true);
        materialTXT.setText("");
        telefonoLabel.setVisible(true);
        telefonoTXT.setVisible(true);
        sitioWebLabel.setVisible(true);
        sitioWebTXT.setVisible(true);
        precioLabel.setVisible(true);
        buscarMaterialbtn.setVisible(true);
        precioTXT.setVisible(true);
        precioTXT.setText("");
        tiempoEntregaLabel.setVisible(true);
        tiempoEntregaTXT.setVisible(true);
        tiempoEntregaTXT.setText("");
        for (int i = 0; i < controlador.getProveedores().getProduccion().buscarProveedor(nombre).getMateriales().size(); i++) {
            String material = controlador.getProveedores().getProduccion().buscarProveedor(nombre).getMateriales().get(i).getMaterial().getNombre();
            materialesLista.addElement(material);
        }        
        materialesList.setModel(materialesLista);
        agregarMaterialbtn.setVisible(true);
        materialesLabel.setVisible(true);
        jScrollPane2.setVisible(true);
        telefonoTXT.setText(telefono);
        sitioWebTXT.setText(webSite);
        eliminarProveedorbtn.setVisible(true);
        

        //AGREGAR LA LISTA DE MATERIALES
    }//GEN-LAST:event_buscarbtnActionPerformed

    private void guardarProveedorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProveedorbtnActionPerformed

        String nombre = nombreTXT.getText();
        String telefono = telefonoTXT.getText();
        String webSite = sitioWebTXT.getText();
        String material = materialTXT.getText();
        int precio = Integer.parseInt(precioTXT.getText());
        int tiempo = Integer.parseInt(tiempoEntregaTXT.getText());
        controlador.getProveedores().agregarNuevoProveedor(nombre, telefono, webSite, material, precio, tiempo);
        nombreTXT.setText("");
        telefonoTXT.setText("");
        sitioWebTXT.setText("");


    }//GEN-LAST:event_guardarProveedorbtnActionPerformed

    private void guardarCambiobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambiobtnActionPerformed
        // TODO add your handling code here:
        String nombre = nombreTXT.getText();
        String telefono = telefonoTXT.getText();
        String webSite = sitioWebTXT.getText();
        controlador.getProveedores().modificarProveedor(nombre, telefono, webSite);

    }//GEN-LAST:event_guardarCambiobtnActionPerformed

    private void agregarMaterialbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMaterialbtnActionPerformed
        // TODO add your handling code here:
        String material = materialTXT.getText();
        String proveedor = controlador.getProveedores().getProveedorActual().getNombre();
        int precio = Integer.parseInt(precioTXT.getText());
        int tiempo = Integer.parseInt(tiempoEntregaTXT.getText());
        controlador.getProveedores().agregarMaterialProveedor(proveedor, material, precio, tiempo);
    }//GEN-LAST:event_agregarMaterialbtnActionPerformed

    private void vistaPrincipalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaPrincipalbtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        controlador.getPrincipal().setVisible(true);
    }//GEN-LAST:event_vistaPrincipalbtnActionPerformed

    private void eliminarProveedorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProveedorbtnActionPerformed
        // TODO add your handling code here:
        controlador.getProveedores().eliminarProveedorActual();
        telefonoLabel.setVisible(false);
        telefonoTXT.setVisible(false);
        sitioWebLabel.setVisible(false);
        sitioWebTXT.setVisible(false);
        guardarProveedorbtn.setVisible(false);
        guardarCambiobtn.setVisible(false);
        materialesLabel.setVisible(false);
        jScrollPane2.setVisible(false);
        materialLabel.setVisible(false);
        materialTXT.setVisible(false);
        precioLabel.setVisible(false);
        precioTXT.setVisible(false);
        tiempoEntregaLabel.setVisible(false);
        tiempoEntregaTXT.setVisible(false);
        agregarMaterialbtn.setVisible(false);
        eliminarProveedorbtn.setVisible(false);
        buscarbtn.setVisible(true);
        buscarMaterialbtn.setVisible(false);
    }//GEN-LAST:event_eliminarProveedorbtnActionPerformed

    private void sitioWebTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sitioWebTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sitioWebTXTActionPerformed

    private void nuevobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevobtnActionPerformed
        // TODO add your handling code here:

        nombreLabel.setVisible(true);
        eliminarProveedorbtn.setVisible(false);
        nombreTXT.setVisible(true);
        guardarProveedorbtn.setVisible(true);
        telefonoLabel.setVisible(true);
        telefonoTXT.setVisible(true);
        sitioWebLabel.setVisible(true);
        sitioWebTXT.setVisible(true);
        jScrollPane2.setVisible(false);
        materialesLabel.setVisible(false);
        materialLabel.setVisible(true);
        materialTXT.setVisible(true);
        precioLabel.setVisible(true);
        precioTXT.setVisible(true);
        tiempoEntregaLabel.setVisible(true);
        tiempoEntregaTXT.setVisible(true);
        guardarCambiobtn.setVisible(false);
        agregarMaterialbtn.setVisible(false);
    }//GEN-LAST:event_nuevobtnActionPerformed

    private void buscarMaterialbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMaterialbtnActionPerformed
        // TODO add your handling code here:
        String material = materialTXT.getText();
        List<String> info = controlador.getProveedores().darInformacionMaterial(material);
        precioTXT.setText(info.get(0));
        tiempoEntregaTXT.setText(info.get(1));        
    }//GEN-LAST:event_buscarMaterialbtnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UIProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UIProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UIProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UIProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UIProveedores().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarMaterialbtn;
    private javax.swing.JButton buscarMaterialbtn;
    private javax.swing.JButton buscarbtn;
    private javax.swing.JButton eliminarProveedorbtn;
    private javax.swing.JButton guardarCambiobtn;
    private javax.swing.JButton guardarProveedorbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel materialLabel;
    private javax.swing.JTextField materialTXT;
    private javax.swing.JLabel materialesLabel;
    private javax.swing.JList<String> materialesList;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTXT;
    private javax.swing.JButton nuevobtn;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JTextField precioTXT;
    private javax.swing.JLabel sitioWebLabel;
    private javax.swing.JTextField sitioWebTXT;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JTextField telefonoTXT;
    private javax.swing.JLabel tiempoEntregaLabel;
    private javax.swing.JTextField tiempoEntregaTXT;
    private javax.swing.JButton vistaPrincipalbtn;
    // End of variables declaration//GEN-END:variables
}
