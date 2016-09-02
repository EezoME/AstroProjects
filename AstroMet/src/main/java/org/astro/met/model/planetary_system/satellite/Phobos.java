package org.astro.met.model.planetary_system.satellite;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Mars;

/**
 * This class represents a model of satellite Phobos (Solar System, Mars).
 * Created by Eezo on 20.08.2016.
 */
public final class Phobos extends Satellite {
    public Phobos(Mars mars) {
        type = Type.SATELLITE;
        pericenter = 9235; // 9235.6
        apocenter = 9519; // 9518.8
        semiMajorAxis = 9377; // 9377.2
        averageOrbitalPeriod = 27552;
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = mars;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 11.1;
        dimensions = "26.8 x 22.4 x 18.4";
        surfaceArea = 1600;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\phobos.png";
        code = DataClass.PHOBOS;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Фобос";
    }
}
