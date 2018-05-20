/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Clientes;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.ClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.TipoClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.ITipoClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;
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
public class ClienteForm extends javax.swing.JFrame {

    private String cedulaCliente;
    private IClienteCtrl clienteCtrl;
    private ITipoClienteCtrl tipoClienteCtrl;
    /**
     * Creates new form ClienteForm
     */
    public ClienteForm(String cedulaCliente) {
        super("Cliente");
        initComponents();
        this.cedulaCliente=cedulaCliente;
        this.clienteCtrl= new ClienteCtrl();
        this.tipoClienteCtrl= new TipoClienteCtrl();
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuardarCliente();
            }
        });
        this.LlenarComboTiposCliente();
        if(this.cedulaCliente.length()>0){
            this.LlenarCamposCliente();
        }
    }

    
     private void LlenarComboTiposCliente(){
        Response<List<TipoCliente>> respuesta= this.tipoClienteCtrl.ObtenerTipoClientes();
        if(respuesta.isExitoso()) {
            List<TipoCliente> tiposCliente=respuesta.getEntidad();
            for (TipoCliente t:tiposCliente
                    ) {
                this.comboTipoCliente.addItem(new ComboItem(t.getDescripcion(),String.valueOf(t.getId())));
            }
        }
    }

    private void LlenarCamposCliente(){
        Response<Cliente> respuesta= this.clienteCtrl.ObtenerClientePorCedula(this.cedulaCliente);
        if(respuesta.isExitoso()){
            Cliente c=respuesta.getEntidad();
            this.txtCedula.setText(c.getCedula());
            this.txtNombre.setText(c.getNombre());
            this.txtCelular.setText(c.getCelular());
            this.txtCorreo.setText(c.getCorreo());
            this.txtDireccion.setText(c.getDireccion());
            ComboItem seleccionado=null;
            ComboBoxModel model = comboTipoCliente.getModel();
            int size = model.getSize();
            String idHorario=String.valueOf(c.getTipoCliente().getId());
            for(int i=0;i<size;i++) {
                ComboItem item = (ComboItem)model.getElementAt(i);
                if(item.getValue().equals(idHorario)){
                    seleccionado=item;
                }
            }
            this.comboTipoCliente.setSelectedItem(seleccionado);
        }
    }

    private void GuardarCliente(){
        if(this.ValidarCamposLlenos()){
            Cliente c= this.ObtenerCliente();
            if(this.cedulaCliente.length()>0){
                Response<Boolean> respuesta= this.clienteCtrl.ActualizarCliente(c,this.cedulaCliente);
                if(respuesta.isExitoso()){
                    JOptionPane.showMessageDialog(this, "Cliente actualizado exitosamente","Actualización exitosa",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, respuesta.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                Response<Boolean> respuesta= this.clienteCtrl.InsertarCliente(c);
                if(respuesta.isExitoso()){
                    JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente","Inserción exitosa",JOptionPane.INFORMATION_MESSAGE);
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

    private Cliente ObtenerCliente(){
        Cliente c= new Cliente();
        c.setCedula(this.txtCedula.getText().trim());
        c.setNombre(this.txtNombre.getText().trim());
        c.setCelular(this.txtCelular.getText().trim());
        c.setCorreo(this.txtCorreo.getText().trim());
        c.setDireccion(this.txtDireccion.getText().trim());
        Object itemCombo = comboTipoCliente.getSelectedItem();
        String idTipoClienteStr = ((ComboItem)itemCombo).getValue();
        TipoCliente t= new TipoCliente();
        t.setId(Integer.parseInt(idTipoClienteStr));
        c.setTipoCliente(t);
        return c;
    }

    private Boolean ValidarCamposLlenos(){
        Object item = comboTipoCliente.getSelectedItem();
        String value = ((ComboItem)item).getValue();
        return this.txtCedula.getText().trim().length()>0 &&
                this.txtNombre.getText().trim().length()>0 &&
                this.txtCelular.getText().trim().length()>0 &&
                this.txtCorreo.getText().trim().length()>0 &&
                this.txtDireccion.getText().trim().length()>0 &&
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

        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboTipoCliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cédula *");

        jLabel2.setText("Nombre *");

        jLabel3.setText("Dirección *");

        jLabel4.setText("Tipo de cliente *");

        jLabel5.setText("Celular *");

        jLabel6.setText("Correo *");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(btnCancelar)
                    .addComponent(comboTipoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<ComboItem> comboTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
