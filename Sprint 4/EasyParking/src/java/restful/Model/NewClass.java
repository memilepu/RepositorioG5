/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.service.ClienteService;

/**
 *
 * @author MI DELL
 */
public class NewClass {

    public static void main(String[] args) {
      ClienteService service = new ClienteService();
      
      service.getUsuarios();
    }

   
 
    
}
