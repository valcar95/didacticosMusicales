/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Ventas.Modelo;

import java.util.*;

/**
 *
 * @author diego
 */
public class Paquete {
    private ArrayList<Producto> listaDeProductos;
    private ArrayList<Servicio> listaDeServicios;

    public Paquete(ArrayList<Producto> listaDeProductos, ArrayList<Servicio> listaDeServicios) {
        this.listaDeProductos = listaDeProductos;
        this.listaDeServicios = listaDeServicios;
    }

    public ArrayList<Servicio> getListaDeServicios() {
        return listaDeServicios;
    }

    public void setListaDeServicios(ArrayList<Servicio> listaDeServicios) {
        this.listaDeServicios = listaDeServicios;
    }

    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(ArrayList<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }
}
