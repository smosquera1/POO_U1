
package principal.models;

public class TikTok extends ContenidoAudiovisual {
    private Usuario usuario;
    private int likes;

    public TikTok(String titulo, int duracionEnMinutos, String genero, int likes) {
        super(titulo, duracionEnMinutos, genero);
        this.likes = likes;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del TikTok:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Usuario de TikTok: " + usuario.getNombre());
        System.out.println("Likes: " + likes);
        System.out.println();
    }

    @Override
    public String obtenerDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles del TikTok:\n");
        detalles.append("ID: ").append(getId()).append("\n");
        detalles.append("Título: ").append(getTitulo()).append("\n");
        detalles.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        detalles.append("Género: ").append(getGenero()).append("\n");
        detalles.append("Usuario de TikTok: ").append(usuario != null ? usuario.getNombre() : "No asignado").append("\n");
        detalles.append("Likes: ").append(likes).append("\n");
        detalles.append("\n");
        return detalles.toString();
    }

}
