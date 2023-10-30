package model;

import java.time.LocalDate;
import java.util.Objects;

public class Professor extends Funcionario {

    private String areaEnsino;
    private String titulacao;

    public Professor(Endereco endereco, int matricula, int cpf, String nome, String telefone, LocalDate dataAdmissao, double valorSalario, String email, String areaEnsino, String titulacao) {
        super(endereco, matricula, cpf, nome, telefone, dataAdmissao, valorSalario, email);
        this.areaEnsino = areaEnsino;
        this.titulacao = titulacao;
    }

    public String getAreaEnsino() {
        return areaEnsino;
    }

    public void setAreaEnsino(String areaEnsino) {
        this.areaEnsino = areaEnsino;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }


    @Override
    public String toString() {
        return "Professor{" +
                "areaEnsino='" + areaEnsino + '\'' +
                ", titulacao='" + titulacao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor professor)) return false;
        return Objects.equals(getAreaEnsino(), professor.getAreaEnsino()) && Objects.equals(getTitulacao(), professor.getTitulacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAreaEnsino(), getTitulacao());
    }
}
