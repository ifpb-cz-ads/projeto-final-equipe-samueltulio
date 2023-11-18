package dao;

import model.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    private static File file;

    public AlunoDao() {
        file = new File("Alunos");
        //Criando o arquivo
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("Falha ao criar alunos");
            }
        }
    }

    //Listar Alunos
    public static List<Aluno> listarAlunos() {

        if (file.length() > 0) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)
                );
                List<Aluno> lista = (List<Aluno>) in.readObject();
                return lista;
            } catch (IOException exception) {
                System.out.println(exception);
            } catch (ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
        return new ArrayList<>();
    }

    //Atualizar Arquivo
    private boolean atualizarArquivo(List<Aluno> lista){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)
            );
            out.writeObject(lista);
            return true;
        }catch(IOException exception){
            System.out.println(exception);
        }
        return false;
    }


    public boolean addAluno(Aluno aluno){
        if(buscarPorEmail(aluno.getEmail()) == null){
            List<Aluno> alunos = listarAlunos();
            if(alunos.add(aluno)){
                atualizarArquivo(alunos);
                return true;
            }
        }
        return false;
    }

    public boolean deletarAluno(Aluno aluno){
        List<Aluno> alunos = listarAlunos();
        if(alunos.remove(aluno)){
            atualizarArquivo(alunos);
            return true;
        }
        return false;
    }


    public static Aluno buscarPorEmail(String email){
        List<Aluno> alunos = listarAlunos();
        for(Aluno aluno: alunos){
            if(aluno.getEmail().equals(email)){
                return aluno;
            }
        }
        return null;
    }

    public boolean atualizarAluno(Aluno aluno){
        Aluno aluno1 = buscarPorEmail(aluno.getEmail());
        if(aluno1 != null){
            List<Aluno> alunos = listarAlunos();
            alunos.remove(aluno1);
            alunos.add(aluno);
            atualizarArquivo(alunos);
            return true;
        }
        return false;
    }
}
