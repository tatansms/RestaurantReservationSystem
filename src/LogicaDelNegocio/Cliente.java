package LogicaDelNegocio;

/**
 * Esta es la clase que se encargara de la logica de los clientes
 */

public class Cliente {
    private String nombre;
    private String telefono;

    /**
     * Constructor
     * @param nombre Nombre del cliente
     * @param telefono Telefono del cliente
     */
    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }


     //Métodos getters y setters


    /**
     *
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre Nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return Telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono Telefono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para mostrar la información del cliente
     */
    public void mostrarInfoCliente() {
        System.out.println("LogicaDelNegocio.Cliente: " + nombre);
        System.out.println("Teléfono: " + telefono);
    }


}
