package factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    public static final String conn = "jdbc:mariadb://localhost:3306/formulario";
    public static final String USUARIO = "root";
    public static final String SENHA = "";
    public static final String DRIVER = "org.mariadb.jdbc.Driver";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(conn, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) {

        closeConnection(conn);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {

        closeConnection(conn, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
