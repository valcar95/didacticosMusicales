/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Infraestructura.Repositorio;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.Entidades.Servicio;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IAsignacionRepositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public class AsignacionRepositorio extends RepositorioBase implements IAsignacionRepositorio {

    @Override
    public List<Asignacion> ObtenerAsignacionesPorCedulaTrabajador(String cedula) throws Exception {
        List<Asignacion> result= new ArrayList<Asignacion>();
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            con = this.ObtenerConeccion();
            String SQL = "SELECT A.id idAsignacion,A.HoraInicio HoraInicioAsignacion," +
                        "A.HoraFin HoraFinAsignacion," +
                        "C.Descripcion DescripcionHorario," +
                        "C.HoraInicio HoraInicioHorario, C.HoraFin HoraFinHorario," +
                        "D.Descripcion DescripcionServicio,*" +
                        "FROM Asignacion A " +
                        "INNER JOIN Trabajador B ON A.CedulaTrabajador=B.Cedula " +
                        "INNER JOIN HorarioLaboral C on B.IdHorario=C.Id " +
                        "INNER JOIN Servicio D ON A.IdServicio=D.Id " +
                        "WHERE A.CedulaTrabajador=?";
            stmt=con.prepareStatement(SQL);
            stmt.setString(1, cedula);
            rs=stmt.executeQuery();
            while (rs.next()) {
                Trabajador t= new Trabajador();
                t.setCedula(rs.getString("CedulaTrabajador"));
                t.setNombre(rs.getString("Nombre"));
                t.setCelular(rs.getString("Celular"));
                t.setCorreo(rs.getString("Correo"));
                t.setSalario(rs.getDouble("Salario"));
                HorarioLaboral h = new HorarioLaboral();
                h.setId(rs.getInt("IdHorario"));
                h.setDescripcion(rs.getString("DescripcionHorario"));
                h.setHoraInicio(rs.getString("HoraInicioHorario"));
                h.setHoraFin(rs.getString("HoraFinHorario"));
                t.setHorarioLaboral(h);
                Servicio s= new Servicio();
                s.setId(rs.getInt("IdServicio"));
                s.setDescripcion(rs.getString("DescripcionServicio"));
                Asignacion a= new Asignacion();
                a.setId(rs.getInt("idAsignacion"));
                a.setHoraInicio(rs.getString("HoraInicioAsignacion"));
                a.setHoraFin(rs.getString("HoraFinAsignacion"));
                LocalidadEnum Localidad=LocalidadEnum.valueOf(rs.getInt("Localidad"));
                a.setLocalidad(Localidad);
                a.setServicio(s);
                a.setTrabajador(t);
                a.setFechaInicio(rs.getString("FechaInicio"));
                a.setFechaFin(rs.getString("FechaFin"));
                result.add(a);
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
    public void InsertarAsignacion(Asignacion a) throws Exception {
        Connection con=null;
        PreparedStatement stmt=null;
        try {
            String SQL="INSERT INTO [dbo].[Asignacion] " +
                    "     ([IdServicio],[CedulaTrabajador],[HoraInicio],"+
                    "[HoraFin],[Localidad],[FechaInicio],[FechaFin]) " +
                    "     VALUES(?,?,?,?,?,?,?)";

            con=this.ObtenerConeccion();
            stmt=con.prepareStatement(SQL);
            stmt.setInt(1, a.getServicio().getId());
            stmt.setString(2, a.getTrabajador().getCedula());
            stmt.setString(3, a.getHoraInicio());
            stmt.setString(4, a.getHoraFin());
            int localidadInt=a.getLocalidad().getValue();
            stmt.setInt(5, localidadInt);
            stmt.setString(6, a.getFechaInicio());
            stmt.setString(7, a.getFechaFin());
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
