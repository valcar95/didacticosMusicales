/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Trabajadores;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.HorariosCtrl;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.TrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IHorariosCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.ITrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.UI.Utilidades.ComboItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author XGAnalista2
 */
public class TrabajadorForm extends javax.swing.JFrame {

    private String cedulaTrabajador;
    private ITrabajadorCtrl trabajadorCtrl;
    private IHorariosCtrl horariosCtrl;
    
    /**
     * Creates new form TrabajadorForm
     */
    public TrabajadorForm(String cedulaTrabajador) {
        super("Trabajador");
        initComponents();
        this.trabajadorCtrl = new TrabajadorCtrl();
        this.horariosCtrl=new HorariosCtrl();
        this.cedulaTrabajador=cedulaTrabajador;
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuardarTrabajador();
            }
        });
        this.LlenarComboHorarios();
        if(this.cedulaTrabajador.length()>0){
            this.LlenarCamposTrabajador();
        }
    }
    
     private void LlenarComboHorarios(){
        Response<List<HorarioLaboral>> respuesta= this.horariosCtrl.ObtenerHorarios();
        if(respuesta.isExitoso()) {
            List<HorarioLaboral> horariosH=respuesta.getEntidad();
            for (HorarioLaboral h:horariosH
                 ) {
                this.comboHorario.addItem(new ComboItem(h.getDescripcion()+" ("+h.getHoraInicio()+" -- "+h.getHoraFin()+")",String.valueOf(h.getId())));
            }
        }
    }

    private void LlenarCamposTrabajador(){
        Response<Trabajador> respuesta= this.trabajadorCtrl.ObtenerTrabajadorPorCedula(this.cedulaTrabajador);
        if(respuesta.isExitoso()){
            Trabajador t=respuesta.getEntidad();
            this.txtCedula.setText(t.getCedula());
            this.txtNombre.setText(t.getNombre());
            this.txtCelular.setText(t.getCelular());
            this.txtCorreo.setText(t.getCorreo());
            this.txtSalario.setText(String.valueOf(t.getSalario()));
            ComboItem seleccionado=null;
            ComboBoxModel model = comboHorario.getModel();
            int size = model.getSize();
            String idHorario=String.valueOf(t.getHorarioLaboral().getId());
            for(int i=0;i<size;i++) {
                ComboItem item = (ComboItem)model.getElementAt(i);
                if(item.getValue().equals(idHorario)){
                    seleccionado=item;
                }
            }
            this.comboHorario.setSelectedItem(seleccionado);
        }
    }

    private void GuardarTrabajador(){
        if(this.ValidarCamposLlenos()){
            Trabajador t= this.ObtenerTrabajador();
            if(this.cedulaTrabajador.length()>0){
                Response<Boolean> respuesta= this.trabajadorCtrl.ActualizarTrabajador(t,this.cedulaTrabajador);
                if(respuesta.isExitoso()){
                    JOptionPane.showMessageDialog(this, "Trabajador actualizado exitosamente","Actualización exitosa",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, respuesta.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                Response<Boolean> respuesta= this.trabajadorCtrl.InsertarTrabajador(t);
                if(respuesta.isExitoso()){
                    JOptionPane.showMessageDialog(this, "Trabajador registrado exitosamente","Inserción exitosa",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, respuesta.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los campos obligatorios (*)","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private Trabajador ObtenerTrabajador(){
        Trabajador t= new Trabajador();
        t.setCedula(this.txtCedula.getText().trim());
        t.setNombre(this.txtNombre.getText().trim());
        t.setCelular(this.txtCelular.getText().trim());
        t.setCorreo(this.txtCorreo.getText().trim());
        t.setSalario(Double.parseDouble(this.txtSalario.getText().trim()));
        Object itemCombo = comboHorario.getSelectedItem();
        String idHorarioStr = ((ComboItem)itemCombo).getValue();
        HorarioLaboral h= new HorarioLaboral();
        h.setId(Integer.parseInt(idHorarioStr));
        t.setHorarioLaboral(h);
        return t;
    }

    private Boolean ValidarCamposLlenos(){

        Object item = comboHorario.getSelectedItem();
        String value = ((ComboItem)item).getValue();

        return this.txtCedula.getText().trim().length()>0 &&
                this.txtNombre.getText().trim().length()>0 &&
                this.txtCelular.getText().trim().length()>0 &&
                this.txtCorreo.getText().trim().length()>0 &&
                this.txtSalario.getText().trim().length()>0 &&
                Integer.parseInt(value)>0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboHorario = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Celular *");

        txtCelular.setMaximumSize(new java.awt.Dimension(180, 0));
        txtCelular.setMinimumSize(new java.awt.Dimension(180, 0));
        txtCelular.setPreferredSize(new java.awt.Dimension(180, 0));

        jLabel5.setText("Correo *");

        txtCorreo.setMaximumSize(new java.awt.Dimension(180, 0));
        txtCorreo.setMinimumSize(new java.awt.Dimension(180, 0));
        txtCorreo.setPreferredSize(new java.awt.Dimension(180, 0));

        jLabel6.setText("Horario Laboral *");

        comboHorario.setMaximumSize(new java.awt.Dimension(180, 0));
        comboHorario.setMinimumSize(new java.awt.Dimension(180, 0));
        comboHorario.setPreferredSize(new java.awt.Dimension(180, 0));

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        jLabel7.setText("Cédula *");

        txtCedula.setMaximumSize(new java.awt.Dimension(180, 0));
        txtCedula.setMinimumSize(new java.awt.Dimension(180, 0));
        txtCedula.setPreferredSize(new java.awt.Dimension(180, 0));

        jLabel8.setText("Nombre *");

        txtNombre.setMaximumSize(new java.awt.Dimension(180, 0));
        txtNombre.setMinimumSize(new java.awt.Dimension(180, 0));
        txtNombre.setPreferredSize(new java.awt.Dimension(180, 0));

        jLabel9.setText("Salario *");

        txtSalario.setMaximumSize(new java.awt.Dimension(180, 0));
        txtSalario.setMinimumSize(new java.awt.Dimension(180, 0));
        txtSalario.setPreferredSize(new java.awt.Dimension(180, 0));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(comboHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<ComboItem> comboHorario;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
