package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Aluno extends Pessoa implements Serializable {
    private String turma;
    private Set<Disciplina> disciplinas;

    @Override
    public String toString() {
        return "Aluno{" +
                "turma='" + turma + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }

    public Aluno(String email, String nome, String cpf, int matricula, String dataNascimento, String turma) {
        super(email, nome, cpf, matricula, dataNascimento);
        this.turma = turma;
        disciplinas = new HashSet<Disciplina>();
    }



//    public boolean addDisciplina(String nome, int nota, String professorId) {
//        if(disciplinas.add(new Disciplina(nome, nota, professorId))) {
//            return true;
//        } else return false;
//    }
}