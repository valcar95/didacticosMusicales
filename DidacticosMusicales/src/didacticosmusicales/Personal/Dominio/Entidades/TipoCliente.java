package didacticosmusicales.Personal.Dominio.Entidades;

public class TipoCliente {
    private int Id;
    private String Descripcion;
    private double Descuento;
    private double Recargo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double descuento) {
        Descuento = descuento;
    }

    public double getRecargo() {
        return Recargo;
    }

    public void setRecargo(double recargo) {
        Recargo = recargo;
    }
}
