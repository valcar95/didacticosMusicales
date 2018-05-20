package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import java.util.List;

public interface IClienteCtrl {
     Response<List<Cliente>> ObtenerClientes();
     Response<Cliente> ObtenerClientePorCedula(String cedula);
     Response<Boolean> EliminarClientePorCedula(String cedula);
     Response<Boolean> InsertarCliente(Cliente c);
     Response<Boolean> ActualizarCliente(Cliente c, String cedula);
}
