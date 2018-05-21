package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IHorarioRepositorio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class HorariosRepositorio extends RepositorioBase implements IHorarioRepositorio {

    @Override
    public List<HorarioLaboral> ObtenerHorarios() throws SQLException {
        List<HorarioLaboral> result= new ArrayList<HorarioLaboral>();
        Connection con=null;
        Statement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            stmt = con.createStatement();
            String SQL = "SELECT * FROM HorarioLaboral HorarioLaboral ORDER BY Descripcion";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                HorarioLaboral h = new HorarioLaboral();
                h.setId(rs.getInt("Id"));
                h.setDescripcion(rs.getString("Descripcion"));
                h.setHoraInicio(rs.getString("HoraInicio"));
                h.setHoraFin(rs.getString("HoraFin"));
                result.add(h);
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
    public void InsertarHorarioLaboral(HorarioLaboral h) throws Exception {
        Connection con=null;
        PreparedStatement stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[HorarioLaboral] ([Descripcion],[HoraInicio],[HoraFin]) VALUES(?,?,?)";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, h.getDescripcion());
            stmt.setString(2, h.getHoraInicio());
            stmt.setString(3, h.getHoraFin());
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
    public void ActualizarHorarioLaboral(HorarioLaboral h) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="UPDATE [dbo].[HorarioLaboral] SET [Descripcion]=?,[HoraInicio]=?,[HoraFin]=? WHERE [Id]=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, h.getDescripcion());
            stmt.setString(2, h.getHoraInicio());
            stmt.setString(3, h.getHoraFin());
            stmt.setInt(4, h.getId());
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
    public void EliminarHorarioLaboralPorId(int id) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[HorarioLaboral] WHERE Id=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, id);
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
    public HorarioLaboral ObtenerHorarioLaboralPorId(int id) throws Exception {
        HorarioLaboral result= null;
        Connection con=null;
        PreparedStatement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT * FROM HorarioLaboral WHERE Id=?";
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            if (rs.next()) {
                result= new HorarioLaboral();
                result.setId(rs.getInt("Id"));
                result.setDescripcion(rs.getString("Descripcion"));
                result.setHoraInicio(rs.getString("HoraInicio"));
                result.setHoraFin(rs.getString("HoraFin"));
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
