package org.astro.met.model.planetary_system;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Belt;
import org.astro.met.model.abstracts.PlanetarySystemObject;

import java.util.List;

/**
 * This class represents an Kuiper Belt.
 * Created by Eezo on 19.08.2016.
 */
public final class KuiperBelt extends Belt {
    public KuiperBelt(List<PlanetarySystemObject> innerObjects) {
        super();
        title = "Пояс Койпера";
        innerRadius = (long) (35 * DataClass.AU_COEFF);
        outerRadius = (long) (48 * DataClass.AU_COEFF);
        this.innerObjects = innerObjects;
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Койпера";
    }
}
