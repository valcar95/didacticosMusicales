/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hecto
 */
public class Pedido {
    private boolean activo;
    private Date fechaDeLlegada;
    private Date fechaEnvio;
    private int identificador;
    private MaterialPorProveedor materialProveedor;
    private int cantidad;

    public Pedido(boolean activo, Date fechaDeLlegada, Date fechaEnvio, int identificador, MaterialPorProveedor materialProveedor, int cantidad) {
        this.activo = activo;
        this.fechaDeLlegada = fechaDeLlegada;
        this.fechaEnvio = fechaEnvio;
        this.identificador = identificador;
        this.materialProveedor = materialProveedor;
        this.cantidad = cantidad;
    }
    
    
    public Pedido(Date fechaEnvio, int identificador, MaterialPorProveedor materialProveedor, int cantidad) {
        this.fechaEnvio = fechaEnvio;
        this.identificador = identificador;
        this.materialProveedor = materialProveedor;
        this.cantidad = cantidad;
        activo = true;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaDeLlegada() {
        return fechaDeLlegada;
    }

    public void setFechaDeLlegada(Date fechaDeLlegada) {
        this.fechaDeLlegada = fechaDeLlegada;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public MaterialPorProveedor getMaterialProveedor() {
        return materialProveedor;
    }

    public void setMaterialProveedor(MaterialPorProveedor materialProveedor) {
        this.materialProveedor = materialProveedor;
    }
    
    public void recibirPedido(Date fechaLl){
        activo = false;
        fechaDeLlegada = fechaLl;
    }
    public String toString(){
        DateFormat df = new SimpleDateFormat("MM//dd//yyyy HH:mm:ss");
        String fechaE= df.format(fechaEnvio);
        String fechaLL;
        if(fechaDeLlegada != null){
           fechaLL = df.format(fechaDeLlegada);
        }
        else{
            fechaLL = "NOLLEGA";
        }
        
        String t = Integer.toString(identificador) + "," + materialProveedor.getMaterial().getNombre() + ","+ 
                        materialProveedor.getProveedor().getNombre() + "," + 
                        Integer.toString(cantidad) + ","+ Boolean.toString(activo) + "," +
                        fechaE + "," + fechaLL + ",";
        return t;
    }
}
