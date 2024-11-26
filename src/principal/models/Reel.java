
package principal.models;

public class Reel extends ContenidoAudiovisual {
    private Usuario usuario;

    public Reel(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);  // Convertir segundos a minutos para duracionEnMinutos
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Reel:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Cuenta de Instagram: " + usuario.getNombre());
        System.out.println();
    }

    @Override
    public String obtenerDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles del Reel:\n");
        detalles.append("ID: ").append(getId()).append("\n");
        detalles.append("Título: ").append(getTitulo()).append("\n");
        detalles.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        detalles.append("Género: ").append(getGenero()).append("\n");
        detalles.append("Cuenta de Instagram: ").append(usuario != null ? usuario.getNombre() : "No asignado").append("\n");
        detalles.append("\n");
        return detalles.toString();
    }

}
