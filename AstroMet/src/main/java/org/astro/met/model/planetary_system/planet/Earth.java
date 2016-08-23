package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.Moon;

import java.util.ArrayList;

/**
 * This class represents a model of planet Earth (Solar System).
 * Created by Eezo on 20.08.2016.
 */
public final class Earth extends PlanetarySystemObject {
    public Earth(Sun sun) {
        type = Type.PLANET;
        pericenter = 147098290;
        apocenter = 152098232;
        semiMajorAxis = 149598261;
        orbitalEccentricity = 0.017;
        averageOrbitalPeriod = (long) (365.256366004 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 29.783;
        rotationPeriod = (long)(0.99726968 * DataClass.DAY_COEFF);
        isSynchronized = false;

        aSatelliteOf = sun;

        equatorialRadius = 6378.1;
        polarRadius = 6356.8;
        meanRadius = 6371.0;
        surfaceArea = 510072000;
        satellites = new ArrayList<>(); // 1, 8300+ artificial satellites
        satellites.add(new Moon(this));

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\earth.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Земля";
    }
}
