import java.util.ArrayList; // Importamos ArrayList para manejar listas dinámicas
import java.util.List; // Importamos List para usarlo como tipo de datos para listas

/**
 * ! Clase Alumno
 * ? Representa a un estudiante con atributos básicos y métodos para interactuar con ellos.
 */
class Alumno {
    // * Atributos privados para mantener el encapsulamiento
    private String nombre; // Nombre del alumno
    private String apellido; // Apellido del alumno
    private int edad; // Edad del alumno

    // * Constructor para inicializar un objeto Alumno
    public Alumno(String nombre, String apellido, int edad) {
        // Asignamos los parámetros recibidos a los atributos de la clase
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.edad = edad; 
    }

    // * Getter para obtener el nombre del alumno
    public String getNombre() {
        // Devuelve el valor del atributo privado "nombre"
        return nombre; 
    }

    // * Getter para obtener el apellido del alumno
    public String getApellido() {
        // Devuelve el valor del atributo privado "apellido"
        return apellido; 
    }

    // * Setter para modificar el apellido del alumno
    public void setApellido(String apellido) {
        // Asigna un nuevo valor al atributo "apellido"
        this.apellido = apellido; 
    }

    // * Getter para obtener la edad del alumno
    public int getEdad() {
        // Devuelve el valor del atributo privado "edad"
        return edad; 
    }

    // * Setter para modificar la edad del alumno
    public void setEdad(int edad) {
        // Asigna un nuevo valor al atributo "edad"
        this.edad = edad; 
    }

    // * Método toString para personalizar la impresión de un objeto Alumno
    @Override
    public String toString() {
        // Devuelve una cadena con los detalles del alumno
        return nombre + " " + apellido + " (" + edad + " años)";
    }
}

/**
 * ! Clase Clase
 * ? Representa una clase educativa que contiene una lista de alumnos.
 */
class Clase {
    // * Atributos
    private String nombre; // Nombre de la clase (e.g., "Matemáticas")
    private String aula; // Nombre del aula donde se imparte la clase
    private List<Alumno> alumnos; // Lista de alumnos en la clase

    // * Constructor para inicializar un objeto Clase
    public Clase(String nombre, String aula) {
        // Inicializamos los atributos
        this.nombre = nombre;
        this.aula = aula;
        this.alumnos = new ArrayList<>(); // Inicializamos la lista de alumnos
    }

    // * Método para agregar un alumno a la lista de la clase
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno); // Añadimos el alumno a la lista
        System.out.println("Alumno " + alumno.getNombre() + " agregado a la clase " + nombre);
    }

    // * Método para mostrar información detallada de la clase
    public void mostrarInformacionClase() {
        System.out.println("\nClase: " + nombre); // Imprimimos el nombre de la clase
        System.out.println("Aula: " + aula); // Imprimimos el aula
        System.out.println("Alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno); // Llamamos al método toString de cada alumno
        }
    }
}

/**
 * ! Clase Principal: InstitucionEducativa
 * ? Contiene el método main para ejecutar el programa.
 */
public class UT2_GuiaGettersSetters {
    public static void main(String[] args) {
        // * Crear una clase educativa
        Clase matematicas = new Clase("Matemáticas", "Aula 101");
        Clase java = new Clase("java", "Aula 103");
        


        // * Crear y agregar alumnos a la clase de matemáticas
        Alumno juan = new Alumno("Juan", "Pérez", 18); // Creamos un alumno
        matematicas.agregarAlumno(juan); // Agregamos el alumno a la clase

        Alumno maria = new Alumno("María", "López", 20); // Creamos otro alumno
        matematicas.agregarAlumno(maria); // Agregamos el alumno a la clase
        java.agregarAlumno(juan);
        // * Modificar atributos usando setters
        juan.setApellido("González"); // Cambiamos el apellido de Juan
        maria.setEdad(21); 
        juan.getApellido();
       // Cambiamos la edad de María

        // * Mostrar información detallada de la clase
        matematicas.mostrarInformacionClase(); // Imprime la información de la clase y sus alumnos
    }
}
