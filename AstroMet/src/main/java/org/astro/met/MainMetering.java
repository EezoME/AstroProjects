package org.astro.met;

import org.astro.met.model.abstracts.PlanetarySystem;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.SolarSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

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
    private JButton buttonRefreshInfo;
    private JLabel labelSatellites;

    private java.util.List<PlanetarySystem> planetarySystems;

    public MainMetering() {
        super("AstroMet v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setBounds(400, 215, 905, 520);
        setVisible(true);
        initializeComboboxes();
        buttonDoCalculations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalculations();
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

    private void doCalculations() {
        // distance c = |a-b|, where a - dstn between Sun and SSO1, b - dstn between Sun and SSO2
        //long a = DataClass.DISTANCES[comboBoxPointOfDeparture.getSelectedIndex()];
        long a = ((PlanetarySystemObject) comboBoxPointOfDeparture.getSelectedItem()).getSemiMajorAxis();
        //long b = DataClass.DISTANCES[comboBoxArrivalPoint.getSelectedIndex()];
        long b = ((PlanetarySystemObject) comboBoxArrivalPoint.getSelectedItem()).getSemiMajorAxis();
        long c = Math.abs(a - b);
        // s - number of seconds of flight time, sp - current speed
        double sp = DataClass.SPEEDS[comboBoxSpeed.getSelectedIndex()];
        long s = (long) (c / sp);
        labelDistance.setText(DataClass.formatDistance(c, comboBoxUnits.getSelectedIndex()));
        labelFlightTime.setText(DataClass.formatTime(s));
    }

    private void getInfo(JComboBox comboBox) {
        if (comboBox.getSelectedIndex() == 0) {
            return;
        }
        PlanetarySystemObject selectedObject = (PlanetarySystemObject) comboBox.getSelectedItem();
        if (selectedObject.getType() == org.astro.met.model.abstracts.Type.PLANET ||
                selectedObject.getType() == org.astro.met.model.abstracts.Type.SATELLITE ||
                selectedObject.getType() == org.astro.met.model.abstracts.Type.DWARF_PLANET) {
            labelDataType.setText(selectedObject.getType().getRussianDescription());
            labelDataPericenter.setText(DataClass.getDigitIdents(selectedObject.getPericenter()) + " км");
            labelDataApocenter.setText(DataClass.getDigitIdents(selectedObject.getApocenter()) + " км");
            labelDataSemiMajorAxis.setText(DataClass.getDigitIdents(selectedObject.getSemiMajorAxis()) + " км");
            labelDataOrbitalEccentricity.setText(DataClass.getDigitIdents(selectedObject.getOrbitalEccentricity()));
            labelDataAverageOrbitalPeriod.setText(DataClass.formatTime(selectedObject.getAverageOrbitalPeriod()));
            labelDataAverageOrbitalSpeed.setText(DataClass.getDigitIdents(selectedObject.getAverageOrbitalSpeed()) + " км/с");
            if (selectedObject.isSynchronized()) {
                labelDataRotationPeriod.setText("синхронизирован");
            } else {
                labelDataRotationPeriod.setText(DataClass.formatTime(selectedObject.getRotationPeriod()));
            }
            labelDataASatelliteOf.setText(selectedObject.getaSatelliteOf().toString());
            labelDataEquatorialRadius.setText(DataClass.getDigitIdents(selectedObject.getEquatorialRadius()) + " км");
            labelDataPolarRadius.setText(DataClass.getDigitIdents(selectedObject.getPolarRadius()) + " км");
            labelDataMeanRadius.setText(DataClass.getDigitIdents(selectedObject.getMeanRadius()) + " км");
            labelDataSurfaceArea.setText("<html>" + DataClass.getDigitIdents(selectedObject.getSurfaceArea()) + " км<sup>2</sup>");
            labelObjectImage.setIcon(new ImageIcon(selectedObject.getPath()));
            comboBoxSatellites.removeAllItems();
            if (selectedObject.getSatellites() == null) {
                comboBoxSatellites.addItem("- спутников не имеет -");
            } else {
                for (int i = 0; i < selectedObject.getSatellites().size(); i++) {
                    comboBoxSatellites.addItem(selectedObject.getSatellites().get(i));
                }
            }
        } else if (selectedObject.getType() == org.astro.met.model.abstracts.Type.STAR) {
            //
        }
    }

    @SuppressWarnings("unckecked")
    private void initializeComboboxes() {
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMetering();
            }
        });
    }
}
