/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String url="jdbc:mysql://localhost:3306/excel?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="123123";
    
    public Connection getConnection(){
        Connection conexion=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion =(Connection)DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Error conexion a BD "+e);
        }
        return conexion;
    }
}
