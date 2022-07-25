/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Modelo extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;

    
    public void crearTabla(String Consulta){
        Connection conexion =getConnection();
        try {
            ps=conexion.prepareStatement(Consulta);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Error al insertar tabla "+ex);
        }
       
        
    }
    int contador=0;
    public void insertarDatos(String insertar){
        Connection conexion =getConnection();
        try {
            ps=conexion.prepareStatement(insertar);
            ps.executeUpdate();
            conexion.close();
        }catch(MySQLSyntaxErrorException e){
            System.out.println("Los datos son demasiados para su servidor");
        } catch (Exception ex) {
            System.err.println("Error al insertar tabla "+ex);
        }
       
       
        
    }
    
}
