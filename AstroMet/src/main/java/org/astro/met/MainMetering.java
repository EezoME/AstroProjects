package org.astro.met;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eezo on 16.08.2016.
 */
public class MainMetering extends JFrame {
    private JPanel rootPanel;
    private JComboBox comboBoxGalaxies;
    private JComboBox comboBoxPlanetarySystems;
    private JComboBox comboBoxPointOfDeparture;
    private JComboBox comboBoxArrivalPoint;
    private JComboBox comboBoxSpeed;
    private JComboBox comboBoxUnits;
    private JLabel labelDistance;
    private JLabel labelFlightTime;
    private JButton buttonDoCalculations;
    private JComboBox comboBoxPSO;
    private JComboBox comboBoxSatellites;
    private JLabel labelDataType;
    private JLabel labelDataPericenter;
    private JLabel labelDataApocenter;
    private JLabel labelDataSemiMajorAxis;
    private JLabel labelDataOrbitalEccentricity;
    private JLabel labelDataAverageOrbitalPeriod;
    private JLabel labelDataAverageOrbitalSpeed;
    private JLabel labelDataRotationPeriod;
    private JLabel labelDataASatelliteOf;
    private JLabel labelDataEquatorialRadius;
    private JLabel labelDataPolarRadius;
    private JLabel labelDataMeanRadius;
    private JLabel labelDataSurfaceArea;
    private JLabel labelObjectImage;

    public MainMetering(){
        super("AstroMet v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setBounds(400, 215, 825, 510);
        setVisible(true);
        initializeComboboxes();
        buttonDoCalculations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalculations();
            }
        });
    }

    private void doCalculations(){
        // distance c = |a-b|, where a - dstn between Sun and SSO1, b - dstn between Sun and SSO2
        long a = DataClass.DISTANCES[comboBoxPointOfDeparture.getSelectedIndex()];
        long b = DataClass.DISTANCES[comboBoxArrivalPoint.getSelectedIndex()];
        long c = Math.abs(a-b);
        // s - number of seconds of flight time, sp - current speed
        double sp = DataClass.SPEEDS[comboBoxSpeed.getSelectedIndex()];
        long s = (long)(c / sp);
        labelDistance.setText(DataClass.formatDistance(c, comboBoxUnits.getSelectedIndex()));
        labelFlightTime.setText(DataClass.formatTime(s));
    }

    @SuppressWarnings("unckecked")
    private void initializeComboboxes(){
        comboBoxGalaxies.addItem(DataClass.GALAXIES[0]);
        comboBoxGalaxies.setSelectedIndex(0);

        comboBoxPlanetarySystems.addItem(DataClass.STAR_SYSTEMS[0]);
        comboBoxPlanetarySystems.setSelectedIndex(0);

        for (int i = 0; i < DataClass.SOLAR_SYSTEM_OBJECTS.length; i++) {
            comboBoxPointOfDeparture.addItem(DataClass.SOLAR_SYSTEM_OBJECTS[i]);
            comboBoxArrivalPoint.addItem(DataClass.SOLAR_SYSTEM_OBJECTS[i]);
        }
        comboBoxPointOfDeparture.setSelectedIndex(3);
        comboBoxArrivalPoint.setSelectedIndex(4);

        for (int i = 0; i < DataClass.SPEEDS_DESCRIPTION.length; i++) {
            comboBoxSpeed.addItem(DataClass.SPEEDS_DESCRIPTION[i]);
        }
        comboBoxSpeed.setSelectedIndex(0);

        for (int i = 0; i < DataClass.UNITS_DESCRIPTION.length; i++) {
            comboBoxUnits.addItem(DataClass.UNITS_DESCRIPTION[i]);
        }
        comboBoxUnits.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMetering();
            }
        });
    }
}
