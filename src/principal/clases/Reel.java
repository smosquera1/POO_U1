
package principal.clases;

public class Reel extends ContenidoAudiovisual {
    private String cuentaInstagram;
    private int duracionSegundos;

    public Reel(String titulo, int duracionSegundos, String genero, String cuentaInstagram) {
        super(titulo, duracionSegundos / 60, genero);  // Convertir segundos a minutos para duracionEnMinutos
        this.cuentaInstagram = cuentaInstagram;
        this.duracionSegundos = duracionSegundos;
    }

    public String getCuentaInstagram() {
        return cuentaInstagram;
    }

    public void setCuentaInstagram(String cuentaInstagram) {
        this.cuentaInstagram = cuentaInstagram;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Reel:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en segundos: " + duracionSegundos);
        System.out.println("Género: " + getGenero());
        System.out.println("Cuenta de Instagram: " + cuentaInstagram);
        System.out.println();
    }
}
