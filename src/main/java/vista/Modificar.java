package vista;

import utils.HintTextFieldUI;

import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class Modificar extends JDialog {
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
    private JComboBox cbNombre;

    public Modificar() {
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
        cbNombre.setEnabled(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public void addModeloEficiencias(Vector eficiencias) {
        final DefaultComboBoxModel eficienciasModel = new DefaultComboBoxModel(eficiencias);
        cbEficiencias.setModel(eficienciasModel);
    }

    public void addModeloMarcas(Vector marcas) {
        final DefaultComboBoxModel marcasModel = new DefaultComboBoxModel(marcas);
        cbMarcas.setModel(marcasModel);
    }

    public void addModeloElementoAModificar(Vector elementos) {
        final DefaultComboBoxModel modeloElementoAModificar = new DefaultComboBoxModel(elementos);
        cbNombre.setModel(modeloElementoAModificar);
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

    public JComboBox getcbNombre(){
        return  this.cbNombre;
    }

    public JComboBox getCbMarcas() {
        return cbMarcas;
    }

    public JComboBox getCbEficiencias() {
        return cbEficiencias;
    }

    public JComboBox getCbNombre() {
        return cbNombre;
    }

    public void mostrarModificadoCorrectamente() {
        System.out.println("Modificado correctamente");
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JTextField getTfEmisiones() {
        return tfEmisiones;
    }

    public JTextField getTfConsumo() {
        return tfConsumo;
    }

    public void onMarcaSeleccionado(){
        tfNombre.setEnabled(true);
        tfEmisiones.setEnabled(false);
        tfConsumo.setEnabled(false);
        cbMarcas.setEnabled(false);
        cbEficiencias.setEnabled(false);
        cbNombre.setEnabled(true);
    }

    public void onModeloSeleccionado(){
        cbNombre.setEnabled(true);
        tfNombre.setEnabled(true);
        tfEmisiones.setEnabled(true);
        tfConsumo.setEnabled(true);
        cbMarcas.setEnabled(true);
        cbEficiencias.setEnabled(true);
    }
}

