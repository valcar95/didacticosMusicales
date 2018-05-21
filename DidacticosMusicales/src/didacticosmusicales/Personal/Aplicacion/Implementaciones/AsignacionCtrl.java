/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.DTO.AsignacionDTO;
import didacticosmusicales.Personal.Aplicacion.Factorias.NotificacionFactoria;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IAsignacionCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import didacticosmusicales.Personal.Dominio.Entidades.Persona;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.InterfacesComunicacion.INotificacion;
import didacticosmusicales.Personal.Dominio.InterfacesLocalizacion.ILocalizacion;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IAsignacionRepositorio;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IClienteRepositorio;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IServicioRepositorio;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITrabajadorRepositorio;
import didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.AsignacionServicio;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.IAsignacionServicio;
import didacticosmusicales.Personal.Infraestructura.Localizacion.Localizacion;
import didacticosmusicales.Personal.Infraestructura.Repositorio.AsignacionRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.ClienteRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.ServicioRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.TrabajadorRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public class AsignacionCtrl extends BaseCtrl implements IAsignacionCtrl {

    private ITrabajadorRepositorio trabajadorRepositorio;
    private IAsignacionRepositorio asignacionRepositorio;
    private IServicioRepositorio servicioRepositorio;
    private IAsignacionServicio asignacionServicio;
    private IClienteRepositorio clienteRepositorio;
    private INotificacion notificacion;
    private ILocalizacion localizacion;
    
    public AsignacionCtrl(){
        this.trabajadorRepositorio= new TrabajadorRepositorio();
        this.asignacionRepositorio= new AsignacionRepositorio();
        this.servicioRepositorio= new ServicioRepositorio();
        this.asignacionServicio= new AsignacionServicio();
        this.clienteRepositorio= new ClienteRepositorio();
        this.notificacion=NotificacionFactoria.ObtenerInstanciaNotificacion();
        this.localizacion=new Localizacion();
    }
    
    @Override
    public Response<Boolean> RegistrarAsignacionCliente(AsignacionDTO a) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            Asignacion asignacion=this.ConstruirAsignacion(a);
            Trabajador t= asignacion.getTrabajador();
            List<Asignacion>asignacionesTrabajador=this.asignacionRepositorio.ObtenerAsignacionesPorCedulaTrabajador(a.getCedulaTrabajador());
            if(this.asignacionServicio.ValidarRegistroDeAsignacion(asignacion,asignacionesTrabajador)){
                this.asignacionRepositorio.InsertarAsignacion(asignacion);
                this.NotificarAsignacion(a.getCedulaCliente(),t,asignacion);
                result.setEntidad(true);
            }
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }
    
    @Override
    public Response<List<Asignacion>> ObtenerAsignacionesPorCedulaTrabajador(String cedula) {
         Response<List<Asignacion>> result= new Response<List<Asignacion>>();
        try{
            result.setEntidad(this.asignacionRepositorio.ObtenerAsignacionesPorCedulaTrabajador(cedula));
            result.setExitoso(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }
    
    private Asignacion ConstruirAsignacion (AsignacionDTO a) throws Exception{
        Asignacion asignacion= new Asignacion();
        asignacion.setServicio(this.servicioRepositorio.ObtenerServicioPorId(a.getIdServicio()));
        asignacion.setTrabajador(this.trabajadorRepositorio.ObtenerTrabajadorPorCedula(a.getCedulaTrabajador()));
        asignacion.setHoraInicio(a.getHoraInicio());
        asignacion.setHoraFin(a.getHoraFin());
        asignacion.setFechaInicio(a.getFechaInicio());
        asignacion.setFechaFin(a.getFechaFin());
        LocalidadEnum localidad=this.localizacion.ObtenerLocalidadDesdeDireccion(a.getDireccion());
        asignacion.setLocalidad(localidad);
        return asignacion;
    }
    
    private void NotificarAsignacion(String cedulaCliente, Trabajador t, Asignacion a) throws Exception{
         List<Persona> personalInvolucrado= new ArrayList<Persona>();
         Cliente c=this.clienteRepositorio.ObtenerClientePorCedula(cedulaCliente);
         personalInvolucrado.add(t);
         personalInvolucrado.add(c);
         this.notificacion.Notificar(personalInvolucrado, a);
    }
    
}
