/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Aplicacion;

import didacticosmusicales.ProduccionF.Dominio.MaterialPorProveedor;
import didacticosmusicales.ProduccionF.Dominio.Produccion;
import didacticosmusicales.ProduccionF.Dominio.Proveedor;

/**
 *
 * @author hecto
 */
public class ControladorPedidos {
    Produccion produccion;
    public ControladorPedidos(Produccion p) {
        produccion = p;
    }

    public Produccion getProduccion() {
        return produccion;
    }
    public void recibirPedido(int id){
        produccion.recibirPedido(id);
    }
    public int nuevoPedido(String material, int cantidad, String proveedor){
        Proveedor p = produccion.buscarProveedor(proveedor);
        MaterialPorProveedor mp = p.buscarMaterial(material);
        if(mp == null){
            return 0;
        }
        int id =  produccion.realizarPedido(material, cantidad, proveedor);
        return id;
    }
}
