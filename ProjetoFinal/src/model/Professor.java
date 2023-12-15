package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Professor extends Pessoa implements Serializable {
    private double salario;

    public Professor(String email, String nome, String cpf, int matricula, LocalDate dataNascimento, double salario) {
        super(email, nome, cpf, matricula, String.valueOf(dataNascimento));
        this.salario = salario;
    }

    public float getSalario() {
        return (float) salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}