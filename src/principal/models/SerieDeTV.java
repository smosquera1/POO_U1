
package principal.models;

import java.util.ArrayList;

public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private ArrayList<Temporada> listaTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        this.listaTemporadas.add(temporada);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println("Total episodios de Temporadas: " + listaTemporadas.stream()
                .mapToInt(Temporada::getEpisodios) // Extraer el valor del campo episodios
                .sum());
        System.out.println();
    }

    @Override
    public String obtenerDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles de la serie de TV:\n");
        detalles.append("ID: ").append(getId()).append("\n");
        detalles.append("Título: ").append(getTitulo()).append("\n");
        detalles.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        detalles.append("Género: ").append(getGenero()).append("\n");
        detalles.append("Temporadas: ").append(temporadas).append("\n");
        detalles.append("Total episodios de Temporadas: ").append(
                listaTemporadas.stream()
                        .mapToInt(Temporada::getEpisodios) // Extraer el valor del campo episodios
                        .sum()
        ).append("\n");
        detalles.append("\n");
        return detalles.toString();
    }

}
