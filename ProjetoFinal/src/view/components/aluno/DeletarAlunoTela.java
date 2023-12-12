package view.components.aluno;

import daoSQL.AlunoDao;
import daoSQL.ProfessorDao;
import model.Aluno;
import model.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarAlunoTela extends JPanel {
    AlunoDao aDao;
    List<Aluno> listAluno;

    public DeletarAlunoTela() throws SQLException, ClassNotFoundException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(5, 1));

        aDao = new AlunoDao();
        listAluno = aDao.listAluno();

        JLabel matriculaLbl = new JLabel("Informe a matricula do professor");
        JTextField matriculaTxt = new JTextField();
        JButton pesquisar = new JButton("Pesquisar");
        JLabel resultadoTxt = new JLabel();
        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    Aluno aluno = aDao.searchAluno(mat);
                    System.out.println("professor");
                    resultadoTxt.setText("Você busca o aluno " + String.valueOf(aluno.getNome()) + " para expulsar?");
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    resultadoTxt.setText("Matrícula inválida");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton apagarAluno = new JButton("Apagar");

        apagarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    if(aDao.deleteAluno(mat)) {
                        resultadoTxt.setText("Expulso com sucesso.");
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
        form.add(apagarAluno);

        panel.add(form, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

}
