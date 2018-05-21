/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Dominio.Entidades;

import javafx.util.Pair;

/**
 *
 * @author XGAnalista2
 */
public class Horario {
    private String HoraInicio;
    private String HoraFin;

    /**
     * @return the HoraInicio
     */
    public String getHoraInicio() {
        return HoraInicio;
    }

    /**
     * @param HoraInicio the HoraInicio to set
     */
    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    /**
     * @return the HoraFin
     */
    public String getHoraFin() {
        return HoraFin;
    }

    /**
     * @param HoraFin the HoraFin to set
     */
    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }
    
    public int ObtenerHoraInicio(){
        if(this.HoraInicio==null){
            return 0;
        }
        String[] partesHora=this.HoraInicio.trim().split(":");
        if(partesHora.length>0){
            return Integer.parseInt(partesHora[0]);
        }
        return 0;
    }
    
    public int ObtenerHoraFin(){
        if(this.HoraInicio==null){
            return 0;
        }
        String[] partesHora=this.HoraFin.trim().split(":");
        if(partesHora.length>0){
            return Integer.parseInt(partesHora[0]);
        }
        return 0;
    }
    
    public int ObtenerMinutosInicio(){
        if(this.HoraInicio==null){
            return 0;
        }
        String[] partesHora=this.HoraInicio.trim().split(":");
        if(partesHora.length==2){
            String[] partesHora2=partesHora[1].split(" ");
            if(partesHora2.length>0){
               return Integer.parseInt(partesHora2[0]);
            }
        }
        return 0;
    }
    
    public int ObtenerMinutosFin(){
        if(this.HoraFin==null){
            return 0;
        }
        String[] partesHora=this.HoraFin.trim().split(":");
        if(partesHora.length==2){
            String[] partesHora2=partesHora[1].split(" ");
            if(partesHora2.length>0){
               return Integer.parseInt(partesHora2[0]);
            }
        }
        return 0;
    }
    
    public String ObtenerAmPmInicio(){
        if(this.HoraInicio==null){
            return "";
        }
        String[] partesHora=this.HoraInicio.trim().split(":");
        if(partesHora.length==2){
            String[] partesHora2=partesHora[1].split(" ");
            if(partesHora2.length==2){
               return partesHora2[1];
            }
        }
        return "";
    }
    
    public String ObtenerAmPmFin(){
        if(this.HoraFin==null){
            return "";
        }
        String[] partesHora=this.HoraFin.trim().split(":");
        if(partesHora.length==2){
            String[] partesHora2=partesHora[1].split(" ");
            if(partesHora2.length==2){
               return partesHora2[1];
            }
        }
        return "";
    }
    
    public Pair<Integer,Integer> ObtenerHoraInicioFormato24(){
        int h=this.ObtenerHoraInicio();
        int m=this.ObtenerMinutosInicio();
        String amPm=this.ObtenerAmPmInicio();
        if(amPm.toLowerCase().equals("pm")){
            h=h+12;
        }
        return new Pair<>(h,m);
    }
    
     public Pair<Integer,Integer> ObtenerHoraFinFormato24(){
        int h=this.ObtenerHoraFin();
        int m=this.ObtenerMinutosFin();
        String amPm=this.ObtenerAmPmFin();
        if(amPm.toLowerCase().equals("pm")){
            h=h+12;
        }
        return new Pair<>(h,m);
    }
}
