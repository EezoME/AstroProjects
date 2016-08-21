package org.astro.met.model.planetary_system.dwarf_planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;


/**
 * This class represents a model of dwarf planet Makemake (Solar System, Kuiper Belt).
 * Created by Eezo on 20.08.2016.
 */
public final class Makemake extends PlanetarySystemObject {
    public Makemake(Sun sun) {
        type = Type.DWARF_PLANET;
        pericenter = (long) (38.050866 * DataClass.AU_COEFF);
        apocenter = (long) (52.821736 * DataClass.AU_COEFF);
        semiMajorAxis = (long) (45.436301 * DataClass.AU_COEFF);
        averageOrbitalPeriod = 111867 * DataClass.DAY_COEFF;
        averageOrbitalSpeed = 4.419;
        aSatelliteOf = sun;

        // dimensions: 1478 +- 34
        equatorialRadius = 751; // +- 23
        polarRadius = 715; // +- 5
        meanRadius = 739; // +- 17
        satellites = null; // 1, not important for now
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Макемаке";
    }
}