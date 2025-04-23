/******************************************************************************************
 *                        📚 **GUÍA COMPLETA: MANEJO DE EXCEPCIONES EN JAVA**
 * ──────────────────────────────────────────────────────────────────────────────
 * Este archivo ofrece una introducción teórica y práctica al manejo de excepciones en Java.
 * Incluye ejemplos ejecutables para comprender:
 *    • try, catch, finally
 *    • throw y throws
 *    • Excepciones personalizadas
 *
 * ! IMPORTANTE: Asegúrate de tener instaladas las extensiones "Java Extension Pack" y 
 * "Better Comments" en VS Code para visualizar los comentarios destacados con colores.
 *
 * Autor: Joaquín
 * Fecha: 28/01/2025
 ******************************************************************************************/

 import java.util.Scanner;

 public class UT2_ManejoExcepciones {
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int opcion;
         
         // =====================================================
         // ! 📌 MENÚ PRINCIPAL: DEMOSTRACIÓN DE EXCEPCIONES
         // =====================================================
         do {
             System.out.println("\n==============================================");
             System.out.println("      MENÚ DE EJEMPLOS DE EXCEPCIONES         ");
             System.out.println("==============================================");
             System.out.println("1. Ejemplo Básico de try-catch");
             System.out.println("2. Ejemplo de finally");
             System.out.println("3. Ejemplo de throw (lanzar excepción manualmente)");
             System.out.println("4. Ejemplo de throws (declaración de método)");
             System.out.println("5. Ejemplo de Excepción Personalizada");
             System.out.println("6. Salir");
             System.out.print("👉 Seleccione una opción: ");
             opcion = readInt(scanner);
             
             switch (opcion) {
                 case 1:
                     System.out.println("\n--- Ejemplo Básico de try-catch ---");
                     ejemploTryCatch();
                     break;
                 case 2:
                     System.out.println("\n--- Ejemplo de finally ---");
                     ejemploFinally();
                     break;
                 case 3:
                     System.out.println("\n--- Ejemplo de throw ---");
                     ejemploThrow();
                     break;
                 case 4:
                     System.out.println("\n--- Ejemplo de throws ---");
                     System.out.print("👉 Ingrese un divisor para 10/divisor: ");
                     int divisor = readInt(scanner);
                     try {
                         ejemploThrows(divisor);
                     } catch (ArithmeticException e) {
                         System.out.println("❌ Excepción capturada en main: " + e.getMessage());
                     }
                     break;
                 case 5:
                     System.out.println("\n--- Ejemplo de Excepción Personalizada ---");
                     ejemploExcepcionPersonalizada();
                     break;
                 case 6:
                     System.out.println("👋 Saliendo del programa...");
                     break;
                 default:
                     System.out.println("❌ Opción inválida. Intente nuevamente.");
             }
         } while (opcion != 6);
         
         scanner.close();
     }
 
     // ---------------------------------------------------------------
     // ! MÉTODO: readInt
     // ---------------------------------------------------------------
     // ⭐ Lee de forma segura un número entero, gestionando entradas no válidas.
     public static int readInt(Scanner scanner) {
         while (true) {
             try {
                 return scanner.nextInt(); // ➡ Intenta leer un entero
             } catch (Exception e) { // ❌ Si la entrada no es válida
                 System.out.println("❌ Entrada no válida. Por favor, ingrese un número entero.");
                 scanner.next(); // Descarta la entrada incorrecta
             }
         }
     }
 
     // =====================================================
     // ! 📌 SECCIÓN 1: Ejemplo Básico de try-catch
     // =====================================================
     /**
      * //! EJEMPLO: try-catch básico
      *
      * ? TEORÍA:
      * - Se intenta ejecutar una operación que puede generar una excepción.
      * - Si ocurre una excepción, el control se transfiere al bloque catch.
      *
      * * TAREA PARA EL ALUMNO: Modifica este ejemplo para lanzar una excepción de otro tipo,
      * como NumberFormatException.
      */
     public static void ejemploTryCatch() {
         try {
             int resultado = 10 / 0; // ! Esto lanza una ArithmeticException
             System.out.println("Resultado: " + resultado);
         } catch (ArithmeticException e) {
             System.out.println("❌ Error aitme" );
         }
     }
 
     // =====================================================
     // ! 📌 SECCIÓN 2: Ejemplo de finally
     // =====================================================
     /**
      * //! EJEMPLO: Uso del bloque finally
      *
      * ? TEORÍA:
      * - El bloque finally se ejecuta siempre, ocurra o no una excepción.
      * - Es útil para liberar recursos o ejecutar código de limpieza.
      *
      * * TAREA PARA EL ALUMNO: Agrega una variable que se incremente en el bloque finally
      * y muestra su valor.
      */
     public static void ejemploFinally() {
         try {
             System.out.println("Intentando ejecutar...");
             int resultado = 10 / 0;
             System.out.println("Resultado: " + resultado);
         } catch (ArithmeticException e) {
             System.out.println("❌ Error: " + e.getMessage());
         } finally {
             System.out.println("✅ Este mensaje siempre se muestra, independientemente de la excepción.");
         }
     }
 
     // =====================================================
     // ! 📌 SECCIÓN 3: Ejemplo de throw (lanzar una excepción manualmente)
     // =====================================================
     /**
      * //! EJEMPLO: Uso de throw para lanzar una excepción manualmente
      *
      * ? TEORÍA:
      * - Se utiliza "throw" para lanzar una excepción de forma manual.
      * - Esto es útil cuando se detecta un error específico que deseas manejar.
      *
      * * TAREA PARA EL ALUMNO: Cambia la excepción lanzada a IllegalArgumentException y modifica el mensaje.
      */
     public static void ejemploThrow() {
         try {
             throw new NullPointerException("❌ Error: Valor nulo detectado");
         } catch (NullPointerException e) {
             System.out.println("✅ Excepción capturada: " + e.getMessage());
         }
     }
 
     // =====================================================
     // ! 📌 SECCIÓN 4: Ejemplo de throws (declaración de método)
     // =====================================================
     /**
      * //! EJEMPLO: Uso de throws en la declaración de un método
      *
      * ? TEORÍA:
      * - "throws" en la firma del método indica que el método puede lanzar una excepción.
      * - Es una forma de delegar el manejo de la excepción al método que lo llama.
      *
      * * TAREA PARA EL ALUMNO: Llama a este método con un divisor distinto de cero y observa el resultado.
      *
      * @param divisor Número por el cual se va a dividir.
      * @throws ArithmeticException si el divisor es 0.
      */
     public static void ejemploThrows(int divisor) throws ArithmeticException {
         if (divisor == 0) {
             throw new ArithmeticException("❌ División por cero no permitida");
         }
         System.out.println("Resultado de la división: " + (10 / divisor));
     }
 
     // =====================================================
     // ! 📌 SECCIÓN 5: Ejemplo de Excepción Personalizada
     // =====================================================
     /**
      * //! EJEMPLO: Uso de una excepción personalizada
      *
      * ? TEORÍA:
      * - Las excepciones personalizadas permiten definir reglas de error específicas.
      * - En este ejemplo, se lanza una excepción personalizada si la edad es menor de 18.
      *
      * * TAREA PARA EL ALUMNO: Modifica el método "validarEdad" para que lance una excepción
      * si la edad es mayor de 100 (por ejemplo, "EdadDemasiadoAltaException").
      */
     public static void ejemploExcepcionPersonalizada() {
         try {
             validarEdad(15); // Intentamos validar una edad inválida
         } catch (EdadInvalidaException e) {
             System.out.println("✅ Excepción personalizada capturada: " + e.getMessage());
         }
     }
 
     /**
      * * Método que lanza una excepción personalizada si la edad es menor de 18.
      * @param edad Edad del usuario.
      * @throws EdadInvalidaException si la edad es menor de 18.
      */
     public static void validarEdad(int edad) throws EdadInvalidaException {
         if (edad < 18) {
             throw new EdadInvalidaException("❌ Debes ser mayor de 18 años.");
         }
         System.out.println("✅ Edad válida.");
     }
 }
 
 /**
  * ! Clase para una Excepción Personalizada: EdadInvalidaException
  *
  * ? TEORÍA:
  * - Se extiende la clase Exception para crear una excepción personalizada.
  * - Esto permite lanzar errores específicos relacionados con la lógica del programa.
  *
  * // TODO: Crea otra excepción personalizada para validar nombres o algún otro dato.
  */
 class EdadInvalidaException extends Exception {
     public EdadInvalidaException(String mensaje) {
         super(mensaje);
     }
 }
 
 /*
 ********************************************************************************************
  *                        ✍️ PRÁCTICAS RECOMENDADAS PARA EL ALUMNO:
  * ──────────────────────────────────────────────────────────────────────────────
  * 1. Modifica el programa y lanza otras excepciones (por ejemplo, IndexOutOfBoundsException,
  *    NumberFormatException, etc.).
  * 2. Implementa una excepción personalizada para validar nombres (por ejemplo, que no sean vacíos).
  * 3. Crea una clase "CuentaBancaria" y utiliza excepciones para evitar retiros de saldo negativo.
  * 4. Experimenta eliminando bloques catch y observa qué sucede en tiempo de ejecución.
  ********************************************************************************************/
 