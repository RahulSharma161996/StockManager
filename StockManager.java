
package stockmanager;

import java.sql.*;
import javax.swing.JOptionPane;
public class StockManager {

    public static Connection con;
    public static void main(String[] args) {
      try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection("jdbc:sqlserver://VAIO\\RAHUL:50302;databaseName=StockDB;username=sa;password=rahul");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
     
       
        gateway gw = new gateway(null,true);
       gw.setVisible(true);
       gw.setTitle("Stock Manager");


    }
    
    
}
