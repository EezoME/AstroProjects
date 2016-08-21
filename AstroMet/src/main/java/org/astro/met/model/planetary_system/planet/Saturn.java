package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.saturn.*;

import java.util.ArrayList;

/**
 * This class represents a model of planet Saturn (Solar System).
 * Created by Eezo on 20.08.2016.
 */
public final class Saturn extends PlanetarySystemObject {
    public Saturn(Sun sun) {
        type = Type.PLANET;
        pericenter = 1353572956; // 9.048 au
        apocenter = 1513325783; // 10.116 au
        semiMajorAxis = 1433449370; // 9.582 au
        averageOrbitalPeriod = (long) (10759.22 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 9.69;
        aSatelliteOf = sun;

        equatorialRadius = 60268; // +- 4
        polarRadius = 54364; // +- 10
        meanRadius = 58232; // +- 6
        satellites = new ArrayList<>(); // 62
        satellites.add(new Mimas(this));
        satellites.add(new Enceladus(this));
        satellites.add(new Tephys(this));
        satellites.add(new Dione(this));
        satellites.add(new Rhea(this));
        satellites.add(new Titan(this));
        satellites.add(new Japetus(this));
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Сатурн";
    }
}
