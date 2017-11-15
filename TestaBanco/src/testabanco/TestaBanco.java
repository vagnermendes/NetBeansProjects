/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testabanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vagner Mendes
 */
public class TestaBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       String url = "jdbc:postgresql://85.25.20.216:5432/vagner_svm";
        String usuario = "vagner";
        String senha = "rootroot";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("CONEXAO: "+conexao);
        } catch (ClassNotFoundException e) {
            // Erro caso o driver JDBC não foi instalado
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro caso haja problemas para se conectar ao banco de dados
            e.printStackTrace();
        }
    }
}
