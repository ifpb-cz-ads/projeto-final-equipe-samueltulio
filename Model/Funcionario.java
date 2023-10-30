package model.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {
    private Endereco endereco;
    private int matricula;
    private int cpf;
    private String nome;
    private String telefone;
    private LocalDate dataAdmissao;
    private double valorSalario;
    private String email;

    public Funcionario(Endereco endereco, int matricula, int cpf, String nome, String telefone, LocalDate dataAdmissao, double valorSalario, String email) {
        this.endereco = endereco;
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.valorSalario = valorSalario;
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(double valorSalario) {
        this.valorSalario = valorSalario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "endereco=" + endereco +
                ", matricula=" + matricula +
                ", cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", valorSalario=" + valorSalario +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        return getMatricula() == that.getMatricula() && getCpf() == that.getCpf() && Double.compare(getValorSalario(), that.getValorSalario()) == 0 && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getTelefone(), that.getTelefone()) && Objects.equals(getDataAdmissao(), that.getDataAdmissao()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEndereco(), getMatricula(), getCpf(), getNome(), getTelefone(), getDataAdmissao(), getValorSalario(), getEmail());
    }
}
