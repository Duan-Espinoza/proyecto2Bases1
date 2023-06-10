package tec.bases.entity;

/**
 * Clase que representa una categoría en el sistema.
 * Contiene información sobre el identificador de categoría y su descripción.
 */
public class Category {

    private Long catID;
    private String catDescription;

    public Category(Long _ID, String _catDescrip) {
        this.catID = _ID;
        this.catDescription = _catDescrip;
    }

    /**
     * Obtiene el identificador de la categoría.
     *
     * @return Long el identificador de la categoría
     */
    public Long getCatID() {
        return catID;
    }

    /**
     * Establece el identificador de la categoría.
     *
     * @param catID el identificador de la categoría
     */
    public void setCatID(Long catID) {
        this.catID = catID;
    }

    /**
     * Obtiene la descripción de la categoría.
     *
     * @return String la descripción de la categoría
     */
    public String getCatDescription() {
        return catDescription;
    }

    /**
     * Establece la descripción de la categoría.
     *
     * @param catDescription la descripción de la categoría
     */
    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    @Override
    public String toString() {
        return "   " +
            this.catID + '\'' + "             " +
            this.catDescription + " " +
            ' ';
    }
}
