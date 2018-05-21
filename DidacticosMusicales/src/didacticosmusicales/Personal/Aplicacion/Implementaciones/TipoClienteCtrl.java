package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Interfaces.ITipoClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITipoClienteRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.TipoClienteRepositorio;

import java.util.List;

public class TipoClienteCtrl extends BaseCtrl implements ITipoClienteCtrl {

    private ITipoClienteRepositorio tipoClienteRepositorio;

    public TipoClienteCtrl(){
        this.tipoClienteRepositorio=new TipoClienteRepositorio();
    }

    @Override
    public Response<List<TipoCliente>> ObtenerTipoClientes() {
        Response<List<TipoCliente>> result= new Response<List<TipoCliente>>();
        try{
            result.setEntidad(this.tipoClienteRepositorio.ObtenerTipoClientes());
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<TipoCliente> ObtenerTipoClientePorId(int id) {
        Response<TipoCliente> result= new Response<TipoCliente>();
        try{
            result.setEntidad(this.tipoClienteRepositorio.ObtenerTipoClientePorId(id));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarTipoClientePorId(int id) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.tipoClienteRepositorio.EliminarTipoClientePorId(id);
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
    public Response<Boolean> InsertarTipoCliente(TipoCliente t) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.tipoClienteRepositorio.InsertarTipoCliente(t);
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
    public Response<Boolean> ActualizarTipoCliente(TipoCliente t) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.tipoClienteRepositorio.ActualizarTipoCliente(t);
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
