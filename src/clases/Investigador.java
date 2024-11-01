
package clases;

import java.util.ArrayList;

import abstracts.Persona;

public class Investigador extends Persona {
    private String especialidad;
    private ArrayList<Documental> documentales;

    public Investigador(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
        this.documentales = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Documental> getDocumentales() {
        return documentales;
    }

    public void agregarDocumental(Documental documental) {
        this.documentales.add(documental);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Investigador: " + getNombre() + ", Edad: " + getEdad() + ", Especialidad: " + especialidad);
    }
}
