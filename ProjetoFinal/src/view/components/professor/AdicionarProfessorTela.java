package view.components.professor;

import javax.swing.*;
import java.awt.*;

public class AdicionarProfessorTela extends JPanel{

    public AdicionarProfessorTela() {
        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        // Componentes
        JLabel jlbNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        panel.add(jlbNome);
        panel.add(txtNome);

        JLabel jlbEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        panel.add(jlbEmail);
        panel.add(txtEmail);

        JLabel jlbCpf = new JLabel("CPF");
        JTextField txtCpf = new JTextField();
        panel.add(jlbCpf);
        panel.add(txtCpf);

        JLabel jlbMatricula = new JLabel("Matricula");
        JTextField txtMatricula = new JTextField();
        panel.add(jlbMatricula);
        panel.add(txtMatricula);

        JLabel jlbNascimento = new JLabel("Data de nascimento");
        JTextField txtNascimento = new JTextField();
        panel.add(jlbNascimento);
        panel.add(txtNascimento);

        JLabel jlbSalario = new JLabel("Salário");
        JTextField txtSalario = new JTextField();
        panel.add(jlbSalario);
        panel.add(txtSalario);

        JButton btnSalvar = new JButton("Salvar");

        panel.add(new JLabel()); // Espaço em branco para alinhar com o layout
        panel.add(btnSalvar);

        // Adiciona o painel ao centro do JPanel
        add(panel, BorderLayout.CENTER);
    }

}
