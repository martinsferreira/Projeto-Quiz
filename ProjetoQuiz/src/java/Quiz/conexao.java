/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;
import java.sql.*;

/**
 *
 * @author nunez aldin
 */
public class conexao {
    public static Connection abriConexao()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url ="";
            url+="jdbc:mysql://127.0.0.1/quizranking?";
            url += "user=root&password=";
            con = DriverManager.getConnection(url);
            System.out.println("Conexão aberta.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    public static void fecharConexao(Connection con)
    {
        
        try
        {
            con.close();
            System.out.println("conexao fechada");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
