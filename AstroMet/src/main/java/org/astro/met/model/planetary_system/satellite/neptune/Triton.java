package org.astro.met.model.planetary_system.satellite.neptune;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Neptune;

/**
 * This class represents a model of satellite Triton (Solar System, Neptune).
 * Created by Eezo on 20.08.2016.
 */
public final class Triton extends PlanetarySystemObject {
    public Triton(Neptune neptune) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 354759;
        averageOrbitalPeriod = (long) (-5.88 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        aSatelliteOf = neptune;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 1353.4;
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Тритон (Нептун I)";
    }
}