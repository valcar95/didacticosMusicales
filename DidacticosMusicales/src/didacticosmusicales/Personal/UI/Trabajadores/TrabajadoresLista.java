/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Trabajadores;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.TrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.ITrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
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
public class TrabajadoresLista extends javax.swing.JPanel {

    /**
     * Creates new form TrabajadoresLista
     */
    private ITrabajadorCtrl trabajadorCtrl;
    private DefaultTableModel tblModel;
    public TrabajadoresLista() {
        initComponents();
        this.trabajadorCtrl = new TrabajadorCtrl();
        this.CargarTrabajadores();
        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarTrabajadorForm("");
            }
        });
    }
    
    private void iniciarModeloTabla(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Cedula");
        tblModel.addColumn("Nombre");
        tblModel.addColumn("Celular");
        tblModel.addColumn("Correo");
        tblModel.addColumn("Salario");
        tblModel.addColumn("Horario");
        tblModel.addColumn("");
        tblModel.addColumn("");
    }

    private void CargarTrabajadores(){
        this.iniciarModeloTabla();
        Response<List<Trabajador>> consulta=this.trabajadorCtrl.ObtenerTrabajadores();
        if(consulta.isExitoso()){
            List<Trabajador> trabajadores=consulta.getEntidad();

            for (Trabajador t:trabajadores) {
                tblModel.addRow(new Object[]{t.getCedula(),t.getNombre(),t.getCelular(),t.getCorreo(),t.getSalario(),t.getHorarioLaboral().getHoraInicio()+" - "+t.getHorarioLaboral().getHoraFin(),"Modificar","Eliminar"});
            }
            tablaTrabajadores.setCellSelectionEnabled(false);
            tablaTrabajadores.setModel(tblModel);
            tablaTrabajadores.setRowHeight(30);
            this.add(panelTrabajadores);
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
                String cedula=((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString();
                MostrarTrabajadorForm(cedula);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tablaTrabajadores, update, 6);
    }

    private void AgregarBotonEliminacion(){
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Realemnte desea eliminar al trabajador?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    String cedula=((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString();
                    Response<Boolean> eliminacionT= trabajadorCtrl.EliminarTrabajadorPorCedula(cedula);
                    if(eliminacionT.isExitoso()){
                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Hubo un problema al realizar la eliminación","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaTrabajadores, delete, 7);
    }

    private void MostrarTrabajadorForm(String cedula){
        JFrame jframe = new TrabajadorForm(cedula);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
        jframe.addWindowListener( new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e) {
                CargarTrabajadores();
            }
        });
    }

    /**
     * Thi method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTrabajadores = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nuevoUsuarioButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTrabajadores = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        panelTrabajadores.setLayout(new java.awt.CardLayout());

        nuevoUsuarioButton.setText("Nuevo trabajador");

        tablaTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaTrabajadores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoUsuarioButton)
                .addContainerGap(226, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(nuevoUsuarioButton)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        );

        panelTrabajadores.add(jPanel1, "card2");

        add(panelTrabajadores, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevoUsuarioButton;
    private javax.swing.JPanel panelTrabajadores;
    private javax.swing.JTable tablaTrabajadores;
    // End of variables declaration//GEN-END:variables
}
