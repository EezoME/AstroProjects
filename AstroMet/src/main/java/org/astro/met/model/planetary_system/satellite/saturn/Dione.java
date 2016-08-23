package org.astro.met.model.planetary_system.satellite.saturn;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Saturn;

/**
 * This class represents a model of satellite Dione (Solar System, Saturn).
 * Created by Eezo on 20.08.2016.
 */
public final class Dione extends PlanetarySystemObject {
    public Dione(Saturn saturn) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 377400;
        averageOrbitalPeriod = (long) (2.77 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = saturn;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 561.7; // diameter: 1123.4
        surfaceArea = 3964659; // computed by formula: 4*pi*r^2
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\dione.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Диона (Сатурн IV)";
    }
}
