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
    private JTextField tfConsumo;
    private JTextField tfEmisiones;
    private JTextField tfClasificacion;
    private JTable jtResultados;
    private JCheckBox cbMarca;

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
            tfConsumo.setEnabled(true);
        }else{
            tfConsumo.setEnabled(false);
        }
    }
    public void onEmisionesSeleccionado(){
        if(cbEmisiones.isSelected()){
            tfEmisiones.setEnabled(true);
        }else{
            tfEmisiones.setEnabled(false);
        }
    }
    public void onClasificacionSeleccionado(){
        if(cbClasificacion.isSelected()){
            tfClasificacion.setEnabled(true);
        }else{
            tfClasificacion.setEnabled(false);
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

    public void cerrarDialogo() {
        dispose();
    }

}
