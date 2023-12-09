package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Aluno extends Pessoa implements Serializable {
    private int turma;

    public Aluno(String email, String nome, String cpf, int matricula, LocalDate dataNascimento) {
        super(email, nome, cpf, matricula, String.valueOf(dataNascimento));
        this.turma = turma;
    }

    public Aluno(String nome, int matricula) {
        super(nome, matricula);
    }

//    public Aluno(String nome, int matricula) {
//        super(nome, matricula);
//    }
}