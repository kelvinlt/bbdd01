package bd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    public static void main(String[] args) {
        Constants c = new Constants();
        Statement s=null;
        ResultSet rs=null;  
        
        try (Connection conn = DriverManager.getConnection(c.url, c.usuari, c.pass)){
            //DatabaseMetaData metadata = conn.getMetaData();
            //System.out.println(metadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE));
            s = conn.createStatement();
            rs = s.executeQuery("select * from alumnes");
            System.out.println("------------------");
            while(rs.next()){
                System.out.println("dni: "+rs.getString("dni"));
                System.out.println("nom: "+rs.getString("nom"));
                System.out.println("edat: "+rs.getInt("edat"));
                System.out.println("------------------");
            }
            
            s.close();
        } catch (SQLException i) {
            System.out.println(i);
        }
        
    }
    
}
