package dao;

import model.Disciplina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao {
    private static File file;

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
    public static List<Disciplina> listarDisciplina() {

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

    //Atualizar Arquivos
    private boolean atualizarArquivo(List<Disciplina> lista){
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

    public boolean addDisciplina(Disciplina disciplina){
        List<Disciplina> disciplinas = listarDisciplina();
        if(disciplinas.add(disciplina)){
            atualizarArquivo(disciplinas);
            return true;
        }
        return false;
    }

    public boolean deletarDisciplina(Disciplina disciplina){
        List<Disciplina> disciplinas = listarDisciplina();
        if(disciplinas.remove(disciplina)){
            atualizarArquivo(disciplinas);
            return true;
        }
        return false;
    }

    public boolean atualizarDisciplina(Disciplina disciplina){
        Disciplina disciplina1 = buscarPorDisciplina(disciplina.getNome());
        if(disciplina1 != null){
            List<Disciplina> disciplinas = listarDisciplina();
            disciplinas.remove(disciplina1);
            disciplinas.add(disciplina);
            atualizarArquivo(disciplinas);
            return true;
        }
        return false;
    }

    public static Disciplina buscarPorDisciplina(String nome){
        List<Disciplina> disciplinas = listarDisciplina();
        for(Disciplina disciplina: disciplinas){
            if(disciplina.getNome().equals(nome)){
                return disciplina;
            }
        }
        return null;
    }
}
