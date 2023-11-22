package view;

import javax.swing.*;

public class AlunosPane extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public AlunosPane() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        AlunosPane dialog = new AlunosPane();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
