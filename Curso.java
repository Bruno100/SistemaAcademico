package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Bruno
 */
public class Curso {
    private int codigo;
    private String nome;
    private int cargaHoraria;
    
    public Curso(){
        codigo = 0;
        nome = "";
        cargaHoraria = 0;
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
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public void cadastrarCurso(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o código do Curso");
        this.codigo = input.nextInt();
        System.out.println("Informe nome do curso");
        this.nome = input.next();
        System.out.println("Informe a Carga Horária do curso");
        this.cargaHoraria = input.nextInt();
    }
    
    public String criarString(){
        String texto = codigo + ";" + nome + ";" + cargaHoraria + "\r\n";
        return texto;
    }
    
    public String pathCurso(){
        return "Arquivos\\curso.txt";
    }
    
    public void imprimirCurso(){
        System.out.println("Código: " + codigo);
        System.out.println("Curso: " + nome);
        System.out.println("Carga Horária " + cargaHoraria);
    }
    
    
    PreparedStatement ps = null;
    public void jButton1ActionPerformed(){
        try {
            ps = Persistencia.conexao().prepareStatement("Insert into"
                    + " curso (codigo,nome,cargaHoraria) values (?,?,?)");
            
            ps.setInt(1, codigo);
            ps.setString(2, nome);
            ps.setInt(3, cargaHoraria);
            
            ps.executeUpdate();
            
            //new JfrmCadastro().setVisible(true);
            //this.dispose();
        }catch(SQLException e){
            System.out.println("Não foi possível executar o comando sql");
        }
    }
    /*
    PreparedStatement ps2 = null;
    ResultSet rs = null;
    public void carregarDados(){
        try {
            ps2 = Persistencia.conexao().prepareStatement("Select")
        }
    }*/
    
    
}
