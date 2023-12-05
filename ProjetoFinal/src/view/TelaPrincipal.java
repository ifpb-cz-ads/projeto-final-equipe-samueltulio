package view;

import view.components.professor.AdicionarProfessorTela;
import view.components.professor.DeletarProfessorTela;
import view.components.professor.ListarProfessorTela;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaPrincipal {

    private JFrame jfrm;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    AdicionarProfessorTela addProfessorTela;
    ListarProfessorTela listProfessorTela;
    DeletarProfessorTela delProfessorTela;

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
        JMenuItem deleteProfessor = new JMenuItem("Deletar Professor");
        professores.add(addProfessor);
        professores.add(listProfessor);
        professores.addSeparator();
        professores.add(deleteProfessor);

        //Adiciona botôes na aplicação, opções para turmas
        JMenuItem addTurma = new JMenuItem("Matricular Turma");
        JMenuItem listTurma = new JMenuItem("Pesquisar Turmas");
        JMenuItem deleteTurma = new JMenuItem("Deletar Turma");
        turmas.add(addTurma);
        turmas.add(listTurma);
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
                listProfessorTela = new ListarProfessorTela();
                cardPanel.removeAll();
                cardPanel.add(listProfessorTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaListarProfessor");
            }
        });

        deleteProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delProfessorTela = new DeletarProfessorTela();
                cardPanel.removeAll();
                cardPanel.add(delProfessorTela);

                cardPanel.revalidate();
                cardPanel.repaint();

                cardLayout.show(cardPanel, "telaDeletarProfessor");
            }
        });

        jfrm.add(cardPanel, BorderLayout.CENTER);
        jfrm.setJMenuBar(jmbar);
        jfrm.setVisible(true);
    }

}
