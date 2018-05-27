/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hecto
 */
public class Proveedor {
    private String nombre;
    private String telefono;
    private String webSite;
    private List<MaterialPorProveedor> materiales;

    public Proveedor(String nombre, String telefono, String webSite) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.webSite = webSite;
        materiales = new ArrayList<MaterialPorProveedor>();
    }

    public Proveedor() {
        materiales = new ArrayList<MaterialPorProveedor>();
    }
    public void agregrarMatProveedor(MaterialPorProveedor mp){
        materiales.add(mp);
    }
    public MaterialPorProveedor buscarMaterial(String material){
        Iterator<MaterialPorProveedor> it = materiales.iterator();
        while(it.hasNext()){
            MaterialPorProveedor p = it.next();
            if(p.getMaterial().getNombre().equals(material)){
                return p;
            }
        }
        return null;
        
    }
            
    public List<MaterialPorProveedor> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<MaterialPorProveedor> materiales) {
        this.materiales = materiales;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    public void enviarPedidoPorWebsite(MaterialPorProveedor mp, int cantidad){
        
    }
    public void enviarPedidoPorTelefono(){
        
    }
    public void agregarMaterial(Material m, int precio, int tiempo){
        MaterialPorProveedor mp = null;
        mp = new MaterialPorProveedor(this, m,precio, tiempo);             
        m.agregarProveedor(mp);          
        this.agregrarMatProveedor(mp);
    }
    public String toString(){
        String texto = nombre+","+telefono+","+webSite;
        for(int i = 0; i < materiales.size();i++){
            texto = texto + "["+materiales.get(i).getMaterial().getNombre() + ","+materiales.get(i).getPrecioPorUnidad() +","+materiales.get(i).getTiempoDeEntrega()+"]";
        }
        return texto;
    }
}
