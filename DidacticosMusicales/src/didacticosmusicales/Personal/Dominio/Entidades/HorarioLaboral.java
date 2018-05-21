package didacticosmusicales.Personal.Dominio.Entidades;

public class HorarioLaboral extends Horario {
    private int Id;
    private String Descripcion;
    
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
}
