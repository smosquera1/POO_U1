package principal;

import principal.clases.*;

public class executable {
	public static void main(String[] args) {
        // Crear instancias de Pelicula, SerieDeTV, y Documental
        Pelicula avatar = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        Documental cosmos = new Documental("Cosmos", 45, "Science", "Astronomy");
        Reel reelInstagram = new Reel("Viaje a la Playa", 30, "Travel", "InstagramAccount");
        TikTok videoTikTok = new TikTok("Bailando en la calle", 2, "Dance", "UserTikTok", 15000);

        // Crear y agregar actores a la película
        Actor actor1 = new Actor("Sam Worthington", 46);
        Actor actor2 = new Actor("Zoe Saldana", 45);
        avatar.agregarActor(actor1);
        avatar.agregarActor(actor2);

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
        ContenidoAudiovisual[] contenidos = {avatar, got, cosmos,reelInstagram,videoTikTok};

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
            System.out.println();
        }

        // Mostrar detalles adicionales
        System.out.println("Actores en "+avatar.getTitulo()+":");
        for (Actor actor : avatar.getActores()) {
            actor.mostrarInformacion();
        }

        System.out.println("\n"+got.getTitulo()+":");
        System.out.println("Total de temporadas: " + got.getTemporadas());

        System.out.println("\nInvestigadores de "+cosmos.getTitulo()+":");
        for (Investigador investigador : cosmos.getInvestigadores()) {
            investigador.mostrarInformacion();
        }
    }
}
