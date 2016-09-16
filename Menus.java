package classes;
/**
 *
 * @author Bruno
 */
public class Menus {
    public static void menuGeral(){
        System.out.println(":::: Menu Geral ::::");
        System.out.println("1 - Cadastrar Curso");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Matricular");
        System.out.println("4 - Imprimir Matriculas");
        System.out.println("5 - Imprimir Cursos");
        System.out.println("6 - Imprimir Alunos");
        System.out.println("20 - Ler Curso");
        System.out.println("21 - Ler Aluno");
        System.out.println("22 - Ler Matricula");
        System.out.println("30 - File to List Curso");
        System.out.println("31 - File to List Aluno");
        System.out.println("32 - File to List Matricula");
        System.out.println("40 - Persistir Dados");
        System.out.println("0 - Sair");
    }
    public static void menuMatricula(){
        System.out.println(":::: Menu Matricula ::::");
        System.out.println("1 - Matricular");
        System.out.println("0 - Sair");
    }
    public static void menuCurso(){
        System.out.println(":::: Menu Curso ::::");
        System.out.println("1 - Cadastrar Curso");
        System.out.println("0 - Sair");
    }
    public static void menuAluno(){
        System.out.println(":::: Menu Aluno ::::");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("0 - Sair");
    }
}
