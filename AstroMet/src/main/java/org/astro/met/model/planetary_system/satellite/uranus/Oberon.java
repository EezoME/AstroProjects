package org.astro.met.model.planetary_system.satellite.uranus;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Uranus;

/**
 * This class represents a model of satellite Oberon (Solar System, Uranus).
 * Created by Eezo on 20.08.2016.
 */
public final class Oberon extends PlanetarySystemObject {
    public Oberon(Uranus uranus) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 583520;
        averageOrbitalPeriod = (long) (13.463 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = uranus;

        equatorialRadius = -1; // diameter: 1522.8 +- 5.2
        polarRadius = -1;
        meanRadius = 761.4; // +- 2.6
        surfaceArea = 7285000;
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Оберон (Уран IV)";
    }
}
