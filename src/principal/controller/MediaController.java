package principal.controller;

import principal.core.CsvConverter;
import principal.model.ContenidoAudiovisual;
import principal.view.MediaView;

import java.util.List;

public class MediaController {
    private MediaView mediaView;

    public MediaController(MediaView mediaView) {
        this.mediaView = mediaView;
    }

    public <T extends ContenidoAudiovisual, U> void procesarContenido(
            String pathEntidadPrincipal,
            String pathEntidadSecundaria,
            String outputPath,
            Class<T> clasePrincipal,
            Class<U> claseSecundaria,
            java.util.function.Function<T, String> obtenerClavePrincipal,
            java.util.function.Function<U, String> obtenerClaveSecundaria,
            java.util.function.BiConsumer<T, U> asociarEntidad
    ) {
        try {
            // Procesar entidades
            List<T> listaPrincipal = CsvConverter.csvConvertirObjeto(pathEntidadPrincipal, clasePrincipal);
            List<U> listaSecundaria = CsvConverter.csvConvertirObjeto(pathEntidadSecundaria, claseSecundaria);
            for (U secundaria : listaSecundaria) {
                listaPrincipal.stream()
                        .filter(principal -> obtenerClavePrincipal.apply(principal).equalsIgnoreCase(obtenerClaveSecundaria.apply(secundaria)))
                        .findFirst()
                        .ifPresent(principal -> asociarEntidad.accept(principal, secundaria));
            }

            // Mostrar y guardar detalles
            mediaView.mostrarDetalles(listaPrincipal);
            mediaView.guardarDetalles(outputPath, listaPrincipal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
