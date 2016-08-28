package org.astro.met.model.planetary_system.satellite.jupiter;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Jupiter;

/**
 * This class represents a model of satellite Io (Solar System, Jupiter).
 * Created by Eezo on 20.08.2016.
 */
public final class Io extends Satellite {
    public Io(Jupiter jupiter) {
        type = Type.SATELLITE;
        pericenter = 420000;
        apocenter = 423400;
        semiMajorAxis = 421700;
        averageOrbitalPeriod = (long) (1.769137786 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 17.334;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = jupiter;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 1821.3;
        dimensions = "3660 x 3637.4 x 3630.6";
        surfaceArea = 41910000; // computed by formula: 4*pi*r^2
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\io.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Ио (Юпитер I)";
    }
}
