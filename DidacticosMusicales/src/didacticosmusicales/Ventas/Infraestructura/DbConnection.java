/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Ventas.Infraestructura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Diego
 */
public class DbConnection {
    static String bd = "codejavu";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
 
    Connection connection = null;

    /** Constructor de DbConnection */
    public DbConnection() {
       try{
          //obtenemos el driver de para mysql
          Class.forName("com.mysql.jdbc.Driver");
          //obtenemos la conexión
          connection = DriverManager.getConnection(url,login,password);

          if (connection!=null){
             System.out.println("Conexión a base de datos "+bd+" OK\n");
          }
       }
       catch(SQLException e){
          System.out.println(e);
       }catch(ClassNotFoundException e){
          System.out.println(e);
       }catch(Exception e){
          System.out.println(e);
       }
    }
    /**Permite retornar la conexión*/
    public Connection getConnection(){
       return connection;
    }

    public void desconectar(){
       connection = null;
    }
}
