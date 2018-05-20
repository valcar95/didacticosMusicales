/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Servicios;

import didacticosmusicales.Personal.Aplicacion.Implementaciones.MaterialCtrl;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.MaterialServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.ServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IMaterialCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IMaterialServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Material;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
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
public class MaterialesServicioForm extends javax.swing.JFrame {

    private int idServicio;
    private IServicioCtrl servicioCtrl;
    private IMaterialCtrl materialCtrl;
    private IMaterialServicioCtrl materialServicioCtrl;
    private List<Material> materialesServicio;
    /**
     * Creates new form MaterialesServicioForm
     */
    public MaterialesServicioForm(int idServicio) {
        initComponents();
        this.idServicio=idServicio;
        this.servicioCtrl= new ServicioCtrl();
        this.materialCtrl= new MaterialCtrl();
        this.materialServicioCtrl= new MaterialServicioCtrl();
        this.ObtenerMaterialesServicio();
        this.ObtenerServicio();
        this.PintarListaMateriales();
    }
    
    private void ObtenerMaterialesServicio(){
        Response<List<Material>> consulta=this.materialServicioCtrl.ObtenerMaterialesServicioPorIdServicio(this.idServicio);
        if(consulta.isExitoso()) {
            this.materialesServicio=consulta.getEntidad();
        }
    }

    private void ObtenerServicio(){
        Response<Servicio> consulta=this.servicioCtrl.ObtenerServicioPorId(this.idServicio);
        if(consulta.isExitoso()) {
            Servicio s= consulta.getEntidad();
            String titulo="Materiales asociados al servicio \""+s.getDescripcion()+"\"";
            this.lblServicio.setText(titulo);
            this.setTitle(titulo);
        }
    }

    private boolean EsMaterialServicio(Material m){
        for (Material trabajdor:this.materialesServicio
                ) {
            if(trabajdor.getId()==m.getId()){
                return true;
            }
        }
        return false;
    }

    private void PintarListaMateriales(){
        Response<List<Material>> consulta=this.materialCtrl.ObtenerMateriales();
        if(consulta.isExitoso()) {
            List<Material> materiales=consulta.getEntidad();
            final DefaultListModel model = new DefaultListModel();
            for (Material m:materiales
                    ) {
                model.addElement(new CheckListItem(m.getNombre(),m,this.EsMaterialServicio(m)));
            }
            this.LlenarListaMaterialesServicio(model);
        }
    }

    private void LlenarListaMaterialesServicio(DefaultListModel model){
        this.listaMateriales.setModel(model);
        this.listaMateriales.setCellRenderer(new CheckListRenderer());
        this.listaMateriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaMateriales.addMouseListener(new MouseAdapter() {
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
                operacionExitosa= GuardarMaterialServicio((Material) item.getData());
            }
            else{
                operacionExitosa=EliminarMaterialServicio((Material) item.getData());
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

    private boolean GuardarMaterialServicio(Material m){
        Response<Boolean> result=this.materialServicioCtrl.InsertarMaterialServicio(m.getId(),this.idServicio);
        return result.isExitoso();
    }

    private boolean EliminarMaterialServicio(Material m){
        Response<Boolean> result=this.materialServicioCtrl.EliminarMaterialServicio(m.getId(),this.idServicio);
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
        listaMateriales = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblServicio.setText("jLabel1");

        jScrollPane1.setViewportView(listaMateriales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(lblServicio)
                .addContainerGap(156, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblServicio)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JList<CheckListItem> listaMateriales;
    // End of variables declaration//GEN-END:variables
}
