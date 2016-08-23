package org.astro.met.model.planetary_system;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Belt;
import org.astro.met.model.abstracts.PlanetarySystemObject;

import java.util.List;

/**
 * This class represents an Oort cloud
 * Created by Eezo on 19.08.2016.
 */
public final class OortCloud extends Belt {
    public OortCloud(List<PlanetarySystemObject> innerObjects) {
        super();
        title = "Облако Оорта";
        innerRadius = (long) (50000 * DataClass.AU_COEFF); // approximately
        outerRadius = (long) (100000 * DataClass.AU_COEFF); // approximately
        this.innerObjects = innerObjects;

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\oort_cloud.png";
    }

    @Override
    public String toString() {
        return "Облако Оорта";
    }
}
