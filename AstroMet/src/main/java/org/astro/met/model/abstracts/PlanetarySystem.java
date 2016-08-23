package org.astro.met.model.abstracts;


import java.util.List;

/**
 * This abstract class represents a planetary system (like our Solar System).
 * Created by Eezo on 19.08.2016.
 */
public abstract class PlanetarySystem {

    /**
     * A list of stars planetary system contains.
     */
    protected List<Star> stars;

    /**
     * A path to image of this object.
     */
    protected String path;

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Unnamed Planetary System";
    }
}
