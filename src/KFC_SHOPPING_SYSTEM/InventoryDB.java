package KFC_SHOPPING_SYSTEM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author singh
 */
public class InventoryDB {
    private final DBManager db;
    private static final String URL = "jdbc:derby:KFC_Inventory;create=true";
    private static final String KFC_MENU = "./resources/KFC_MENU.txt";
    private static ArrayList<String> list = new ArrayList<>();
    private static final String TableName = "INVENTORY";

    public InventoryDB(){
        this.db = new DBManager(URL);
    }
    
    public void createItemsTable(){
        try {
            
            if (!db.checkTable(TableName)){
                db.getStatement().executeUpdate("CREATE TABLE " + TableName + "(ID INT, "
                        + "CATEGORY VARCHAR(50),ITEM_NAME VARCHAR(50), ITEM_PRICE FLOAT)");
            }
            db.getStatement().close();
        } catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void fillTable(){
        int count = 1;
        try{
            
            list = File_IO.readFile(KFC_MENU);
            for(String o: list){
                String[] itemInfo = o.split(",");
                Double price = Double.parseDouble(itemInfo[2]);
                String sqlInsert = "INSERT INTO " + TableName + " VALUES ("+ count++ + ",'"+ itemInfo[0]+ "','" + itemInfo[1]+ "', "+price+")";
                System.out.println(sqlInsert);
               db.getStatement().executeUpdate(sqlInsert);
            }
        }catch(SQLException e){
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Vector getCategory(){
        ResultSet rs = null;
        Vector<String> v = null;
        try{
           // db.getStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlQuery = "SELECT CATEGORY";
            //rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while(rs.next()){
                v.add(rs.getString("CATEGORY"));
            }
        }catch(SQLException e){
            System.out.println("get cat");
        }
        return v;
    }
}
