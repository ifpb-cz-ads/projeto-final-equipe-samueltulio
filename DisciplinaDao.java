package dao;

import model.Disciplina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao {
    private File file;

    public DisciplinaDao() {
        file = new File("Disciplina");
        //Criando o arquivo
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("Falha ao criar uma disciplina");
            }
        }
    }

    //Listar Disciplinas
    public List<Disciplina> listarDisciplina() {

        if (file.length() > 0) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)
                );
                List<Disciplina> lista = (List<Disciplina>) in.readObject();
                return lista;
            } catch (IOException exception) {
                System.out.println(exception);
            } catch (ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
        return new ArrayList<>();
    }

    //Atualizar Disiciplinas
    private boolean atualizarDisciplina(List<Disciplina> lista){
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

    public boolean addDisiciplina(Disciplina disciplina){
        List<Disciplina> disciplinas = listarDisciplina();
        if(disciplinas.add(disciplina)){
            atualizarDisciplina(disciplinas);
            return true;
        }
        return false;
    }
}
