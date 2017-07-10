package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mark on 10.07.2017.
 */

public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
