package model;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private String nome;
    private int nota;
    private String professorId;

    public Disciplina(String nome, int nota, String professorId) {
        this.nome = nome;
        this.nota = nota;
        this.professorId = professorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setProfessor(String professor) {
        this.professorId = professor;
    }

    public String getProfessor() {
        return professorId;
    }

}
