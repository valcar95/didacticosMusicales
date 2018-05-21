package didacticosmusicales.Personal;
import didacticosmusicales.Personal.Dominio.Entidades.HorarioLaboral;
import didacticosmusicales.Personal.Dominio.Entidades.Trabajador;
import didacticosmusicales.Personal.Infraestructura.Repositorio.TrabajadorRepositorio;
import didacticosmusicales.Personal.UI.Personal;

import javax.swing.*;
import java.util.List;

public class MainPersonal {
    public static void AbrirModuloPersonal (){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jframe = new Personal();
                jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jframe.setVisible(true);
                jframe.setExtendedState( jframe.getExtendedState()|JFrame.MAXIMIZED_BOTH );
            }
        });
    }
}
