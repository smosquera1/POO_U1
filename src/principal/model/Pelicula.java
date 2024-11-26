
package principal.model;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class    Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private ArrayList<Actor> actores;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        this.actores.add(actor);
        actor.agregarPelicula(this);  // Agregar la película en el actor también
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        System.out.println("Actores: " + actores.stream().map(Actor::getNombre).collect(Collectors.toList()));
        System.out.println();
    }

    @Override
    public String obtenerDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles de la película:\n");
        detalles.append("ID: ").append(getId()).append("\n");
        detalles.append("Título: ").append(getTitulo()).append("\n");
        detalles.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        detalles.append("Género: ").append(getGenero()).append("\n");
        detalles.append("Estudio: ").append(estudio).append("\n");
        detalles.append("Actores: ").append(actores.stream().map(Actor::getNombre).collect(Collectors.toList())).append("\n");
        detalles.append("\n");
        return detalles.toString();
    }
}
