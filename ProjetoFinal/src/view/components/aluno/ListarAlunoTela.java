package view.components.aluno;

import daoSQL.AlunoDao;
import model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListarAlunoTela extends JPanel {
    AlunoDao aDao;
    List<Aluno> listAluno;
    String[] colNames = {"Email", "Nome", "CPF", "Matrícula", "Data de Nascimento"};
    public ListarAlunoTela() throws SQLException, ClassNotFoundException {
        aDao = new AlunoDao();
        listAluno = aDao.listAluno();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel tablePane = new JPanel();
        tablePane.setLayout(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableAluno = new JTable(tableModel);

        // Adiciona os dados da lista à tabela
        for (Aluno aluno : listAluno) {
            tableModel.addRow(new Object[]{aluno.getEmail(), aluno.getNome(), aluno.getCpf(),
                    aluno.getMatricula(), aluno.getDataNascimento()});
        }

        JButton atualizar = new JButton("Atualizar");

        JScrollPane scroll = new JScrollPane(tableAluno);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(tablePane, BorderLayout.CENTER);
        panel.add(atualizar, BorderLayout.SOUTH);

        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }
}
