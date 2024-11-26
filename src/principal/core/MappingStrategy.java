package principal.core;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import principal.model.*;

public class MappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {

    @Override
    public T createBean() throws InstantiationException, IllegalAccessException {
        try {
            if (type == Pelicula.class || type == Documental.class || type == Investigador.class) {
            return type.getConstructor(String.class, int.class, String.class, String.class)
                    .newInstance("", 0, "", "");
            }
            if (type == Actor.class || type == Usuario.class || type == Reel.class) {
                return type.getConstructor(String.class, int.class, String.class)
                        .newInstance("", 0, "");
            }
            if (type == SerieDeTV.class) {
                return type.getConstructor(String.class, int.class, String.class, int.class)
                        .newInstance("", 0, "",0);
            }
            if (type == Temporada.class) {
                return type.getConstructor(int.class, int.class, String.class)
                        .newInstance(0, 0, "");
            }
            if (type == TikTok.class) {
                return type.getConstructor(String.class, int.class, String.class, int.class)
                        .newInstance("",0,"", 0);
            }
            return super.createBean();
        } catch (Exception e) {
            throw new InstantiationException("No se pudo instanciar el bean: " + e.getMessage());
        }
    }
}
