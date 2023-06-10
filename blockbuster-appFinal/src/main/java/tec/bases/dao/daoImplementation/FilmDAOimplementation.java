package tec.bases.dao.daoImplementation;

//Librerias
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import tec.bases.dao.FilmDAO;
import tec.bases.entity.Film;

/**
 * Implementación de la interfaz FilmDAO que se conecta a una base de datos para realizar operaciones relacionadas con la entidad Film.
 */
public class FilmDAOimplementation extends GenericDAOimplementation<Film, Long> implements FilmDAO {

    private final DataSource dataSource;

    public FilmDAOimplementation(DataSource _dataSource) {
        this.dataSource = _dataSource;
    }

    private Connection getDBconnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<Film> findAll() throws SQLException {
        String selectStringQuery = "SELECT * FROM blockbuster.film";

        Connection dbConnection = getDBconnection();
        try (PreparedStatement findFilm = dbConnection.prepareStatement(selectStringQuery)) {
            dbConnection.setAutoCommit(false);
            var resultSet = findFilm.executeQuery();
            dbConnection.commit();
            return resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Film> findByID(Long id) throws SQLException {
        String findStringQuery =
                "SELECT * FROM blockbuster.Film WHERE blockbuster.Film.film_cod = ?";

        Connection dbConnection = getDBconnection();
        try (PreparedStatement findFilm = dbConnection.prepareStatement(findStringQuery)) {
            dbConnection.setAutoCommit(false);
            findFilm.setLong(1, id);
            var resultSet = findFilm.executeQuery();
            dbConnection.commit();
            resultSet.next();
            return Optional.of(resultSetToEntity(resultSet));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return Optional.empty();
    }

    @Override
    public void save(Film t) throws SQLException {
        String saveStringQuery =
                "INSERT INTO blockbuster.Film (film_tittle, film_releaseDate, film_catID) " +
                        "VALUES (?, ?, ?)";

        Connection dbConnection = getDBconnection();
        try (PreparedStatement saveFilm = dbConnection.prepareStatement(saveStringQuery)) {
            dbConnection.setAutoCommit(false);
            saveFilm.setString(1, t.getFilmTitle());
            saveFilm.setDate(2, t.getFilmReleaseDate());
            saveFilm.setLong(3, t.getFilmCategory());

            saveFilm.executeUpdate();
            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    public void update(Film t) throws SQLException {
        String updateStringQueryTitle = "UPDATE blockbuster.Film AS film " +
                "SET film.film_tittle = ? WHERE film.film_cod = ?";

        String updateStringQueryDate = "UPDATE blockbuster.Film AS film " +
                "SET film.film_releaseDate = ? WHERE film.film_cod = ?";

        String updateStringQueryCat = "UPDATE blockbuster.Film AS film " +
                "SET film.film_catID = ? WHERE film.film_cod = ?";


        Connection dbConnection = getDBconnection();
        try (
                PreparedStatement updateTitle = dbConnection.prepareStatement(updateStringQueryTitle);
                PreparedStatement updateDate = dbConnection.prepareStatement(updateStringQueryDate);
                PreparedStatement updateCat = dbConnection.prepareStatement(updateStringQueryCat)
        ) {
            dbConnection.setAutoCommit(false);
            updateTitle.setString(1, t.getFilmTitle());
            updateTitle.setLong(2, t.getFilmID());
            updateTitle.executeUpdate();

            updateDate.setDate(1, t.getFilmReleaseDate());
            updateDate.setLong(2, t.getFilmID());
            updateDate.executeUpdate();

            updateCat.setLong(1, t.getFilmCategory());
            updateCat.setLong(2, t.getFilmID());
            updateCat.executeUpdate();

            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String deleteStringQuery = "DELETE FROM blockbuster.Film WHERE blockbuster.Film.film_cod = ?";

        Connection dbConnection = getDBconnection();
        try (PreparedStatement deleteFilm = dbConnection.prepareStatement(deleteStringQuery)) {
            dbConnection.setAutoCommit(false);
            deleteFilm.setLong(1, id);
            deleteFilm.executeUpdate();
            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    protected Film resultSetToEntity(ResultSet _resultSet) throws SQLException {
        var filmID = _resultSet.getLong("film_cod");
        var filmTitle = _resultSet.getString("film_tittle");
        var filmDate = _resultSet.getDate("film_releaseDate");
        var catID = _resultSet.getLong("film_catID");

        return new Film(filmID, filmTitle, filmDate, catID);
    }

    @Override
    protected List<Film> resultSetToList(ResultSet _resultSet) throws SQLException {
        List<Film> myFilms = new ArrayList<>();
        while (_resultSet.next()) {
            myFilms.add(resultSetToEntity(_resultSet));
        }
        return myFilms;
    }
}
