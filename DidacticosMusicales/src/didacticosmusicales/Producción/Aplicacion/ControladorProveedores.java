/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hecto
 */
public class ControladorProveedores {
    Produccion produccion;
    Proveedor proveedorActual;
    public ControladorProveedores(Produccion p) {
        produccion = p;
    }

    public Proveedor getProveedorActual() {
        return proveedorActual;
    }
    
    public void agregarNuevoProveedor(String nombre, String telefono, String webSite, String Material, int precio, int tiempo){
        produccion.ingresarNuevoProveedor(nombre, telefono, webSite, Material, precio, tiempo);
        System.out.println("daniel");
    }
    public void modificarProveedor(String nombre, String telefono, String webSite){
        Proveedor p = produccion.buscarProveedor(nombre);
        p.setTelefono(telefono);
        p.setWebSite(webSite);
    }
    public void buscarProveedor(String nombre){
        Proveedor p = produccion.buscarProveedor(nombre);
        proveedorActual = p;        
    }
    public void agregarMaterialProveedor(String nombre, String material,int precio, int tiempo){
        produccion.agregarMaterial(nombre, material, precio, tiempo);
    }
    public String darTelefono(){
        return proveedorActual.getTelefono();
    }
    public String darwebSite(){
        return proveedorActual.getWebSite();
    }
    public List<String> darInformacionMaterial(String material){
        ArrayList<String> informacion = new ArrayList<>();        
        String i = Integer.toString(proveedorActual.buscarMaterial(material).getPrecioPorUnidad());
        informacion.add(i);
        i = Integer.toString(proveedorActual.buscarMaterial(material).getTiempoDeEntrega());
        informacion.add(i);
        return informacion;
    }
    public Produccion getProduccion() {
        return produccion;
    }
    public void eliminarProveedorActual(){
        produccion.eliminarProveedor(proveedorActual);
    }
}
