package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import didacticosmusicales.Personal.Dominio.Entidades.TipoCliente;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IClienteRepositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio extends RepositorioBase implements IClienteRepositorio {
    @Override
    public void InsertarCliente (Cliente c) throws SQLException {
        Connection con=null;
        PreparedStatement stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[Cliente] " +
                    "           ([Cedula],[Celular],[Correo],[Nombre],[Direccion],[TipoCliente]) " +
                    "     VALUES(?,?,?,?,?,?)";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, c.getCedula());
            stmt.setString(2, c.getCelular());
            stmt.setString(3, c.getCorreo());
            stmt.setString(4, c.getNombre());
            stmt.setString(5, c.getDireccion());
            stmt.setInt(6, c.getTipoCliente().getId());
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
    public void ActualizarCliente (Cliente c,String cedula) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="UPDATE [dbo].[Cliente] " +
                    "   SET [Cedula]=?,[Celular]=?,[Correo]=?,[Nombre]=?,[Direccion]=?,[TipoCliente]=? " +
                    " WHERE [Cedula]=?";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, c.getCedula());
            stmt.setString(2, c.getCelular());
            stmt.setString(3, c.getCorreo());
            stmt.setString(4, c.getNombre());
            stmt.setString(5, c.getDireccion());
            stmt.setInt(6, c.getTipoCliente().getId());
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
    public void EliminarClientePorCedula (String cedula) throws SQLException {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[Cliente] WHERE Cedula=?";
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
    public List<Cliente> ObtenerClientes() throws SQLException {
        List<Cliente> result= new ArrayList<Cliente>();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            con = this.ObtenerConeccion();
            stmt = con.createStatement();
            String SQL = "SELECT * FROM Cliente C INNER JOIN TipoCliente T ON C.TipoCliente=T.id ORDER BY Nombre";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Cliente c= new Cliente();
                c.setCedula(rs.getString("Cedula"));
                c.setNombre(rs.getString("Nombre"));
                c.setCelular(rs.getString("Celular"));
                c.setCorreo(rs.getString("Correo"));
                c.setDireccion(rs.getString("Direccion"));
                TipoCliente t = new TipoCliente();
                t.setId(rs.getInt("Id"));
                t.setDescripcion(rs.getString("Descripcion"));
                t.setDescuento(rs.getDouble("Descuento"));
                t.setRecargo(rs.getDouble("Recargo"));
                c.setTipoCliente(t);
                result.add(c);
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
    public Cliente ObtenerClientePorCedula(String cedula) throws SQLException {
        Cliente result= null;
        Connection con=null;
        PreparedStatement  stmt=null;
        ResultSet  rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT * FROM Cliente C INNER JOIN TipoCliente T ON C.TipoCliente=T.id WHERE C.Cedula=?";
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, cedula);
            rs=stmt.executeQuery();
            if (rs.next()) {
                result= new Cliente();
                result.setCedula(rs.getString("Cedula"));
                result.setNombre(rs.getString("Nombre"));
                result.setCelular(rs.getString("Celular"));
                result.setCorreo(rs.getString("Correo"));
                result.setDireccion(rs.getString("Direccion"));
                TipoCliente t = new TipoCliente();
                t.setId(rs.getInt("Id"));
                t.setDescripcion(rs.getString("Descripcion"));
                t.setDescuento(rs.getDouble("Descuento"));
                t.setRecargo(rs.getDouble("Recargo"));
                result.setTipoCliente(t);
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
