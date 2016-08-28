package org.astro.met.model.planetary_system.satellite.neptune;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Neptune;

/**
 * This class represents a model of satellite Nereid (Solar System, Neptune).
 * Created by Eezo on 20.08.2016.
 */
public final class Nereid extends Satellite {
    public Nereid(Neptune neptune) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 5513400;
        averageOrbitalPeriod = (long) (360.1362 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = 41460;
        isSynchronized = false;

        aSatelliteOf = neptune;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 170; // diameter: 340
        surfaceArea = 363168;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\nereid.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Нереида (Нептун II)";
    }
}
