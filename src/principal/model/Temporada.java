
package principal.model;

public class Temporada {
    private int numero;
    private int episodios;
    private String tituloRelacion;

    public Temporada(int numero, int episodios, String tituloRelacion) {
        this.numero = numero;
        this.episodios = episodios;
        this.tituloRelacion = tituloRelacion;
    }

    public void setTituloRelacion(String tituloSerie) {
        this.tituloRelacion = tituloSerie;
    }

    public String getTituloRelacion() {
        return tituloRelacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
}
