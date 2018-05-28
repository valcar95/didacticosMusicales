/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Ventas.Modelo;
/**
 *
 * @author diego
 */
public class Cliente {
    private Identificacion identificacion;
    private String nombre;
    private String codigoDeCliente;
    private Direccion direccion;
    private String correoElectronico;
    private String telefonoFijo;
    private String telefonoMovil;

    public Cliente(Identificacion identificacion, String nombre, String codigoDeCliente, Direccion direccion, String correoElectronico, String telefonoFijo, String telefonoMovil) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.codigoDeCliente = codigoDeCliente;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoDeCliente() {
        return codigoDeCliente;
    }

    public void setCodigoDeCliente(String codigoDeCliente) {
        this.codigoDeCliente = codigoDeCliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
}
