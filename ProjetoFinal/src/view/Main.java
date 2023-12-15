package view;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TelaPrincipal();
//            }
//        });

        SwingUtilities.invokeLater(() -> {
//            listAvailableFonts();
//            Font customFont = new Font("Consolas", Font.PLAIN, 14);
//            Color customForegroundColor = Color.red;
//            Color customBackgroundColor = Color.blue;
//            applyGlobalFontAndColors(customFont, customForegroundColor, customBackgroundColor);
            new TelaPrincipal();
        });

    }

    private static void listAvailableFonts() {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        System.out.println("Fontes disponíveis:");
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }

    private static void applyGlobalFontAndColors(Font font, Color foreground, Color background) {
        UIManager.put("Button.font", font);
        UIManager.put("Button.foreground", foreground);
        UIManager.put("Button.background", background);

        UIManager.put("Label.font", font);
        UIManager.put("Label.foreground", foreground);
        UIManager.put("Label.background", background);

        // Adicione mais configurações conforme necessário para outros componentes
    }
}
