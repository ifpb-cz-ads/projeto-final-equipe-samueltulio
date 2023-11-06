package model.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Professor extends Pessoa {
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
}
