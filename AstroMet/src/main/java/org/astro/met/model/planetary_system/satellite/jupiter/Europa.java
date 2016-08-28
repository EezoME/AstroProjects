package org.astro.met.model.planetary_system.satellite.jupiter;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Jupiter;

/**
 * This class represents a model of satellite Europa (Solar System, Jupiter).
 * Created by Eezo on 20.08.2016.
 */
public final class Europa extends Satellite {
    public Europa(Jupiter jupiter) {
        type = Type.SATELLITE;
        pericenter = 664792;
        apocenter = 677408;
        semiMajorAxis = 671100;
        averageOrbitalPeriod = (long) (3.551 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 49476.1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = jupiter;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 1560.8; // +- 0.5
        surfaceArea = 30610000;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\europa.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Европа (Юпитер II)";
    }
}
