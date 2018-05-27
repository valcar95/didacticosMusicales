/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Aplicacion;

import didacticosmusicales.ProduccionF.Dominio.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hecto
 */
public class ControladorProductos {
    Produccion produccion;
    Producto productoActual;
    public ControladorProductos(Produccion p) {
        produccion = p;
    }
    public void agregarNuevoProducto(String nombre, String id, String material, int cantMaterial, int precio, int tiempoElaboracion){
        Producto p = produccion.getInventario().buscarProducto(id);
        if(p != null){
            System.out.println("Ya se encuentra el producto");
            return;
        }
        produccion.ingresarNuevoProducto(nombre, id, material, cantMaterial, precio, tiempoElaboracion);
    }
    public void modificarProducto(String nombre, String material, int cantMaterial, int precio, int tiempoElaboracion){
        produccion.modificarProducto(productoActual.getId(), nombre, material, cantMaterial, precio, tiempoElaboracion);
    }
    public void buscarProducto(String id){
        productoActual = produccion.getInventario().buscarProducto(id);        
    }
    public List<String> darInfoProductoActual(){
        ArrayList<String> info = new ArrayList<>();
        info.add(productoActual.getNombre());
        info.add(productoActual.getMaterial().getNombre());
        info.add(Integer.toString(productoActual.getCantMaterial()));
        info.add(Integer.toString(productoActual.getPrecio()));
        
        info.add(Integer.toString(productoActual.getTiempoElaboracion()));
        return info;
    }
    public void eliminarProductoActual(){
        produccion.eliminarProducto(productoActual.getId());
    }
            
    
}
