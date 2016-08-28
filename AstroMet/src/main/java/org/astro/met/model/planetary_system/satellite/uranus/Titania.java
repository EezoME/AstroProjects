package org.astro.met.model.planetary_system.satellite.uranus;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Satellite;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.planet.Uranus;

/**
 * This class represents a model of satellite Titania (Solar System, Uranus).
 * Created by Eezo on 20.08.2016.
 */
public final class Titania extends Satellite {
    public Titania(Uranus uranus) {
        type = Type.SATELLITE;
        pericenter = -1;
        apocenter = -1;
        semiMajorAxis = 435910;
        averageOrbitalPeriod = (long) (8.71 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = uranus;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 788.4; // diameter: 1576.8
        surfaceArea = 7820000;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\titania.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Титания (Уран III)";
    }
}
