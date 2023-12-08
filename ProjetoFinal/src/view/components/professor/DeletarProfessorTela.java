package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarProfessorTela extends JPanel {

    JPanel jpn;
    ProfessorDao pDao;
    List<Professor> listProfessor;

    public DeletarProfessorTela() throws SQLException, ClassNotFoundException {
        jpn = new JPanel();
        jpn.setLayout(new GridLayout());
        jpn.setLayout(new GridLayout(2, 1));

        pDao = new ProfessorDao();
        listProfessor = pDao.listProfessor();

        JLabel jlab = new JLabel("Informe a matricula do professor");
        JTextField matricula = new JTextField();
        JButton pesquisar = new JButton("Pesquisar");
        JLabel resultado = new JLabel("Sem nada");
        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matricula.getText());
                    Professor professor = pDao.searchProfessor(mat);
                    System.out.println("professor");
                    resultado.setText(String.valueOf(professor));
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    resultado.setText("Matrícula inválida");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton apagarProfessor = new JButton("Apagar");

        jpn.add(jlab);
        jpn.add(matricula);
        jpn.add(pesquisar);
        jpn.add(resultado);
        jpn.add(apagarProfessor);

        add(jpn, BorderLayout.CENTER);
    }


//        JPanel panel;
//        ProfessorDao dao;
//        Professor professor;

//    public DeletarProfessorTela() throws SQLException, ClassNotFoundException {
//            panel = new JPanel();
//            panel.setLayout(new SpringLayout());
//
//            dao = new ProfessorDao();
//
//            JLabel label = new JLabel("Informe a matrícula do professor");
//            JTextField matriculaTxt = new JTextField();
//            JButton pesquisarBtn = new JButton("Pesquisar");
//
//            pesquisarBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JFrame frame = null;
//                    try {
//                        frame = new JFrame("Janela Principal");
//                        int matricula = Integer.parseInt(matriculaTxt.getText());
//                        professor = dao.searchProfessor(matricula);
//                        System.out.println(professor);
//                    } catch (SQLException ex) {
//                        JOptionPane.showMessageDialog(frame, "Erro ao pesquisar.");
//                    }
//                }
//            });
//
//            panel.add(label);
//            panel.add(matriculaTxt);
//            panel.add(pesquisarBtn);
//
//    }
}


