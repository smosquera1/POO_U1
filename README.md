
# Proyecto: Procesador de Archivos CSV en Java

Este proyecto permite procesar diferentes tipos de archivos CSV y generar archivos de salida en formato de texto con los datos procesados. La arquitectura sigue principios de **SOLID**, **Clean Code**, y el patrón **MVC** para garantizar claridad, extensibilidad y mantenibilidad.

## Estructura del Proyecto

```
POO_U1/
├── src/                      # Código fuente principal
│   ├── principal/
│   │   ├── controller/       # Controladores que orquestan el flujo del programa
│   │   ├── core/             # Funciones auxiliares para manejar archivos CSV
│   │   ├── model/            # Modelos que representan entidades como Película, Actor, etc.
│   │   ├── view/             # Vista para la generación de archivos de salida y consola
│   │   └── Executable.java   # Clase principal que ejecuta el programa
├── csvs/                     # Archivos CSV de entrada
│   ├── Peliculas.csv
│   ├── Actores.csv
│   ├── Series.csv
│   ├── Temporadas.csv
│   ├── Documentales.csv
│   ├── Investigadores.csv
│   ├── TikToks.csv
│   ├── UsuariosTikTok.csv
│   ├── Reels.csv
│   └── UsuariosReels.csv
├── detalles/                 # Archivos de texto generados como salida
│   ├── PeliculasDetalles.txt
│   ├── SeriesDetalles.txt
│   ├── DocumentalesDetalles.txt
│   ├── TikToksDetalles.txt
│   └── ReelsDetalles.txt
├── librerias/                # Librerías necesarias en formato JAR
│   ├── opencsv-4.1.jar
│   └── commons-lang3-3.17.0.jar
└── README.md                 # Documentación del proyecto
```

## Requisitos Previos

1. **Java JDK 8 o superior.**
2. Configurar las siguientes librerías JAR en tu entorno:
   - `opencsv-4.1.jar`
   - `commons-lang3-3.17.0.jar`

## Configuración del Proyecto

### En Eclipse

1. Abre Eclipse y crea un nuevo proyecto de tipo `Java Project`.
2. Copia la estructura del proyecto en tu carpeta de trabajo de Eclipse.
3. Agrega las librerías JAR al proyecto:
   - Haz clic derecho en el proyecto y selecciona `Build Path > Configure Build Path...`.
   - Ve a la pestaña `Libraries` y selecciona `Add External JARs...`.
   - Agrega los archivos JAR de la carpeta `librerias/`.
4. Limpia y construye el proyecto desde el menú `Project > Clean...`.

### En IntelliJ IDEA

1. Abre IntelliJ IDEA y selecciona `Open` para abrir la carpeta del proyecto.
2. Configura las dependencias del proyecto:
   - Ve a `File > Project Structure > Modules > Dependencies`.
   - Haz clic en el botón `+`, selecciona `JARs or directories`, y agrega los archivos JAR de la carpeta `librerias/`.
3. Limpia y construye el proyecto desde el menú `Build > Rebuild Project`.

## Archivos CSV de Entrada

1. **Peliculas.csv**
   - `titulo`: Título de la película.
   - `duracionEnMinutos`: Duración de la película en minutos.
   - `genero`: Género de la película.
   - `estudio`: Estudio cinematográfico.

2. **Actores.csv**
   - `nombre`: Nombre del actor.
   - `edad`: Edad del actor.
   - `tituloRelacion`: Relación con una película (enlace con `Peliculas.csv`).

3. **Series.csv**
   - `titulo`: Título de la serie.
   - `duracionEnMinutos`: Duración promedio de un episodio.
   - `genero`: Género de la serie.
   - `temporadas`: Número de temporadas.

4. **Temporadas.csv**
   - `numero`: Número de la temporada.
   - `episodios`: Número de episodios de la temporada.
   - `tituloRelacion`: Relación con una serie (enlace con `Series.csv`).

5. **Documentales.csv**
   - `titulo`: Título del documental.
   - `duracionEnMinutos`: Duración del documental en minutos.
   - `genero`: Género del documental.
   - `tema`: Tema principal del documental.

6. **Investigadores.csv**
   - `nombre`: Nombre del investigador.
   - `edad`: Edad del investigador.
   - `tituloRelacion`: Relación con un documental (enlace con `Documentales.csv`).

7. **TikToks.csv**
   - `titulo`: Título del TikTok.
   - `duracionEnMinutos`: Duración del TikTok en minutos.
   - `genero`: Género del TikTok.
   - `likes`: Número de likes.

8. **UsuariosTikTok.csv**
   - `nombre`: Nombre del usuario.
   - `edad`: Edad del usuario.
   - `tituloRelacion`: Relación con un TikTok (enlace con `TikToks.csv`).

9. **Reels.csv**
   - `titulo`: Título del Reel.
   - `duracionEnMinutos`: Duración del Reel en minutos.
   - `genero`: Género del Reel.

10. **UsuariosReels.csv**
    - `nombre`: Nombre del usuario.
    - `edad`: Edad del usuario.
    - `tituloRelacion`: Relación con un Reel (enlace con `Reels.csv`).

## Generación de Salida

Los archivos generados en la carpeta `detalles/` contienen los datos procesados:
- **PeliculasDetalles.txt**: Información sobre películas y sus actores.
- **SeriesDetalles.txt**: Detalles de series y sus temporadas.
- **DocumentalesDetalles.txt**: Documentales e investigadores asociados.
- **TikToksDetalles.txt**: TikToks y usuarios relacionados.
- **ReelsDetalles.txt**: Reels y usuarios relacionados.


## Principios Aplicados

### Detalles sobre la Carpeta `model`

La carpeta `model` contiene las definiciones de las entidades principales del dominio. Estas clases representan los conceptos y datos del problema que se procesan en el sistema, como películas, actores, series, documentales, TikToks y más. Cada clase está diseñada para almacenar información relevante y encapsular la lógica específica relacionada con cada entidad.

#### Principios de Diseño Aplicados

1. **POJOs (Plain Old Java Objects):**
   - Las clases son simples objetos de datos con atributos que representan las columnas de los archivos CSV correspondientes.
   - Incluyen métodos específicos para operar sobre sus datos, como `agregarActor` en la clase `Pelicula`.

2. **Relación entre Entidades:**
   - Las relaciones entre las entidades están modeladas explícitamente:
     - Una `Pelicula` tiene una lista de `Actor` que participan en ella.
     - Un `Actor` puede estar asociado a múltiples `Pelicula`.
     - Una `SerieDeTV` está compuesta por múltiples `Temporada`.
   - Estas relaciones se manejan con listas y referencias bidireccionales para facilitar la navegación entre objetos.

3. **Herencia y Polimorfismo:**
   - **Herencia:** Todas las entidades como `Pelicula`, `SerieDeTV`, `Documental`, `TikTok` y `Reel` heredan de la clase base `ContenidoAudiovisual`, que define atributos y métodos comunes como:
     - `titulo`: El título del contenido.
     - `duracionEnMinutos`: La duración.
     - `genero`: El género del contenido.
   - **Polimorfismo:** Los objetos que heredan de `ContenidoAudiovisual` pueden ser tratados de forma genérica. Por ejemplo, al mostrar detalles de diferentes tipos de contenido, puedes invocar el método `obtenerDetalles` independientemente del tipo específico del contenido.

4. **Encapsulación:**
   - Todos los atributos son privados y se acceden mediante métodos públicos (`getters` y `setters`), garantizando el control sobre los datos almacenados.

### Ejemplo de Aplicación de Polimorfismo y Herencia

Al procesar diferentes tipos de contenido (como películas, series o documentales), las clases comparten una interfaz común definida por la clase base `ContenidoAudiovisual`. Esto permite manejar de forma uniforme la lista de objetos procesados:

```java
List<ContenidoAudiovisual> contenidos = new ArrayList<>();
contenidos.add(new Pelicula("Titanic", 195, "Drama", "20th Century Fox"));
contenidos.add(new SerieDeTV("Breaking Bad", 50, "Drama", 5));

for (ContenidoAudiovisual contenido : contenidos) {
    System.out.println(contenido.obtenerDetalles());
}
```

En este ejemplo, gracias al polimorfismo, cada objeto invoca su propia implementación de `obtenerDetalles` sin necesidad de conocer su tipo específico.

### Diagrama de clases de models

![Descripción de la imagen](diagramas\models.png)

### SOLID

1. **Responsabilidad Única:** 
   - Cada clase tiene una única responsabilidad:
     - `Pelicula` maneja información sobre películas.
     - `Actor` maneja información sobre los actores.
     - `MediaController` coordina la lógica entre modelos y vistas.
   - Esto facilita mantener y extender el código sin introducir dependencias no deseadas.

2. **Abierto/Cerrado:**
   - El sistema está diseñado para agregar nuevos tipos de contenido (como `Videojuegos`) sin modificar el código existente. Basta con agregar un nuevo modelo, un controlador y un método en `FunctionsHelpers`.

3. **Sustitución de Liskov:**
   - Las clases como `Pelicula`, `Reel` y `TikTok` heredan de `ContenidoAudiovisual` y pueden sustituirse donde se utilice esta clase base.

4. **Segregación de Interfaces:**
   - Los métodos en cada clase son específicos para su propósito. Por ejemplo, `Pelicula` tiene `agregarActor`, pero no incluye métodos irrelevantes para su contexto.

5. **Inversión de Dependencias:**
   - El controlador (`MediaController`) depende de abstracciones (`Modelo` y `Vista`), no de implementaciones concretas.

### Clean Code

- **Nombres Claros:** Los nombres de métodos y variables son descriptivos (`agregarActor`, `getEstudio`, etc.).
- **Funciones Pequeñas:** Las funciones en `FunctionsHelpers` son pequeñas y realizan una tarea específica, como leer o escribir un archivo CSV.
- **Evitar Repetición:** La lógica de procesamiento de CSVs es genérica y reutilizable mediante métodos genéricos en `FunctionsHelpers`.

## Patrón Modelo-Vista-Controlador (MVC)

1. **Modelo (Model):** Define las entidades del dominio (`Pelicula`, `Actor`, `Reel`, etc.). Cada modelo contiene la lógica relacionada con los datos.
2. **Vista (View):** Responsable de mostrar datos en consola o generar archivos de salida. Centraliza la generación de reportes.
3. **Controlador (Controller):** Maneja la lógica del programa y coordina la interacción entre modelo y vista. En este caso, `MediaController` realiza esta función.

## Funciones CORE

La carpeta `core` contiene utilidades para manejar archivos CSV:

1. **`readCsvToObjects`:** 
   - Lee un archivo CSV y lo convierte en una lista de objetos del modelo especificado.

2. **`writeToFile`:**
   - Toma una lista de objetos y escribe sus detalles en un archivo de texto.

3. **`procesarYGuardarDetalles`:**
   - Método genérico que coordina la lectura de datos desde dos archivos CSV relacionados, los enlaza (por ejemplo, `Peliculas` y `Actores`), y luego genera un archivo de salida con los resultados.
