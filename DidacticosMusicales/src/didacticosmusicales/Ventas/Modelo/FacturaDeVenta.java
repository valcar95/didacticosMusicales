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
public class FacturaDeVenta {
    private String numeroDeFactura;
    private Cliente cliente;
    private Paquete paqueteAdquirido;
    private double precioBase;
    private double valorImpuestos;
    private double totalDescuento;
    private double totalRecargo;
    private double valorTotal;
}
