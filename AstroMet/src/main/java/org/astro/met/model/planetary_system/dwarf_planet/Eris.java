package org.astro.met.model.planetary_system.dwarf_planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;

/**
 * This class represents a model of dwarf planet Eris (Solar System, Scattered Disc).
 * Created by Eezo on 20.08.2016.
 */
public final class Eris extends PlanetarySystemObject {
    public Eris(Sun sun) {
        type = Type.DWARF_PLANET;
        pericenter = (long) (37.911 * DataClass.AU_COEFF);
        apocenter = (long) (97.651 * DataClass.AU_COEFF);
        semiMajorAxis = (long) (67.781 * DataClass.AU_COEFF);
        orbitalEccentricity = 0.4415;
        averageOrbitalPeriod = 203830 * DataClass.DAY_COEFF;
        averageOrbitalSpeed = 3.4338;
        rotationPeriod = (long)(25.9 * DataClass.HOUR_COEFF);
        isSynchronized = false;

        aSatelliteOf = sun;

        equatorialRadius = -1;
        polarRadius = -1;
        meanRadius = 1163; // +- 6
        surfaceArea = 17000000; // +- 0.02*10^7 km^2
        satellites = null; // 1, not important for now
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Эрида";
    }
}
