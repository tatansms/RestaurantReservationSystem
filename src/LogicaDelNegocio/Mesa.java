package LogicaDelNegocio;

/**
 * Esta es la clase que se encargara de la logica de las mesas
 */
public class Mesa {
    private int numeroMesa;
    private int capacidad;
    private boolean disponible;

    /**
     * Constructor
     * @param numeroMesa Número de la mesa
     * @param capacidad Cantidad de personas que pueden estar en la mesa
     */
    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.disponible = true;  // Por defecto, la mesa está disponible cuando se crea
    }


    // Métodos getters y setters

    /**
     *
     * @return Número de la mesa
     */
    public int getNumeroMesa() {
        return numeroMesa;
    }

    /**
     *
     * @param numeroMesa Número de la mesa
     */
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     *
     * @return Cantidad de personas que pueden estar en la mesa
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     *
     * @param capacidad Cantidad de personas que pueden estar en la mesa
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     *
     * @return Si la mesa esta disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     *
     * @param disponible Si la mesa esta disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Método para reservar la mesa
     */
    public void reservar() {
        if (disponible) {
            disponible = false;
            System.out.println("La mesa " + numeroMesa + " ha sido reservada.");
        } else {
            System.out.println("La mesa " + numeroMesa + " ya está reservada.");
        }
    }

    /**
     * Método para liberar la mesa (cuando una reserva es cancelada o completada)
     */
    public void liberar() {
        disponible = true;
        System.out.println("La mesa " + numeroMesa + " ha sido liberada.");
    }

    /**
     * Método para verificar si una mesa puede acomodar a un número de personas
     * @param numPersonas Numero de personas que piden estar en la mesa
     * @return Si la mesa tiene el tamaño suficiente para las personas
     */
    public boolean puedeAcomodar(int numPersonas) {
        return numPersonas <= capacidad;
    }
}
