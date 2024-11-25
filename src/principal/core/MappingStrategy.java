package principal.core;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import principal.clases.Actor;
import principal.clases.Pelicula;

public class MappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {

    @Override
    public T createBean() throws InstantiationException, IllegalAccessException {
        try {
            if (type == Pelicula.class) {
            return type.getConstructor(String.class, int.class, String.class, String.class)
                    .newInstance("", 0, "", ""); // Proporcionar valores predeterminados
            }
            if (type == Actor.class) {
                return type.getConstructor(String.class, int.class, String.class)
                        .newInstance("", 0, ""); // Valores predeterminados para nombre, edad y nombrePelicula
            }
            return super.createBean();
        } catch (Exception e) {
            throw new InstantiationException("No se pudo instanciar el bean: " + e.getMessage());
        }
    }
}
