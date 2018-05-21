/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Entidades;

import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import javafx.util.Pair;

/**
 *
 * @author XGAnalista2
 */
public class Asignacion extends Horario {
    private int Id;
    private Trabajador Trabajador;
    private Servicio Servicio;
    private LocalidadEnum Localidad;
    private String FechaInicio;
    private String FechaFin;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Trabajador
     */
    public Trabajador getTrabajador() {
        return Trabajador;
    }

    /**
     * @param Trabajador the Trabajador to set
     */
    public void setTrabajador(Trabajador Trabajador) {
        this.Trabajador = Trabajador;
    }

    /**
     * @return the Servicio
     */
    public Servicio getServicio() {
        return Servicio;
    }

    /**
     * @param Servicio the Servicio to set
     */
    public void setServicio(Servicio Servicio) {
        this.Servicio = Servicio;
    }

    /**
     * @return the Localidad
     */
    public LocalidadEnum getLocalidad() {
        return Localidad;
    }

    /**
     * @param Localidad the Localidad to set
     */
    public void setLocalidad(LocalidadEnum Localidad) {
        this.Localidad = Localidad;
    }

    /**
     * @return the FechaInicio
     */
    public String getFechaInicio() {
        return FechaInicio;
    }

    /**
     * @param FechaInicio the FechaInicio to set
     */
    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    /**
     * @return the FechaFin
     */
    public String getFechaFin() {
        return FechaFin;
    }

    /**
     * @param FechaFin the FechaFin to set
     */
    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }
   
}
