package dao;

import model.Pessoa;
import model.Professor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Pedro@gmail.com", "Pedro", "333.333.333-33", "0003", LocalDate.of(1992, 8, 5), 7000.00);
        ProfessorDao pDao = new ProfessorDao();

        System.out.println(pDao.addProfessor(prof1));
        System.out.println(pDao.listarProfessor());
    }
}
