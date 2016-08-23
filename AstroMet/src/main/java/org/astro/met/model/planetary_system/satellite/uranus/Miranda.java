package org.astro.met.model.planetary_system.satellite.uranus;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Uranus;

/**
 * This class represents a model of satellite Miranda (Solar System, Uranus).
 * Created by Eezo on 20.08.2016.
 */
public final class Miranda extends PlanetarySystemObject {
    public Miranda(Uranus uranus) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 129900;
        averageOrbitalPeriod = (long) (1.413 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 24067.7;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = uranus;

        equatorialRadius = -1; // dimensions: 240.4 x 234.2 x 232.9
        polarRadius = -1;
        meanRadius = 235.8; // +- 0.7
        surfaceArea = 698711; // 698 710.82 km^2
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\miranda.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Миранда (Уран V)";
    }
}
