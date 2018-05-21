package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Interfaces.IClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IClienteRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.ClienteRepositorio;

import java.util.List;

public class ClienteCtrl extends BaseCtrl implements IClienteCtrl {

    private IClienteRepositorio clienteRepositorio;

    public ClienteCtrl(){
        this.clienteRepositorio= new ClienteRepositorio();
    }

    @Override
    public Response<List<Cliente>> ObtenerClientes() {
        Response<List<Cliente>> result= new Response<List<Cliente>>();
        try{
            result.setEntidad(this.clienteRepositorio.ObtenerClientes());
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Cliente> ObtenerClientePorCedula(String cedula) {
        Response<Cliente> result= new Response<Cliente>();
        try{
            result.setEntidad(this.clienteRepositorio.ObtenerClientePorCedula(cedula));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarClientePorCedula(String cedula) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.clienteRepositorio.EliminarClientePorCedula(cedula);
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
    public Response<Boolean> InsertarCliente(Cliente c) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.clienteRepositorio.InsertarCliente(c);
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
    public Response<Boolean> ActualizarCliente(Cliente c, String cedula) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.clienteRepositorio.ActualizarCliente(c,cedula);
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
