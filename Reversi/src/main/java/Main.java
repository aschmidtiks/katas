import gui.Frame;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame(8, 8);
            }
        });
    }
}
