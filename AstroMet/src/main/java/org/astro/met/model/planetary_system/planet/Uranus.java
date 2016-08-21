package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystemObject;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.uranus.*;

import java.util.ArrayList;

/**
 * This class represents a model of planet Uranus (Solar System).
 * Created by Eezo on 20.08.2016.
 */
public final class Uranus extends PlanetarySystemObject {
    public Uranus(Sun sun) {
        type = Type.PLANET;
        pericenter = 2748938461L; // 18.37551863 au
        apocenter = 3004419704L; // 20.08330526 au
        semiMajorAxis = 2876679082L; // 19.22941195 au
        averageOrbitalPeriod = (long) (30685.4 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 6.81;
        aSatelliteOf = sun;

        equatorialRadius = 25559;
        polarRadius = 24973;
        meanRadius = 25362; // +- 7
        satellites = new ArrayList<>(); // 27
        satellites.add(new Miranda(this));
        satellites.add(new Ariel(this));
        satellites.add(new Umbriel(this));
        satellites.add(new Titania(this));
        satellites.add(new Oberon(this));
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Уран";
    }
}
