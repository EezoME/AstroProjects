package org.astro.met.model.planetary_system.satellite;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Earth;


/**
 * This class represents a model of satellite Moon (Solar System, Earth).
 * Created by Eezo on 20.08.2016.
 */
public final class Moon extends PlanetarySystemObject {
    public Moon(Earth earth) {
        type = Type.SATELLITE;
        pericenter = 363104; // 356400--370400
        apocenter = 405696; // 404000--406700
        semiMajorAxis = 384399; // 0.00257 au
        averageOrbitalPeriod = (long) (27.321582 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 1.023;
        aSatelliteOf = earth;

        equatorialRadius = 1738.14;
        polarRadius = 1735.97;
        meanRadius = 1737.1;
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Луна";
    }
}
