/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal;

import didacticosmusicales.Personal.Aplicacion.DTO.AsignacionDTO;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.AsignacionCtrl;

/**
 *
 * @author XGAnalista2
 */
public class mainTest {
    
    public static void main(String[] str){
        AsignacionCtrl ctrl= new AsignacionCtrl();

        AsignacionDTO a= new AsignacionDTO();

        a.setCedulaTrabajador("123456");
        a.setCedulaCliente("1232234");
        a.setDireccion("km 10 av Palmas");
        a.setFechaFin("07/08/2018");
        a.setFechaInicio("23/05/2018");
        a.setHoraInicio("09:25 am");
        a.setHoraFin("11:00 am");
        a.setIdServicio(1);
        
        ctrl.RegistrarAsignacionCliente(a);
    }
    
    
    
}
