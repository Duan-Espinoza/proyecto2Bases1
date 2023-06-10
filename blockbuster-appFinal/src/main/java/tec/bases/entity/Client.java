package tec.bases.entity;

/**
 * Clase que representa un cliente en el sistema.
 * Contiene información sobre el identificador del cliente, su nombre, apellido, dirección y número de celular.
 */
public class Client {

    private int clientID;
    private String clientName;
    private String clientLastName;
    private String clientDir;
    private int clientCel;

    public Client(int _ID, String _name, String _lastName, String _dir, int _cel) {
        this.clientID = _ID;
        this.clientName = _name;
        this.clientLastName = _lastName;
        this.clientDir = _dir;
        this.clientCel = _cel;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return int el identificador del cliente
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param clientID el identificador del cliente
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return String el nombre del cliente
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param clientName el nombre del cliente
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return String el apellido del cliente
     */
    public String getClientLastName() {
        return clientLastName;
    }

    /**
     * Establece el apellido del cliente.
     *
     * @param clientLastName el apellido del cliente
     */
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    /**
     * Obtiene la dirección del cliente.
     *
     * @return String la dirección del cliente
     */
    public String getClientDir() {
        return clientDir;
    }

    /**
     * Establece la dirección del cliente.
     *
     * @param clientDir la dirección del cliente
     */
    public void setClientDir(String clientDir) {
        this.clientDir = clientDir;
    }

    /**
     * Obtiene el número de celular del cliente.
     *
     * @return int el número de celular del cliente
     */
    public int getClientCel() {
        return clientCel;
    }

    /**
     * Establece el número de celular del cliente.
     *
     * @param clientCel el número de celular del cliente
     */
    public void setClientCel(int clientCel) {
        this.clientCel = clientCel;
    }
}
