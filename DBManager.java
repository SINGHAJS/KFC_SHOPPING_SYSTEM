package KFC_SHOPPING_SYSTEM;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
     public Connection getConnection() {
        return this.conn;
    }

    public DBManager(String URL){
        establishConnection(URL);
    }
    
    private void establishConnection(String URL){
        if(this.conn == null){
            try {
                    conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
                
            } catch (SQLException e){
                System.out.println("hi");
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
                //add error message
            }
        }
    }
    
    public void closeConnections(){
        if(conn!= null){
            try{
                conn.close();
            }catch (SQLException ex){
                //display error
            }
        }
    }
    public boolean checkTable(String tableName){
        boolean flag = false;
        try{
            DatabaseMetaData dbmd = this.conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null,null,null,null);
            while(rsDBMeta.next()){
                String tName = rsDBMeta.getString("TABLE_NAME");
                if(tName.compareToIgnoreCase(tableName) == 0){
                    flag = true;
                }
            }
            if (rsDBMeta != null){
                rsDBMeta.close();
            }
        }catch(SQLException e){
        }
        return flag;
    }
    
    public void dropTable(String name) {
        try {
            Statement statement = this.conn.createStatement(); 
            ResultSet resultset = this.conn.getMetaData().getTables(null, null, "%", null);
            while (resultset.next()) {
                String dbName = resultset.getString(3);
                if (dbName.equalsIgnoreCase(name)){
                    String sql = "DROP TABLE " + name;
                    statement.executeUpdate(sql);
                    System.out.println("[REMOVING EXISTING " + name +" TABLE]");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
        
    public void createCustomerTable(String tableName) {
        String createCustomerTable = "CREATE  TABLE " + tableName
                + " (USERNAME VARCHAR(50) NOT NULL, PASSWORD VARCHAR(50) NOT NULL, "
                + "EMAIL VARCHAR(50), ADDRESS VARCHAR(100) NOT NULL)";
        String insertCustomerTableValues = "INSERT INTO " + tableName
                + " VALUES ('pdc', 'Password12345', 'pdc@pdcProjects.com', "
                + "'123 Street Auckland New Zealand')";

        try {
            dropTable(tableName);
            this.statement = getConnection().createStatement();
            statement.executeUpdate(createCustomerTable);
            statement.executeUpdate(insertCustomerTableValues);
            System.out.println("[NEW " + tableName + " TABLE CREATED]");
        } catch (SQLException ex) {
            System.out.println("[ERROR: " + ex + "]");
        }
    }
}