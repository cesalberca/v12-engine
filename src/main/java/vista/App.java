package vista;

import javax.swing.*;

public class App {
    private JPanel jpPrincipal;
    private JToolBar jtbMenu;
    private JButton crearButton;
    private JTextPane textPane1;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton marcasButton;
    private JButton filtrarButton;
    private JButton button2;

    public App() {
        JFrame frame = new JFrame("Gesmotor");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        frame.setContentPane(jpPrincipal);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
