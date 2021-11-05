package poolconexiones.manejo01jdbc.datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Conexion02 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    /* Inicializa el pool de conexiones */
    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        /* Definimos el tamaño inicial del pool de conexiones */
        ds.setInitialSize(5);
        return ds;
    }

    public static Connection getConection() throws SQLException {
        /* En vez de usar  DriverManager se llama al DataSource */
        //return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        return getDataSource().getConnection();
    }

    /* Sobrecarga de métodos */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement stm) throws SQLException {
        stm.close();
    }

    public static void close(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    public static void close(Connection cnn) throws SQLException {
        cnn.close();
    }
}
