package view.components.professor;

import javax.swing.*;
import java.awt.*;

public class AdicionarProfessorTela extends JPanel{
    private JFrame jfrm;

    public AdicionarProfessorTela() {
        setLayout(new SpringLayout());

        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        // Componentes
        JLabel jlbNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel jlbEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel jlbCpf = new JLabel("CPF");
        JTextField txtCpf = new JTextField();

        JLabel jlbMatricula = new JLabel("Matricula");
        JTextField txtMatricula = new JTextField();

        JLabel jlbNascimento = new JLabel("Data de nascimento (apenas números)");
        JTextField txtNascimento = new JTextField();

        JLabel jlbSalario = new JLabel("Salário");
        JTextField txtSalario = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        // Adiciona componentes ao painel
        panel.add(jlbNome);
        panel.add(txtNome);
        panel.add(jlbEmail);
        panel.add(txtEmail);
        panel.add(jlbCpf);
        panel.add(txtCpf);
        panel.add(jlbMatricula);
        panel.add(txtMatricula);
        panel.add(jlbNascimento);
        panel.add(txtNascimento);
        panel.add(jlbSalario);
        panel.add(txtSalario);

        panel.add(new JLabel()); // Espaço em branco para alinhar com o layout
        panel.add(btnSalvar);

        // Adiciona o painel ao centro do JPanel
        add(panel, BorderLayout.CENTER);
    }

}
