package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Interfaces.ITrabajadorServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITrabajadorServicioRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.TrabajadorServicioRepositorio;

import java.util.List;

public class TrabajadorServicioCtrl extends BaseCtrl implements ITrabajadorServicioCtrl {

    private ITrabajadorServicioRepositorio trabajadorServicioRepositorio;

    public TrabajadorServicioCtrl(){
        this.trabajadorServicioRepositorio= new TrabajadorServicioRepositorio();
    }

    @Override
    public Response<List<Trabajador>> ObtenerTrabajadoresServicioPorIdServicio(int idServicio) {
        Response<List<Trabajador>> result= new Response<List<Trabajador>>();
        try{
            result.setEntidad(this.trabajadorServicioRepositorio.ObtenerTrabajadoresServicioPorIdServicio(idServicio));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> InsertarTrabajadorServicio(String cedulaTrabajador, int idServicio) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.trabajadorServicioRepositorio.InsertarTrabajadorServicio(cedulaTrabajador,idServicio);
            result.setExitoso(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarTrabajadorServicio(String cedulaTrabajador, int idServicio) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.trabajadorServicioRepositorio.EliminarTrabajadorServicio(cedulaTrabajador,idServicio);
            result.setExitoso(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }
}
