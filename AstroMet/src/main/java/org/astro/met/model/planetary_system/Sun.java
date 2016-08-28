package org.astro.met.model.planetary_system;

import org.astro.met.DataClass;
import org.astro.met.model.abstracts.Star;
import org.astro.met.model.planetary_system.dwarf_planet.*;
import org.astro.met.model.planetary_system.planet.*;

import java.util.ArrayList;

/**
 * This class represents our star - Sun (Milky Way, Solar System).
 * Created by Eezo on 19.08.2016.
 */
public final class Sun extends Star {
    public Sun() {
        super();
        distanceFromTheCenterOfTheGalaxy = (long) (2.5 * Math.pow(10, 17)); // km
        distanceFromTheGalacticPlane = (long) (4.6 * Math.pow(10, 14)); // km
        equatorialRadius = 695510;
        meanRadius = 696000; // 1,392·10^9 m / 2
        surfaceArea = 6078770000000L;
        satellites = new ArrayList<>();
        satellites.add(new Mercury(this));
        satellites.add(new Venus(this));
        satellites.add(new Earth(this));
        satellites.add(new Mars(this));
        Ceres ceres = new Ceres(this);
        satellites.add(new AsteroidBelt(DataClass.makeAList(ceres)));
        satellites.add(ceres);
        satellites.add(new Jupiter(this));
        satellites.add(new Saturn(this));
        satellites.add(new Uranus(this));
        satellites.add(new Neptune(this));
        Pluto pluto = new Pluto(this);
        Haumea haumea = new Haumea(this);
        Makemake makemake = new Makemake(this);
        satellites.add(new KuiperBelt(DataClass.makeAList(pluto, haumea, makemake)));
        satellites.add(pluto);
        satellites.add(haumea);
        satellites.add(makemake);
        satellites.add(new Eris(this));
        satellites.add(new OortCloud(null)); // No one known object for now

        path = DataClass.PATH_TO_IMAGES_FOLDER + "\\sun.gif";
    }

    @Override
    public String toString() {
        return type.getRussianDescription() + " Солнце";
    }
}
