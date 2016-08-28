package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Mimas (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Mimas extends Satellite {
    public Mimas(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 185539;
        averageOrbitalPeriod = (long) (0.942 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 198.3; // +- 0.3
        dimensions = "414.8 x 394.4 x 381.4";
        surfaceArea = 493000; // approximately
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\mimas.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Мимас (Сатурн I)";
    }
}
