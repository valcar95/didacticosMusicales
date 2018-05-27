/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Dominio;

import java.util.List;

/**
 *
 * @author hecto
 */
public class Producto {

    private String nombre;
    private String id;
    private Material material;
    private int cantMaterial;
    private int precio;
    private int tiempoElaboracion;
    private int cantidadEnInventario;

    public Producto(String nombre, String id, Material material, int cantMaterial, int precio, int tiempoElaboracion) {
        this.nombre = nombre;
        this.id = id;
        this.material = material;
        this.cantMaterial = cantMaterial;
        this.precio = precio;
        this.tiempoElaboracion = tiempoElaboracion;
        this.cantidadEnInventario = 0;
    }

    public Producto(String nombre, String id, Material material, int cantMaterial, int precio, int tiempoElaboracion, int cantidadEnInventario) {
        this.nombre = nombre;
        this.id = id;
        this.material = material;
        this.cantMaterial = cantMaterial;
        this.precio = precio;
        this.tiempoElaboracion = tiempoElaboracion;
        this.cantidadEnInventario = cantidadEnInventario;
    }

    public int getCantidadEnInventario() {
        return cantidadEnInventario;
    }

    public void setCantidadEnInventario(int cantidadEnInventario) {
        this.cantidadEnInventario = cantidadEnInventario;
    }

    public int getCantMaterial() {
        return cantMaterial;
    }

    public void setCantMaterial(int cantMaterial) {
        this.cantMaterial = cantMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTiempoElaboracion() {
        return tiempoElaboracion;
    }

    public void setTiempoElaboracion(int tiempoElaboracion) {
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public void modificarProducto(String nombre, Material material, int cantMaterial, int precio, int tiempoElaboracion) {
        this.setNombre(nombre);
        this.setMaterial(material);
        this.setCantMaterial(cantMaterial);
        this.setPrecio(precio);
        this.setTiempoElaboracion(tiempoElaboracion);
    }

    public String toString() {
        String t = nombre + "," + id + "," + material.getNombre()
                + "," + cantMaterial + "," + precio + "," + tiempoElaboracion 
                + "," + cantidadEnInventario + ",";

        return t;

    }

}
