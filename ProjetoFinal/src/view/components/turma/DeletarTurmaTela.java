package view.components.turma;

import daoSQL.ProfessorDao;
import daoSQL.TurmaDao;
import model.Professor;
import model.Turma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarTurmaTela extends JPanel {
    TurmaDao tDao;
    List<Turma> listTurmas;

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
            JLabel resultadoTxt = new JLabel();
            pesquisar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(idTxt.getText());
                        Turma turma = tDao.searchTurma(id);
                        resultadoTxt.setText("Você busca a turma " + String.valueOf(turma.getSerie()) + " do ano " + String.valueOf(turma.getAnoLetivo()) + " para deletar?");
                    } catch (NumberFormatException ex) {
                        // Tratamento para entrada inválida de matrícula
                        resultadoTxt.setText("Identificador inválida");
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
                            resultadoTxt.setText("Deletado com sucesso.");
                        } else {
                            resultadoTxt.setText("Falha.");
                        }
                    } catch (NumberFormatException ex) {
                        resultadoTxt.setText("Insira novamente o identificador.");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            form.add(idLbl);
            form.add(idTxt);
            form.add(pesquisar);
            form.add(resultadoTxt);
            form.add(apagarProfessor);

            panel.add(form, BorderLayout.CENTER);

            add(panel, BorderLayout.CENTER);

    }
}
