package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;

import java.util.List;

public interface ITipoClienteCtrl {
     Response<List<TipoCliente>> ObtenerTipoClientes();
     Response<TipoCliente> ObtenerTipoClientePorId(int id);
     Response<Boolean> EliminarTipoClientePorId(int id);
     Response<Boolean> InsertarTipoCliente(TipoCliente t);
     Response<Boolean> ActualizarTipoCliente(TipoCliente t);
}
