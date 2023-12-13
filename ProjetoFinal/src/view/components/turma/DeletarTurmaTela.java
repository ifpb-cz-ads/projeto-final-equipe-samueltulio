package view.components.turma;

import daoSQL.TurmaDao;
import model.Turma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarTurmaTela extends JPanel {
    TurmaDao tDao;
    List<Turma> listTurmas;
    String[] colNames = {"Identificador", "Série", "Ano Letivo"};

    public DeletarTurmaTela() throws SQLException, ClassNotFoundException {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JPanel form = new JPanel();
            form.setLayout(new GridLayout(5, 1));

            tDao = new TurmaDao();
            listTurmas = tDao.listTurma();

            JLabel idLbl = new JLabel("Informe o identificador da turma");
            JTextField idTxt = new JTextField();
            JButton pesquisar = new JButton("Pesquisar");

            DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
            JTable tableTurma = new JTable(tableModel);

            pesquisar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(idTxt.getText());
                        Turma turma = tDao.searchTurma(id);
                        tableModel.addRow(new Object[]{turma.getIdTurma(), turma.getSerie(), turma.getAnoLetivo()});
                    } catch (NumberFormatException ex) {
                        // Tratamento para entrada inválida de matrícula
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });


            JButton apagarProfessor = new JButton("Apagar");

            apagarProfessor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int mat = Integer.parseInt(idTxt.getText());
                        if(tDao.deleteTurma(mat)) {
                            JOptionPane.showMessageDialog(null, "Deletado com sucesso.");
                            tableModel.setRowCount(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao deletar");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Insira novamente a matricula.");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            form.add(idLbl);
            form.add(idTxt);
            form.add(pesquisar);
            form.add(tableTurma);
            form.add(apagarProfessor);

            panel.add(form, BorderLayout.CENTER);

            add(panel, BorderLayout.CENTER);

    }
}
