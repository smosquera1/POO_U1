
package principal.model;

public abstract class Persona {
    private String tituloRelacion;
    private String nombre;
    private int edad;

    public Persona(String tituloRelacion, String nombre, int edad) {
        this.tituloRelacion = tituloRelacion;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getTituloRelacion() {
        return tituloRelacion;
    }

    public void setTituloRelacion(String tituloRelacion) {
        this.tituloRelacion = tituloRelacion;
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
    
    public abstract void mostrarInformacion();
}
