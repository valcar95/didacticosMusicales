/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Infraestructura.Comunicacion.Notificaciones;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Persona;
import didacticosmusicales.Personal.Dominio.InterfacesComunicacion.INotificacion;
import didacticosmusicales.Personal.Infraestructura.Comunicacion.Helpers.EmailManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XGAnalista2
 */
public class CorreoElectronico implements INotificacion{

    @Override
    public void Notificar(List<Persona> personalInvolucrado, Asignacion asignacion) {
        List<String> correos=this.ObtenerCorreosPersonas(personalInvolucrado);
        String asunto="Asignación de servicio Didacticos Musicales";
        String texto=this.ObtenerTextoCorreo(asignacion);
        EmailManager.EnviarEmail(correos, asunto, texto);
    }
    
    private String ObtenerTextoCorreo(Asignacion asignacion){
       String texto="Se ha registrado una nueva asignación para el servicio \""+
        asignacion.getServicio().getDescripcion()+"\" entre las fechas "+asignacion.getFechaInicio()+
        " y "+asignacion.getFechaFin()+". El servicio se prestará en el horario de "+
        asignacion.getHoraInicio()+" a "+asignacion.getHoraFin()+".";
       return texto; 
    }
    
    private List<String> ObtenerCorreosPersonas(List<Persona> personas){
        List<String> correos= new ArrayList<String>();
        for(Persona p:personas){
            correos.add(p.getCorreo());
        }
        return correos;
    }
}
