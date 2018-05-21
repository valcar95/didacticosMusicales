package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Interfaces.IHorariosCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IHorarioRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.HorariosRepositorio;

import java.util.List;

public class HorariosCtrl extends BaseCtrl implements IHorariosCtrl {

    private IHorarioRepositorio horariosRepositorio;

    public HorariosCtrl(){
        this.horariosRepositorio=new HorariosRepositorio();
    }

    @Override
    public Response<List<HorarioLaboral>> ObtenerHorarios(){
        Response<List<HorarioLaboral>> result= new Response<List<HorarioLaboral>>();
        try{
            result.setEntidad(this.horariosRepositorio.ObtenerHorarios());
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<HorarioLaboral> ObtenerHorarioLaboralPorId(int id) {
        Response<HorarioLaboral> result= new Response<HorarioLaboral>();
        try{
            result.setEntidad(this.horariosRepositorio.ObtenerHorarioLaboralPorId(id));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarHorarioLaboralPorId(int id) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.horariosRepositorio.EliminarHorarioLaboralPorId(id);
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
    public Response<Boolean> InsertarHorarioLaboral(HorarioLaboral h) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.horariosRepositorio.InsertarHorarioLaboral(h);
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
    public Response<Boolean> ActualizarHorarioLaboral(HorarioLaboral h) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.horariosRepositorio.ActualizarHorarioLaboral(h);
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
