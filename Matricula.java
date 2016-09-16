package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Matricula {
    private int numero;
    private String dataMatricula;
    private Curso curso;
    private Aluno aluno;
    
    public Matricula(){
        numero = 0;
        dataMatricula = "";
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDataMatricula() {
        return dataMatricula;
    }
    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public void setAluno(Aluno a){
        this.aluno = a;
    }
    public void setCurso(Curso c){
        this.curso = c;
    }
       
    public void matricular(Aluno a, Curso c){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o numero da matricula");
        this.numero = input.nextInt();
        System.out.println("Informe a data da matricula");
        this.dataMatricula = input.next();
        this.curso = c;
        this.aluno = a;
    }
    
    public void imprimirMatricula(){
        System.out.println("Numero: " + numero);
        System.out.println("Data Matricula: " + dataMatricula);
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("CPF: " + aluno.getCpf());
        System.out.println("Curso: " + curso.getNome());
    }
    
    public String criarString(){
        String texto = numero + ";" + dataMatricula + ";" + aluno.getNome() + ";" + aluno.getCpf()  + ";" + curso.getNome() + "\r\n";
        return texto;
    }

    public String pathMatricula(){
        return "Arquivos\\matricula.txt";
    }
    
    PreparedStatement ps = null;
    public void jButton1ActionPerformed(){
        try {
            ps = Persistencia.conexao().prepareStatement("Insert into"
                    + " matricula (numero,dataMatricula,idCurso,idAluno) values (?,?,?,?)");
            
            ps.setInt(1, numero);
            ps.setString(2, dataMatricula);
            ps.setInt(3, curso.getCodigo());
            ps.setInt(4, aluno.getCodigo());
            
            ps.executeUpdate();
            
            //new JfrmCadastro().setVisible(true);
            //this.dispose();
        }catch(SQLException e){
            System.out.println("Não foi possível executar o comando sql");
        }
    }
}
