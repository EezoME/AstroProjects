package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.jupiter.Callisto;
import org.astro.met.model.planetary_system.satellite.jupiter.Europa;
import org.astro.met.model.planetary_system.satellite.jupiter.Ganymede;
import org.astro.met.model.planetary_system.satellite.jupiter.Io;

import java.util.ArrayList;

/**
 * This class represents a model of planet Jupiter (Solar System).
 * Created by Eezo on 20.08.2016.
 */
public final class Jupiter extends PlanetarySystemObject {
    public Jupiter(Sun sun) {
        type = Type.PLANET;
        pericenter = (long) (4.950429 * DataClass.AU_COEFF); // 7.405736*10^8 km
        apocenter = (long) (5.458104 * DataClass.AU_COEFF); // 8.165208*10^8 km
        semiMajorAxis = (long) (7.785472 * DataClass.AU_COEFF); // 7.785472*10^8 km
        averageOrbitalPeriod = (long) (4332.589 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 13.07;
        aSatelliteOf = sun;

        equatorialRadius = 71492.0; // +- 4
        polarRadius = 66854.0; // +- 10
        meanRadius = 69911.0; // +- 6
        satellites = new ArrayList<>(); // 67
        satellites.add(new Io(this));
        satellites.add(new Europa(this));
        satellites.add(new Ganymede(this));
        satellites.add(new Callisto(this));
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Юпитер";
    }
}
