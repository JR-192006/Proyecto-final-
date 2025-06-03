package view;
import java.util.Scanner;


public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println(" ");
        System.out.println("/////BIENVENIDO AL SISTEMA DE SERVICIO DE CITAS MEDICAS/////");
        System.out.println("///////////////////////// SSCM /////////////////////////////");
        System.out.println("--Recuerda que nuestros horarios de atencion son de 08:00 a 17:00--");
        System.out.println(" ");
        System.out.println("1. Reservar Cita");
        System.out.println("2. Agregar Empleado");
        System.out.println("3. Agregar Servicio");
        System.out.println("4. Cancelar Cita");
        System.out.println("5. Eliminar Empleado");
        System.out.println("6. Eliminar Servicio");
        System.out.println("7. Ver Citas Agendadas");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }



    public String leerDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public String mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
        return mensaje;
    }
}
