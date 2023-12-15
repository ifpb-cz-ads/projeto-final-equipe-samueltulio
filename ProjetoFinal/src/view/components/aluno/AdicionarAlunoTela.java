package view.components.aluno;

import daoSQL.AlunoDao;
import daoSQL.ProfessorDao;
import model.Aluno;
import model.Professor;
import model.StaticMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AdicionarAlunoTela extends JPanel {
    public AdicionarAlunoTela() {
        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(5, 2));

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
        JTextField txtCpf = new JFormattedTextField(StaticMethods.getCpfFormatter());
        form.add(jlbCpf);
        form.add(txtCpf);

        JLabel jlbMatricula = new JLabel("Matricula:");
        JTextField txtMatricula = new JTextField();
        form.add(jlbMatricula);
        form.add(txtMatricula);

        JLabel jlbNascimento = new JLabel("Data de nascimento:");
        JTextField txtNascimento = new JFormattedTextField(StaticMethods.getDateFormatter());
        form.add(jlbNascimento);
        form.add(txtNascimento);

        JButton btnSalvar = new JButton("Salvar");

//        panel.add(new JLabel()); // Espaço em branco para alinhar com o layout
        panel.add(form, BorderLayout.CENTER);
        panel.add(btnSalvar, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String nome = txtNome.getText();
//                String email = txtEmail.getText();
//                String cpf = txtCpf.getText();
//                int matricula = Integer.parseInt(txtMatricula.getText());
//                String nascimentoString = txtNascimento.getText();
//                LocalDate nascimento = LocalDate.parse(nascimentoString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//                Aluno aluno = new Aluno(email, nome, cpf, matricula, nascimento);
//                try {
//                    AlunoDao adao = new AlunoDao();
//                    adao.addAluno(aluno);
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                } catch (ClassNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                }

                try {
                    String nome = txtNome.getText();
                    String email = txtEmail.getText();
                    String cpf = txtCpf.getText();
                    int matricula = Integer.parseInt(txtMatricula.getText());
                    String nascimentoString = txtNascimento.getText();
                    LocalDate nascimento = LocalDate.parse(nascimentoString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Aluno aluno = new Aluno(email, nome, cpf, matricula, nascimento);

                    if (nome.isEmpty()) {
                        throw new IllegalArgumentException("O campo de nome não pode ser vazio.");
                    }

                    if (email.isEmpty()) {
                        throw new IllegalArgumentException("O campo de email não pode ser vazio.");
                    }

                    if (cpf.isEmpty()) {
                        throw new IllegalArgumentException("O campo de CPF não pode ser vazio.");
                    }

                    if (matricula <= 0) {
                        throw new IllegalArgumentException("A matrícula deve ser um número positivo.");
                    }

                    try {
                        AlunoDao adao = new AlunoDao();
                        if(adao.addAluno(aluno)) {
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