package org.astro.met.model.planetary_system.dwarf_planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.Charon;

import java.util.ArrayList;

/**
 * This class represents a model of dwarf planet Pluto (Solar System, Kuiper Belt).
 * Created by Eezo on 19.08.2016.
 */
public final class Pluto extends PlanetarySystemObject {
    public Pluto(Sun sun) {
        type = Type.DWARF_PLANET;
        pericenter = (long) (29.667 * DataClass.AU_COEFF);
        apocenter = (long) (49.31 * DataClass.AU_COEFF);
        semiMajorAxis = (long) (39.482117 * DataClass.AU_COEFF);
        averageOrbitalPeriod = (long) (90553.02 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 4.6691;
        aSatelliteOf = sun;

        equatorialRadius = -1; //dimensions: 2374 +- 8
        polarRadius = -1;
        meanRadius = 1187; // +- 4
        satellites = new ArrayList<>(); // 5
        satellites.add(new Charon(this));
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Плутон";
    }
}
