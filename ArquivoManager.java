package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoManager {

    public void writeArquivo(String texto, String path) throws IOException {
        File file = new File(path);

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(texto);
        fileWriter.flush();
        fileWriter.close();

    }

    public void readArquivo(String path) {
        try {
            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Mensagem de erro.");
        }
    }

    public static ArrayList<Curso> preencherCurso(ArrayList<Curso> curso, String path) {
        try {

            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            int temp = 0;
            
            
            while (linha != null) {
                Curso c = new Curso();
                String[] vet = linha.split(";");
                c.setCodigo(Integer.parseInt(vet[0]));
                c.setNome(vet[1]);
                c.setCargaHoraria(Integer.parseInt(vet[2]));
                curso.add(c);
                temp++;
                linha = bufferedReader.readLine();               
            }
            return curso;
        } catch (IOException e) {
            System.out.println("Mensagem de erro.\n" + e);
            //return curso;
        }
        return null;
    }
    
    public static  ArrayList<Aluno> preencherAluno(ArrayList<Aluno> aluno, String path) {
        try {

            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            int temp = 0;
            
            
            while (linha != null) {
                Aluno a = new Aluno();
                String[] vet = linha.split(";");
                a.setCodigo(Integer.parseInt(vet[0]));
                a.setNome(vet[1]);
                a.setCpf(vet[2]);
                aluno.add(a);
                temp++;
                linha = bufferedReader.readLine();               
            }
            return aluno;
        } catch (IOException e) {
            System.out.println("Mensagem de erro.\n" + e);
        }
        return null;
    }
    
    public static  ArrayList<Matricula> preencherMatricula(ArrayList<Matricula> matricula, String path, ArrayList<Aluno> aluno, ArrayList<Curso> curso) {
        try {

            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            int temp = 0;
            
            
            while (linha != null) {
                Matricula m = new Matricula();
                Aluno a = new Aluno();
                Curso c = new Curso();
                
                String[] vet = linha.split(";");
                m.setNumero(Integer.parseInt(vet[0]));
                m.setDataMatricula(vet[1]);
                
                int codigo = 0;
                for(int i=0;i < aluno.size();i++){
                    if(aluno.get(i).getCpf().equals(vet[3])){
                        codigo = aluno.get(i).getCodigo();
                        break;
                    }
                }
                a.setCodigo(codigo);
                a.setNome(vet[2]);
                a.setCpf(vet[3]);
                m.setAluno(a);
                
                codigo = 0;
                int cargaHr = 0;
                for(int i=0;i < curso.size();i++){
                    if(curso.get(i).getNome().equals(vet[4])){
                        codigo = curso.get(i).getCodigo();
                        cargaHr = curso.get(i).getCargaHoraria();
                        break;
                    }
                }
                c.setCodigo(codigo);
                c.setNome(vet[4]);
                c.setCargaHoraria(cargaHr);
                m.setCurso(c);               
              
                matricula.add(m);
                
                temp++;
                linha = bufferedReader.readLine();               
            }
            return matricula;
        } catch (IOException e) {
            System.out.println("Mensagem de erro.\n" + e);
        }
        return null;
    }
}