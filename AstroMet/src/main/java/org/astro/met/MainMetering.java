package org.astro.met;

import org.astro.met.model.abstracts.PlanetarySystem;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.planetary_system.SolarSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * This class contains main form and realization of computing.
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
    private JButton buttonRefreshInfo;
    private JLabel labelSatellites;
    private JLabel labelType;
    private JLabel labelPericenter;
    private JLabel labelApocenter;
    private JLabel labelSemiMajorAxis;
    private JLabel labelOrbitalEccentricity;
    private JLabel labelAverageOrbitalPeriod;
    private JLabel labelAverageOrbitalSpeed;
    private JLabel labelRotationPeriod;
    private JLabel labelASatelliteOf;
    private JLabel labelEquatorialRadius;
    private JLabel labelPolarRadius;
    private JLabel labelMeanRadius;
    private JLabel labelSurfaceArea;

    private JLabel[][] labels;

    private java.util.List<PlanetarySystem> planetarySystems;

    public MainMetering() {
        super("AstroMet v2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setBounds(400, 215, 905, 520);
        setVisible(true);
        initialize();
        buttonDoCalculations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computing();
            }
        });
        comboBoxPSO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo(comboBoxPSO);
            }
        });
        buttonRefreshInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo(comboBoxPSO);
            }
        });
        comboBoxSatellites.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo(comboBoxSatellites);
            }
        });
    }

    private void computing() {
        // distance c = |a-b|, where a - dstn between Sun and SSO1, b - dstn between Sun and SSO2
        //long a = DataClass.DISTANCES[comboBoxPointOfDeparture.getSelectedIndex()];
        long a = ((PlanetarySystemObject) comboBoxPointOfDeparture.getSelectedItem()).getDistanceForComputing();
        //long b = DataClass.DISTANCES[comboBoxArrivalPoint.getSelectedIndex()];
        long b = ((PlanetarySystemObject) comboBoxArrivalPoint.getSelectedItem()).getDistanceForComputing();
        long c = Math.abs(a - b);
        // s - number of seconds of flight time, sp - current speed
        double sp = DataClass.SPEEDS[comboBoxSpeed.getSelectedIndex()];
        long s = (long) (c / sp);
        labelDistance.setText(DataClass.formatDistance(c, comboBoxUnits.getSelectedIndex()));
        labelFlightTime.setText(DataClass.formatTime(s));
    }

    private void getInfo(JComboBox comboBox) {
        if (comboBox.getSelectedIndex() <= 0) {
            return;
        }
        clearLabels();
        PlanetarySystemObject selectedObject = (PlanetarySystemObject) comboBox.getSelectedItem();
        Iterator<String> iterator = selectedObject.getObjectInfoMap().keySet().iterator();
        int ind = 0;
        while (iterator.hasNext()) {
            labels[ind][0].setText(iterator.next());
            labels[ind][1].setText(selectedObject.getObjectInfoMap().get(labels[ind][0].getText()));
            ind++;
        }
        labelObjectImage.setIcon(new ImageIcon(selectedObject.getPath()));
        comboBoxSatellites.removeAllItems();
        try {
            labelSatellites.setVisible(true);
            if (selectedObject.getSatellites() == null) {
                comboBoxSatellites.setVisible(false);
                labelSatellites.setVisible(true);
            } else {
                comboBoxSatellites.setVisible(true);
                labelSatellites.setVisible(false);
                for (int i = 0; i < selectedObject.getSatellites().size(); i++) {
                    comboBoxSatellites.addItem(selectedObject.getSatellites().get(i));
                }
            }
        } catch (UnsupportedOperationException e){
            comboBoxSatellites.setVisible(false);
            labelSatellites.setVisible(false);
            labelSatellites.setVisible(false);
        }
    }

    @SuppressWarnings("unckecked")
    private void initialize() {
        // labels
        labels = new JLabel[][]{{labelType, labelDataType}, {labelPericenter, labelDataPericenter},
                {labelApocenter, labelDataApocenter}, {labelSemiMajorAxis, labelDataSemiMajorAxis},
                {labelOrbitalEccentricity, labelDataOrbitalEccentricity}, {labelAverageOrbitalPeriod, labelDataAverageOrbitalPeriod},
                {labelAverageOrbitalSpeed, labelDataAverageOrbitalSpeed}, {labelRotationPeriod, labelDataRotationPeriod},
                {labelASatelliteOf, labelDataASatelliteOf}, {labelEquatorialRadius, labelDataEquatorialRadius},
                {labelPolarRadius, labelDataPolarRadius}, {labelMeanRadius, labelDataMeanRadius}, {labelSurfaceArea, labelDataSurfaceArea}};
        labelSatellites.setVisible(false);
        clearLabels();


        planetarySystems = new ArrayList<>();
        planetarySystems.add(new SolarSystem());

        comboBoxGalaxies.addItem(DataClass.GALAXIES[0]);
        comboBoxGalaxies.setSelectedIndex(0);

        for (int i = 0; i < planetarySystems.size(); i++) {
            comboBoxPlanetarySystems.addItem(planetarySystems.get(i));
        }
        comboBoxPlanetarySystems.setSelectedIndex(0);

        //Planetary System Objects
        List<PlanetarySystemObject> psos = planetarySystems.get(comboBoxPlanetarySystems.getSelectedIndex()).getPSOs();
        comboBoxPSO.addItem(" - не выбрано - ");
        for (int i = 0; i < psos.size(); i++) {
            comboBoxPointOfDeparture.addItem(psos.get(i));
            comboBoxArrivalPoint.addItem(psos.get(i));
            comboBoxPSO.addItem(psos.get(i));
        }
        comboBoxPointOfDeparture.setSelectedIndex(3);
        comboBoxArrivalPoint.setSelectedIndex(4);

        // speeds
        for (int i = 0; i < DataClass.SPEEDS_DESCRIPTION.length; i++) {
            comboBoxSpeed.addItem(DataClass.SPEEDS_DESCRIPTION[i]);
        }
        comboBoxSpeed.setSelectedIndex(0);

        // units
        for (int i = 0; i < DataClass.UNITS_DESCRIPTION.length; i++) {
            comboBoxUnits.addItem(DataClass.UNITS_DESCRIPTION[i]);
        }
        comboBoxUnits.setSelectedIndex(0);
    }

    private void clearLabels(){
        for (int i = 0; i < labels.length; i++) {
            labels[i][0].setText("");
            labels[i][1].setText("");
        }
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