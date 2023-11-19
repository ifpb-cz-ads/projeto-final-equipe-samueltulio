package dao;

import model.Aluno;
import model.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao {
    private static File file;

    public ProfessorDao() {
        file = new File("Professor");
        //Criando o professor
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("Falha ao criar o professor");
            }
        }
    }

    //Listar Professor
    public static List<Professor> listarProfessor() {

        if (file.length() > 0) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)
                );
                List<Professor> lista = (List<Professor>) in.readObject();
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
    private boolean atualizarArquivo(List<Professor> lista){
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

    public boolean addProfessor(Professor professor){
        List<Professor> professors = listarProfessor();
        if(professors.add(professor)){
            atualizarArquivo(professors);
            return true;
        }
        return false;
    }

    public boolean deletarProfessor(Professor professor){
        List<Professor> professors = listarProfessor();
        if(professors.remove(professor)){
            atualizarArquivo(professors);
            return true;
        }
        return false;
    }

    public static Professor buscarPorProfessor(String nome){
        List<Professor> professors = listarProfessor();
        for(Professor professor: professors){
            if(professor.getNome().equals(nome)){
                return professor;
            }
        }
        return null;
    }

    public boolean atualizarProfessor(Professor professor){
        Professor professor1 = buscarPorProfessor(professor.getNome());
        if(professor1 != null){
            List<Professor> professors = listarProfessor();
            professors.remove(professor1);
            professors.add(professor);
            atualizarArquivo(professors);
            return true;
        }
        return false;
    }
}
