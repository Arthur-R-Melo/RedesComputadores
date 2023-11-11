/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arthu
 */
public class FactoryPostgres {
    private static Connection c;
    
    public static Connection getConexaoPostgres() {
        if(c == null) {
            try {
                c = DriverManager.getConnection("jdbc:postgresql://10.90.24.54:5432/aula", "postgres", "postgres");
            } catch (SQLException ex) {
                System.err.println("Houve um erro na conexão!");
                return null;
            }
        }
        return c;
    }
}