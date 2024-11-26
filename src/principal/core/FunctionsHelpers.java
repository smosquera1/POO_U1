package principal.core;

import principal.models.ContenidoAudiovisual;

import java.util.List;

public class FunctionsHelpers {
    public static <T extends ContenidoAudiovisual, U> void procesarYGuardarDetalles(
            String pathEntidadPrincipal,
            String pathEntidadSecundaria,
            String outputFilePath,
            Class<T> clasePrincipal,
            Class<U> claseSecundaria,
            java.util.function.Function<T, String> obtenerClavePrincipal,
            java.util.function.Function<U, String> obtenerClaveSecundaria,
            java.util.function.BiConsumer<T, U> asociarEntidad
    ) throws Exception {
        // Leer CSVs
        List<T> listaPrincipal = FileHelpers.readCsvToObjects(pathEntidadPrincipal, clasePrincipal);
        List<U> listaSecundaria = FileHelpers.readCsvToObjects(pathEntidadSecundaria, claseSecundaria);

        // Asociar entidades secundarias a las principales
        for (U secundaria : listaSecundaria) {
            listaPrincipal.stream()
                    .filter(principal -> obtenerClavePrincipal.apply(principal).equalsIgnoreCase(obtenerClaveSecundaria.apply(secundaria)))
                    .findFirst()
                    .ifPresent(principal -> asociarEntidad.accept(principal, secundaria));
        }

        // Guardar los detalles en un archivo
        FileHelpers.writeToFile(outputFilePath, listaPrincipal);
    }
}
