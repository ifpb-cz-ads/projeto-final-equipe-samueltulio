package dao;


import model.Aluno;
import model.Disciplina;
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
    private boolean atualizarArquivo(List<Turma> lista) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)
            );
            out.writeObject(lista);
            return true;
        } catch (IOException exception) {
            System.out.println(exception);
        }
        return false;
    }

    public boolean addTurma(Turma turma) {
        List<Turma> turmas = listarTurma();
        if (turmas.add(turma)) {
            atualizarArquivo(turmas);
            return true;
        }
        return false;
    }

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
        private boolean atualizarArquivo(List<Aluno> lista) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)
                );
                out.writeObject(lista);
                return true;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            return false;
        }


        public boolean addAluno(Aluno aluno) {
            if (buscarPorEmail(aluno.getEmail()) == null) {
                List<Aluno> alunos = listarAlunos();
                if (alunos.add(aluno)) {
                    atualizarArquivo(alunos);
                    return true;
                }
            }
            return false;
        }

        public boolean deletarAluno(Aluno aluno) {
            List<Aluno> alunos = listarAlunos();
            if (alunos.remove(aluno)) {
                atualizarArquivo(alunos);
                return true;
            }
            return false;
        }


        public static Aluno buscarPorEmail(String email) {
            List<Aluno> alunos = listarAlunos();
            for (Aluno aluno : alunos) {
                if (aluno.getEmail().equals(email)) {
                    return aluno;
                }
            }
            return null;
        }

        public boolean atualizarAluno(Aluno aluno) {
            Aluno aluno1 = buscarPorEmail(aluno.getEmail());
            if (aluno1 != null) {
                List<Aluno> alunos = listarAlunos();
                alunos.remove(aluno1);
                alunos.add(aluno);
                atualizarArquivo(alunos);
                return true;
            }
            return false;
        }

    }

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
}
