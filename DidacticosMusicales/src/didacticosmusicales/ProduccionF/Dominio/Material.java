/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hecto
 */
public class Material {
    private String nombre;
    private List<MaterialPorProveedor> marPro;
    private int cantidadEnInventario;

    public Material(String nombre) {
        this.nombre = nombre;
        marPro = new ArrayList<>();
        cantidadEnInventario = 0;
    
    }

    public Material(String nombre, List<MaterialPorProveedor> marPro) {
        this.nombre = nombre;
        this.marPro = marPro;
        this.marPro = marPro;
        cantidadEnInventario = 0;
    }

    public Material(String nombre, List<MaterialPorProveedor> marPro, int cantidadEnInventario) {
        this.nombre = nombre;
        this.marPro = marPro;
        this.cantidadEnInventario = cantidadEnInventario;
        this.marPro = marPro;
    }
    
    public void agregarProveedor(MaterialPorProveedor mp){
        marPro.add(mp);
    }
    public int getCantidadEnInventario() {
        return cantidadEnInventario;
    }

    public void setCantidadEnInventario(int cantidadEnInventario) {
        this.cantidadEnInventario = cantidadEnInventario;
    }
    

    public List<MaterialPorProveedor> getMarPro() {
        return marPro;
    }

    public void setMarPro(List<MaterialPorProveedor> marPro) {
        this.marPro = marPro;
    }
    
  
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        String t = nombre + "," + cantidadEnInventario + ",";
        return t;
    }
}
