package vista;

import utils.HintTextFieldUI;

import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class Eliminar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton rbtnMarca;
    private JRadioButton rbtnModelo;
    private JComboBox cbNombre;

    public Eliminar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void onMarcaSeleccionado(){
        cbNombre.setEnabled(true);
    }

    public void onModeloSeleccionado(){
        cbNombre.setEnabled(true);
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
    public JComboBox getCbNombre(){
        return this.cbNombre;
    }

    public void mostrarEliminadoCorrectamente() {
        System.out.println("Eliminado correctamente");
    }

    public void addModeloMarcas(Vector marcas){
        final DefaultComboBoxModel marcasModel = new DefaultComboBoxModel(marcas);
        cbNombre.setModel(marcasModel);
    }

    public void addModelModelo(Vector modelos){
        final DefaultComboBoxModel modeloModel = new DefaultComboBoxModel(modelos);
        cbNombre.setModel(modeloModel);
    }
}
