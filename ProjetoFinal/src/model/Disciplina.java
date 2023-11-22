package model;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private int nota;

    public Disciplina(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
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

}
