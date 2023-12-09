package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarProfessorTela extends JPanel {
    ProfessorDao pDao;
    List<Professor> listProfessor;

    public DeletarProfessorTela() throws SQLException, ClassNotFoundException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(5, 1));

        pDao = new ProfessorDao();
        listProfessor = pDao.listProfessor();

        JLabel matriculaLbl = new JLabel("Informe a matricula do professor");
        JTextField matriculaTxt = new JTextField();
        JButton pesquisar = new JButton("Pesquisar");
        JLabel resultadoTxt = new JLabel();
        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    Professor professor = pDao.searchProfessor(mat);
                    System.out.println("professor");
                    resultadoTxt.setText("Você busca o professor " + String.valueOf(professor.getNome()) + " para demitir?");
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    resultadoTxt.setText("Matrícula inválida");
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
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    if(pDao.deleteProfessor(mat)) {
                        resultadoTxt.setText("Deletado com sucesso.");
                    } else {
                        resultadoTxt.setText("Falha.");
                    }
                } catch (NumberFormatException ex) {
                    resultadoTxt.setText("Insira novamente a matrícula.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        form.add(matriculaLbl);
        form.add(matriculaTxt);
        form.add(pesquisar);
        form.add(resultadoTxt);
        form.add(apagarProfessor);

        panel.add(form, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

}


