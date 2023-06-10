package tec.bases.dao.daoImplementation;

//Librerias
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tec.bases.dao.GenericDAO;

/**
 * Implementación genérica de la interfaz GenericDAO que proporciona métodos comunes para las operaciones CRUD de entidades.
 * Se espera que las clases concretas que extiendan esta clase implementen los métodos abstractos para convertir resultados de ResultSet a entidades y viceversa.
 * @param <T> el tipo de la entidad
 * @param <ID> el tipo de la identificación de la entidad
 */
public abstract class GenericDAOimplementation<T, ID extends Serializable> implements GenericDAO<T, ID> {

    /**
     * Convierte un ResultSet en una entidad de tipo T.
     * @param _resultSet el ResultSet a convertir
     * @return la entidad convertida
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
     */
    protected abstract T resultSetToEntity(ResultSet _resultSet) throws SQLException;

    /**
     * Convierte un ResultSet en una lista de entidades de tipo T.
     * @param _resultSet el ResultSet a convertir
     * @return la lista de entidades convertidas
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
     */
    protected abstract List<T> resultSetToList(ResultSet _resultSet) throws SQLException;
    
}
