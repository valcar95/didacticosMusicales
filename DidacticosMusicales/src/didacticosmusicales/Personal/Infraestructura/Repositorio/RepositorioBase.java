package didacticosmusicales.Personal.Infraestructura.Repositorio;
import java.sql.*;
public class RepositorioBase {
    String connectionUrl = "jdbc:sqlserver://SQL5017.site4now.net;database=DB_9EF6CA_DM;user=DB_9EF6CA_DM_admin;password=futuro32";
    Connection con=null;
    public Connection  ObtenerConeccion(){
        try {
           return DriverManager.getConnection(connectionUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
