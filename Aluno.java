package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Aluno {
    private int codigo;
    private String nome;
    private String cpf;
    
    public Aluno(){
        nome = "";
        cpf = "";
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void cadastrarAluno(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o código do Aluno");
        this.codigo = input.nextInt();
        System.out.println("Informe o nome do Aluno");
        this.nome = input.next();
        System.out.println("Informe cpf");
        this.cpf = input.next();
    }
    
    public void imprimirAluno(){
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("CPF " + cpf);
    }
    
    public String criarString(){
        String texto = codigo + ";" + nome + ";" + cpf + "\r\n";
        return texto;
    }
    
    public String pathAluno(){
        return "Arquivos\\aluno.txt";
    }
    
    PreparedStatement ps = null;
    public void jButton1ActionPerformed(){
        try {
            ps = Persistencia.conexao().prepareStatement("Insert into"
                    + " aluno (codigo,nome,cpf) values (?,?,?)");
            
            ps.setInt(1, codigo);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            
            ps.executeUpdate();
            
            //new JfrmCadastro().setVisible(true);
            //this.dispose();
        }catch(SQLException e){
            System.out.println("Não foi possível executar o comando sql");
        }
    }
}
