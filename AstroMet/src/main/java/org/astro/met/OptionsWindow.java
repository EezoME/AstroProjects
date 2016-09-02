package org.astro.met;

import javax.swing.*;
import java.awt.event.*;

public class OptionsWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton radioButtonKilometers;
    private JRadioButton radioButtonMiles;
    private JComboBox comboBoxLanguage;

    private ButtonGroup bg;

    public OptionsWindow() {
        setContentPane(contentPane);
        setBounds(600,400,getWidth(),getHeight());
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        bg = new ButtonGroup();
        bg.add(radioButtonKilometers);
        bg.add(radioButtonMiles);
        if (MainMetering.defaultUnit == DataClass.KM_COEFF) {
            bg.setSelected(radioButtonKilometers.getModel(), true);
        } else {
            bg.setSelected(radioButtonMiles.getModel(), true);
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (radioButtonKilometers.isSelected()){
            MainMetering.defaultUnit = DataClass.KM_COEFF;
        } else {
            MainMetering.defaultUnit = DataClass.MILES_COEFF;
        }

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        OptionsWindow dialog = new OptionsWindow();
        dialog.pack();
        dialog.setVisible(true);
    }
}
