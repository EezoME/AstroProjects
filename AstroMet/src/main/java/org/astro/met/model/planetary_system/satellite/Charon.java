package org.astro.met.model.planetary_system.satellite;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.dwarf_planet.Pluto;

/**
 * This class represents a model of satellite Charon (Solar System, Pluto).
 * Created by Eezo on 20.08.2016.
 */
public final class Charon extends PlanetarySystemObject {
    public Charon(Pluto pluto) {
        type = Type.SATELLITE;
        pericenter = 19628;
        apocenter = 19644;
        // ecziscenter
        semiMajorAxis = 19636; // calculated manually
        averageOrbitalPeriod = (long) (6.3872301 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = -1;
        rotationPeriod = -1;
        isSynchronized = true;

        aSatelliteOf = pluto;

        equatorialRadius = -1; // diameter: 1212 +- 6
        polarRadius = -1;
        meanRadius = 606; // calculated manually: avg diameter 1212+-6 km
        surfaceArea = 4580000;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\charon.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Харон (Плутон I)";
    }
}