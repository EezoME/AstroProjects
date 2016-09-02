package org.astro.met.model.planetary_system.satellite.jupiter;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Jupiter;

/**
 * This class represents a model of satellite Ganymede (Solar System, Jupiter).
 * Created by Eezo on 20.08.2016.
 */
public final class Ganymede extends Satellite {
    public Ganymede(Jupiter jupiter) {
        type = Type.SATELLITE;
        pericenter = 1069200;
        apocenter = 1071600;
        semiMajorAxis = 1070400;
        averageOrbitalPeriod = (long) (7.15455296 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 10.880;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = jupiter;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 2634.1; // +- 0.3
        surfaceArea = 87000000; // computed by formula: 4*pi*r^2
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\ganymede.jpg";
        code = DataClass.GANYMEDE;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Ганимед (Юпитер III)";
    }
}
