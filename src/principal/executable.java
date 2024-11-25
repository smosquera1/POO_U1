package principal;
import principal.clases.*;
import principal.core.ReadFile;
import java.util.*;

public class executable {
	public static void main(String[] args) throws Exception {
        String pathPeliculas = "./csvs/Peliculas.csv";
        String pathActores = "./csvs/Actores.csv";
        // Leer películas
        List<Pelicula> peliculas = ReadFile.readCsvToObjects(pathPeliculas, Pelicula.class);
        // Crear un mapa de título de película -> objeto Pelicula
            Map<String, Pelicula> mapaPeliculas = new HashMap<>();
            for (Pelicula pelicula : peliculas) {
                mapaPeliculas.put(pelicula.getTitulo(), pelicula);
            }
            // Leer actores con el campo temporal `nombrePelicula`
            List<Actor> actores = ReadFile.readCsvToObjects(pathActores, Actor.class);

            // Asociar las películas a los actores
            for (Actor actor : actores) {
                    Pelicula pelicula = mapaPeliculas.get(actor.getNombrePelicula());
                    if (pelicula != null) {
                            pelicula.agregarActor(actor);
                    }
                    // Limpia el campo temporal después de asociarlo
                    actor.setNombrePelicula(null);
            }

            // Imprimir los detalles de las peliculas
            for (Pelicula p : peliculas) {
                    p.mostrarDetalles();
            }

        // Crear instancias de Pelicula, SerieDeTV, y Documental

        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        Documental cosmos = new Documental("Cosmos", 45, "Science", "Astronomy");
        Reel reelInstagram = new Reel("Viaje a la Playa", 30, "Travel", "InstagramAccount");
        TikTok videoTikTok = new TikTok("Bailando en la calle", 2, "Dance", "UserTikTok", 15000);


        // Crear y agregar temporadas a la serie
        Temporada temporada1 = new Temporada(1, 10);
        Temporada temporada2 = new Temporada(2, 10);
        got.agregarTemporada(temporada1);
        got.agregarTemporada(temporada2);

        // Crear y agregar investigadores al documental
        Investigador investigador1 = new Investigador("Carl Sagan", 62, "Astronomía");
        Investigador investigador2 = new Investigador("Neil deGrasse Tyson", 64, "Astrofísica");
        cosmos.agregarInvestigador(investigador1);
        cosmos.agregarInvestigador(investigador2);

        // Crear un arreglo de ContenidoAudiovisual
        ContenidoAudiovisual[] contenidos = { got, cosmos,reelInstagram,videoTikTok};

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
            System.out.println();
        }

        System.out.println("\n"+got.getTitulo()+":");
        System.out.println("Total de temporadas: " + got.getTemporadas());

        System.out.println("\nInvestigadores de "+cosmos.getTitulo()+":");
        for (Investigador investigador : cosmos.getInvestigadores()) {
            investigador.mostrarInformacion();
        }
    }
}
