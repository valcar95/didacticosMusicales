package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.ITipoClienteRepositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoClienteRepositorio extends RepositorioBase implements ITipoClienteRepositorio {
    @Override
    public void InsertarTipoCliente (TipoCliente t) throws SQLException{
        Connection con=null;
        PreparedStatement stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[TipoCliente] ([Descripcion],[Descuento],[Recargo]) VALUES(?,?,?)";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, t.getDescripcion());
            stmt.setDouble(2, t.getDescuento());
            stmt.setDouble(3, t.getRecargo());
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
    public void ActualizarTipoCliente (TipoCliente t) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="UPDATE [dbo].[TipoCliente] SET [Descripcion]=?,[Descuento]=?,[Recargo]=? WHERE [Id]=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, t.getDescripcion());
            stmt.setDouble(2, t.getDescuento());
            stmt.setDouble(3, t.getRecargo());
            stmt.setInt(4, t.getId());
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
    public void EliminarTipoClientePorId (int id) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[TipoCliente] WHERE Id=?";
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
    public List<TipoCliente> ObtenerTipoClientes() throws SQLException {
        List<TipoCliente> result= new ArrayList<TipoCliente>();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            con = this.ObtenerConeccion();
            stmt = con.createStatement();
            String SQL = "SELECT * FROM TipoCliente ORDER BY Descripcion";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                TipoCliente t= new TipoCliente();
                t.setId(rs.getInt("Id"));
                t.setDescripcion(rs.getString("Descripcion"));
                t.setDescuento(rs.getDouble("Descuento"));
                t.setRecargo(rs.getDouble("Recargo"));
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
    public TipoCliente ObtenerTipoClientePorId(int id) throws Exception {
        TipoCliente result= null;
        Connection con=null;
        PreparedStatement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT * FROM TipoCliente WHERE Id=?";
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            if (rs.next()) {
                result= new TipoCliente();
                result.setId(rs.getInt("Id"));
                result.setDescripcion(rs.getString("Descripcion"));
                result.setDescuento(rs.getDouble("Descuento"));
                result.setRecargo(rs.getDouble("Recargo"));
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
