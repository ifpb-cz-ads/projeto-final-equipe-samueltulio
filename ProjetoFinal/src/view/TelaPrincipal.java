package view;

import view.components.aluno.AdicionarAlunoTela;
import view.components.aluno.ListarAlunoTela;
import view.components.aluno.DeletarAlunoTela;
import view.components.professor.AdicionarProfessorTela;
import view.components.professor.DeletarProfessorTela;
import view.components.professor.ListarProfessorTela;
import view.components.professor.TurmaProfessor;
import view.components.turma.AdicionarTurmaTela;
import view.components.turma.AlunosPorTurmaTela;
import view.components.turma.ListarTurmaTela;
import view.components.turma.DeletarTurmaTela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaPrincipal {

    private JFrame jfrm;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    AdicionarProfessorTela addProfessorTela;
    ListarProfessorTela listProfessorTela;
    TurmaProfessor aliciarTurmasProfessores;
    DeletarProfessorTela delProfessorTela;
    AdicionarTurmaTela addTurmaTela;
    ListarTurmaTela listTurmaTela;
    DeletarTurmaTela delTurmaTela;
    AdicionarAlunoTela addAlunoTela;
    ListarAlunoTela listAlunoTela;
    DeletarAlunoTela delAlunoTela;
    AlunosPorTurmaTela turmasTela;


    public TelaPrincipal() {
            // Cria JFrame para a aplicação
            ImageIcon icon = new ImageIcon("aluna.png");
            jfrm = new JFrame("SysSchool");
            jfrm.setIconImage(icon.getImage());
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Configuração do cardLayout
            cardPanel = new JPanel();
            cardLayout = new CardLayout();
            cardPanel.setLayout(cardLayout);

            // Configuração do menu
            JMenuBar jmbar = new JMenuBar();
            jmbar.add(criarMenuProfessores());
            jmbar.add(criarMenuTurmas());
            jmbar.add(criarMenuAlunos());
            jmbar.add(criarMenuSair());

            jfrm.setJMenuBar(jmbar);
            jfrm.add(cardPanel, BorderLayout.CENTER);
            jfrm.setSize(800, 600);
            jfrm.setLocationRelativeTo(null); // Centraliza a janela na tela
            jfrm.setVisible(true);
    }

    private void centralizarFormulario(JPanel formulario) {
        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adiciona margens

        painelCentral.add(formulario, gbc);

        cardPanel.add(painelCentral, "Centro");
        cardLayout.show(cardPanel, "Centro");
    }

    private void exibirFormulario(String nomeFormulario) {
        JPanel formulario = null;

        switch (nomeFormulario) {
            case "formularioMatriculaProfessor":
                addProfessorTela = new AdicionarProfessorTela();
                formulario = addProfessorTela;
                break;
            case "formularioListarProfessor":
                try {
                    listProfessorTela = new ListarProfessorTela();
                    formulario = listProfessorTela;
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "formularioTurmaProfessor":
                aliciarTurmasProfessores = new TurmaProfessor();
                formulario = aliciarTurmasProfessores;
                break;
            case "formularioAdicionarTurma":
                addTurmaTela = new AdicionarTurmaTela();
                formulario = addTurmaTela;
                break;
            case "formularioListarTurma":
                try {
                    listTurmaTela = new ListarTurmaTela();
                    formulario = listTurmaTela;
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "formularioListarAlunosTurma":
                try {
                    turmasTela = new AlunosPorTurmaTela();
                    formulario = turmasTela;
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "formularioDeletarTurma":
                try {
                    delTurmaTela = new DeletarTurmaTela();
                    formulario = delTurmaTela;
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "formularioAdicionarAluno":
                addAlunoTela = new AdicionarAlunoTela();
                formulario = addAlunoTela;
                break;
            case "formularioListarAluno":
                try {
                    listAlunoTela = new ListarAlunoTela();
                    formulario = listAlunoTela;
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "formularioDeletarAluno":
                try {
                    delAlunoTela = new DeletarAlunoTela();
                    formulario = delAlunoTela;
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            // Adicione outros casos para formulários adicionais
            default:
                // Se o nome do formulário não for reconhecido, não faz nada
        }

        centralizarFormulario(formulario);
        cardLayout.show(cardPanel, "Centro");
    }

    private JMenu criarMenuProfessores() {
        JMenu professores = new JMenu("Professores");

        JMenuItem addProfessor = new JMenuItem("Matricular Professor");
        JMenuItem listProfessor = new JMenuItem("Pesquisar Professores");
        JMenuItem turmasProfessores = new JMenuItem("Selecionar turma");
        JMenuItem deleteProfessor = new JMenuItem("Deletar Professor");

        professores.add(addProfessor);
        professores.add(listProfessor);
        professores.add(turmasProfessores);
        professores.addSeparator();
        professores.add(deleteProfessor);

        addProfessor.addActionListener(e -> exibirFormulario("formularioMatriculaProfessor"));
        listProfessor.addActionListener(e -> exibirFormulario("formularioListarProfessor"));
        turmasProfessores.addActionListener(e -> exibirFormulario("formularioTurmaProfessor"));
        deleteProfessor.addActionListener(e -> exibirFormulario("formularioDeletarProfessor"));

        return professores;
    }

    private JMenu criarMenuTurmas() {
        JMenu turmas = new JMenu("Turmas");

        JMenuItem addTurma = new JMenuItem("Matricular Turma");
        JMenuItem listTurma = new JMenuItem("Pesquisar Turmas");
        JMenuItem deleteTurma = new JMenuItem("Deletar Turma");
        JMenuItem alunosPorTurma = new JMenuItem("Buscar alunos por turma");

        turmas.add(addTurma);
        turmas.add(listTurma);
        turmas.add(alunosPorTurma);
        turmas.addSeparator();
        turmas.add(deleteTurma);

        addTurma.addActionListener(e -> exibirFormulario("formularioAdicionarTurma"));
        listTurma.addActionListener(e -> exibirFormulario("formularioListarTurma"));
        alunosPorTurma.addActionListener(e -> exibirFormulario("formularioListarAlunosTurma"));
        deleteTurma.addActionListener(e -> exibirFormulario("formularioDeletarTurma"));

        return turmas;
    }

    private JMenu criarMenuAlunos() {
        JMenu alunos = new JMenu("Alunos");

        JMenuItem addAluno = new JMenuItem("Matricular Aluno");
        JMenuItem listAluno = new JMenuItem("Pesquisar Aluno");
        JMenuItem deleteAluno = new JMenuItem("Cancelar Matrícula");

        alunos.add(addAluno);
        alunos.add(listAluno);
        alunos.addSeparator();
        alunos.add(deleteAluno);

        addAluno.addActionListener(e -> exibirFormulario("formularioAdicionarAluno"));
        listAluno.addActionListener(e -> exibirFormulario("formularioListarAluno"));
        deleteAluno.addActionListener(e -> exibirFormulario("formularioDeletarAluno"));

        return alunos;
    }

    private JMenu criarMenuSair() {
        JMenu sair = new JMenu("Sair");

        JMenuItem sairLogin = new JMenuItem("Sair da aplicação");
        sair.add(sairLogin);

        sairLogin.addActionListener(e -> System.exit(0));

        return sair;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaPrincipal::new);
    }
}
