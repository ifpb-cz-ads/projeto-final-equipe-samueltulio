package view.components.turma;

import daoSQL.TurmaDao;
import model.Professor;
import model.Turma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

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

        atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = tableModel.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    int idTurma = (int) tableModel.getValueAt(i, 0);
                    String serie = (String) tableModel.getValueAt(i, 1);
                    int anoLetivo = (int) tableModel.getValueAt(i, 2);

                    Turma turma = new Turma(idTurma, serie, anoLetivo);

                    // Atualiza o professor no banco de dados
                    try {
                        tDao.updateTurma(turma);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + ex.getMessage());
                    }
                }

                try {
                    tDao.connection.setAutoCommit(false);
                    tDao.connection.commit();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    listTurmas = tDao.listTurma();
                    tableModel.setRowCount(0); // Limpa a tabela
                    for (Turma turma : listTurmas) {
                        tableModel.addRow(new Object[]{turma.getIdTurma(), turma.getSerie(), turma.getAnoLetivo()});
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tableTurmas);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(tablePane, BorderLayout.CENTER);
        panel.add(atualizar, BorderLayout.SOUTH);

        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }
}
