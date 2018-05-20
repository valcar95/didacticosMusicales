package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;

import java.util.List;

public interface ITrabajadorServicioCtrl {
    Response<List<Trabajador>> ObtenerTrabajadoresServicioPorIdServicio(int idServicio);
    Response<Boolean> InsertarTrabajadorServicio (String cedulaTrabajador, int idServicio);
    Response<Boolean> EliminarTrabajadorServicio (String cedulaTrabajador, int idServicio);
}
