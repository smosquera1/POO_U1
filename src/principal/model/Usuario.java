package principal.model;

public class Usuario extends Persona {
    public Usuario(String nombre, int edad, String tituloRelacion) {
        super(tituloRelacion, nombre, edad);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Usuario: " + getNombre() + ", Edad: " + getEdad());
    }
}
