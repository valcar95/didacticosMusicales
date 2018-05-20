package didacticosmusicales.Personal.Dominio.Entidades;

public class Material {
    private int Id;
    private String Nombre;

    public Material(int id, String nombre){
        this.Id=id;
        this.Nombre=nombre;
    }

    public Material(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
