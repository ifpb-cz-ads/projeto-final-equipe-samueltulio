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
import java.time.format.DateTimeParseException;

public class AdicionarProfessorTela extends JPanel {

    public AdicionarProfessorTela() {
        // Painel para organizar os componentes
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(7, 2));

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

        // Adiciona o botão "Salvar" na parte inferior do formulário
        JButton btnSalvar = new JButton("Salvar");
        form.add(new JLabel()); // Espaço vazio para ocupar a célula da grade
        form.add(btnSalvar);

        // Adiciona o formulário diretamente ao centro do JPanel usando FlowLayout para centralizar
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(form);

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

        Color backgroundColor = Color.decode("#FBF7F4");
        panel.setBackground(backgroundColor);
        form.setBackground(backgroundColor);

        Font font = new Font("Arial", Font.PLAIN, 14);
        jlbNome.setFont(font);
        txtNome.setFont(font);
        jlbEmail.setFont(font);
        txtEmail.setFont(font);
        jlbCpf.setFont(font);
        txtCpf.setFont(font);
        jlbMatricula.setFont(font);
        txtMatricula.setFont(font);
        jlbNascimento.setFont(font);
        txtNascimento.setFont(font);
        jlbSalario.setFont(font);
        txtSalario.setFont(font);

        Color buttonColor = Color.decode("#E8998D");
        btnSalvar.setBackground(buttonColor);

        // Definindo a cor do texto no botão
        btnSalvar.setForeground(Color.WHITE);

        // Criando bordas arredondadas para o botão
        int borderRadius = 15; // Ajuste conforme necessário
        btnSalvar.setBorder(BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));

        int formWidth = 900; // ajuste conforme necessário
        int formHeight = 700; // ajuste conforme necessário
        form.setPreferredSize(new Dimension(formWidth, formHeight));
        form.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // margens internas
                BorderFactory.createLineBorder(Color.BLACK) // borda preta
        ));

        // Adiciona o painel ao centro do JPanel
        setBackground(backgroundColor);
        add(panel, BorderLayout.CENTER);

    }
}
