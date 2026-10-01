/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julia
 */
public class Conexao {
    
     private static final String URL =
            "jdbc:mysql://localhost:3306/MeuControle";

    private static final String USER = "root";

    private static final String PASSWORD = "SUA_SENHA_DO_MYSQL.";

    private Conexao() {
    }

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
