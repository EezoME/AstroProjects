package org.astro.met.model.planetary_system.satellite;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Mars;

/**
 * This class represents a model of satellite Deimos (Solar System, Mars).
 * Created by Eezo on 20.08.2016.
 */
public final class Deimos extends Satellite {
    public Deimos(Mars mars) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 23458;
        averageOrbitalPeriod = (long) (1.26244 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = mars;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 6.2; // avg diameter 12.4 km
        dimensions = "15 x 12.2 x 10.4";
        surfaceArea = -1;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\deimos.jpg";
        code = DataClass.DEIMOS;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Деймос";
    }
}
