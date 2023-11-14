package dao;


import model.Aluno;
import model.Turma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDao {
    private File file;

    public TurmaDao() {
        file = new File("Turmas");
        //Criando uma turma
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("Falha ao criar uma turma");
            }
        }
    }

    //Listar Turma
    public List<Turma> listarTurma() {

        if (file.length() > 0) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)
                );
                List<Turma> lista = (List<Turma>) in.readObject();
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
    private boolean atualizarArquivo(List<Turma> lista){
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

    public boolean addTurma(Turma turma){
        List<Turma> turmas = listarTurma();
        if(turmas.add(turma)){
            atualizarArquivo(turmas);
            return true;
        }
        return false;
    }

}
