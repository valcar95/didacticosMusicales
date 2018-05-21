/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Aplicacion.DTO;

/**
 *
 * @author XGAnalista2
 */
public class AsignacionDTO {
    private String cedulaTrabajador;
    private String cedulaCliente;
    private int idServicio;
    private String horaInicio; 
    private String horaFin;
    private String direccion;
    private String fechaInicio;
    private String fechaFin;

    /**
     * @return the cedulaTrabajador
     */
    public String getCedulaTrabajador() {
        return cedulaTrabajador;
    }

    /**
     * @param cedulaTrabajador the cedulaTrabajador to set
     */
    public void setCedulaTrabajador(String cedulaTrabajador) {
        this.cedulaTrabajador = cedulaTrabajador;
    }

    /**
     * @return the cedulaCliente
     */
    public String getCedulaCliente() {
        return cedulaCliente;
    }

    /**
     * @param cedulaCliente the cedulaCliente to set
     */
    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
