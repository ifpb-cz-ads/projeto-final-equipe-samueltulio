package view.components.professor;

import dao.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarProfessorTela extends JPanel {

    String[] colNames = {"Email", "Nome", "CPF", "Matricula", "Data de nascimento", "Salário"};
    ProfessorDao pDao;
    List<Professor> listProfessor;

    public ListarProfessorTela() {
        pDao = new ProfessorDao();
        listProfessor = pDao.listarProfessor();

        setLayout(new SpringLayout());

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableProfessor = new JTable(tableModel);

        // Adiciona os dados da lista à tabela
        for (Professor professor : listProfessor) {
            tableModel.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
                    professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
        }

        JScrollPane scroll = new JScrollPane(tableProfessor);

        // Adiciona o JScrollPane ao JPanel
        add(scroll, BorderLayout.CENTER);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Listar Professores");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(new ListarProfessorTela());
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
}
