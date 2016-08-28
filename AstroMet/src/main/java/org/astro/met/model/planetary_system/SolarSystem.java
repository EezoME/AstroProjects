package org.astro.met.model.planetary_system;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.PlanetarySystem;

import java.util.ArrayList;

/**
 * This class represents our PS - Solar System.
 * Created by Eezo on 19.08.2016.
 */
public final class SolarSystem extends PlanetarySystem {
    public SolarSystem() {
        stars = new ArrayList<>();
        stars.add(new Sun());

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\solar_system.jpg";
    }

    @Override
    public String toString() {
        return "Солнечная система";
    }
}
