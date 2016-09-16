
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persistencia {
    private static Connection conn = null;
    
    private Persistencia(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inscricoes", "root", "");
            
        }catch(ClassNotFoundException e){
            System.out.println("Não foi possivel encontrar o Driver especificado " + e);
        }catch(SQLException ex){
            System.out.println("Não foi possível conectar ao banco de dados" + ex);
        }
    }
    
    public static Connection conexao(){
        if(conn == null)
            new Persistencia();
        return conn;
    }
    
    /*
    PreparedStatement ps = null;
    Result
    */
    
    /*
    PreparedStatement ps = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
        try {
            ps = Persistencia.conexao().prepareStatement("Insert int curso (codigo,nome,cargaHoraria) values (?,?,?)");
            
        }catch(SQLException e){
            System.out.println("Não foi possível executar o comando sql");
        }
    }*/
    
    
}
