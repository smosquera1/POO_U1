package principal;

import principal.controller.MediaController;
import principal.model.*;
import principal.view.MediaView;

public class Executable {

        public static void main(String[] args) throws Exception {
                MediaView mediaView = new MediaView();
                MediaController controller = new MediaController(mediaView);
                // Procesar películas y actores
                controller.procesarContenido(
                        "./csvs/Peliculas.csv",
                        "./csvs/Actores.csv",
                        "./detalles/PeliculasDetalles.txt",
                        Pelicula.class,
                        Actor.class,
                        Pelicula::getTitulo,
                        Actor::getTituloRelacion,
                        Pelicula::agregarActor
                );

                // Procesar series y temporadas
                controller.procesarContenido(
                        "./csvs/Series.csv",
                        "./csvs/Temporadas.csv",
                        "./detalles/SeriesDetalles.txt",
                        SerieDeTV.class,
                        Temporada.class,
                        SerieDeTV::getTitulo,
                        Temporada::getTituloRelacion,
                        SerieDeTV::agregarTemporada
                );

                // Procesar documentales e investigadores
                controller.procesarContenido(
                        "./csvs/Documentales.csv",
                        "./csvs/Investigadores.csv",
                        "./detalles/DocumentalesDetalles.txt",
                        Documental.class,
                        Investigador.class,
                        Documental::getTitulo,
                        Investigador::getTituloRelacion,
                        Documental::agregarInvestigador
                );

                // Procesar TikToks y usuarios
                controller.procesarContenido(
                        "./csvs/TikToks.csv",
                        "./csvs/UsuariosTikTok.csv",
                        "./detalles/TikToksDetalles.txt",
                        TikTok.class,
                        Usuario.class,
                        TikTok::getTitulo,
                        Usuario::getTituloRelacion,
                        TikTok::setUsuario
                );

                // Procesar Reels y usuarios
                controller.procesarContenido(
                        "./csvs/Reels.csv",
                        "./csvs/UsuariosReels.csv",
                        "./detalles/ReelsDetalles.txt",
                        Reel.class,
                        Usuario.class,
                        Reel::getTitulo,
                        Usuario::getTituloRelacion,
                        Reel::setUsuario
                );
        }
}
