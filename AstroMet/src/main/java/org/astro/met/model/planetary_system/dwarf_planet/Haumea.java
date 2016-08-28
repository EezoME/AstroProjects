package org.astro.met.model.planetary_system.dwarf_planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.DwarfPlanet;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;


/**
 * This class represents a model of dwarf planet Haumea (Solar System, Kuiper Belt).
 * Created by Eezo on 20.08.2016.
 */
public final class Haumea extends DwarfPlanet {
    public Haumea(Sun sun) {
        type = Type.DWARF_PLANET;
        pericenter = (long) (34.494401 * DataClass.AU_COEFF);
        apocenter = (long) (51.475447 * DataClass.AU_COEFF);
        semiMajorAxis = (long) (42.98492 * DataClass.AU_COEFF);
        orbitalEccentricity = 0.1902;
        averageOrbitalPeriod = 102937 * DataClass.DAY_COEFF;
        averageOrbitalSpeed = 4.484;
        rotationPeriod = (long)(3.9154 * DataClass.HOUR_COEFF); // +- 0.0001 h

        aSatelliteOf = sun;

        equatorialRadius = -1; // 1960x1518x996 km (~1400 km)
        polarRadius = -1;
        meanRadius = 718; // avg diameter 1300
        surfaceArea = 20000000; // approximately
        satellites = null; // 2, not important for now

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\haumea.jpg";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Хаумеа";
    }
}
