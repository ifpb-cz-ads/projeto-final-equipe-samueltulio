package dao;

import model.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    private File file;

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
    public List<Aluno> listarAlunos() {

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

    //Atualizar Alunos
    private boolean atualizarAlunos(List<Aluno> lista){
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

    public boolean addUsuario(Aluno aluno){
        List<Aluno> alunos = listarAlunos();
        if(alunos.add(aluno)){
            atualizarAlunos(alunos);
            return true;
        }
        return false;
    }
}