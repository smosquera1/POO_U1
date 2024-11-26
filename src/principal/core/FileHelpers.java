package principal.core;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import principal.models.ContenidoAudiovisual;

import java.io.FileWriter;
import java.io.IOException;

public class FileHelpers {

    public static <T> List<T> readCsvToObjects(String filePath, Class<T> type) throws Exception {
        try (Reader reader = new FileReader(filePath)) {
            // Usar la estrategia personalizada para el mapeo
            MappingStrategy<T> mappingStrategy = new MappingStrategy<>();
            mappingStrategy.setType(type);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withMappingStrategy(mappingStrategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
    }
    public static void writeToFile(String filePath, List<? extends ContenidoAudiovisual> contenido) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (ContenidoAudiovisual item : contenido) {
                writer.write(item.obtenerDetalles());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
