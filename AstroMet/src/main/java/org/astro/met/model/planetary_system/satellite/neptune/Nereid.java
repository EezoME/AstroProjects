package org.astro.met.model.planetary_system.satellite.neptune;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Neptune;

/**
 * This class represents a model of satellite Nereid (Solar System, Neptune).
 * Created by Eezo on 20.08.2016.
 */
public final class Nereid extends PlanetarySystemObject {
    public Nereid(Neptune neptune) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 5513400;
        averageOrbitalPeriod = (long) (360.1362 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        aSatelliteOf = neptune;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 170; // diameter: 340
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Нереида (Нептун II)";
    }
}
