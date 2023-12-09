package view;

import daoSQL.AlunoDao;
import daoSQL.DisciplinaDao;
import daoSQL.ProfessorDao;
import daoSQL.TurmaDao;
import database.ConFactory;
import model.Aluno;
import model.Disciplina;
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
//        daoA.addAluno(new Aluno("Jose@gmail.com", "José", "33333333333", 3, "2002-10-13"));
//        daoA.deleteAluno(3);
//        daoA.matricularDisciplina(1, 2, 100);
        System.out.println(daoT.alunosTurma(1));
    }
}
