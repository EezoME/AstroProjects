package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.Deimos;
import org.astro.met.model.planetary_system.satellite.Phobos;

import java.util.ArrayList;

/**
 * This class represents a model of planet Mars (Solar System).
 * Created by Eezo on 20.08.2016.
 */
public final class Mars extends PlanetarySystemObject {
    public Mars(Sun sun) {
        type = Type.PLANET;
        pericenter = (long) (1.381 * DataClass.AU_COEFF); // 2.06655*10^8 km
        apocenter = (long) (1.666 * DataClass.AU_COEFF); // 2.49232*10^8 km
        semiMajorAxis = (long) (1.523662 * DataClass.AU_COEFF); // 2.2794382*10^8 km
        orbitalEccentricity = 0.094;
        averageOrbitalPeriod = (long) (686.98 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 24.13; // 24.077
        rotationPeriod = (long)(24.6229 * DataClass.HOUR_COEFF);
        isSynchronized = false;

        aSatelliteOf = sun;

        equatorialRadius = 3396.2;
        polarRadius = 3376.2;
        meanRadius = 3389.5;
        surfaceArea = 144371391;
        satellites = new ArrayList<>(); // 2
        satellites.add(new Phobos(this));
        satellites.add(new Deimos(this));
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Марс";
    }
}
