/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author hecto
 */
public class MaterialPorProveedor {
    private Proveedor proveedor;
    private Material material;
    private int precioPorUnidad;
    private int tiempoDeEntrega;

    public MaterialPorProveedor(Proveedor proveedor, Material material, int precioPorUnidad, int tiempoDeEntrega) {
        this.proveedor = proveedor;
        this.material = material;
        this.precioPorUnidad = precioPorUnidad;
        this.tiempoDeEntrega = tiempoDeEntrega;
    }
    
    
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(int precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public int getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public void setTiempoDeEntrega(int tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }
    
    
}
