package didacticosmusicales.Personal.Infraestructura.Repositorio;


import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITrabajadorServicioRepositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorServicioRepositorio extends RepositorioBase implements ITrabajadorServicioRepositorio {
    @Override
    public List<Trabajador> ObtenerTrabajadoresServicioPorIdServicio(int idServicio) throws SQLException {
        List<Trabajador> result= new ArrayList<Trabajador>();
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT A.*,B.* FROM Trabajador A " +
                            "INNER JOIN HorarioLaboral B ON A.Idhorario=B.Id " +
                            "INNER JOIN TrabajadorServicio C ON C.CedulaTrabajador=A.Cedula " +
                            "WHERE C.Idservicio=?";
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, idServicio);
            rs=stmt.executeQuery();
            while (rs.next()) {
                Trabajador t= new Trabajador();
                t.setCedula(rs.getString("Cedula"));
                t.setNombre(rs.getString("Nombre"));
                t.setCelular(rs.getString("Celular"));
                t.setCorreo(rs.getString("Correo"));
                t.setSalario(rs.getDouble("Salario"));
                HorarioLaboral h = new HorarioLaboral();
                h.setId(rs.getInt("Id"));
                h.setDescripcion(rs.getString("Descripcion"));
                h.setHoraInicio(rs.getString("HoraInicio"));
                h.setHoraFin(rs.getString("HoraFin"));
                t.setHorarioLaboral(h);
                result.add(t);
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
        return result;
    }

    @Override
    public void InsertarTrabajadorServicio(String cedulaTrabajador, int idServicio) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[TrabajadorServicio] " +
                    "           ([CedulaTrabajador],[idServicio]) " +
                    "     VALUES(?,?)";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, cedulaTrabajador);
            stmt.setInt(2, idServicio);
            stmt.execute();
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void EliminarTrabajadorServicio(String cedulaTrabajador, int idServicio) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[TrabajadorServicio] WHERE CedulaTrabajador=? AND idServicio=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, cedulaTrabajador);
            stmt.setInt(2, idServicio);
            stmt.execute();
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
}
