package view;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal {
    public TelaPrincipal() {
        JFrame jfrm = new JFrame("Bem-vindo!");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jfrm.setSize(400, 200);

        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Meus Dados", new TelaLogin());
        jtp.addTab("Turmas", new TelaLogin());
        jtp.addTab("Alunos", new TelaLogin());
        jfrm.add(jtp);

        jfrm.setVisible(true);
    }
}
