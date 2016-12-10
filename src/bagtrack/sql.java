
package bagtrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Team Twee
 */
public class sql {
    
   
    public static ResultSet select(String query){
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            
            ResultSet results = statement.executeQuery();
            
            return results;
            
            
            //while(results.next()){
            //    System.out.println(results.getString("naam"));
            //    array.add(results.getString(query));
                
            //}
            
            
            
            
            
        }catch(Exception e){
            System.out.println(e);
            System.out.println("NULL GIVEN");
            
        }finally{
            System.out.println("Selection finished");
        }
        return null;
    }
    
    public static void insert(String query){
        
        try{
            Connection con = getConnection();
            PreparedStatement insertStatement = con.prepareStatement(query);
            insertStatement.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Insert Complete");
        }
    }
    public static Connection getConnection(){
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/bagtrack";
            String username = "java";
            String password = "password"; 
            Class.forName(driver); Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e){
            System.out.println(e);
        } 
        System.out.println("NULL returned");
        return null;
    }
}
