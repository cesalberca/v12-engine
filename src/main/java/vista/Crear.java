package vista;

import utils.HintTextFieldUI;

import javax.swing.*;
import java.awt.event.*;

public class Crear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton rbtnMarca;
    private JRadioButton rbtnModelo;
    private JComboBox cbMarcas;
    private JComboBox cbEficiencias;
    private JTextField tfNombre;
    private JTextField tfEmisiones;
    private JTextField tfConsumo;

    public Crear() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        tfNombre.setUI(new HintTextFieldUI("Nombre", true));
        tfConsumo.setUI(new HintTextFieldUI("Consumo", true));
        tfEmisiones.setUI(new HintTextFieldUI("Emisiones", true));
        tfNombre.setEnabled(false);
        tfEmisiones.setEnabled(false);
        tfConsumo.setEnabled(false);
        cbMarcas.setEnabled(false);
        cbEficiencias.setEnabled(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void onMarcaSeleccionado(){
        tfNombre.setEnabled(true);
        tfEmisiones.setEnabled(false);
        tfConsumo.setEnabled(false);
        cbMarcas.setEnabled(false);
        cbEficiencias.setEnabled(false);
    }

    public void onModeloSeleccionado(){
        tfNombre.setEnabled(true);
        tfEmisiones.setEnabled(true);
        tfConsumo.setEnabled(true);
        cbMarcas.setEnabled(true);
        cbEficiencias.setEnabled(true);
    }

    public void cerrarDialogo() {
        dispose();
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel(){
        return buttonCancel;
    }

    public JRadioButton getRbtnMarca() {
        return this.rbtnMarca;
    }

    public JRadioButton getRbtnModelo(){
        return this.rbtnModelo;
    }

    public void mostrarCreadoCorrectamente() {
        System.out.println("Creado correctamente");
    }
}
