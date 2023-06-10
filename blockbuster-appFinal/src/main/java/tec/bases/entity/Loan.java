package tec.bases.entity;

//librerias
import java.util.Date;

/**
 * Clase que representa un préstamo en el sistema.
 * Contiene información sobre el identificador del préstamo, el identificador de la película prestada,
 * el identificador del cliente que realiza el préstamo, la fecha de préstamo, la fecha de devolución y el estado del préstamo.
 */
public class Loan {

    private long loanID;
    private long filmID;
    private long clientID;
    private Date loanDate;
    private Date loanDevolutionDate;
    private boolean state;

    public Loan(long _ID, long _filmID, long _clientID, Date _loanDate, Date _devolDate, boolean _state) {
        this.loanID = _ID;
        this.filmID = _filmID;
        this.clientID = _clientID;
        this.loanDate = _loanDate;
        this.loanDevolutionDate = _devolDate;
        this.state = _state;
    }

    public Loan(long _filmID, long _clientID, Date _loanDate) {
        this.loanID = 0;
        this.filmID = _filmID;
        this.clientID = _clientID;
        this.loanDate = _loanDate;
        this.loanDevolutionDate = null;
        this.state = false;
    }

    /**
     * Obtiene el identificador del préstamo.
     *
     * @return long el identificador del préstamo
     */
    public long getLoanID() {
        return loanID;
    }

    /**
     * Establece el identificador del préstamo.
     *
     * @param loanID el identificador del préstamo
     */
    public void setLoanID(long loanID) {
        this.loanID = loanID;
    }

    /**
     * Obtiene el identificador de la película prestada.
     *
     * @return long el identificador de la película prestada
     */
    public long getFilmID() {
        return filmID;
    }

    /**
     * Establece el identificador de la película prestada.
     *
     * @param filmID el identificador de la película prestada
     */
    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    /**
     * Obtiene el identificador del cliente que realiza el préstamo.
     *
     * @return long el identificador del cliente
     */
    public long getClientID() {
        return clientID;
    }

    /**
     * Establece el identificador del cliente que realiza el préstamo.
     *
     * @param clientID el identificador del cliente
     */
    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    /**
     * Obtiene la fecha de préstamo.
     *
     * @return Date la fecha de préstamo
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * Establece la fecha de préstamo.
     *
     * @param loanDate la fecha de préstamo
     */
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * Obtiene la fecha de devolución.
     *
     * @return Date la fecha de devolución
     */
    public Date getLoanDevolutionDate() {
        return loanDevolutionDate;
    }

    /**
     * Establece la fecha de devolución.
     *
     * @param loanDevolutionDate la fecha de devolución
     */
    public void setLoanDevolutionDate(Date loanDevolutionDate) {
        this.loanDevolutionDate = loanDevolutionDate;
    }

    /**
     * Comprueba el estado del préstamo.
     *
     * @return boolean true si el préstamo está activo, false de lo contrario
     */
    public boolean isState() {
        return state;
    }

    /**
     * Establece el estado del préstamo.
     *
     * @param state el estado del préstamo
     */
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "   " +
            this.loanID + '\'' + "         " +
            this.filmID + "          " +
            this.clientID + "           " +
            this.loanDate + "      " +
            this.loanDevolutionDate + "        " +
            this.state +
            ' ';
    }
}
