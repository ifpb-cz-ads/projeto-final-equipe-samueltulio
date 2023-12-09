package model;

import java.io.Serializable;

public class Boletim implements Serializable {
    private String nome;
    private int idDisciplina;
    private double nota;

    public Boletim(String nome, int idDisciplina, double nota) {
        this.nome = nome;
        this.idDisciplina = idDisciplina;
        this.nota = nota;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
