/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Horarios;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.HorariosCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IHorariosCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
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
public class HorariosLista extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private IHorariosCtrl horariosCtrl;
    
    /**
     * Creates new form HorariosLista
     */
    public HorariosLista() {
        initComponents();
        this.horariosCtrl= new HorariosCtrl();
        this.CargarHorarios();
        btnNuevoHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarHorarioForm(0);
            }
        });
    }
    
    private void iniciarModeloTabla(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Id");
        tblModel.addColumn("Descripción");
        tblModel.addColumn("Hora inicio");
        tblModel.addColumn("Hora fin");
        tblModel.addColumn("");
        tblModel.addColumn("");
    }

    private void CargarHorarios(){
        this.iniciarModeloTabla();
        Response<List<HorarioLaboral>> consulta=this.horariosCtrl.ObtenerHorarios();
        if(consulta.isExitoso()){
            List<HorarioLaboral> horarios=consulta.getEntidad();

            for (HorarioLaboral h:horarios) {
                tblModel.addRow(new Object[]{h.getId(), h.getDescripcion(), h.getHoraInicio(), h.getHoraFin(), "Modificar", "Eliminar"});
            }
            tablaHorarios.setCellSelectionEnabled(false);
            tablaHorarios.setModel(tblModel);
            tablaHorarios.setRowHeight(30);
            tablaHorarios.getColumnModel().getColumn(0).setMinWidth(0);
            tablaHorarios.getColumnModel().getColumn(0).setMaxWidth(0);
            this.add(panelHorarios);
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
                int idHorario=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                MostrarHorarioForm(idHorario);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tablaHorarios, update, 4);
    }

    private void AgregarBotonEliminacion(){
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Realemnte desea eliminar el Horario?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    int idHorario=Integer.parseInt(((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString());
                    Response<Boolean> eliminacionT= horariosCtrl.EliminarHorarioLaboralPorId(idHorario);
                    if(eliminacionT.isExitoso()){
                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                    }
                }
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaHorarios, delete, 5);
    }

    private void MostrarHorarioForm(int idHorario){
        JFrame jframe = new HorarioForm(idHorario);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
        jframe.addWindowListener( new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e) {
                CargarHorarios();
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

        panelHorarios = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoHorario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHorarios = new javax.swing.JTable();

        panelHorarios.setLayout(new java.awt.CardLayout());

        btnNuevoHorario.setText("Nuevo horario laboral");

        tablaHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaHorarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoHorario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoHorario)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );

        panelHorarios.add(jPanel1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoHorario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelHorarios;
    private javax.swing.JTable tablaHorarios;
    // End of variables declaration//GEN-END:variables
}
