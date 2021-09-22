package KFC_SHOPPING_SYSTEM;
import java.sql.Connection;
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
    
    public boolean dropTable(String name) {
        boolean check = false;
        try {
            Statement statement = this.conn.createStatement(); 
            ResultSet resultset = this.conn.getMetaData().getTables(null, null, "%", null);
            while (resultset.next()) {
                String dbName = resultset.getString(3);
                if (dbName.equalsIgnoreCase(name)) {
                    check = true;
                    String sql = "DROP TABLE " + name;
                    statement.executeUpdate(sql);
                    System.out.println("Removing existing DB");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return check;
    }
}