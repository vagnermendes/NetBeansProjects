/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vagner Mendes
 */
public class Conexao {

    private Connection conexao;
    private String Consutlar;
    public ResultSet rs = null;
    private Statement stm = null;
/*
    private static String url       = "jdbc:postgresql://85.25.18.201:5432/personal_altaperformancetunning";
    private static String usuario   = "personal_altaperformancetunning";
    private static String senha     = "acb17100291151100tony";
 */
    private static String url       = "jdbc:postgresql://localhost:5432/altaperformancetunning";
    private static String usuario   = "postgres";
    private static String senha     = "root";

    public Conexao(){
        try {
            Class.forName("org.postgresql.Driver");
            conexao = (Connection) DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        if(conexao!=null){
            System.out.println("Conectou");
        }else{
            System.out.println("Falhou Conexao");
        }s
        */
    }

    public ResultSet Query(String sql){
        try {
            stm = (Statement) conexao.createStatement();
            rs = (ResultSet) stm.executeQuery(sql);           
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }

    public void Save(String sql){
        try {
            PreparedStatement prep = (PreparedStatement) conexao.prepareStatement(sql);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Delete(String sql){
        try {
            PreparedStatement prep = (PreparedStatement) conexao.prepareStatement(sql);
            prep.execute();
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Close(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int SaveGetID(String sql){
        int id = 0 ;
        try {
            PreparedStatement prep = (PreparedStatement) conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prep.executeUpdate();
            ResultSet keys = prep.getGeneratedKeys();
            keys.next();
            id = keys.getInt(1);
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}