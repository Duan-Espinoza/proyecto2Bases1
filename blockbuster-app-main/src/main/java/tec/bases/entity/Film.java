package tec.bases.entity;

//Librerias
import java.sql.Date;

/**
 * Clase que representa una película en el sistema.
 * Contiene información sobre el identificador de la película, su título, fecha de lanzamiento y categoría.
 */
public class Film {

    private Long filmID;
    private String filmTittle;
    private Date filmReleaseDate;
    private Long filmCategory;

    public Film(Long _ID, String _tittle, Date _date, Long _category) {
        this.filmID = _ID;
        this.filmTittle = _tittle;
        this.filmReleaseDate = _date;
        this.filmCategory = _category;
    }

    public Film(String _tittle, Date _date, Long _category) {
        this.filmID = Long.valueOf(0);
        this.filmTittle = _tittle;
        this.filmReleaseDate = _date;
        this.filmCategory = _category;
    }

    /**
     * Obtiene el identificador de la película.
     *
     * @return Long el identificador de la película
     */
    public Long getFilmID() {
        return filmID;
    }

    /**
     * Establece el identificador de la película.
     *
     * @param filmID el identificador de la película
     */
    public void setFilmID(Long filmID) {
        this.filmID = filmID;
    }

    /**
     * Obtiene el título de la película.
     *
     * @return String el título de la película
     */
    public String getFilmTittle() {
        return filmTittle;
    }

    /**
     * Establece el título de la película.
     *
     * @param filmTittle el título de la película
     */
    public void setFilmTittle(String filmTittle) {
        this.filmTittle = filmTittle;
    }

    /**
     * Obtiene la fecha de lanzamiento de la película.
     *
     * @return Date la fecha de lanzamiento de la película
     */
    public Date getFilmReleaseDate() {
        return filmReleaseDate;
    }

    /**
     * Establece la fecha de lanzamiento de la película.
     *
     * @param filmReleaseDate la fecha de lanzamiento de la película
     */
    public void setFilmReleaseDate(Date filmReleaseDate) {
        this.filmReleaseDate = filmReleaseDate;
    }

    /**
     * Obtiene la categoría de la película.
     *
     * @return Long la categoría de la película
     */
    public Long getFilmCategory() {
        return filmCategory;
    }

    /**
     * Establece la categoría de la película.
     *
     * @param filmCategory la categoría de la película
     */
    public void setFilmCategory(Long filmCategory) {
        this.filmCategory = filmCategory;
    }

    @Override
    public String toString() {
        return "   " +
            this.filmID + '\'' + "         " +
            this.filmTittle + "          " +
            this.filmReleaseDate + "           " +
            this.filmCategory + "      " +
            ' ';
    }
}
