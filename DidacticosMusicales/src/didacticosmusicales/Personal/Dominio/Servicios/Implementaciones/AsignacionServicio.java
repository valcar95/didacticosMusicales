/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Servicios.Implementaciones;

import didacticosmusicales.Personal.Dominio.Entidades.Asignacion;
import didacticosmusicales.Personal.Dominio.Entidades.Enumerables.LocalidadEnum;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Dominio.Servicios.Implementaciones.Localidad.LocalidadServicio;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.IAsignacionServicio;
import didacticosmusicales.Personal.Dominio.Servicios.Interfaces.Localidad.ILocalidadServicio;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author XGAnalista2
 */
public class AsignacionServicio implements IAsignacionServicio {

    private ILocalidadServicio localidadServicio;
    
    public AsignacionServicio(){
        this.localidadServicio= new LocalidadServicio();
    }
    
    @Override
    public boolean ValidarRegistroDeAsignacion(Asignacion asignacion, List<Asignacion> asignaciones) throws Exception {
        int tiempoAdicionalLocalidad=this.localidadServicio.ObtenerMinutosAdicionalesPorLocalidad(asignacion.getLocalidad());
        Pair<Integer,Integer> horaInicioCompleta=this.ObtenerHoraMinutosAsignacionInicio(asignacion, tiempoAdicionalLocalidad);
        Pair<Integer,Integer> horaFinCompleta=this.ObtenerHoraMinutosAsignacionFin(asignacion, tiempoAdicionalLocalidad);
        boolean horaInicioDentrodeHorarioLaboral=this.ValidarHoraDentroDeHorario(horaInicioCompleta,asignacion.getTrabajador());
        boolean horaFinDentrodeHorarioLaboral=this.ValidarHoraDentroDeHorario(horaFinCompleta,asignacion.getTrabajador());
        boolean asignacionValidaDentroDeAsignaciones=this.ValidarAsignacionDentroDeAsignacionesExisatentes(asignacion, asignaciones);
        
        if(!horaInicioDentrodeHorarioLaboral){
          throw new Exception("La hora inicial de la asignacion está por fuera del horario"+ 
          "del trabajador. Tenga en cuenta el tiempo adicional por cuestiones "+
          "de desplazamiento ("+String.valueOf(tiempoAdicionalLocalidad)+" minutos)");
        }
        
        if(!horaFinDentrodeHorarioLaboral){
          throw new Exception("La hora final de la asignacion está por fuera del horario"+ 
          "del trabajador. Tenga en cuenta el tiempo adicional por cuestiones "+
          "de desplazamiento ("+String.valueOf(tiempoAdicionalLocalidad)+" minutos)");
        }
        
        if(!asignacionValidaDentroDeAsignaciones){
          throw new Exception("La asignación tiene conflicos con otras asignaciones existentes "+ 
          "del trabajador. Tenga en cuenta el tiempo adicional por cuestiones "+
          "de desplazamiento ("+String.valueOf(tiempoAdicionalLocalidad)+" minutos)");
        }
        
        return horaInicioDentrodeHorarioLaboral && horaFinDentrodeHorarioLaboral && asignacionValidaDentroDeAsignaciones;
    }
    
    private boolean ValidarAsignacionDentroDeAsignacionesExisatentes(Asignacion asignacion, List<Asignacion> asignaciones){
            
        // TODO: implemantar validación de asignación actual contra validaciones existentes
        return true;
    }
    
    private boolean ValidarHoraDentroDeHorario(Pair<Integer,Integer> horaCompleta, Trabajador t){
        int hora=horaCompleta.getKey();
        int minutos=horaCompleta.getValue();
        
        int horaInicioHorarioLaboral=t.getHorarioLaboral().ObtenerHoraInicio();
        int minutosInicioHorarioLaboral=t.getHorarioLaboral().ObtenerMinutosInicio();
        int horaFinHorarioLaboral=t.getHorarioLaboral().ObtenerHoraFin();
        int minutosFinHorarioLaboral=t.getHorarioLaboral().ObtenerMinutosFin();
        
        boolean horaMayorQueInicio=false;
        boolean horaMenorQueFin=false;
        
        if(hora>horaInicioHorarioLaboral){
            horaMayorQueInicio=true;
        }
        else{
            if(hora==horaInicioHorarioLaboral){
                if(minutos>=minutosInicioHorarioLaboral){
                    horaMayorQueInicio=true;
                }
            }
        }
        
        if(hora<horaFinHorarioLaboral){
            horaMenorQueFin=true;
        }
        else{
            if(hora==horaFinHorarioLaboral){
                if(minutos<=minutosFinHorarioLaboral){
                    horaMenorQueFin=true;
                }
            }
        }
        
        return horaMayorQueInicio && horaMenorQueFin;
    }
    
    private Pair<Integer,Integer> ObtenerHoraMinutosAsignacionInicio(Asignacion asignacion,int minutosAdicionales){
        Pair<Integer,Integer> horasminutosInicio=asignacion.ObtenerHoraInicioFormato24();
        int hora=horasminutosInicio.getKey();
        int minutos=horasminutosInicio.getValue();
        int minutos2=minutos-minutosAdicionales;
        if(minutos2<0){
            hora=hora-1;
            minutos2=60+minutos2;
            if(hora<1){
                hora=24;
            }
        }
        return new Pair<>(hora,minutos2);
    }
    
    private Pair<Integer,Integer> ObtenerHoraMinutosAsignacionFin(Asignacion asignacion,int minutosAdicionales){
        Pair<Integer,Integer> horasminutosInicio=asignacion.ObtenerHoraFinFormato24();
        int hora=horasminutosInicio.getKey();
        int minutos=horasminutosInicio.getValue();
        int minutos2=(minutos+minutosAdicionales)%60;
        if(minutos2<=minutos && minutosAdicionales>0){
          hora=(hora+1)%24;
        }
        return new Pair<>(hora,minutos2);
    }
    
    
   
    
}
