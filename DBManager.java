package KFC_SHOPPING_SYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ajit Singh ID: 19070642
 *
 */
public class DBManager {

    private static final String USER_NAME = "kfc"; //DB username
    private static final String PASSWORD = "kfc"; //DB password
    private static final String URL = "jdbc:derby:KFC_DB_Ebd; create=true";  //url of the DB host

    Connection conn;

    public DBManager() {
        establishConnection();
    }
     public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " CONNECTION SUCCESSFUL");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
