package model;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class StaticMethods {

    public StaticMethods() {
    }

    public static MaskFormatter getDateFormatter() {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return formatter;
    }

    public static MaskFormatter getCpfFormatter() {
        MaskFormatter formatter =  null;
        try {
            formatter = new MaskFormatter("###.###.###-##");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return formatter;
    }
}
