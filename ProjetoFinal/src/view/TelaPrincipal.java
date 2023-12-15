package view;

import model.Turma;
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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

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
        //Cria JFrame para a aplicação
        ImageIcon icon = new ImageIcon("aluna.png");
        jfrm = new JFrame("SysSchool");
        jfrm.setIconImage(icon.getImage());
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JMenuBar jmbar = new JMenuBar();

        //Cria opções do menu
        JMenu professores = new JMenu("Professores");
        JMenu turmas = new JMenu("Turmas");
        JMenu alunos = new JMenu("Alunos");
        JMenu sair = new JMenu("Sair");

        //Adiciona botôes na aplicação, opções para professores
        JMenuItem addProfessor = new JMenuItem("Matricular Professor");
        JMenuItem listProfessor = new JMenuItem("Pesquisar Professores");
        JMenuItem turmasProfessores = new JMenuItem("Selecionar turma");
        JMenuItem deleteProfessor = new JMenuItem("Deletar Professor");
        professores.add(addProfessor);
        professores.add(listProfessor);
        professores.add(turmasProfessores);
        professores.addSeparator();
        professores.add(deleteProfessor);

        //Adiciona botôes na aplicação, opções para turmas
        JMenuItem addTurma = new JMenuItem("Matricular Turma");
        JMenuItem listTurma = new JMenuItem("Pesquisar Turmas");
        JMenuItem deleteTurma = new JMenuItem("Deletar Turma");
        JMenuItem alunosPorTurma = new JMenuItem("Buscar alunos por turma");
        turmas.add(addTurma);
        turmas.add(listTurma);
        turmas.add(alunosPorTurma);
        turmas.addSeparator();
        turmas.add(deleteTurma);

        //Adiciona botões na aplicação, opções para alunos
        JMenuItem addAluno = new JMenuItem("Matricular Aluno");
        JMenuItem listAluno = new JMenuItem("Pesquisar Aluno");
        JMenuItem deleteAluno = new JMenuItem("Cancelar Matrícula");
        alunos.add(addAluno);
        alunos.add(listAluno);
        alunos.addSeparator();
        alunos.add(deleteAluno);

        //Adiciona botões na aplicação, opção para sair
        JMenuItem sairLogin = new JMenuItem("Sair da aplicação");
        sair.add(sairLogin);

        jmbar.add(professores);
        jmbar.add(turmas);
        jmbar.add(alunos);
        jmbar.add(sair);

        //Recurso para adicionar telas de acordo com opções do menu
        //Adiciona no cardLayout (contido no cardPanel)
        //Devo criar ainda as telas para cada interação
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        addProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProfessorTela = new AdicionarProfessorTela();
                cardPanel.removeAll();
                cardPanel.add(addProfessorTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaMatriculaProfessor");
            }
        });

        listProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listProfessorTela = new ListarProfessorTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(listProfessorTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaListarProfessor");
            }
        });

        turmasProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliciarTurmasProfessores = new TurmaProfessor();
                cardPanel.removeAll();
                cardPanel.add(aliciarTurmasProfessores);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaTurmaProfessor");
            }
        });

        deleteProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    delProfessorTela = new DeletarProfessorTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(delProfessorTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaDeletarProfessor");
            }
        });

        addTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTurmaTela = new AdicionarTurmaTela();
                cardPanel.removeAll();
                cardPanel.add(addTurmaTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaAdicionarTurma");
            }
        });

        listTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listTurmaTela = new ListarTurmaTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(listTurmaTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaAdicionarTurma");
            }
        });

        alunosPorTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    turmasTela = new AlunosPorTurmaTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(turmasTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaListarAlunosTurma");
            }
        });

        deleteTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    delTurmaTela = new DeletarTurmaTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(delTurmaTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaAdicionarTurma");
            }
        });

        addAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAlunoTela = new AdicionarAlunoTela();
                cardPanel.removeAll();
                cardPanel.add(addAlunoTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaAdicionarAluno");
            }
        });

        listAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listAlunoTela = new ListarAlunoTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(listAlunoTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaListarAluno");
            }
        });

        deleteAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    delAlunoTela = new DeletarAlunoTela();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                cardPanel.removeAll();
                cardPanel.add(delAlunoTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaListarAluno");
            }
        });

        sairLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Color backgroundColor = Color.decode("#E8998D");
        cardPanel.setBackground(backgroundColor);
        jfrm.setBackground(backgroundColor);

        jfrm.add(cardPanel, BorderLayout.CENTER);
        jfrm.setJMenuBar(jmbar);
        jfrm.setVisible(true);
    }

}
