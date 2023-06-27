
package conexionDb;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class Conexion {
   Connection conectar;
    
        String usuario="root";
        String contrasenia="Paramore33";
        String bd="sistema-de-ventas";
        String ip="localhost";
        String puerto="3306";
    
        String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
   
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null,"Conexion exitosas a la Base de DATOS");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Problemas en la conexion"+ e.toString());
            
        }
        return conectar;
        
    }
}
    