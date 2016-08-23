package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Japetus (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Japetus extends PlanetarySystemObject {
    public Japetus(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 3560820;
        averageOrbitalPeriod = (long) (79.3215 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1; // diameter: 1494.8 x 1424.8
        polarRadius = -1;
        meanRadius = 735.6; // +- 3
        surfaceArea = 6700000;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\japetus.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Япет (Сатурн VIII)";
    }
}
