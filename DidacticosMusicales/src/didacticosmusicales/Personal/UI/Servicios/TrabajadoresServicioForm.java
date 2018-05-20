/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Servicios;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.ServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.TrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.TrabajadorServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.ITrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.ITrabajadorServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.UI.Utilidades.Timeout;
import didacticosmusicales.Personal.UI.Utilidades.checkList.CheckListItem;
import didacticosmusicales.Personal.UI.Utilidades.checkList.CheckListRenderer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author XGAnalista2
 */
public class TrabajadoresServicioForm extends javax.swing.JFrame {

    private int idServicio;
    private ITrabajadorServicioCtrl trabajadorServicioCtrl;
    private ITrabajadorCtrl trabajadorCtrl;
    private IServicioCtrl servicioCtrl;
    private List<Trabajador> trabajadoresServicio;
    /**
     * Creates new form TrabajadoresServicioForm
     */
    public TrabajadoresServicioForm(int idServicio) {
        initComponents();
        this.idServicio=idServicio;
        this.trabajadorServicioCtrl= new TrabajadorServicioCtrl();
        this.trabajadorCtrl= new TrabajadorCtrl();
        this.servicioCtrl= new ServicioCtrl();
        this.ObtenerTrabajadoresServicio();
        this.ObtenerServicio();
        this.PintarListaTrabajadores();
    }

     private void ObtenerServicio(){
        Response<Servicio> consulta=this.servicioCtrl.ObtenerServicioPorId(this.idServicio);
        if(consulta.isExitoso()) {
            Servicio s= consulta.getEntidad();
            String titulo="Trabajadores asociados al servicio \""+s.getDescripcion()+"\"";
            this.lblServicio.setText(titulo);
            this.setTitle(titulo);
        }
    }

    private void ObtenerTrabajadoresServicio(){
        Response<List<Trabajador>> consulta=this.trabajadorServicioCtrl.ObtenerTrabajadoresServicioPorIdServicio(this.idServicio);
        if(consulta.isExitoso()) {
            this.trabajadoresServicio=consulta.getEntidad();
        }
    }

    private boolean EsTrabajadorServicio(Trabajador t){
        for (Trabajador trabajdor:this.trabajadoresServicio
             ) {
            if(trabajdor.getCedula().equals(t.getCedula())){
                return true;
            }
        }
        return false;
    }

    private void PintarListaTrabajadores(){
        Response<List<Trabajador>> consulta=this.trabajadorCtrl.ObtenerTrabajadores();
        if(consulta.isExitoso()) {
            List<Trabajador> trabajadores=consulta.getEntidad();
            final DefaultListModel model = new DefaultListModel();
            for (Trabajador t:trabajadores
                 ) {
                model.addElement(new CheckListItem(t.getNombre()+" ("+t.getCedula()+")",t,this.EsTrabajadorServicio(t)));
            }
            this.LlenarListaTrabajadoresServicio(model);
        }
    }

    private void LlenarListaTrabajadoresServicio(DefaultListModel model){
        this.listaTrabajadores.setModel(model);
        this.listaTrabajadores.setCellRenderer(new CheckListRenderer());
        this.listaTrabajadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaTrabajadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                JList list = (JList) event.getSource();
                int index = list.locationToIndex(event.getPoint());// Get index of item
                // clicked
                CheckListItem item = (CheckListItem) list.getModel()
                        .getElementAt(index);
                ItemSeleccionado(item,list,index);
            }
        });
    }

    private void ItemSeleccionado(CheckListItem item,JList list, int index){
        String labelItem=item.getLabel();
        item.setLabel(labelItem+" "+"Guardando...");
        item.setSelected(!item.isSelected());
        list.repaint(list.getCellBounds(index, index));
        Timeout.setTimeout(()->{
            boolean operacionExitosa=false;
            if(item.isSelected()){
                operacionExitosa= GuardarTrabajadorServicio((Trabajador) item.getData());
            }
            else{
                operacionExitosa=EliminarTrabajadorServicio((Trabajador) item.getData());
            }
            if(operacionExitosa){
                item.setLabel(labelItem+" "+"OK");
                Timeout.setTimeout(() -> {
                    item.setLabel(labelItem);
                    list.repaint(list.getCellBounds(index, index));
                }, 1500);
            }
            else{
                item.setSelected(!item.isSelected());
                item.setLabel(labelItem+" "+"ERROR...");
                Timeout.setTimeout(() -> {
                    item.setLabel(labelItem);
                    list.repaint(list.getCellBounds(index, index));
                }, 1500);
            }
            list.repaint(list.getCellBounds(index, index));

        },10);
    }

    private boolean GuardarTrabajadorServicio(Trabajador t){
        Response<Boolean> result=this.trabajadorServicioCtrl.InsertarTrabajadorServicio(t.getCedula(),this.idServicio);
        return result.isExitoso();
    }

    private boolean EliminarTrabajadorServicio(Trabajador t){
        Response<Boolean> result=this.trabajadorServicioCtrl.EliminarTrabajadorServicio(t.getCedula(),this.idServicio);
        return result.isExitoso();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServicio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTrabajadores = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblServicio.setText("jLabel1");

        jScrollPane1.setViewportView(listaTrabajadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblServicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblServicio)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JList<CheckListItem> listaTrabajadores;
    // End of variables declaration//GEN-END:variables
}
