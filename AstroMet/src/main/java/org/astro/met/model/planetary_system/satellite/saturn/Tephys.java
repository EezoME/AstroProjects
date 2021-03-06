package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Tephys (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Tephys extends Satellite {
    public Tephys(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 294672;
        averageOrbitalPeriod = (long) (1.887802 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 531.1; // +- 0.6
        surfaceArea = -1;
        dimensions = "1076.8 x 1057.4 x 1052.6";
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\tephys.jpg";
        code = DataClass.TEPHYS;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Тефия (Сатурн III)";
    }
}
