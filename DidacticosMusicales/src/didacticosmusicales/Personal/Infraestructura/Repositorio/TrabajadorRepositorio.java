package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITrabajadorRepositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorRepositorio extends RepositorioBase implements ITrabajadorRepositorio {
    @Override
    public void InsertarTrabajador (Trabajador t) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[Trabajador] " +
                    "           ([Cedula],[Celular],[Correo] ,[Nombre] ,[Salario] ,[IdHorario]) " +
                    "     VALUES(?,?,?,?,?,?)";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, t.getCedula());
            stmt.setString(2, t.getCelular());
            stmt.setString(3, t.getCorreo());
            stmt.setString(4, t.getNombre());
            stmt.setDouble(5, t.getSalario());
            stmt.setInt(6, t.getHorarioLaboral().getId());
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
    public void ActualizarTrabajador (Trabajador t,String cedula) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="UPDATE [dbo].[Trabajador] " +
                    "   SET [Cedula]=?,[Celular]=?,[Correo]=?,[Nombre]=?,[Salario]=?,[IdHorario]=? " +
                    " WHERE [Cedula]=?";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, t.getCedula());
            stmt.setString(2, t.getCelular());
            stmt.setString(3, t.getCorreo());
            stmt.setString(4, t.getNombre());
            stmt.setDouble(5, t.getSalario());
            stmt.setInt(6, t.getHorarioLaboral().getId());
            stmt.setString(7, cedula);
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
    public void EliminarTrabajadorPorCedula (String cedula) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[Trabajador] WHERE Cedula=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, cedula);
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
    public List<Trabajador> ObtenerTrabajadores() throws SQLException {
        List<Trabajador> result= new ArrayList<Trabajador>();
        Connection con=null;
        Statement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            stmt = con.createStatement();
            String SQL = "SELECT * FROM Trabajador T INNER JOIN HorarioLaboral L ON T.IdHorario = L.Id ORDER BY T.Nombre";
            rs = stmt.executeQuery(SQL);
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
    public Trabajador ObtenerTrabajadorPorCedula(String cedula) throws SQLException {
        Trabajador result= null;
        Connection con=null;
        PreparedStatement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT * FROM Trabajador T INNER JOIN HorarioLaboral H ON T.IdHorario = H.id WHERE T.Cedula=?";
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, cedula);
            rs=stmt.executeQuery();
            if (rs.next()) {
                result= new Trabajador();
                result.setCedula(rs.getString("Cedula"));
                result.setNombre(rs.getString("Nombre"));
                result.setCelular(rs.getString("Celular"));
                result.setCorreo(rs.getString("Correo"));
                result.setSalario(rs.getDouble("Salario"));
                HorarioLaboral h = new HorarioLaboral();
                h.setId(rs.getInt("Id"));
                h.setDescripcion(rs.getString("Descripcion"));
                h.setHoraInicio(rs.getString("HoraInicio"));
                h.setHoraFin(rs.getString("HoraFin"));
                result.setHorarioLaboral(h);
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
}
