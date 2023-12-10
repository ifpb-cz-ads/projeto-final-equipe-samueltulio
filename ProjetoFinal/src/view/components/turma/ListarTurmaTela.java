package view.components.turma;

import daoSQL.TurmaDao;
import model.Turma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ListarTurmaTela extends JPanel {

    String[] colNames = {"Identificador", "Série", "Ano Letivo"};
    TurmaDao tDao;
    java.util.List<Turma> listTurmas;

    public ListarTurmaTela() throws SQLException, ClassNotFoundException {
        tDao = new TurmaDao();
        listTurmas = (java.util.List<Turma>) tDao.listTurma();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel tablePane = new JPanel();
        tablePane.setLayout(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableTurmas = new JTable(tableModel);

        // Adiciona os dados da lista à tabela
        for (Turma turma : listTurmas) {
            tableModel.addRow(new Object[]{turma.getIdTurma(), turma.getSerie(), turma.getAnoLetivo()});
        }

        JButton atualizar = new JButton("Atualizar");

        JScrollPane scroll = new JScrollPane(tableTurmas);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(tablePane, BorderLayout.CENTER);
        panel.add(atualizar, BorderLayout.SOUTH);

        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }
}
