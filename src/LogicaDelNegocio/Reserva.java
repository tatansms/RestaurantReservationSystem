package LogicaDelNegocio;

/**
 * Esta es la clase que se encargara de la logica de las reservas
 */
public class Reserva {
    private static int contadorID = 0;
    private int id;
    private String fecha;
    private String hora;
    private int numPersonas;
    private Mesa mesaAsignada;
    private Cliente cliente;

    /**
     * Constructor
     * @param fecha Fecha de la reserva
     * @param hora Hora de la reserva
     * @param numPersonas Numero de personas que estaran en la reserva
     * @param cliente Informacion del cliente
     */
    public Reserva(String fecha, String hora, int numPersonas, Cliente cliente) {
        this.id= ++contadorID; // Asignar un ID único a la reserva;
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cliente = cliente;
    }

    // Métodos getters y setters

    /**
     *
     * @return Fecha de la reserva
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha Fecha de la reserva
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return Hora de la reserva
     */
    public String getHora() {
        return hora;
    }

    /**
     *
     * @param hora Hora de la reserva
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     *
     * @return Número de personas que estaran en la reserva
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     *
     * @param numPersonas Número de personas que estaran en la reserva
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     *
     * @return LogicaDelNegocio.Mesa asignada para la reserva
     */
    public Mesa getMesaAsignada() {
        return mesaAsignada;
    }

    /**
     *
     * @param mesaAsignada LogicaDelNegocio.Mesa asignada para la reserva
     */
    public void setMesaAsignada(Mesa mesaAsignada) {
        this.mesaAsignada = mesaAsignada;
    }

    /**
     *
     * @return Informacion del cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente Informacion del cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return ID de la reserva
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id ID de la reserva
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que verifica si una reserva coincide con un ID específico
     * @param id ID de la reserva
     * @return Si la ID coincide con la ID de la reserva
     */
    public boolean coincideCon(int id) {
        return this.id == id;
    }

    /**
     * Método para mostrar información de la reserva
     */

    public void mostrarInfoReserva() {
        System.out.println("LogicaDelNegocio.Reserva para " + cliente.getNombre() + " el día " + fecha + " a las " + hora);
        System.out.println("Número de personas: " + numPersonas);
        System.out.println("LogicaDelNegocio.Mesa asignada: " + (mesaAsignada != null ? mesaAsignada.getNumeroMesa() : "No asignada aún"));
        System.out.println("Teléfono de contacto: " + cliente.getTelefono());
    }

}
