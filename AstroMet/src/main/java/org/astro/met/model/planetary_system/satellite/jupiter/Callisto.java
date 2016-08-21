package org.astro.met.model.planetary_system.satellite.jupiter;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Jupiter;

/**
 * This class represents a model of satellite Callisto (Solar System, Jupiter).
 * Created by Eezo on 20.08.2016.
 */
public final class Callisto extends PlanetarySystemObject {
    public Callisto(Jupiter jupiter) {
        type = Type.SATELLITE;
        pericenter = 1869000;
        apocenter = 1897000;
        semiMajorAxis = 1882700;
        averageOrbitalPeriod = (long) (16.6890184 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 8.204;
        aSatelliteOf = jupiter;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 2410.3; // +- 1.5
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Каллисто (Юпитер IV)";
    }
}