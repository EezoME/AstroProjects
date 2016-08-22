package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Rhea (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Rhea extends PlanetarySystemObject {
    public Rhea(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 527100;
        averageOrbitalPeriod = (long) (4.5 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 764.3; // diameter: 1528.6
        surfaceArea = 7337000;
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Рея (Сатурн V)";
    }
}
