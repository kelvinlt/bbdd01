package bd;

import classes.Alumnes;
import classes.Moduls;
import classes.Notes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gestio c = new Gestio();
        Statement s = null;
        ResultSet rs = null;
        int opcionBase= 0;
        int opcionObj= 0;

        try (Connection conn = DriverManager.getConnection(c.url, c.usuari, c.pass)) {
            //DatabaseMetaData metadata = conn.getMetaData();
            //System.out.println(metadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE));                  
            while(opcionBase != 5){
                mmenu();
                
            opcionBase = Integer.parseInt(br.readLine());
                switch(opcionBase){
                    case 1:
                        System.out.println("Has escogido: 1-Alta");
                        selectObject();
                        opcionObj = Integer.parseInt(br.readLine());
                        switch(opcionObj){
                            case 1:
                                System.out.println("Alumno nuevo:");
                                System.out.println("DNI?");
                                String dni = br.readLine();
                                System.out.println("Nombre?");
                                String nombre = br.readLine();
                                System.out.println("Edad?");
                                int edad = Integer.parseInt(br.readLine());
                                
                                Alumnes nAlumne = new Alumnes(dni, nombre, edad);
                                altaAlumne(conn, nAlumne);
                                System.out.println("Alumn inscrito!");
                                break;
                            case 2:
                                System.out.println("Modulo nuevo:");
                                System.out.println("Codigo?");
                                int codigo = Integer.parseInt(br.readLine());
                                System.out.println("Nombre?");
                                String nombreModulo = br.readLine();
                                System.out.println("Curso?");
                                int curso = Integer.parseInt(br.readLine());
                                
                                Moduls nModuls = new Moduls(codigo, nombreModulo, curso);
                                altaModuls(conn, nModuls);
                                System.out.println("Modulo inscrito!");
                                break;
                            case 3:
                                System.out.println("Nota nueva:");
                                System.out.println("DNI?");
                                String dniN = br.readLine();
                                System.out.println("Codigo?");
                                int codigoN = Integer.parseInt(br.readLine());
                                System.out.println("Nota?");
                                double nota = Double.parseDouble(br.readLine());
                                
                                Notes nNotes = new Notes(dniN, codigoN, nota);
                                altaNotes(conn, nNotes);
                                System.out.println("Nota inscrita!");
                                break;
                            case 4:
                                System.out.println("Saliendo de alta");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Has escogido: 2-Baja");
                        selectObject();
                        opcionObj = Integer.parseInt(br.readLine());
                        switch(opcionObj){
                            case 1:
                                System.out.println("Escribe el dni del alumen a borrar:");
                                String dni = br.readLine();
                                bajaAlumnes(conn, dni);
                                System.out.println("El alumno ha sido eliminado de la base de datos!");
                                break;
                            case 2:
                                System.out.println("Escribe el codigo del curso a borrar:");
                                int codigo = Integer.parseInt(br.readLine());
                                bajaModul(conn, codigo);
                                System.out.println("El modulo ha sido eliminado de la base de datos!");
                                break;
                            case 3:
                                System.out.println("Para borrar la nota tienes que introducir el dni(alumno) y el codigo(curso)");
                                System.out.println("Escribe el dni del alumen:");
                                String nDni = br.readLine();
                                System.out.println("Escribe el codigo del curso:");
                                int nCodigo = Integer.parseInt(br.readLine());
                                bajaNota(conn, nDni, nCodigo);
                                System.out.println("La nota ha sido eliminada de la base de datos!");
                                break;
                            case 4:
                                System.out.println("Saliendo de baja");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Has escogido: 3-Modificacion");
                        selectObject();
                        break;
                    case 4:
                        System.out.println("Has escogido: 4-Consulta");
                        selectObject();
                        break;
                    case 5:
                        System.out.println("Has escogido: 5-Salir");
                        break;
                }
            }            
            //s = conn.createStatement();
            //rs = s.executeQuery("select * from alumnes");
            //System.out.println("------------------");
            //while (rs.next()) {
            //    System.out.println("dni: " + rs.getString("dni"));
            //   System.out.println("nom: " + rs.getString("nom"));
            //    System.out.println("edat: " + rs.getInt("edat"));
            //    System.out.println("------------------");
            //}
            s.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void mmenu() {
        System.out.println("---------------------------");
        System.out.println("Menu principal:");
        System.out.println("1-Alta");
        System.out.println("2-Baja");
        System.out.println("3-Modificacion");
        System.out.println("4-Consulta");
        System.out.println("5-Salir");
        System.out.println("Escoge una de las opciones");
        System.out.println("---------------------------");
    }
    
    public static void selectObject(){
        System.out.println("---------------------------");
        System.out.println("Seleciona:");
        System.out.println("1-Alumno");
        System.out.println("2-Modulo");
        System.out.println("3-Nota");
        System.out.println("4-Salir");
        System.out.println("---------------------------");
    }

    public static void altaAlumne(Connection conn, Alumnes alumne) {
        try {
            String aux = "INSERT INTO alumnes VALUES(?,?,?)";
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
            String aux = "INSERT INTO moduls VALUES(?,?,?)";
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
            String aux = "INSERT INTO notes VALUES(?,?,?)";
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
    
    public static void bajaAlumnes(Connection conn, String dni){
        try {
            String aux = "DELETE FROM alumnes WHERE dni = ?";
            PreparedStatement ps = conn.prepareStatement(aux);
            ps.setString(1, dni);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void bajaModul(Connection conn, int codi){
        try {
            String aux = "DELETE FROM moduls WHERE codi = ?";
            PreparedStatement ps = conn.prepareStatement(aux);
            ps.setInt(1, codi);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void bajaNota(Connection conn,String dni,int codi){
        try {
            String aux = "DELETE FROM notes WHERE dni=? and codi = ?";
            PreparedStatement ps = conn.prepareStatement(aux);
            ps.setString(1, dni);
            ps.setInt(2, codi);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
