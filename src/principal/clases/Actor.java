
package principal.clases;
import java.util.ArrayList;

public class Actor extends Persona {
    private ArrayList<Pelicula> peliculas;
    private String nombrePelicula; // Campo temporal para asociar la película durante la lectura

    public Actor(String nombre, int edad,String nombrePelicula) {
        super(nombre, edad);
        this.nombrePelicula = nombrePelicula;
        this.peliculas = new ArrayList<>();
    }
    // Campo temporal
    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
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
