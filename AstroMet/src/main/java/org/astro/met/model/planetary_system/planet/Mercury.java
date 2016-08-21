package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;

/**
 * This class represents a model of planet Mercury (Solar System).
 * Created by Eezo on 19.08.2016.
 */
public final class Mercury extends PlanetarySystemObject {
    public Mercury(Sun sun) {
        type = Type.PLANET;
        pericenter = 46001009; // 0.30749951 au
        apocenter = 69817445; // 0.46670079 au
        semiMajorAxis = 57909227; // 0.38709927 au
        averageOrbitalPeriod = (long) (87.969 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 47.36;
        aSatelliteOf = sun;

        equatorialRadius = 2439.7;
        polarRadius = 2439.7;
        meanRadius = 2439.7; // +- 1
        satellites = null; // No one known satellite
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Меркурий";
    }
}
