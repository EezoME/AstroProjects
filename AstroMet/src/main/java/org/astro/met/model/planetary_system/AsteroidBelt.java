package org.astro.met.model.planetary_system;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Belt;
import org.astro.met.model.abstracts.PlanetarySystemObject;

import java.util.List;

/**
 * This class represents an Asteroid Belt.
 * Created by Eezo on 19.08.2016.
 */
public final class AsteroidBelt extends Belt {

    public AsteroidBelt(List<PlanetarySystemObject> innerObjects) {
        super();
        title = "Пояс астероидов";
        innerRadius = (long) (2.2 * DataClass.AU_COEFF);
        outerRadius = (long) (3.6 * DataClass.AU_COEFF);
        this.innerObjects = innerObjects;

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\asteroid_belt.png";
        code = DataClass.ASTEROID_BELT;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " астероидов";
    }
}
