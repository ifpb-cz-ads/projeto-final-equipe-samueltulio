package view.components.professor;

import dao.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ListarProfessorTela extends JPanel {

    String[] colNames = {"Email", "Nome", "CPF", "Matricula", "Data de nascimento", "Salário"};
    ProfessorDao pDao;
    List listProfessor;

    public ListarProfessorTela() {
        pDao = new ProfessorDao();
        listProfessor = (List) pDao.listarProfessor();

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        DefaultTableModel tableModelo = new DefaultTableModel(colNames, 0);

        if (listProfessor != null) {
            int size = listProfessor.size();
            for (int i = 0; i < listProfessor.size(); i++) {
                Professor professor = listProfessor.get(i);
                Object[] rowData = {professor.getEmail(), professor.getNome(), professor.getCpf(),
                        professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()};

                tableModelo.addRow(rowData);
            }
        }

        JTable tableProfessores = new JTable(tableModelo);
        JScrollPane jspProfesosres = new JScrollPane(tableProfessores);
        add(jspProfesosres, BorderLayout.CENTER);
    }
}
