package principal.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import principal.model.ContenidoAudiovisual;

public class MediaView {

    public <T extends ContenidoAudiovisual> void mostrarDetalles(List<T> contenido) {
        for (T item : contenido) {
            System.out.println(item.obtenerDetalles());
        }
    }

    public static <T extends ContenidoAudiovisual> void guardarDetalles(String filePath, List<T> contenido) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (T item : contenido) {
                writer.write(item.obtenerDetalles());
            }
            System.out.println("Archivo guardado exitosamente en "+filePath.replace("/", "\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}