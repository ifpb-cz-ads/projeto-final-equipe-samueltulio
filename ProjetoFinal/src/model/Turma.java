package model;

import java.io.Serializable;
import java.util.*;

public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    private String serie;
    private int anoLetivo;
    private Set<Aluno> alunos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma turma)) return false;
        return anoLetivo == turma.anoLetivo && Objects.equals(serie, turma.serie) && Objects.equals(alunos, turma.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serie, anoLetivo, alunos);
    }

    public Turma(String serie, int anoLetivo) {
        this.serie = serie;
        this.anoLetivo = anoLetivo;
        alunos = new HashSet<Aluno>();
    }
}