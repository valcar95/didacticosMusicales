package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import java.util.List;

public interface IHorarioRepositorio {
     List<HorarioLaboral> ObtenerHorarios() throws Exception;
     void InsertarHorarioLaboral (HorarioLaboral h) throws Exception;
     void ActualizarHorarioLaboral (HorarioLaboral h) throws Exception;
     void EliminarHorarioLaboralPorId (int id) throws Exception;
     HorarioLaboral ObtenerHorarioLaboralPorId(int id) throws Exception;
}
