package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.Material;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IMaterialRepositorio;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IMaterialServicioRepositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterialServicioRepositorio extends RepositorioBase implements IMaterialServicioRepositorio {

    private IMaterialRepositorio materialRepositorio;

    public MaterialServicioRepositorio(){
        this.materialRepositorio= new MaterialRepositorio();
    }

    @Override
    public List<Integer> ObtenerIdsMaterialesServicioPorIdServicio(int idServicio) throws Exception {
        List<Integer> result= new ArrayList<Integer>();
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT IdMaterial FROM MaterialServicio WHERE IdServicio=?";
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, idServicio);
            rs=stmt.executeQuery();
            List<Integer> idsMateriales= new ArrayList<Integer>();
            while (rs.next()) {
                int idMaterial=rs.getInt("IdMaterial");
                idsMateriales.add(idMaterial);
            }
            result=idsMateriales;
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
    public void InsertarMaterialServicio(int idMaterial, int idServicio) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[MaterialServicio] " +
                    "           ([IdMaterial],[idServicio]) " +
                    "     VALUES(?,?)";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, idMaterial);
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
    public void EliminarMaterialServicio(int idMaterial, int idServicio) throws Exception {
        Connection con=null;
        PreparedStatement   stmt=null;
        try {
            String SQL="DELETE FROM [dbo].[MaterialServicio] WHERE IdMaterial=? AND idServicio=?";
            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, idMaterial);
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
