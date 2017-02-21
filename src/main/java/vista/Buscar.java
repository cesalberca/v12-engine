package vista;

import javax.swing.*;
import java.awt.event.*;

public class Buscar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbbMarca;
    private JCheckBox cbClasificacion;
    private JCheckBox cbEmisiones;
    private JCheckBox cbConsumo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable jtResultados;
    private JCheckBox cbMarca;

    public Buscar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void onMarcaSeleccionado(){
        cbbMarca.setEnabled(true);
    }
    public void onConsumoSeleccionado(){
        cbConsumo.setEnabled(true);
    }
    public void onEmisionesSeleccionado(){
        cbEmisiones.setEnabled(true);
    }
    public void onClasificacionSeleccionado(){
        cbClasificacion.setEnabled(true);
    }
    public void onMarcaDeseleccionado(){
        cbbMarca.setEnabled(false);
    }
    public void onConsumoDeseleccionado(){
        cbConsumo.setEnabled(false);
    }
    public void onEmisionesDeseleccionado(){
        cbEmisiones.setEnabled(false);
    }
    public void onClasificacionDeseleccionado(){
        cbClasificacion.setEnabled(false);
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JCheckBox getCbClasificacion() {
        return cbClasificacion;
    }

    public JCheckBox getCbEmisiones() {
        return cbEmisiones;
    }

    public JCheckBox getCbConsumo() {
        return cbConsumo;
    }

    public JCheckBox getCbMarca() {
        return cbMarca;
    }

    public void cerrarDialogo() {
        dispose();
    }


    //TODO Quitar esto de aquí
    public static void main(String[] args) {
        Buscar dialog = new Buscar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
