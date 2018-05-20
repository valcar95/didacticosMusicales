package didacticosmusicales.Personal.Aplicacion.Utilidades;

public class Response<T> {

    private T Entidad;
    private boolean Exitoso;
    private String mensajeError;

    public Response(){
        this.Exitoso=true;
    }

    public T getEntidad() {
        return Entidad;
    }

    public void setEntidad(T entidad) {
        Entidad = entidad;
    }

    public boolean isExitoso() {
        return Exitoso;
    }

    public void setExitoso(boolean exitoso) {
        Exitoso = exitoso;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
