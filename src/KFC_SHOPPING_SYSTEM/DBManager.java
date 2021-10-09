package KFC_SHOPPING_SYSTEM;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 */
public class DBManager {

    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private Connection conn;
    private Statement statement;

    /**
     *
     * @return connection
     */
    public Connection getConnection() {
        return this.conn;
    }

    public Statement getStatement() {
        try {
            this.statement = this.conn.createStatement();
        } catch (SQLException e) {
            System.out.println("hi");
        }
        return this.statement;
    }

    /**
     *
     * @param URL
     */
    public DBManager(String URL) {
        this.establishConnection(URL);
    }

    /**
     *
     * @param URL establish connection given the URL address
     */
    private void establishConnection(String URL) {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("[DB CONNECTION SUCCESSFUL]");
            } catch (SQLException ex) {
                System.err.println("[ERROR: " + ex + "]");
            }
        }
    }

    /**
     * close connection
     */
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("[ERROR: " + ex + "]");
            }
        }
    }

    /**
     *
     * @param tableName
     * @return flag
     *
     */
    public boolean checkTable(String tableName) {
        boolean flag = false;
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String tName = rsDBMeta.getString("TABLE_NAME");
                if (tName.compareToIgnoreCase(tableName) == 0) {
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
            System.err.println("[ERROR: " + ex + "]");
        }
        return flag;
    }

    /**
     *
     * @param name check if a table exists in the database if the table exists,
     * remove the table from the database
     */
    public void dropTable(String name) {
        try {
            Statement statement = this.conn.createStatement();
            ResultSet resultset = this.conn.getMetaData().getTables(null, null, "%", null);
            while (resultset.next()) {
                String dbName = resultset.getString(3);
                if (dbName.equalsIgnoreCase(name)) {
                    String sql = "DROP TABLE " + name;
                    statement.executeUpdate(sql);
                    System.out.println("[REMOVING EXISTING " + name + " TABLE]");
                }
            }
        } catch (SQLException ex) {
            System.err.println("[ERROR: " + ex + "]");
        }
    }

    /**
     * 
     * @param tableName 
     */
    public void createInventoryTable(String tableName) {
        try {
            statement = this.conn.createStatement();
            String sqlCreate = "CREATE TABLE " + tableName + "(ITEM_ID INT, CATEGORY VARCHAR(30), ITEM_NAME VARCHAR(30), PRICE FLOAT)";
            statement.executeUpdate(sqlCreate);

        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
            
}
