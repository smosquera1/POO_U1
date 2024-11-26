package principal;

import principal.models.*;
import principal.core.FunctionsHelpers;

public class Executable {

        public static void main(String[] args) throws Exception {
                // Procesar películas y actores
                FunctionsHelpers.procesarYGuardarDetalles(
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
                FunctionsHelpers.procesarYGuardarDetalles(
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
                FunctionsHelpers.procesarYGuardarDetalles(
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
                FunctionsHelpers.procesarYGuardarDetalles(
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
                FunctionsHelpers.procesarYGuardarDetalles(
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
