package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Interfaces.IServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IServicioRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.ServicioRepositorio;

import java.util.List;

public class ServicioCtrl extends BaseCtrl implements IServicioCtrl {

    private IServicioRepositorio servicioRepositorio;

    public ServicioCtrl(){
        servicioRepositorio= new ServicioRepositorio();
    }

    @Override
    public Response<List<Servicio>> ObtenerServicios() {
        Response<List<Servicio>> result= new Response<List<Servicio>>();
        try{
            result.setEntidad(this.servicioRepositorio.ObtenerServicios());
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Servicio> ObtenerServicioPorId(int id) {
        Response<Servicio> result= new Response<Servicio>();
        try{
            result.setEntidad(this.servicioRepositorio.ObtenerServicioPorId(id));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarServicioPorId(int id) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.servicioRepositorio.EliminarServicioPorId(id);
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
    public Response<Boolean> InsertarServicio(Servicio s) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.servicioRepositorio.InsertarServicio(s);
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
    public Response<Boolean> ActualizarServicio(Servicio s) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.servicioRepositorio.ActualizarServicio(s);
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
