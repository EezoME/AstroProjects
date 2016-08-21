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
        averageOrbitalPeriod = (long) (224.698 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 35.02;
        aSatelliteOf = sun;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 6051.8; // +- 1.0
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Венера";
    }
}
