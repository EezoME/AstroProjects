package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;

/**
 * This class represents a model of planet Venus (Solar System).
 * Created by Eezo on 19.08.2016.
 */
public final class Venus extends PlanetarySystemObject {
    public Venus(Sun sun) {
        type = Type.PLANET;
        pericenter = 107476259; // 0.71843270 au
        apocenter = 108942109; // 0.72823128 au
        semiMajorAxis = 108208930; // 0.723332 au
        orbitalEccentricity = 0.007;
        averageOrbitalPeriod = (long) (224.698 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 35.02;
        rotationPeriod = (long)(243.023 * DataClass.DAY_COEFF); // +- 0.002 d
        isSynchronized = false;

        aSatelliteOf = sun;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 6051.8; // +- 1.0
        surfaceArea = 460000000;
        satellites = null; // No one known satellite

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\venus.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Венера";
    }
}
