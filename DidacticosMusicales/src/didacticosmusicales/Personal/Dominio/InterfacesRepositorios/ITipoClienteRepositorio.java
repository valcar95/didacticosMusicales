package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;
import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;
import java.util.List;

public interface ITipoClienteRepositorio {
     void InsertarTipoCliente (TipoCliente t) throws Exception;
     void ActualizarTipoCliente (TipoCliente t) throws Exception;
     void EliminarTipoClientePorId (int id) throws Exception;
     List<TipoCliente> ObtenerTipoClientes() throws Exception;
     TipoCliente ObtenerTipoClientePorId(int id) throws Exception;
}
