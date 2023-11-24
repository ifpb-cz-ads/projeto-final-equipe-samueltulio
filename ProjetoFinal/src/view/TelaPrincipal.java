package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaPrincipal {

    JFrame jfrm;

    public TelaPrincipal() {
        //Cria JFrame para a aplicação
        jfrm = new JFrame("Bem-Vindo, vamos começar!");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Cria barra de menu para a aplicação
        MenuInicial menuInicial = new MenuInicial();
        JMenuBar jmbar = menuInicial.setMenu();

        jfrm.setJMenuBar(jmbar);
        jfrm.setVisible(true);
    }

}
