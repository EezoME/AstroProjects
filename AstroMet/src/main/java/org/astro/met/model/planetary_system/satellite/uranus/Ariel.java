package org.astro.met.model.planetary_system.satellite.uranus;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Uranus;

/**
 * This class represents a model of satellite Ariel (Solar System, Uranus).
 * Created by Eezo on 20.08.2016.
 */
public final class Ariel extends PlanetarySystemObject {
    public Ariel(Uranus uranus) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 191020;
        averageOrbitalPeriod = (long) (2.52 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 5.51; // calculated on the basis of other parameters (by Wiki)
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = uranus;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 578.9; // dimensions: 1162.2 x 1155.8 x 1155.4
        surfaceArea = 4211300;
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Ариэль (Уран I)";
    }
}
