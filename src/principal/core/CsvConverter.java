package principal.core;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class CsvConverter {

    public static <T> List<T> csvConvertirObjeto(String filePath, Class<T> type) throws Exception {
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

}
