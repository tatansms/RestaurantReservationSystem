package LogicaDelNegocio;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase que se encargara de la logica del restaurante
 */
public class Restaurante {
    private List<Mesa> mesas;
    private List<Reserva> reservas;

    /**
     *Constructor: Inicializa el restaurante con un número fijo de mesas
     * @param numeroMesas Numero de mesas del restaurante
     * @param capacidades Cantidad de personas que podran estar en cada mesa
     */
    public Restaurante(int numeroMesas, int[] capacidades) {
        mesas = new ArrayList<>();
        reservas = new ArrayList<>();

        // Crea mesas según el número y las capacidades proporcionadas
        for (int i = 0; i < numeroMesas; i++) {
            mesas.add(new Mesa(i + 1, capacidades[i]));
        }
    }

    /**
     * Método para verificar la disponibilidad de una mesa para una reserva específica
     * @param fecha Fecha de la reserva
     * @param hora Hora de la reserva
     * @param numPersonas Numero de personas que estaran en la reserva
     * @return Si hay almenos una mesa disponible para la reserva
     */
    public boolean verificarDisponibilidad(String fecha, String hora, int numPersonas) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponible() && mesa.puedeAcomodar(numPersonas)) {
                return true;  // Al menos una mesa está disponible para la capacidad requerida
            }
        }
        return false;  // No hay mesas disponibles con la capacidad requerida
    }


    /**
     * Método para registrar una nueva reserva
     * @param fecha Fecha de la reserva
     * @param hora Hora de la reserva
     * @param numPersonas Numero de personas que estaran en la reserva
     * @param cliente Informacion del cliente
     * @return Si la reserva se ha realizado correctamente
     */
    public boolean registrarReserva(String fecha, String hora, int numPersonas, Cliente cliente) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIngresada = LocalDate.parse(fecha, formatter); // Se convierte la fecha a LocalDate
        LocalDate fechaActual = LocalDate.now(); // Se consigue la fecha actual
        if (fechaIngresada.isEqual(fechaActual) || fechaIngresada.isAfter(fechaActual)) { //se comprueba si la fecha ingresada es la misma o esta despues de la actual
        Mesa mesaDisponible = null;
        for (Mesa mesa : mesas) {
            if (mesa.isDisponible() && mesa.puedeAcomodar(numPersonas)) {
                mesaDisponible = mesa;
                break;
            }
        }

        if (mesaDisponible != null) {
            Reserva nuevaReserva = new Reserva(fecha, hora, numPersonas, cliente);
            nuevaReserva.setMesaAsignada(mesaDisponible);
            mesaDisponible.reservar();
            reservas.add(nuevaReserva);
            System.out.println("LogicaDelNegocio.Reserva registrada exitosamente. ID de la reserva: " + nuevaReserva.getId());
            return true;
        } else {
            System.out.println("No hay mesas disponibles para " + numPersonas + " personas.");
            return false;
        }
        }
        else {
            System.out.println("La fecha ingresada es invalida");
            return false;
        }
    }


    /**
     * Método para cancelar una reserva
     * @param id ID de la reserva
     */
    public void cancelarReserva(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.coincideCon(id)) {
                // Libera la mesa y elimina la reserva
                reserva.getMesaAsignada().liberar();
                reservas.remove(reserva);
                System.out.println("LogicaDelNegocio.Reserva cancelada exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró una reserva para cancelar con el ID proporcionado.");
    }


    /**
     * Método para obtener todas las reservas de un día específico
     * @param fecha Fecha de la reserva
     */
    public void obtenerReservasPorDia(String fecha) {
        System.out.println("Reservas para el día " + fecha + ":");
        for (Reserva reserva : reservas) {
            if (reserva.getFecha().equals(fecha)) {
                reserva.mostrarInfoReserva();
            }
        }
    }

    /**
     * Método para mostrar el estado de todas las mesas
     */
    public void mostrarEstadoMesas() {
        for (Mesa mesa : mesas) {
            String estado = mesa.isDisponible() ? "Disponible" : "Reservada";
            System.out.println("LogicaDelNegocio.Mesa " + mesa.getNumeroMesa() + " - Capacidad: " + mesa.getCapacidad() + " - Estado: " + estado);
        }
    }
}
