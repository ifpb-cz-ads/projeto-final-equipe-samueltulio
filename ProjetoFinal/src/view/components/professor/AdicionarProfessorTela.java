package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;
import model.StaticMethods;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AdicionarProfessorTela extends JPanel {

    public AdicionarProfessorTela() {
        // Painel para organizar os componentes
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

        JLabel jlbSalario = new JLabel("Salário:");
        JTextField txtSalario = new JTextField();
        form.add(jlbSalario);
        form.add(txtSalario);

        JButton btnSalvar = new JButton("Salvar");

        // Adiciona o formulário diretamente ao centro do JPanel usando FlowLayout para centralizar
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(form);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Código do botão salvar continua igual...
                } catch (DateTimeParseException | IllegalArgumentException exp) {
                    JOptionPane.showMessageDialog(null, "Erro no preenchimento do formulário: " + exp.getMessage());
                } catch (Exception exp) {
                    exp.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Por favor, revise seu formulário.");
                }
            }
        });
    }
}
