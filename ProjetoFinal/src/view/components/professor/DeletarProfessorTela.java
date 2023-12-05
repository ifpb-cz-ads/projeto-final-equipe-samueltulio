package view.components.professor;

import dao.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class DeletarProfessorTela extends JPanel {
    JPanel jpn;
    ProfessorDao pDao;
    List<Professor> listProfessor;

    public DeletarProfessorTela() {
        jpn = new JPanel();
        jpn.setLayout(new GridLayout());
        jpn.setLayout(new GridLayout(2, 1));

        pDao = new ProfessorDao();
        listProfessor = pDao.listarProfessor();

        JList jlist = new JList(listProfessor.toArray());
        jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JLabel jlab = new JLabel("Escolha um professor.");
        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = jlist.getSelectedIndex();
                if (index != -1) {
                    jlab.setText("Seleção atual " + listProfessor.get(index));
                }
            }
        });

        JScrollPane jscr = new JScrollPane(jlist);

        JButton apagarProfessor = new JButton("Apagar");

        jpn.add(jscr);
        jpn.add(apagarProfessor);

        add(jpn, BorderLayout.CENTER);
    }
}
