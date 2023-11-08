package dao;

import model.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao {
    private File file;

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
    public List<Professor> listarProfessor() {

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

    //Atualizar professor
    private boolean atualizarProfessor(List<Professor> lista){
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
            atualizarProfessor(professors);
            return true;
        }
        return false;
    }
}
