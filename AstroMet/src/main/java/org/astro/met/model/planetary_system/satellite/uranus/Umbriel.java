package org.astro.met.model.planetary_system.satellite.uranus;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Uranus;

/**
 * This class represents a model of satellite Umbriel (Solar System, Uranus).
 * Created by Eezo on 20.08.2016.
 */
public final class Umbriel extends Satellite {
    public Umbriel(Uranus uranus) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 266000;
        averageOrbitalPeriod = (long) (4.144 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = uranus;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 584.7; // diameter: 1169.4 +- 2.8
        surfaceArea = 4296000;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\umbriel.gif";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Умбриэль (Уран II)";
    }
}
