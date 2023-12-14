package view;

import javax.swing.*;
import java.awt.*;

public class SubTela extends JPanel {

    public SubTela(JPanel formulario) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(formulario, gbc);
    }
}
