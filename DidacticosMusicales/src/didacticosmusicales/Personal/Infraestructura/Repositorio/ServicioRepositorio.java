package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IServicioRepositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicioRepositorio extends RepositorioBase implements IServicioRepositorio {
    @Override
    public void InsertarServicio(Servicio s) throws Exception {
        Connection con=null;
        PreparedStatement stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[Servicio] ([Descripcion]) VALUES(?)";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, s.getDescripcion());
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
    public void ActualizarServicio(Servicio s) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="UPDATE [dbo].[Servicio] SET [Descripcion]=? WHERE [Id]=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, s.getDescripcion());
            stmt.setInt(2, s.getId());
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
    public void EliminarServicioPorId(int id) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[Servicio] WHERE Id=?";
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
    public List<Servicio> ObtenerServicios() throws Exception {
        List<Servicio> result= new ArrayList<Servicio>();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            con = this.ObtenerConeccion();
            stmt = con.createStatement();
            String SQL = "SELECT * FROM Servicio ORDER BY Descripcion";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Servicio s= new Servicio();
                s.setId(rs.getInt("Id"));
                s.setDescripcion(rs.getString("Descripcion"));
                result.add(s);
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
    public Servicio ObtenerServicioPorId(int id) throws Exception {
        Servicio result= null;
        Connection con=null;
        PreparedStatement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT * FROM Servicio WHERE Id=?";
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            if (rs.next()) {
                result= new Servicio();
                result.setId(rs.getInt("Id"));
                result.setDescripcion(rs.getString("Descripcion"));
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
