/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Material;
import Dominio.Produccion;
import Presentacion.FromPrincipal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hecto
 */
public class ControladorPrincipal {
    Produccion produccion;
    FromPrincipal principal;
    ControladorProveedores proveedores;
    ControladorProductos productos;
    ControladorMateriales materiales;
    ControladorPedidos pedidos;
    
    

    public ControladorPrincipal(FromPrincipal p) {        
        produccion = new Produccion();
        principal = p;
        
        proveedores = new ControladorProveedores(produccion);
        productos = new ControladorProductos(produccion);
        materiales = new ControladorMateriales(produccion);
        pedidos = new ControladorPedidos(produccion);
    }

    public ControladorPedidos getPedidos() {
        return pedidos;
    }
    
    public ControladorMateriales getMateriales() {
        return materiales;
    }
    
    public ControladorProveedores getProveedores() {
        return proveedores;
    }

    public ControladorProductos getProductos() {
        return productos;
    }
    
    public FromPrincipal getPrincipal() {
        return principal;
    }
    
        public List<String> darListaMateriales(){
        List<Material> m = produccion.getInventario().getMateriales();
        Iterator<Material> it = m.iterator();
        ArrayList<String> nombres = new ArrayList<>();
        while(it.hasNext()){
            Material p = it.next();
            nombres.add(p.getNombre());

        }       
        return nombres;
    }
    
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
            java.util.logging.Logger.getLogger(FromPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        FromPrincipal FM = new  FromPrincipal();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                FM.setVisible(true);
            }
        });
    }
    
    
}
