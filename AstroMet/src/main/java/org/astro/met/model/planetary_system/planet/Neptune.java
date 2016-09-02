package org.astro.met.model.planetary_system.planet;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Planet;
import org.astro.met.model.abstracts.Type;
import org.astro.met.model.planetary_system.Sun;
import org.astro.met.model.planetary_system.satellite.neptune.Nereid;
import org.astro.met.model.planetary_system.satellite.neptune.Triton;

import java.util.ArrayList;

/**
 * This class represents a model of planet Neptune (Solar System).
 * Created by Eezo on 20.08.2016.
 */
public final class Neptune extends Planet {
    public Neptune(Sun sun) {
        type = Type.PLANET;
        pericenter = 4452940833L; // 29.76607095 au
        apocenter = 4553946490L; // 30.44125206 au
        semiMajorAxis = 4503443661L; // 30.10366151 au
        orbitalEccentricity = 0.011;
        averageOrbitalPeriod = (long) (60190.03 * DataClass.DAY_COEFF);
        averageOrbitalSpeed = 5.4349;
        rotationPeriod = (long)(0.6653 * DataClass.DAY_COEFF);

        aSatelliteOf = sun;

        equatorialRadius = 24764; // +- 15
        polarRadius = 24341; // +- 30
        meanRadius = 24622; // +- 19
        surfaceArea = 7640800000L;
        satellites = new ArrayList<>(); // 14
        satellites.add(new Triton(this));
        satellites.add(new Nereid(this));

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\neptune.gif";
        code = DataClass.NEPTUNE;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Нептун";
    }
}
