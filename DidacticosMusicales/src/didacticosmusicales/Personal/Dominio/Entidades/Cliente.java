package didacticosmusicales.Personal.Dominio.Entidades;

public class Cliente extends Persona {
    private String Direccion;
    private TipoCliente TipoCliente;

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        TipoCliente = tipoCliente;
    }
}
