package principal;

import principal.controller.MediaController;
import principal.model.*;
import principal.view.MediaView;

public class Executable {

        public static void main(String[] args) throws Exception {
                MediaView mediaView = new MediaView();
                MediaController controller = new MediaController(mediaView);
                String basePath = System.getProperty("user.dir");
                String correctedPath = basePath.replace("\\src", "");
                // Procesar películas y actores
                controller.procesarContenido(
                        correctedPath+"/csvs/Peliculas.csv",
                        correctedPath+"/csvs/Actores.csv",
                        correctedPath+"/detalles/PeliculasDetalles.txt",
                        Pelicula.class,
                        Actor.class,
                        Pelicula::getTitulo,
                        Actor::getTituloRelacion,
                        Pelicula::agregarActor
                );

                // Procesar series y temporadas
                controller.procesarContenido(
                        correctedPath+"/csvs/Series.csv",
                        correctedPath+"/csvs/Temporadas.csv",
                        correctedPath+"/detalles/SeriesDetalles.txt",
                        SerieDeTV.class,
                        Temporada.class,
                        SerieDeTV::getTitulo,
                        Temporada::getTituloRelacion,
                        SerieDeTV::agregarTemporada
                );

                // Procesar documentales e investigadores
                controller.procesarContenido(
                        correctedPath+"/csvs/Documentales.csv",
                        correctedPath+"/csvs/Investigadores.csv",
                        correctedPath+"/detalles/DocumentalesDetalles.txt",
                        Documental.class,
                        Investigador.class,
                        Documental::getTitulo,
                        Investigador::getTituloRelacion,
                        Documental::agregarInvestigador
                );

                // Procesar TikToks y usuarios
                controller.procesarContenido(
                        correctedPath+"/csvs/TikToks.csv",
                        correctedPath+"/csvs/UsuariosTikTok.csv",
                        correctedPath+"/detalles/TikToksDetalles.txt",
                        TikTok.class,
                        Usuario.class,
                        TikTok::getTitulo,
                        Usuario::getTituloRelacion,
                        TikTok::setUsuario
                );

                // Procesar Reels y usuarios
                controller.procesarContenido(
                        correctedPath+"/csvs/Reels.csv",
                        correctedPath+"/csvs/UsuariosReels.csv",
                        correctedPath+"/detalles/ReelsDetalles.txt",
                        Reel.class,
                        Usuario.class,
                        Reel::getTitulo,
                        Usuario::getTituloRelacion,
                        Reel::setUsuario
                );
        }
}
