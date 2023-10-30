package model.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Secretario extends Funcionario {

    private String tipoCargo;
    private double horarioTrabalho;

    public Secretario(Endereco endereco, int matricula, int cpf, String nome, String telefone, LocalDate dataAdmissao, double valorSalario, String email, String tipoCargo, double horarioTrabalho) {
        super(endereco, matricula, cpf, nome, telefone, dataAdmissao, valorSalario, email);
        this.tipoCargo = tipoCargo;
        this.horarioTrabalho = horarioTrabalho;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public double getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(double horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    @Override
    public String toString() {
        return "Secretario{" +
                "tipoCargo='" + tipoCargo + '\'' +
                ", horarioTrabalho=" + horarioTrabalho +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Secretario that)) return false;
        return Double.compare(getHorarioTrabalho(), that.getHorarioTrabalho()) == 0 && Objects.equals(getTipoCargo(), that.getTipoCargo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoCargo(), getHorarioTrabalho());
    }
}
