package org.astro.met.model.abstracts;


import java.util.ArrayList;
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

    /**
     * Returns a full list of all planetary system objects in a system (including stars).
     *
     * @return a list of PSOs
     */
    public List<PlanetarySystemObject> getPSOs() {
        List<PlanetarySystemObject> list = new ArrayList<>();
        list.addAll(stars);
        list.addAll(stars.get(0).satellites);
        return list;
    }

    /**
     * Checks the current list and its sublists for the presence of the code that match to a given code.
     * @param psoList current list of PSOs
     * @param code given code
     * @return {@link PlanetarySystemObject} if match was found, null - otherwise
     */
    public PlanetarySystemObject getPSOByCode(List<PlanetarySystemObject> psoList, int code) {
        if (psoList == null) {
            psoList = getPSOs();
        }
        for (int i = 0; i < psoList.size(); i++) {
            if (psoList.get(i).code == code) {
                return psoList.get(i);
            }
            try {
                if (psoList.get(i).getSatellites() == null) {
                    continue;
                }
            } catch (UnsupportedOperationException e){
                continue;
            }
            if (getPSOByCode(psoList.get(i).getSatellites(), code) != null) {
                return getPSOByCode(psoList.get(i).getSatellites(), code);
            }
        }
        return null;
    }


    public List<Star> getStars() {
        return stars;
    }

    protected void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Unnamed Planetary System";
    }
}
