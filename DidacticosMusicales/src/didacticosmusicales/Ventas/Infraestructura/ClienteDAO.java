/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Ventas.Infraestructura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import didacticosmusicales.Ventas.Infraestructura.DbConnection;
import didacticosmusicales.Ventas.Modelo.ClientePrueba;
/**
 *
 * @author Diego
 */
public class ClienteDAO {
    public void registrarCliente(ClientePrueba persona) 
 {
  DbConnection conex= new DbConnection();
  try {
      try (Statement estatuto = conex.getConnection().createStatement()) {
          estatuto.executeUpdate("INSERT INTO cliente VALUES ('"+persona.getNumeroDeIdentificacion()+"', '"
                  +persona.getTipoDeIdentificacion()+"', '"+persona.getNombre()+"', '"
                  +persona.getDireccion()+"', '"+persona.getMunicipio()+"', '"+persona.getDepartamento()+"', '"+persona.getCorreoElectronico()+"', '"
                  +persona.getTelefonoDeContacto()+"')");
          JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
      }
   conex.desconectar();
    
  } catch (SQLException e) {
            System.out.println(e.getMessage());
   JOptionPane.showMessageDialog(null, "No se Registro la persona");
  }
 }
    
/**
 * permite consultar el empleado asociado al documento enviado
 * como parametro 
 * @param documento 
 * @return
 */
public ArrayList<ClientePrueba> consultarPersona(int documento) {
  ArrayList<ClientePrueba> miEmpleado = new ArrayList<ClientePrueba>();
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente where id = ? ");
   consulta.setInt(1, documento);
   ResultSet res = consulta.executeQuery();
    
  if(res.next()){
    ClientePrueba persona;
    persona = new ClientePrueba();
    persona.setNumeroDeIdentificacion(res.getString("id"));
    persona.setTipoDeIdentificacion(res.getString("tipodeidentificacion"));
    persona.setNombre(res.getString("nombre"));
    persona.setMunicipio(res.getString("municipio"));
    persona.setDepartamento(res.getString("departamento"));
    persona.setCorreoElectronico(res.getString("correo"));
    persona.setTelefonoDeContacto(res.getString("telefono"));
    miEmpleado.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
    
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
  }
  return miEmpleado;
 }
 
/**
 * permite consultar la lista de empleados
 * @return
 */

/**
public ArrayList< personavo> listaDePersonas() {
  ArrayList< personavo> miEmpleado = new ArrayList< personavo>();
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
   ResultSet res = consulta.executeQuery();
   while(res.next()){
    PersonaVO persona= new PersonaVO();
    persona.setIdPersona(Integer.parseInt(res.getString("id")));
    persona.setNombrePersona(res.getString("nombre"));
    persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
    persona.setProfesionPersona(res.getString("profesion"));
    persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
    miEmpleado.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
    
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
  }
  return miEmpleado;
 }
*/
}
