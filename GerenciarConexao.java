import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GerenciarConexao {

    
    private static Connection conexao; 



    public static Connection pegarConexao() throws ClassNotFoundException, SQLException{

        String url = "jdbc:mysql://127.0.0.1/dblocadora";
        String usuario = "root"; 
        String senha = ""; 

    
        Class.forName("com.mysql.cj.jdbc.Driver");

        conexao = DriverManager.getConnection(url, usuario, senha);


        return conexao;


    }

    
}