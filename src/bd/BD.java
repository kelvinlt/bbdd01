package bd;

import classes.Alumnes;
import classes.Moduls;
import classes.Notes;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    public static void main(String[] args) {
        Gestio c = new Gestio();
        Statement s = null;
        ResultSet rs = null;

        try (Connection conn = DriverManager.getConnection(c.url, c.usuari, c.pass)) {
            //DatabaseMetaData metadata = conn.getMetaData();
            //System.out.println(metadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE));
            s = conn.createStatement();
            rs = s.executeQuery("select * from alumnes");
            System.out.println("------------------");
            while (rs.next()) {
                System.out.println("dni: " + rs.getString("dni"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("edat: " + rs.getInt("edat"));
                System.out.println("------------------");
            }

            s.close();
        } catch (SQLException i) {
            System.out.println(i);
        }

    }

    public static void mmenu() {
        System.out.println("Menu principal:");
        System.out.println("1-Alta");
        System.out.println("2-Baja");
        System.out.println("3-Modificacion");
        System.out.println("4-Consulta");
    }

    public static void altaAlumne(Connection conn, Alumnes alumne) {
        try {
            String aux = "INSERT INTO Alumnes VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(aux);
            ps.setString(1, alumne.getDni());
            ps.setString(2, alumne.getNom());
            ps.setInt(3, alumne.getEdat());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void altaModuls(Connection conn, Moduls modul) {
        try {
            String aux = "INSERT INTO Moduls VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(aux);
            ps.setInt(1, modul.getCodi());
            ps.setString(2, modul.getNom());
            ps.setInt(3, modul.getCurs());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void altaNotes(Connection conn, Notes nota) {
        try {
            String aux = "INSERT INTO Notes VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(aux);
            ps.setString(1, nota.getDni());
            ps.setInt(2, nota.getCodi());
            ps.setDouble(3, nota.getNota());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
