package didacticosmusicales.Personal.Dominio.InterfacesRepositorios;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import java.util.List;

public interface ITrabajadorServicioRepositorio {
    List<Trabajador> ObtenerTrabajadoresServicioPorIdServicio(int idServicio)  throws Exception;
    void InsertarTrabajadorServicio (String cedulaTrabajador, int idServicio) throws Exception;
    void EliminarTrabajadorServicio (String cedulaTrabajador, int idServicio) throws Exception;
}
