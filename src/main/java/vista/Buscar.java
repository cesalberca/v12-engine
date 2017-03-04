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
    private JCheckBox cbMarca;
    private JComboBox cbbEmisiones;
    private JComboBox cbbClasificacion;
    private JSlider sConsumo;
    private JLabel jlValorSeleccionado;
    private JTextArea taResultados;

    public Buscar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void onMarcaSeleccionado(){
        if(cbMarca.isSelected()){
            cbbMarca.setEnabled(true);
        }else{
            cbbMarca.setEnabled(false);
        }
    }
    public void onConsumoSeleccionado(){
        if(cbConsumo.isSelected()){
            sConsumo.setEnabled(true);
        }else{
            sConsumo.setEnabled(false);
        }
    }
    public void onEmisionesSeleccionado(){
        if(cbEmisiones.isSelected()){
            cbbEmisiones.setEnabled(true);
        }else{
            cbbEmisiones.setEnabled(false);
        }
    }
    public void onClasificacionSeleccionado(){
        if(cbClasificacion.isSelected()){
            cbbClasificacion.setEnabled(true);
        }else{
            cbbClasificacion.setEnabled(false);
        }
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

    public JTextArea getTaResultados() {
        return taResultados;
    }

    public void cerrarDialogo() {
        dispose();
    }

    public JComboBox getCbbMarca() {
        return cbbMarca;
    }

    public JComboBox getCbbEmisiones() {
        return cbbEmisiones;
    }

    public JComboBox getCbbClasificacion() {
        return cbbClasificacion;
    }

    public JSlider getsConsumo() {
        return sConsumo;
    }

    public void onCambioSlider() {
        this.jlValorSeleccionado.setText(String.valueOf(sConsumo.getValue()));
    }
}
