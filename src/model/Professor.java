package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Professor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private double salario;

    public Professor(String email, String nome, String cpf, String matricula, Date dataNascimento, double salario) {
        super(email, nome, cpf, matricula, dataNascimento);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "salario=" + salario +
                '}';
    }
}