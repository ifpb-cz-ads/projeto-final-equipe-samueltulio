package model.Model;

import model.Endereco;

import java.time.LocalDate;
import java.util.Objects;

public class Aluno {

    private int matricula;
    private int cpf;
    private String nome;
    private String sexo;
    private Endereco endereco;
    private String telefone;
    private LocalDate dataNascimento;
    private String nomeResponsavel;

    public Aluno(int matricula, int cpf, String nome, String sexo, Endereco endereco, String telefone, LocalDate dataNascimento, String nomeResponsavel) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.nomeResponsavel = nomeResponsavel;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", endereco=" + endereco +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return getMatricula() == aluno.getMatricula() && getCpf() == aluno.getCpf() && Objects.equals(getNome(), aluno.getNome()) && Objects.equals(getSexo(), aluno.getSexo()) && Objects.equals(getEndereco(), aluno.getEndereco()) && Objects.equals(getTelefone(), aluno.getTelefone()) && Objects.equals(getDataNascimento(), aluno.getDataNascimento()) && Objects.equals(getNomeResponsavel(), aluno.getNomeResponsavel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula(), getCpf(), getNome(), getSexo(), getEndereco(), getTelefone(), getDataNascimento(), getNomeResponsavel());
    }
}
