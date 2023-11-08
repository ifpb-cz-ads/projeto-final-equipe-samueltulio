package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String turma;
    private Set<Disciplina> disciplinas;

    @Override
    public String toString() {
        return "Aluno{" +
                "turma='" + turma + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }

    public Aluno(String email, String nome, String cpf, String matricula, Date dataNascimento, String turma) {
        super(email, nome, cpf, matricula, dataNascimento);
        this.turma = turma;
        disciplinas = new Set<Disciplina>() {
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
            public Iterator<Disciplina> iterator() {
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
            public boolean add(Disciplina disciplina) {
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
            public boolean addAll(Collection<? extends Disciplina> collection) {
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