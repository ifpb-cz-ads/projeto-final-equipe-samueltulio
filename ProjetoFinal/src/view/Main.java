package view;

import daoSQL.ProfessorDao;
import database.ConFactory;
import model.Professor;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal();
            }
        });
//        ProfessorDao pdao = new ProfessorDao();
//        pdao.addProfessor(new Professor("joao@gmail.com", "João", "22222222222", 2, LocalDate.of(2000, 10, 1), 3500.0f));
//        pdao.addProfessor(new Professor("maria@gmail.com", "Maria", "33333333333", 3, LocalDate.of(2000, 11, 1), 6500.0f));

//        System.out.println(pdao.listProfessor());

    }
}
