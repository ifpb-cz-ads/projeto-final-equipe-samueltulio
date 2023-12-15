package model;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private String nome;
    private int idDisciplina;

    public Disciplina(int idDisciplina, String nome) {
        this.nome = nome;
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
}
