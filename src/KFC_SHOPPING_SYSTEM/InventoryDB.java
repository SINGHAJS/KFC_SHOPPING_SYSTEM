package KFC_SHOPPING_SYSTEM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class InventoryDB {

    private final DBManager db;
    private static final String URL = "jdbc:derby:KFC_Inventory;create=true";
    private static final String KFC_MENU = "./resources/KFC_MENU.txt";
    private static ArrayList<String> list = new ArrayList<>();
    private static final String tableName = "INVENTORY";

    public InventoryDB() {//connects to database
        this.db = new DBManager(URL);
    }

    public void createItemsTable() {//creates items table if there is no existing table
        try {
            if (!db.checkTable(tableName)) {
                db.getStatement().executeUpdate("CREATE TABLE " + tableName + "(ID INT, "
                        + "CATEGORY VARCHAR(50),ITEM_NAME VARCHAR(50), ITEM_PRICE DOUBLE, AVAILABILITY BOOLEAN)");
                fillTable();
            }
            db.getStatement().close();
        } catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void fillTable() {//fills table with data from file using file reader
        int count = 1;
        try {
            list = File_IO.readFile(KFC_MENU);
            for (String o : list) {
                String[] itemInfo = o.split(",");
                Double price = Double.parseDouble(itemInfo[2]);
                String sqlInsert = "INSERT INTO " + tableName + " VALUES (?,?,?,?,?)";
                PreparedStatement ps = this.db.getConnection().prepareStatement(sqlInsert);
                ps.setInt(1, count ++);
                ps.setString(2, itemInfo[0]);
                ps.setString(3, itemInfo[1]);
                ps.setDouble(4, price);
                ps.setBoolean(5,true);
                ps.executeUpdate();
            }
            System.out.println("Table Filled");
        } catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Vector getCategory() {//returns a vector of category columns values (including duplicates)
        ResultSet rs = null;
        Vector<String> category = new Vector<String>();
        try {
            String sqlQuery = "SELECT CATEGORY FROM " + tableName;
            rs = db.getStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                category.add(rs.getString("CATEGORY"));
            }
        } catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return category;
    }

    public Vector getItems(String categoryName) {//using the categroy input selects the items with same category and returns the list of items
        ResultSet rs = null;
        Vector<ProductItems> items = new Vector<ProductItems>();
        try {
            String sqlQuery = "Select ITEM_NAME, ITEM_PRICE from " + tableName + " where (CATEGORY='" + categoryName +  "') AND (AVAILABILITY = true)";
            rs = db.getStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                String iname = rs.getString("ITEM_NAME");
                double price = rs.getDouble("ITEM_PRICE");
                items.add(new ProductItems(categoryName, iname, price,true));
            }
        } catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return items;
    }
    public void editItem(int id, boolean b){//changes the availability of item using inputs
         try {
                String sqlInsert = "UPDATE " + tableName + " SET AVAILABILITY = ? WHERE ID = ?";
                PreparedStatement ps = this.db.getConnection().prepareStatement(sqlInsert);
                ps.setBoolean(1,b);
                ps.setInt(2, id);
                ps.executeUpdate();
        }catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public Vector getEntireTable(){ //returns a vector of entire table
        ResultSet rs = null;
        Vector<ProductItems> allItems = new Vector<ProductItems>();
         try {
            String sqlQuery = "Select ITEM_NAME, ITEM_PRICE , CATEGORY, AVAILABILITY from " + tableName;
            rs = db.getStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                String iname = rs.getString("ITEM_NAME");
                double price = rs.getDouble("ITEM_PRICE");
                String category = rs.getString("CATEGORY");
                boolean getAvailable = rs.getBoolean("AVAILABILITY");
                allItems.add(new ProductItems(category, iname, price,getAvailable));
            }
        } catch (SQLException e) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return allItems;
    }
}
