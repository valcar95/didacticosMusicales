package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;
import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import java.util.List;
public interface IClienteRepositorio {
     void InsertarCliente (Cliente c) throws Exception;
     void ActualizarCliente (Cliente c, String cedula) throws Exception;
     void EliminarClientePorCedula (String cedula) throws Exception;
     List<Cliente> ObtenerClientes() throws Exception;
     Cliente ObtenerClientePorCedula(String cedula) throws Exception;
}
