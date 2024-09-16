package Vista;
import LogicaDelNegocio.*;
import java.util.Scanner;

/**
 * Esta es la clase que se encargara de la interaccion con el usuario
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar capacidades de las mesas (ejemplo de 2 mesas)
        int[] capacidades = {2,2,4,4,6};

        // Crear el restaurante con 5 mesas
        Restaurante restaurante = new Restaurante(5, capacidades);

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n--- Sistema de Reservas del LogicaDelNegocio.Restaurante ---");
            System.out.println("1. Crear LogicaDelNegocio.Cliente y Registrar LogicaDelNegocio.Reserva");
            System.out.println("2. Cancelar LogicaDelNegocio.Reserva");
            System.out.println("3. Mostrar Reservas del Día");
            System.out.println("4. Mostrar Estado de las Mesas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    // Crear LogicaDelNegocio.Cliente y Registrar LogicaDelNegocio.Reserva
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del cliente: ");
                    String telefono = scanner.nextLine();
                    Cliente cliente = new Cliente(nombre, telefono);

                    System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Ingrese la hora de la reserva (HH:MM): ");
                    String hora = scanner.nextLine();
                    System.out.print("Ingrese el número de personas: ");
                    int numPersonas = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea

                    // Registrar la reserva
                    restaurante.registrarReserva(fecha, hora, numPersonas, cliente);
                    break;

                case 2:
                    // Cancelar LogicaDelNegocio.Reserva
                    System.out.print("Ingrese el ID de la reserva a cancelar: ");
                    int idCancelar = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea

                    // Cancelar la reserva por ID
                    restaurante.cancelarReserva(idCancelar);


                break;

                case 3:
                    // Mostrar reservas del día
                    System.out.print("Ingrese la fecha para ver las reservas (YYYY-MM-DD): ");
                    String fechaReporte = scanner.nextLine();

                    restaurante.obtenerReservasPorDia(fechaReporte);
                    break;

                case 4:
                    // Mostrar estado de las mesas
                    System.out.println("Estado de las mesas:");
                    restaurante.mostrarEstadoMesas();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }

        scanner.close();
    }
}

