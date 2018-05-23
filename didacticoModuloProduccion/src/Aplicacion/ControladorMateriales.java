/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Dominio.Produccion;

/**
 *
 * @author hecto
 */
public class ControladorMateriales {
    Produccion produccion;

    public ControladorMateriales(Produccion produccion) {
        this.produccion = produccion;
    }
    public void entregarMaterial(String nombre,int cantidad){
        produccion.entregarMaterial(nombre, cantidad);
    }

    public Produccion getProduccion() {
        return produccion;
    }
    
}
