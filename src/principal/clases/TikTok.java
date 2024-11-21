
package principal.clases;

public class TikTok extends ContenidoAudiovisual {
    private String usuarioTikTok;
    private int likes;

    public TikTok(String titulo, int duracionEnMinutos, String genero, String usuarioTikTok, int likes) {
        super(titulo, duracionEnMinutos, genero);
        this.usuarioTikTok = usuarioTikTok;
        this.likes = likes;
    }

    public String getUsuarioTikTok() {
        return usuarioTikTok;
    }

    public void setUsuarioTikTok(String usuarioTikTok) {
        this.usuarioTikTok = usuarioTikTok;
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
        System.out.println("Usuario de TikTok: " + usuarioTikTok);
        System.out.println("Likes: " + likes);
        System.out.println();
    }
}
