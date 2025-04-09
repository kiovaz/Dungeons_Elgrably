/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ramon Souza
 */
public class Conexao {
    
    public static Connection faz_conexao() throws SQLException{
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost/db_players", "root", "banana"); // aqui vcs tem botar a senha que vcs cadastraram no sql de vcs
            
        } catch (ClassNotFoundException e) {
            
            throw new SQLException(e.getException());
            
        }
        
    }
    
}
