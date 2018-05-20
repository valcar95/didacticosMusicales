package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import java.util.List;

public interface ITrabajadorRepositorio {
    void InsertarTrabajador (Trabajador t) throws Exception;
    void ActualizarTrabajador (Trabajador t,String cedula) throws Exception;
    void EliminarTrabajadorPorCedula (String cedula) throws Exception;
    List<Trabajador> ObtenerTrabajadores() throws Exception;
    Trabajador ObtenerTrabajadorPorCedula(String cedula) throws Exception;
}
