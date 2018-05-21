package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Interfaces.ITrabajadorCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITrabajadorRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.TrabajadorRepositorio;

import java.util.List;

public class TrabajadorCtrl extends BaseCtrl implements ITrabajadorCtrl {

    private ITrabajadorRepositorio trabajadorRepositorio;

    public TrabajadorCtrl(){
        this.trabajadorRepositorio = new TrabajadorRepositorio();
    }

    @Override
    public Response<List<Trabajador>> ObtenerTrabajadores(){
        Response<List<Trabajador>> result= new Response<List<Trabajador>>();
        try{
            result.setEntidad(this.trabajadorRepositorio.ObtenerTrabajadores());
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Trabajador> ObtenerTrabajadorPorCedula(String cedula){
        Response<Trabajador> result= new Response<Trabajador>();
        try{
            result.setEntidad(this.trabajadorRepositorio.ObtenerTrabajadorPorCedula(cedula));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarTrabajadorPorCedula(String cedula){
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.trabajadorRepositorio.EliminarTrabajadorPorCedula(cedula);
            result.setEntidad(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> InsertarTrabajador(Trabajador t){
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.trabajadorRepositorio.InsertarTrabajador(t);
            result.setEntidad(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> ActualizarTrabajador(Trabajador t, String cedula){
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.trabajadorRepositorio.ActualizarTrabajador(t,cedula);
            result.setEntidad(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }
}
