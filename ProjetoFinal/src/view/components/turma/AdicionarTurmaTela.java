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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
                int id = Integer.parseInt(txtId.getText());
                String serie = txtSerie.getText();
                int ano = Integer.parseInt(txtAno.getText());

                Turma turma = new Turma(id, serie, ano);
                try {
                    TurmaDao tdao = new TurmaDao();
                    tdao.addTurma(turma);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        // Adiciona o painel ao centro do JPanel
        add(panel, BorderLayout.CENTER);
    }
}
