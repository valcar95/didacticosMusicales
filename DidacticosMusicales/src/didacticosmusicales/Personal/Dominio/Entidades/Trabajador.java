package didacticosmusicales.Personal.Dominio.Entidades;
public class Trabajador extends Persona {
    private double Salario;
    private HorarioLaboral HorarioLaboral;
    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public HorarioLaboral getHorarioLaboral() {
        return HorarioLaboral;
    }

    public void setHorarioLaboral(HorarioLaboral horarioLaboral) {
        HorarioLaboral = horarioLaboral;
    }
}
