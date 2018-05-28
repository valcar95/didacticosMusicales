/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Ventas.Aplicacion;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import didacticosmusicales.Ventas.Infraestructura.ClienteDAO;
import didacticosmusicales.Ventas.Modelo.ClientePrueba;

/**
 *
 * @author Diego
 */
public class Controller {
    public static void registrarPersona() {
        ClienteDAO miClienteDAO = new ClienteDAO();
        ClientePrueba miCliente=new ClientePrueba();
        Object [] tiposDeDocumentos ={"NIT","C.C","C.E","T.I","Pasaporte"}; 
        Object seleccion = JOptionPane.showInputDialog(null,"Selecciona el tipo de documento", "Seleccion de documento",JOptionPane.QUESTION_MESSAGE,null,tiposDeDocumentos, tiposDeDocumentos[0]);
        
        String mensajeIngreso="Ingrese\n\n";
        String datosSolicitados[] = {"Numero de identificacion : ","Nombre : ",
                "Dirección: ","Municipio: ","Departamento: ", "Correo electrónico: ", "Telefono: "};
        String datosPersona[] = new String[8];
        datosPersona[7] = (String) seleccion;
        
        for (int i = 0; i < datosSolicitados.length; i++) {
         //solicita el ingreso del dato y se almacena en el arreglo de datosPersona
         datosPersona[i]=JOptionPane.showInputDialog(null, mensajeIngreso+
            datosSolicitados[i],"Datos Cliente",JOptionPane.INFORMATION_MESSAGE);
        }
        miCliente.setNumeroDeIdentificacion(datosPersona[0]);
        miCliente.setTipoDeIdentificacion(datosPersona[7]);
        miCliente.setNombre(datosPersona[1]);
        miCliente.setDireccion(datosPersona[2]);
        miCliente.setMunicipio(datosPersona[3]);
        miCliente.setDepartamento(datosPersona[4]);
        miCliente.setCorreoElectronico(datosPersona[5]);
        miCliente.setTelefonoDeContacto(datosPersona[6]);
        miClienteDAO.registrarCliente(miCliente);
 }
}
