package view;

import daoSQL.ProfessorDao;
import daoSQL.TurmaDao;
import database.ConFactory;
import model.Professor;
import model.Turma;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TelaPrincipal();
//            }
//        });

        TurmaDao daoT = new TurmaDao();
//        daoT.addTurma(new Turma(2, "6° Ano B", 2023));
//        daoT.deleteTurma(2);

        System.out.println(daoT.listTurma());

//        ProfessorDao daoP = new ProfessorDao();
//        System.out.println(daoP.listProfessor());


    }
}
