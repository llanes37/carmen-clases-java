/**
 * ! Programación Orientada a Objetos (POO) en Java - Guía Completa
 * ? Este archivo ofrece una explicación detallada de los pilares de la POO:
 * ? clases, objetos, métodos, atributos, encapsulamiento, herencia, polimorfismo y abstracción.
 * * Incluye ejemplos ejecutables para cada concepto.
 *
 * ! IMPORTANTE: Asegúrate de tener las extensiones "Java Extension Pack" y "Better Comments" en VS Code.
 * Autor: Joaquín
 * Fecha: 24/01/2025
 */

/**
 * ! Introducción a la Programación Orientada a Objetos (POO)
 *
 * ? La POO es un paradigma de programación basado en el uso de objetos, que son instancias de clases.
 * Principales conceptos:
 *
 * - *Clases*: Plantillas que definen las propiedades (atributos) y comportamientos (métodos) de los objetos.
 * - *Objetos*: Instancias de una clase que poseen estado y comportamiento.
 * - *Encapsulamiento*: Protección de los datos mediante modificadores de acceso.
 * - *Herencia*: Permite que una clase reutilice propiedades y métodos de otra clase.
 * - *Polimorfismo*: Habilidad de un método para comportarse de distintas formas según el contexto.
 * - *Abstracción*: Oculta los detalles internos y expone solo la funcionalidad esencial.
 */

// * Ejemplo práctico: Clases, objetos y encapsulamiento
public class UT3_ClasesObjetosEncapsulamiento {
    public static void main(String[] args) {
        // ! Creación de un objeto de la clase Persona
        Persona persona1 = new Persona("Juan", "Pérez", 30);

        // ? Uso de métodos getter para obtener información
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());
        System.out.println("Edad: " + persona1.getEdad());

        // ? Uso de métodos setter para modificar información
        persona1.setEdad(31);
        System.out.println("Nueva edad: " + persona1.getEdad());

        // ! Mostrar información completa usando el método toString
        System.out.println("Información de la persona: " + persona1);

        // ! Ejemplo de herencia y polimorfismo
        Empleado empleado1 = new Empleado("Ana", "García", 28, "Programadora");
        System.out.println("Información del empleado: " + empleado1);

        // ? Uso de método polimórfico
        Persona persona2 = new Empleado("Carlos", "López", 35, "Diseñador");
        System.out.println("Información polimórfica: " + persona2);
    }
}

/**
 * ! Clase Persona (Demostración de encapsulamiento)
 */
class Persona {
    // * Atributos privados (Encapsulamiento)
    private String nombre;
    private String apellido;
    private int edad;

    // * Constructor
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // * Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // * toString para representar la información del objeto
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + edad + " años)";
    }
}

/**
 * ! Clase Empleado (Herencia y Polimorfismo)
 */
class Empleado extends Persona {
    // * Atributo adicional para la clase Empleado
    private String puesto;

    // * Constructor que llama al constructor de la clase padre (Persona)
    public Empleado(String nombre, String apellido, int edad, String puesto) {
        super(nombre, apellido, edad); // Llamada al constructor de la clase padre
        this.puesto = puesto;
    }

    // * Getter y Setter para el atributo puesto
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    // * Sobrescritura del método toString para incluir el puesto
    @Override
    public String toString() {
        return super.toString() + ", Puesto: " + puesto;
    }
}
