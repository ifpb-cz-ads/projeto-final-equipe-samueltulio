package view;

import view.components.aluno.AdicionarAlunoTela;
import view.components.aluno.DeletarAlunoTela;
import view.components.aluno.ListarAlunoTela;
import view.components.professor.AdicionarProfessorTela;
import view.components.professor.DeletarProfessorTela;
import view.components.professor.ListarProfessorTela;
import view.components.professor.TurmaProfessor;
import view.components.turma.AdicionarTurmaTela;
import view.components.turma.AlunosPorTurmaTela;
import view.components.turma.DeletarTurmaTela;
import view.components.turma.ListarTurmaTela;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

        // Adicione estas linhas para alterar a cor de fundo ou adicionar uma imagem de fundo
        cardPanel.setBackground(Color.LIGHT_GRAY); // ou qualquer cor desejada
        // OU
        cardPanel.add(new JLabel(new ImageIcon("/home/ftulioalmeida/IdeaProjects/projeto-final-equipe-samueltulio/ProjetoFinal/dev.jpg")));

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

        // Adiciona uma borda ao redor do formulário
        JPanel painelComBorda = new JPanel(new BorderLayout());
        painelComBorda.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adiciona a borda preta
        painelComBorda.add(formulario, BorderLayout.CENTER);

        painelCentral.add(painelComBorda, gbc);

        cardPanel.add(painelCentral, "Centro");
        cardLayout.show(cardPanel, "Centro");
    }

    private void exibirFormulario(String nomeFormulario) throws SQLException, ClassNotFoundException {
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
            case "formularioDeletarProfessor":
                delProfessorTela = new DeletarProfessorTela();
                formulario = delProfessorTela;
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

        if (formulario != null) {
            centralizarFormulario(formulario);
        }
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

        addProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    exibirFormulario("formularioMatriculaProfessor");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        listProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    exibirFormulario("formularioListarProfessor");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        turmasProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    exibirFormulario("formularioTurmaProfessor");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        deleteProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    exibirFormulario("formularioDeletarProfessor");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

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

        addTurma.addActionListener(e -> {
            try {
                exibirFormulario("formularioAdicionarTurma");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        listTurma.addActionListener(e -> {
            try {
                exibirFormulario("formularioListarTurma");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        alunosPorTurma.addActionListener(e -> {
            try {
                exibirFormulario("formularioListarAlunosTurma");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        deleteTurma.addActionListener(e -> {
            try {
                exibirFormulario("formularioDeletarTurma");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

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

        addAluno.addActionListener(e -> {
            try {
                exibirFormulario("formularioAdicionarAluno");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        listAluno.addActionListener(e -> {
            try {
                exibirFormulario("formularioListarAluno");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        deleteAluno.addActionListener(e -> {
            try {
                exibirFormulario("formularioDeletarAluno");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        return alunos;
    }

    private JMenu criarMenuSair() {
        JMenu sair = new JMenu("Sair");

        JMenuItem sairLogin = new JMenuItem("Sair da aplicação");
        sair.add(sairLogin);

        sairLogin.addActionListener(e -> System.exit(0));

        return sair;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(TelaPrincipal::new);
//    }
}
