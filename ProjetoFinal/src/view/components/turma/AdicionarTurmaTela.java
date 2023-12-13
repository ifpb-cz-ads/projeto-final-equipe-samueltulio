package view.components.turma;

import daoSQL.TurmaDao;
import model.Turma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class AdicionarTurmaTela extends JPanel {
    public AdicionarTurmaTela() {
        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3, 2));

        // Componentes
        JLabel jlbId = new JLabel("Identificador:");
        JTextField txtId = new JTextField();
        form.add(jlbId);
        form.add(txtId);

        JLabel jlbSerie = new JLabel("Série:");
        JTextField txtSerie = new JTextField();
        form.add(jlbSerie);
        form.add(txtSerie);

        JLabel jlbAno = new JLabel("Ano letivo:");
        JTextField txtAno = new JTextField();
        form.add(jlbAno);
        form.add(txtAno);

        JButton btnSalvar = new JButton("Salvar");

        panel.add(form, BorderLayout.CENTER);
        panel.add(btnSalvar, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    String serie = txtSerie.getText();
                    int ano = Integer.parseInt(txtAno.getText());

                    if (id <= 0) {
                        throw new IllegalArgumentException("O campo de nome não pode ser vazio.");
                    }

                    if (serie.isEmpty()) {
                        throw new IllegalArgumentException("O campo de email não pode ser vazio.");
                    }

                    if (ano <= 0) {
                        throw new IllegalArgumentException("O campo de CPF não pode ser vazio.");
                    }

                    try {
                        Turma turma = new Turma(id, serie, ano);
                        TurmaDao tdao = new TurmaDao();
                        if(tdao.addTurma(turma)) {
                            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao adicionar.");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                } catch (DateTimeParseException | IllegalArgumentException exp) {
                    JOptionPane.showMessageDialog(null, "Erro no preenchimento do formulário: " + exp.getMessage());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Por favor, revise seu formulário.");
                }
            }
        });

        // Adiciona o painel ao centro do JPanel
        add(panel, BorderLayout.CENTER);
    }
}
