package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Enceladus (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Enceladus extends Satellite {
    public Enceladus(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 237948;
        averageOrbitalPeriod = 118387; // 118386.82 or 1.370218 days
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 252.1; // +- 0.1
        dimensions = "513.2 x 502.8 x 496.6";
        surfaceArea = -1;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\enceladus.jpg";
        code = DataClass.ENCELADUS;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Энцелад (Сатурн II)";
    }
}
