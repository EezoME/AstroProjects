package org.astro.met;

import org.astro.met.model.abstracts.PlanetarySystem;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.planetary_system.SolarSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JButton buttonGetSatelliteInfo;

    private JLabel[][] labels;

    private java.util.List<PlanetarySystem> planetarySystems;
    static double defaultUnit;

    public MainMetering() {
        super("AstroMet v2.1.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        createMenuBar();
        setBounds(400, 215, 905, 530);
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
        buttonGetSatelliteInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo(comboBoxSatellites);
            }
        });
        comboBoxSatellites.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getInfo(comboBoxSatellites);
            }
        });
        labelObjectImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (labelObjectImage.getIcon().toString().equals(planetarySystems.get(0).getPath())) {
                    System.out.println(labelObjectImage.getMousePosition());

                    PlanetarySystemObject pso = getPointRange(labelObjectImage.getMousePosition());
                    comboBoxPSO.setSelectedItem(pso);
                    if (pso != null && comboBoxPSO.getSelectedIndex() == -1){
                        getInfo(pso);
                    }
                }
            }
        });
    }

    /**
     * This method computes data for AstroMet.
     */
    private void computing() {
        // distance c = |a-b|, where a - dstn between Sun and SSO1, b - dstn between Sun and SSO2
        //long a = PSO.getDistanceForComputing();
        long a = ((PlanetarySystemObject) comboBoxPointOfDeparture.getSelectedItem()).getDistanceForComputing();
        //long b = PSO.getDistanceForComputing();
        long b = ((PlanetarySystemObject) comboBoxArrivalPoint.getSelectedItem()).getDistanceForComputing();
        long c = Math.abs(a - b);
        // s - number of seconds of flight time, sp - current speed
        double sp = DataClass.SPEEDS[comboBoxSpeed.getSelectedIndex()];
        long s = (long) (c / sp);
        labelDistance.setText(DataClass.formatDistance(c, comboBoxUnits.getSelectedIndex()));
        labelFlightTime.setText(DataClass.formatTime(s));
    }

    /**
     * Checks combobox for planetary system objects.
     */
    private void getInfo(JComboBox comboBox) {
        if (comboBox.getSelectedIndex() < 0) {
            return;
        }
        if (comboBox.getSelectedItem() instanceof PlanetarySystemObject) {
            getInfo((PlanetarySystemObject) comboBox.getSelectedItem());
        } else {
            //JOptionPane.showMessageDialog(this, "Выберите объект планетарной системы из списка.");
            labelObjectImage.setIcon(new ImageIcon(DataClass.PATH_TO_IMAGES_FOLDER + "\\solar_system.png"));
        }
    }

    /**
     * This method computes and formats data for AstroInfo.
     */
    private void getInfo(PlanetarySystemObject selectedObject) {
        clearLabels();
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
                labelSatellites.setText("Спутников не имеет");
            } else {
                comboBoxSatellites.setVisible(true);
                labelSatellites.setText("Спутники: ");
                for (int i = 0; i < selectedObject.getSatellites().size(); i++) {
                    comboBoxSatellites.addItem(selectedObject.getSatellites().get(i));
                }
            }
        } catch (UnsupportedOperationException e) {
            comboBoxSatellites.setVisible(false);
            labelSatellites.setVisible(false);
            labelSatellites.setVisible(false);
        }
    }

    /**
     * Custom method for preparing form for viewing.
     */
    @SuppressWarnings("unckecked")
    private void initialize() {
        defaultUnit = DataClass.KM_COEFF;

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

    /**
     * Check current point allocatable for some of PSOs.
     * @param point mouse current point
     * @return an object of planetary system or null if no matches was found
     */
    private PlanetarySystemObject getPointRange(Point point) {
        if (point == null) {
            return null;
        }

        // Sun
        if ((point.x >= 0 && point.x <= 25) && (point.y >= 139 && point.y <= 262)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.SUN);
        }

        // Mercury
        if ((point.x >= 35 && point.x <= 40) && (point.y >= 160 && point.y <= 195)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.MERCURY);
        }

        // Venus
        if ((point.x >= 45 && point.x <= 54) && (point.y >= 152 && point.y <= 184)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.VENUS);
        }

        // Earth
        if ((point.x >= 57 && point.x <= 69) && (point.y >= 145 && point.y <= 176)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.EARTH);
        }

        // Moon
        if ((point.x >= 59 && point.x <= 65) && (point.y >= 131 && point.y <= 143)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.MOON);
        }

        // Mars
        if ((point.x >= 72 && point.x <= 81) && (point.y >= 140 && point.y <= 170)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.MARS);
        }

        // Asteroid Belt
        if ((point.x >= 55 && point.x <= 94) && (point.y >= 87 && point.y <= 134) ||
                (point.x >= 95 && point.x <= 104) && (point.y >= 105 && point.y <= 176) ||
                (point.x >= 103 && point.x <= 117) && (point.y >= 148 && point.y <= 214) ||
                (point.x >= 95 && point.x <= 114) && (point.y >= 238 && point.y <= 263)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.ASTEROID_BELT);
        }

        // Ceres
        if ((point.x >= 89 && point.x <= 110) && (point.y >= 223 && point.y <= 259)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.CERES);
        }

        // Jupiter
        if ((point.x >= 122 && point.x <= 162) && (point.y >= 168 && point.y <= 217) ||
                (point.x >= 138 && point.x <= 149) && (point.y >= 144 && point.y <= 167)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.JUPITER);
        }

        // Saturn
        if ((point.x >= 180 && point.x <= 217) && (point.y >= 149 && point.y <= 181) ||
                (point.x >= 195 && point.x <= 206) && (point.y >= 128 && point.y <= 146)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.SARUTN);
        }

        // Uranus
        if ((point.x >= 243 && point.x <= 260) && (point.y >= 137 && point.y <= 153) ||
                (point.x >= 274 && point.x <= 282) && (point.y >= 100 && point.y <= 122)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.URANUS);
        }

        // Neptune
        if ((point.x >= 269 && point.x <= 286) && (point.y >= 98 && point.y <= 141)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.NEPTUNE);
        }

        // Pluto
        if ((point.x >= 290 && point.x <= 315) && (point.y >= 164 && point.y <= 172) ||
                (point.x >= 296 && point.x <= 300) && (point.y >= 159 && point.y <= 163)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.PLUTO);
        }

        // Charon
        if ((point.x >= 302 && point.x <= 304) && (point.y >= 160 && point.y <= 163)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.CHARON);
        }

        // Makemake
        if ((point.x >= 292 && point.x <= 325) && (point.y >= 200 && point.y <= 207)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.MAKEMAKE);
        }

        // Kuiper Belt
        if ((point.x >= 304 && point.x <= 321) && (point.y >= 84 && point.y <= 105) ||
                (point.x >= 317 && point.x <= 321) && (point.y >= 105 && point.y <= 136) ||
                (point.x >= 317 && point.x <= 334) && (point.y >= 137 && point.y <= 193) ||
                (point.x >= 328 && point.x <= 334) && (point.y >= 197 && point.y <= 208) ||
                (point.x >= 318 && point.x <= 334) && (point.y >= 216 && point.y <= 253)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.KUIPER_BELT);
        }

        // Eris
        if ((point.x >= 324 && point.x <= 338) && (point.y >= 93 && point.y <= 105)) {
            return planetarySystems.get(0).getPSOByCode(null, DataClass.ERIS);
        }

        return null;
    }

    /**
     * Custom method to make a menu bar.
     */
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        JMenuItem optionsItem = new JMenuItem("Настройки...");
        JMenuItem exitItem = new JMenuItem("Выход");
        fileMenu.add(optionsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        optionsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionsWindow.main(null);
            }
        });
    }

    /**
     * Custom method prepares labels for new info items.
     */
    private void clearLabels() {
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