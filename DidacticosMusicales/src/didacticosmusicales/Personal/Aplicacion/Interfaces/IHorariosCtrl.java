package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import java.util.List;

public interface IHorariosCtrl {
    Response<List<HorarioLaboral>> ObtenerHorarios();
     Response<HorarioLaboral> ObtenerHorarioLaboralPorId(int id);
     Response<Boolean> EliminarHorarioLaboralPorId(int id);
     Response<Boolean> InsertarHorarioLaboral(HorarioLaboral h);
     Response<Boolean> ActualizarHorarioLaboral(HorarioLaboral h);
}
