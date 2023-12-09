package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdicionarProfessorTela extends JPanel{

    public AdicionarProfessorTela() {
        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(6, 2));

        // Componentes
        JLabel jlbNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        form.add(jlbNome);
        form.add(txtNome);

        JLabel jlbEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        form.add(jlbEmail);
        form.add(txtEmail);

        JLabel jlbCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        form.add(jlbCpf);
        form.add(txtCpf);

        JLabel jlbMatricula = new JLabel("Matricula:");
        JTextField txtMatricula = new JTextField();
        form.add(jlbMatricula);
        form.add(txtMatricula);

        JLabel jlbNascimento = new JLabel("Data de nascimento:");
        JTextField txtNascimento = new JTextField();
        form.add(jlbNascimento);
        form.add(txtNascimento);

        JLabel jlbSalario = new JLabel("Salário:");
        JTextField txtSalario = new JTextField();
        form.add(jlbSalario);
        form.add(txtSalario);

        JButton btnSalvar = new JButton("Salvar");

//        panel.add(new JLabel()); // Espaço em branco para alinhar com o layout
        panel.add(form, BorderLayout.CENTER);
        panel.add(btnSalvar, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String cpf = txtCpf.getText();
                int matricula = Integer.parseInt(txtMatricula.getText());
                String nascimentoString = txtNascimento.getText();
                LocalDate nascimento = LocalDate.parse(nascimentoString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                LocalDate nascimento = LocalDate.parse(txtNascimento.getText());
                double salario = Double.parseDouble(txtSalario.getText());

                Professor professor = new Professor(email, nome, cpf, matricula, nascimento, salario);
                try {
                    ProfessorDao pdao = new ProfessorDao();
                    pdao.addProfessor(professor);
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
