
package principal.models;
import java.util.ArrayList;

public class Actor extends Persona {
    private final ArrayList<Pelicula> peliculas;

    public Actor(String nombre, int edad,String tituloRelacion) {
        super(tituloRelacion, nombre, edad);
        this.peliculas = new ArrayList<>();
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Actor: " + getNombre() + ", Edad: " + getEdad());
    }
}
