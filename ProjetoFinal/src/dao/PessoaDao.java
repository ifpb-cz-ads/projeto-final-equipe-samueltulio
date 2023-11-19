package dao;

import model.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao {
    private File file;

    public PessoaDao() {
        file = new File("Pessoa");
        //Criando a pessoa
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("Falha ao criar uma pessoa");
            }
        }
    }

    //Listar Pessoas
    public List<Pessoa> listarPessoa() {

        if (file.length() > 0) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)
                );
                List<Pessoa> lista = (List<Pessoa>) in.readObject();
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
    private boolean atualizarArquuivo(List<Pessoa> lista){
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

    public boolean addPessoa(Pessoa pessoa){
        List<Pessoa> pessoas = listarPessoa();
        if(pessoas.add(pessoa)){
            atualizarArquuivo(pessoas);
            return true;
        }
        return false;
    }
}
