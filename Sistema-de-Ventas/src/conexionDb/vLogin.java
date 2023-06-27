/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionDb;

import Interfaces.Login;
import Interfaces.menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class vLogin {


    
    public void validaUsuario(JTextField usuario, JPasswordField contrasenia){
    
        try {
            
            
            ResultSet rs=null;           
            PreparedStatement ps= null;
            
            conexionDb.Conexion objetoConexion = new conexionDb.Conexion();
            
            String consulta="select * from Usuarios where Usuarios.ingresoUsuario =(?) and Usuarios.ingresoContrasenia=(?);";
            ps=objetoConexion.estableceConexion().prepareStatement(consulta);
            
            String contra = String.valueOf(contrasenia.getPassword());
            
            ps.setString(1, usuario.getText());
            ps.setString(2,contra);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null,"El Usuario es Correcto");
                Login objetoMenu = new Login();
                objetoMenu.setVisible(true);
               
                //llamanos jframe menu
                menu men=new menu();
                men.setVisible(true);
                
                   
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"El Usuario es INCORRECTO, VUELVA A INTENTAR");
               
            }
            
      
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
            
            
        }
    }    
}

