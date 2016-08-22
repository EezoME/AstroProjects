package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Titan (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Titan extends PlanetarySystemObject {
    public Titan(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 1221870;
        averageOrbitalPeriod = (long) (15.945 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 2576; // diameter: 5152
        surfaceArea = 83000000;
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Титан (Сатурн VI)";
    }
}
