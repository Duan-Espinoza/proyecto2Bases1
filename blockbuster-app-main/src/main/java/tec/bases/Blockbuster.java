package tec.bases;

//librerias
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import tec.bases.dao.*;
import tec.bases.entity.*;

/**
 * Clase que representa el sistema Blockbuster.
 * Proporciona métodos para acceder y administrar préstamos, categorías y películas.
 */
public class Blockbuster {

    private LoanDAO loanDao;
    private CategoryDAO catDao;
    private FilmDAO filmDao;

    /**
     * Constructor de la clase Blockbuster.
     * @param _loanDao el DAO de Loan a utilizar.
     * @param _catDao el DAO de Category a utilizar.
     * @param _filmDao el DAO de Film a utilizar.
     */
    public Blockbuster(LoanDAO _loanDao, CategoryDAO _catDao, FilmDAO _filmDao) {
        this.loanDao = _loanDao;
        this.catDao = _catDao;
        this.filmDao = _filmDao;
    }

    // Métodos de préstamos...

    /**
     * Obtiene todos los préstamos de Blockbuster.
     * @return List<Loan> la lista de préstamos.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public List<Loan> getAllLoans() throws SQLException {
        return this.loanDao.findAll();
    }

    /**
     * Guarda un préstamo en Blockbuster.
     * @param _loan el préstamo a guardar.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void saveLoan(Loan _loan) throws SQLException {
        this.loanDao.save(_loan);
    }

    /**
     * Busca un préstamo por su ID de película.
     * @param _id el ID de la película.
     * @return List<Loan> la lista de préstamos encontrados.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public List<Loan> findLoanByID(long _id) throws SQLException {
        return this.loanDao.findByFilm(_id);
    }

    /**
     * Elimina un préstamo en Blockbuster dado un ID de película y un ID de cliente.
     * @param _filmID el ID de la película.
     * @param _clientID el ID del cliente.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void deleteLoan(Long _filmID, Long _clientID) throws SQLException {
        this.loanDao.deleteLoan(_filmID, _clientID);
    }


    
    // Métodos de categorías...

    /**
     * Guarda una categoría en Blockbuster.
     * @param _cat la categoría a guardar.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void saveCategory(Category _cat) throws SQLException {
        this.catDao.save(_cat);
    }

    /**
     * Obtiene todas las categorías de Blockbuster.
     * @return List<Category> la lista de categorías.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public List<Category> getAllCategories() throws SQLException {
        return this.catDao.findAll();
    }

    /**
     * Busca una categoría por su ID.
     * @param _id el ID de la categoría.
     * @return Optional<Category> la categoría encontrada (si existe).
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public Optional<Category> findCategoryByID(Long _id) throws SQLException {
        return this.catDao.findByID(_id);
    }

    /**
     * Elimina una categoría en Blockbuster dado un ID.
     * @param _id el ID de la categoría.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void deleteCategory(Long _id) throws SQLException {
        this.catDao.delete(_id);
    }

    /**
     * Actualiza una categoría en Blockbuster.
     * @param _cat la categoría a actualizar.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void updateCategory(Category _cat) throws SQLException {
        this.catDao.update(_cat);
    }


    // Métodos de películas...

    /**
     * Guarda una película en Blockbuster.
     * @param _film la película a guardar.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void saveFilm(Film _film) throws SQLException {
        this.filmDao.save(_film);
    }

    /**
     * Obtiene todas las películas de Blockbuster.
     * @return List<Film> la lista de películas.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public List<Film> getAllFilms() throws SQLException {
        return this.filmDao.findAll();
    }

    /**
     * Busca una película por su ID.
     * @param _id el ID de la película.
     * @return Optional<Film> la película encontrada (si existe).
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public Optional<Film> findFilmByID(Long _id) throws SQLException {
        return this.filmDao.findByID(_id);
    }

    /**
     * Elimina una película en Blockbuster dado un ID.
     * @param _id el ID de la película.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void deleteFilm(Long _id) throws SQLException {
        this.filmDao.delete(_id);
    }

    /**
     * Actualiza una película en Blockbuster.
     * @param _film la película a actualizar.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public void updateFilm(Film _film) throws SQLException {
        this.filmDao.update(_film);
    }
}
