package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;

import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import java.util.List;

public interface IServicioRepositorio {
     void InsertarServicio (Servicio s) throws Exception;
     void ActualizarServicio (Servicio s) throws Exception;
     void EliminarServicioPorId (int id) throws Exception;
     List<Servicio> ObtenerServicios() throws Exception;
     Servicio ObtenerServicioPorId(int id) throws Exception;
}
