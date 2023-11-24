package view;

import javax.swing.*;

public class MenuInicial {

    public JMenuBar setMenu() {
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
        JMenuItem addTurma = new JMenuItem("Matricualar Turma");
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

        return jmbar;
    }
    public MenuInicial() {}

}
