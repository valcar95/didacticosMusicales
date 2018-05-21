/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal;

import didacticosmusicales.Personal.Aplicacion.DTO.AsignacionDTO;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.AsignacionCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;

/**
 *
 * @author XGAnalista2
 */
public class MainTest {
    
    public static void main (String[] arg){
        
        AsignacionCtrl actrl= new AsignacionCtrl();
        
        AsignacionDTO d= new AsignacionDTO();
        
        d.setCedulaCliente("1232234");
        d.setCedulaTrabajador("123456");
        d.setDireccion("Km 10, av. Palmas");
        d.setIdServicio(1);
        d.setFechaInicio("03/06/2018");
        d.setFechaFin("24/08/2018");
        d.setHoraInicio("9:25 am");
        d.setHoraFin("10:00 am");
        
       Response<Boolean> r= actrl.RegistrarAsignacionCliente(d);
       
       if(!r.isExitoso()){
       int a=0;
       }
        
    
    }
}
