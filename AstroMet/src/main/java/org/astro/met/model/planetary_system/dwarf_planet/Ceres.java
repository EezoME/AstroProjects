package org.astro.met.model.planetary_system.dwarf_planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;


/**
 * This class represents a model of dwarf planet Ceres (Solar System, Asteroid Belt).
 * Created by Eezo on 20.08.2016.
 */
public final class Ceres extends PlanetarySystemObject {
    public Ceres(Sun sun) {
        type = Type.DWARF_PLANET;
        pericenter = (long) (2.5465 * DataClass.AU_COEFF);
        apocenter = (long) (2.9842 * DataClass.AU_COEFF);
        semiMajorAxis = (long) (2.7653 * DataClass.AU_COEFF);
        averageOrbitalPeriod = (long) (1680.5 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 17.882;
        aSatelliteOf = sun;

        equatorialRadius = 481.5;
        polarRadius = 445.5;
        meanRadius = (equatorialRadius + polarRadius) / 2; // value not found
        satellites = null; // No one known satellites
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Церера";
    }
}
