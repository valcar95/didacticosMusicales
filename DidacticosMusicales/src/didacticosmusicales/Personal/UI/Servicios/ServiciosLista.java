/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Servicios;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.ServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import didacticosmusicales.Personal.UI.Utilidades.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XGAnalista2
 */
public class ServiciosLista extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private IServicioCtrl servicioCtrl;
    /**
     * Creates new form ServiciosLista
     */
    public ServiciosLista() {
        initComponents();
        this.servicioCtrl= new ServicioCtrl();
        this.CargarServicios();
        btnNuevoServicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarServicioForm(0);
            }
        });
    }

    private void iniciarModeloTabla(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Id");
        tblModel.addColumn("Descripción");
        tblModel.addColumn("");
        tblModel.addColumn("");
        tblModel.addColumn("");
        tblModel.addColumn("");
    }

    private void CargarServicios(){
        this.iniciarModeloTabla();
        Response<List<Servicio>> consulta=this.servicioCtrl.ObtenerServicios();
        if(consulta.isExitoso()){
            List<Servicio> servicios=consulta.getEntidad();

            for (Servicio s:servicios) {
                tblModel.addRow(new Object[]{s.getId(), s.getDescripcion(),"Asociar trabajadores","Asociar materiales", "Modificar", "Eliminar"});
            }
            tablaServicios.setCellSelectionEnabled(false);
            tablaServicios.setModel(tblModel);
            tablaServicios.setRowHeight(30);
            tablaServicios.getColumnModel().getColumn(0).setMinWidth(0);
            tablaServicios.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaServicios.getColumnModel().getColumn(2).setMinWidth(160);
            tablaServicios.getColumnModel().getColumn(2).setMaxWidth(160);
            tablaServicios.getColumnModel().getColumn(3).setMinWidth(160);
            tablaServicios.getColumnModel().getColumn(3).setMaxWidth(160);
            this.add(panelServicios);
        }
        this.AgregarBotonesTabla();
    }

    private void AgregarBotonesTabla(){
        this.AgregarBotonModificacion();
        this.AgregarBotonEliminacion();
        this.AgregarBotonAsociarTrabajadores();
        this.AgregarBotonAsociarMateriales();
    }
    
    private void AgregarBotonAsociarTrabajadores(){
        Action asociarTrabajadores = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                int idServicio=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                MostrarAsociarTrabajadoresForm(idServicio);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaServicios, asociarTrabajadores, 2);
    }

    private void AgregarBotonAsociarMateriales(){
        Action asociarMateriales = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                int idServicio=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                MostrarAsociarMaterialesForm(idServicio);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaServicios, asociarMateriales, 3);
    }

    private void AgregarBotonModificacion(){
        Action update = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                int idServicio=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                MostrarServicioForm(idServicio);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaServicios, update, 4);
    }

    private void AgregarBotonEliminacion(){
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Realemnte desea eliminar el servicio?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    int idServicio=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                    Response<Boolean> eliminacionT= servicioCtrl.EliminarServicioPorId(idServicio);
                    if(eliminacionT.isExitoso()){
                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Hubo un problema al realizar la eliminación","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaServicios, delete, 5);
    }

    private void MostrarServicioForm(int idServicio){
        JFrame jframe = new ServicioForm(idServicio);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
        jframe.addWindowListener( new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e) {
                CargarServicios();
            }
        });
    }

    private void MostrarAsociarTrabajadoresForm(int idServicio){
        JFrame jframe = new TrabajadoresServicioForm(idServicio);
        jframe.setSize(500,600);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void MostrarAsociarMaterialesForm(int idServicio){
        JFrame jframe = new MaterialesServicioForm(idServicio);
        jframe.setSize(500,600);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelServicios = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoServicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();

        panelServicios.setLayout(new java.awt.CardLayout());

        btnNuevoServicio.setText("Nuevo Servicio");

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaServicios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoServicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnNuevoServicio)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );

        panelServicios.add(jPanel1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoServicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelServicios;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables
}
