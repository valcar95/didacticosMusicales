package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;

import java.util.List;

public interface IServicioCtrl {
     Response<List<Servicio>> ObtenerServicios();
     Response<Servicio> ObtenerServicioPorId(int id);
     Response<Boolean> EliminarServicioPorId(int id);
     Response<Boolean> InsertarServicio(Servicio s);
     Response<Boolean> ActualizarServicio(Servicio s);
}
