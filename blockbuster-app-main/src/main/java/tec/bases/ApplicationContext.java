package tec.bases;

//librerias
import com.zaxxer.hikari.HikariDataSource;
import tec.bases.dao.*;
import tec.bases.dao.daoImplementation.*;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import tec.bases.entity.Loan;
import com.zaxxer.hikari.HikariConfig;

/**
 * Clase que representa el contexto de la aplicación.
 * Se encarga de inicializar y mantener una instancia de Blockbuster.
 */
public class ApplicationContext {

    private Blockbuster blockbuster;

    /**
     * Constructor de la clase ApplicationContext.
     * Inicializa las instancias necesarias de DAOs y el objeto Blockbuster.
     */
    public ApplicationContext() {
        var hikariDataSource = initHikariDataSource();
        LoanDAO mySQLloans = initLoanDao(hikariDataSource);
        CategoryDAO mySQLcat = initCategoryDao(hikariDataSource);
        FilmDAO mySQLfilms = initFilmDao(hikariDataSource);

        this.blockbuster = initBlockBuster(mySQLloans, mySQLcat, mySQLfilms);
    }

    /**
     * Inicializa y configura el objeto HikariDataSource.
     * @return HikariDataSource la fuente de datos configurada.
     */
    private static HikariDataSource initHikariDataSource() {
        HikariConfig config = new HikariConfig("/database.properties");
        return new HikariDataSource(config);
    }

    /**
     * Inicializa el objeto LoanDAO utilizando la fuente de datos proporcionada.
     * @param dataSource la fuente de datos a utilizar.
     * @return LoanDAO la instancia de LoanDAO creada.
     */
    private static LoanDAO initLoanDao(DataSource dataSource) {
        return new LoanDAOimplementation(dataSource);
    }

    /**
     * Inicializa el objeto CategoryDAO utilizando la fuente de datos proporcionada.
     * @param dataSource la fuente de datos a utilizar.
     * @return CategoryDAO la instancia de CategoryDAO creada.
     */
    private static CategoryDAO initCategoryDao(DataSource dataSource) {
        return new CategoryDAOimplementation(dataSource);
    }

    /**
     * Inicializa el objeto FilmDAO utilizando la fuente de datos proporcionada.
     * @param dataSource la fuente de datos a utilizar.
     * @return FilmDAO la instancia de FilmDAO creada.
     */
    private static FilmDAO initFilmDao(DataSource dataSource) {
        return new FilmDAOimplementation(dataSource);
    }

    /**
     * Inicializa el objeto Blockbuster utilizando los DAOs proporcionados.
     * @param _loanDao el DAO de Loan a utilizar.
     * @param _catDao el DAO de Category a utilizar.
     * @param _filmDao el DAO de Film a utilizar.
     * @return Blockbuster la instancia de Blockbuster creada.
     */
    private static Blockbuster initBlockBuster(LoanDAO _loanDao, CategoryDAO _catDao, FilmDAO _filmDao) {
        return new Blockbuster(_loanDao, _catDao, _filmDao);
    }

    /**
     * Obtiene una lista de todos los préstamos de Blockbuster.
     * @return List<Loan> la lista de préstamos.
     * @throws SQLException si ocurre un error en la base de datos.
     */
    public List<Loan> getLoans() throws SQLException {
        return this.blockbuster.getAllLoans();
    }
    

    /**
     * Retorna la instancia actual de Blockbuster.
     * @return Blockbuster la instancia de Blockbuster.
     */
    public Blockbuster getBlockbuster() {
        return blockbuster;
    }

    /**
     * Establece la instancia de Blockbuster.
     * @param blockbuster la instancia de Blockbuster a establecer.
     */
    public void setBlockbuster(Blockbuster blockbuster) {
        this.blockbuster = blockbuster;
    }
}
