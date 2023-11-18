package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    private String serie;
    private int anoLetivo;
    private Set<Aluno> alunos;

    @Override
    public String toString() {
        return "Turma{" +
                "serie='" + serie + '\'' +
                ", anoLetivo=" + anoLetivo +
                ", alunos=" + alunos +
                '}';
    }


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


        alunos = new Set<Aluno>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Aluno> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Aluno aluno) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Aluno> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }


        };
    }

}