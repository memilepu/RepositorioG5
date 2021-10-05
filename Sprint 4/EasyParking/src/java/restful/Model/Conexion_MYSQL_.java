
package restful.Model;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion_MYSQL_ {
    
    private Connection con;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost:3306";
    private static final String DB = "parqueadero";
    private static final String URL = "jdbc:mysql://" + HOST + "/" + DB;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "joses0207";
    
    public Conexion_MYSQL_() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueadero", "root", "joses0207");
            this.con=con;
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }

    public Connection getCon() {
        return con;
    }

    public void desconectar() {
        try {
            if (con != null) {
                con.close();
                System.out.println("La desconexion fue exitosa");
            }

        } catch (Exception excepcion) {
            System.out.println("Ha ocurrido un error al desconectar  " + excepcion.getMessage());
        }
    }
    
}
