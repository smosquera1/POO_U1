
package principal.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private ArrayList<Investigador> investigadores;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void agregarInvestigador(Investigador investigador) {
        this.investigadores.add(investigador);
        investigador.agregarDocumental(this);  // Agregar el documental en el investigador también
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.println("Investigadores: " + investigadores.stream().map(Investigador::getNombre).collect(Collectors.toList()));
        System.out.println();
    }

    @Override
    public String obtenerDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles del documental:\n");
        detalles.append("ID: ").append(getId()).append("\n");
        detalles.append("Título: ").append(getTitulo()).append("\n");
        detalles.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        detalles.append("Género: ").append(getGenero()).append("\n");
        detalles.append("Tema: ").append(tema).append("\n");
        detalles.append("Investigadores: ").append(
                investigadores.stream().map(Investigador::getNombre).collect(Collectors.toList())
        ).append("\n");
        detalles.append("\n");
        return detalles.toString();
    }
}
