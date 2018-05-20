package didacticosmusicales.Personal.Aplicacion.Interfaces;

import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;

import java.util.List;

public interface ITrabajadorCtrl {
     Response<List<Trabajador>> ObtenerTrabajadores();
     Response<Trabajador> ObtenerTrabajadorPorCedula(String cedula);
     Response<Boolean> EliminarTrabajadorPorCedula(String cedula);
     Response<Boolean> InsertarTrabajador(Trabajador t);
     Response<Boolean> ActualizarTrabajador(Trabajador t, String cedula);
}
