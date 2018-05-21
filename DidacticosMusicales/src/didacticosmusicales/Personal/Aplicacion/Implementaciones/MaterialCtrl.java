package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Adaptadores.Implementaciones.MaterialesAdaptador;
import didacticosmusicales.Personal.Aplicacion.Adaptadores.Interfaces.IMaterialesAdaptador;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IMaterialCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Material;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IMaterialRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.MaterialRepositorio;

import java.util.List;

public class MaterialCtrl extends BaseCtrl implements IMaterialCtrl {

    private IMaterialesAdaptador materialesAdaptador;
    public MaterialCtrl(){
        this.materialesAdaptador= new MaterialesAdaptador();
    }

    @Override
    public Response<List<Material>> ObtenerMateriales() {
        Response<List<Material>> result= new Response<List<Material>>();
        try{
            result.setEntidad(this.materialesAdaptador.ObtenerMateriales());
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }
}
