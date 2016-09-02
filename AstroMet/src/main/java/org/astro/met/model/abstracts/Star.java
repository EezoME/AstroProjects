package org.astro.met.model.abstracts;

import org.astro.met.DataClass;

import java.util.HashMap;
import java.util.List;

/**
 * This abstract class represents PS star.
 * Created by Eezo on 19.08.2016.
 */
public abstract class Star extends PlanetarySystemObject {

    /**
     * Distance form the center of the galaxy to the PS star (km).
     */
    protected long distanceFromTheCenterOfTheGalaxy = -1; // km

    /**
     * Distance form the galactic pole to the PS star (km).
     */
    protected long distanceFromTheGalacticPlane = -1; // km

    public Star() {
        type = Type.STAR;
    }

    @Override
    public HashMap<String, String> getObjectInfoMap() {
        HashMap<String, String> ido = super.getObjectInfoMap();

        if (distanceFromTheCenterOfTheGalaxy != -1){
            ido.put(DataClass.INFO_DISTANCE_FROM_THE_CENTER_OF_THE_GALAXY, DataClass.getDistance(distanceFromTheCenterOfTheGalaxy));
        }
        if (distanceFromTheGalacticPlane != -1){
            ido.put(DataClass.INFO_DISTANCE_FROM_THE_GALACTIC_PLANE, DataClass.getDistance(distanceFromTheGalacticPlane));
        }

        return ido;
    }

    /**
     * Returns an array of distances between star and its PSOs.
     * @return array of distances (in km)
     */
    public long[] getDistancesToSSO() {
        List<PlanetarySystemObject> satellites = getSatellites();
        if (satellites == null || satellites.size() == 0) {
            return null;
        }
        long[] distances = new long[satellites.size()];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = satellites.get(i).getDistanceForComputing();
        }
        return distances;
    }

    public long getDistanceFromTheCenterOfTheGalaxy() {
        return distanceFromTheCenterOfTheGalaxy;
    }

    protected void setDistanceFromTheCenterOfTheGalaxy(long distanceFromTheCenterOfTheGalaxy) {
        this.distanceFromTheCenterOfTheGalaxy = distanceFromTheCenterOfTheGalaxy;
    }

    public long getDistanceFromTheGalacticPlane() {
        return distanceFromTheGalacticPlane;
    }

    protected void setDistanceFromTheGalacticPlane(long distanceFromTheGalacticPlane) {
        this.distanceFromTheGalacticPlane = distanceFromTheGalacticPlane;
    }

    @Override
    public String toString() {
        return "Unnamed Star";
    }
}
