/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_ac";
    private static final String USER = "root";
    private static final String PASS = "";
    public static Connection getConnection()throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(URL, USER, PASS);
        return conexao;
    }
    public static void classConnection(Connection conn) {
     try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada com sucesso");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados" + e);
        }
    }

    
}
