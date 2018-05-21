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
import didacticosmusicales.Personal.UI.Utilidades.ComboItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author XGAnalista2
 */
public class HorarioForm extends javax.swing.JFrame {

    
    private int idHorario;
    private IHorariosCtrl horariosCtrl;
    
    /**
     * Creates new form HorarioForm
     */
    public HorarioForm(int idHorario) {
        super("Horario laboral");
        initComponents();
        this.horariosCtrl= new HorariosCtrl();
        this.idHorario=idHorario;
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuardarHorario();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.LlenarCombos();
        if(this.idHorario>0){
            this.LlenarCamposHorario();
        }
    }

    private void LlenarCamposHorario(){
        Response<HorarioLaboral> respuesta= this.horariosCtrl.ObtenerHorarioLaboralPorId(this.idHorario);
        if(respuesta.isExitoso()){
            HorarioLaboral h=respuesta.getEntidad();
            this.txtDescripcion.setText(h.getDescripcion());
            this.LlenarCombosHorarios(h);
        }
    }

    private void LlenarCombosHorarios(HorarioLaboral h){
        this.PreseleccionarCombo(this.comboHoraInicio,String.valueOf(h.ObtenerHoraInicio()));
        this.PreseleccionarCombo(this.comboMinutosInicio,String.valueOf(h.ObtenerMinutosInicio()));
        this.PreseleccionarCombo(this.comboAmPmInicio,h.ObtenerAmPmInicio());
        
        this.PreseleccionarCombo(this.comboHoraFin,String.valueOf(h.ObtenerHoraFin()));
        this.PreseleccionarCombo(this.comboMinutosFin,String.valueOf(h.ObtenerMinutosFin()));
        this.PreseleccionarCombo(this.comboAmPmFin,h.ObtenerAmPmFin());
    }

    private void PreseleccionarCombo(JComboBox combo, String valor){
        ComboItem seleccionado=null;
        ComboBoxModel model = combo.getModel();
        int size = model.getSize();
        for(int i=0;i<size;i++) {
            ComboItem item = (ComboItem)model.getElementAt(i);
            if(item.getValue().toLowerCase().equals(valor.toLowerCase())){
                seleccionado=item;
            }
        }
        combo.setSelectedItem(seleccionado);
    }

    private void GuardarHorario(){
        if(this.ValidarCamposLlenos()){
            HorarioLaboral h= this.ObtenerHorarioLaboral();
            if(this.idHorario>0){
                h.setId(this.idHorario);
                Response<Boolean> respuesta= this.horariosCtrl.ActualizarHorarioLaboral(h);
                if(respuesta.isExitoso()){
                    JOptionPane.showMessageDialog(this, "Horario laboral actualizado exitosamente","Actualización exitosa",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, respuesta.getMensajeError(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                Response<Boolean> respuesta= this.horariosCtrl.InsertarHorarioLaboral(h);
                if(respuesta.isExitoso()){
                    JOptionPane.showMessageDialog(this, "Horario laboral registrado exitosamente","Inserción exitosa",JOptionPane.INFORMATION_MESSAGE);
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

    private void LlenarCombos(){
        this.LlenarCombosHoras();
        this.LlenarCombosMinutos();
        this.LlenarCombosAmPm();

    }

    private void LlenarCombosHoras(){
        for (int i=1; i<= 12; i++) {
            String hora=String.valueOf(i);
            if(i<10){
                hora="0"+hora;
            }
            this.comboHoraInicio.addItem(new ComboItem(hora,hora));
            this.comboHoraFin.addItem(new ComboItem(hora,hora));
        }

    }

    private void LlenarCombosMinutos(){
        for (int i=0; i<= 60; i+=5) {
            String minuto=String.valueOf(i);
            if(i<10){
                minuto="0"+minuto;
            }
            this.comboMinutosInicio.addItem(new ComboItem(minuto,minuto));
            this.comboMinutosFin.addItem(new ComboItem(minuto,minuto));
        }
    }

    private void LlenarCombosAmPm(){
        this.comboAmPmInicio.addItem(new ComboItem("AM","AM"));
        this.comboAmPmInicio.addItem(new ComboItem("PM","PM"));
        this.comboAmPmFin.addItem(new ComboItem("AM","AM"));
        this.comboAmPmFin.addItem(new ComboItem("PM","PM"));
    }

    private HorarioLaboral ObtenerHorarioLaboral(){
        HorarioLaboral h= new HorarioLaboral();
        h.setDescripcion(this.txtDescripcion.getText().trim());
        h.setHoraInicio(this.ObtenerHoraCompleta(this.comboHoraInicio,this.comboMinutosInicio,this.comboAmPmInicio));
        h.setHoraFin(this.ObtenerHoraCompleta(this.comboHoraFin,this.comboMinutosFin,this.comboAmPmFin));
        return h;
    }

    private String ObtenerHoraCompleta(JComboBox cHora, JComboBox cMinutos, JComboBox cAmPm){
        String valor=this.ObtenerValorCombo(cHora)+":"+this.ObtenerValorCombo(cMinutos)+" "+this.ObtenerValorCombo(cAmPm);
        return valor;
    }

    private String ObtenerValorCombo(JComboBox combo){
        Object itemCombo = combo.getSelectedItem();
        String valor = ((ComboItem)itemCombo).getValue();
        return valor;
    }

    private Boolean ValidarCamposLlenos(){
        return this.txtDescripcion.getText().trim().length()>0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboHoraInicio = new javax.swing.JComboBox<>();
        comboMinutosInicio = new javax.swing.JComboBox<>();
        comboAmPmInicio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboHoraFin = new javax.swing.JComboBox<>();
        comboMinutosFin = new javax.swing.JComboBox<>();
        comboAmPmFin = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descripción *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Hora inicio *");

        jLabel3.setText("Hora fin *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(comboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboAmPmFin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(comboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboAmPmInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAmPmInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAmPmFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(51, 51, 51)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<ComboItem> comboAmPmFin;
    private javax.swing.JComboBox<ComboItem> comboAmPmInicio;
    private javax.swing.JComboBox<ComboItem> comboHoraFin;
    private javax.swing.JComboBox<ComboItem> comboHoraInicio;
    private javax.swing.JComboBox<ComboItem> comboMinutosFin;
    private javax.swing.JComboBox<ComboItem> comboMinutosInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
