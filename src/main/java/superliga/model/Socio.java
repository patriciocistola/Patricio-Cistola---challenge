package src.main.java.superliga.model;

public class Socio {
    public String nombre;
    public int edad;
    public String equipo;
    public String estado;
    public String estudios;

    public Socio(String nombre, int edad, String equipo, String estado, String estudios) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.estado = estado;
        this.estudios = estudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

}
