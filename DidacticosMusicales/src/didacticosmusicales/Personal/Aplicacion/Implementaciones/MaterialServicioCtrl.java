package didacticosmusicales.Personal.Aplicacion.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Adaptadores.Implementaciones.MaterialesAdaptador;
import didacticosmusicales.Personal.Aplicacion.Adaptadores.Interfaces.IMaterialesAdaptador;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IMaterialServicioCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Material;
import didacticosmusicales.Personal.Dominio.InterfacesRepositorios.IMaterialServicioRepositorio;
import didacticosmusicales.Personal.Infraestructura.Repositorio.MaterialServicioRepositorio;

import java.util.List;

public class MaterialServicioCtrl extends BaseCtrl implements IMaterialServicioCtrl {
    private IMaterialServicioRepositorio materialServicioRepositorio;
    private IMaterialesAdaptador materialesAdaptador;
    public MaterialServicioCtrl(){
        this.materialServicioRepositorio= new MaterialServicioRepositorio();
        this.materialesAdaptador= new MaterialesAdaptador();
    }

    @Override
    public Response<List<Material>> ObtenerMaterialesServicioPorIdServicio(int idServicio) {
        Response<List<Material>> result= new Response<List<Material>>();
        try{
            List<Integer> idsMateriales=this.materialServicioRepositorio.ObtenerIdsMaterialesServicioPorIdServicio(idServicio);
            result.setEntidad(this.materialesAdaptador.ObtenerMaterialesPorIds(idsMateriales));
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> InsertarMaterialServicio(int isMaterial, int idServicio) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.materialServicioRepositorio.InsertarMaterialServicio(isMaterial,idServicio);
            result.setExitoso(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }

    @Override
    public Response<Boolean> EliminarMaterialServicio(int isMaterial, int idServicio) {
        Response<Boolean> result= new Response<Boolean>();
        try{
            this.materialServicioRepositorio.EliminarMaterialServicio(isMaterial,idServicio);
            result.setExitoso(true);
        }
        catch(Exception e){
            this.RegistrarLog(e);
            result.setExitoso(false);
            result.setMensajeError(e.getMessage());
        }
        return result;
    }
}
