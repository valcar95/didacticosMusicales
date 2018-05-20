/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Clientes.TiposCliente;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.TipoClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.ITipoClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import didacticosmusicales.Personal.UI.Utilidades.*;

/**
 *
 * @author XGAnalista2
 */
public class TiposClienteLista extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private ITipoClienteCtrl tipoClienteCtrl;
    
    /**
     * Creates new form TiposClienteLista
     */
    public TiposClienteLista() {
        initComponents();
        this.tipoClienteCtrl=new TipoClienteCtrl();
        this.CargarTiposCliente();
        btnNuevoTipoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarTipoClienteForm(0);
            }
        });
    }
    
    private void iniciarModeloTabla(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Id");
        tblModel.addColumn("Descripción");
        tblModel.addColumn("Descuento");
        tblModel.addColumn("Recargo");
        tblModel.addColumn("");
        tblModel.addColumn("");
    }

    private void CargarTiposCliente(){
        this.iniciarModeloTabla();
        Response<List<TipoCliente>> consulta=this.tipoClienteCtrl.ObtenerTipoClientes();
        if(consulta.isExitoso()){
            List<TipoCliente> tiposCliente=consulta.getEntidad();

            for (TipoCliente t:tiposCliente) {
                tblModel.addRow(new Object[]{t.getId(), t.getDescripcion(), t.getDescuento(), t.getRecargo(), "Modificar", "Eliminar"});
            }
            tablaTiposCliente.setCellSelectionEnabled(false);
            tablaTiposCliente.setModel(tblModel);
            tablaTiposCliente.setRowHeight(30);
            tablaTiposCliente.getColumnModel().getColumn(0).setMinWidth(0);
            tablaTiposCliente.getColumnModel().getColumn(0).setMaxWidth(0);
            this.add(panelTiposCliente);
        }
        this.AgregarBotonesTabla();
    }

    private void AgregarBotonesTabla(){
        this.AgregarBotonModificacion();
        this.AgregarBotonEliminacion();
    }

    private void AgregarBotonModificacion(){
        Action update = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                int idTipoCliente=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                MostrarTipoClienteForm(idTipoCliente);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tablaTiposCliente, update, 4);
    }

    private void AgregarBotonEliminacion(){
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Realemnte desea eliminar el tipo de cliente?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    int idTipoCliente=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                    Response<Boolean> eliminacionT= tipoClienteCtrl.EliminarTipoClientePorId(idTipoCliente);
                    if(eliminacionT.isExitoso()){
                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                    }
                }
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaTiposCliente, delete, 5);
    }

    private void MostrarTipoClienteForm(int idTipoCliente){
        JFrame jframe = new TiposClienteForm(idTipoCliente);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
        jframe.addWindowListener( new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e) {
                CargarTiposCliente();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTiposCliente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoTipoCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTiposCliente = new javax.swing.JTable();

        panelTiposCliente.setLayout(new java.awt.CardLayout());

        btnNuevoTipoCliente.setText("Nuevo tipo de cliente");

        tablaTiposCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaTiposCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoTipoCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnNuevoTipoCliente)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        panelTiposCliente.add(jPanel1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTiposCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTiposCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoTipoCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTiposCliente;
    private javax.swing.JTable tablaTiposCliente;
    // End of variables declaration//GEN-END:variables
}
