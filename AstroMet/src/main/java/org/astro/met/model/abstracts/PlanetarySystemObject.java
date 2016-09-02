package org.astro.met.model.abstracts;

import org.astro.met.DataClass;

import java.util.HashMap;
import java.util.List;

/**
 * This template represents all planetary system objects (PSO) like planets, satellites, belts etc.
 * By default, distances shows in km, time in seconds.
 * Created by Eezo on 19.08.2016.
 */
public abstract class PlanetarySystemObject {

    /**
     * PSO type.
     */
    protected Type type;

    /**
     * The intersection of the surface of a rotating sphere with the plane that is perpendicular
     * to the sphere's axis of rotation and midway between its poles.
     */
    protected double equatorialRadius = -1; // km

    /**
     * A geographical pole is either of the two points on a planet, dwarf planet or natural satellite,
     * or a "large" rotating body or sphere where the body's axis of rotation intersects its surface.
     */
    protected double polarRadius = -1; // km

    /**
     * The mean radius of PSO.
     */
    protected double meanRadius = -1; // km

    /**
     * The surface of PSO area (km<sup>2</sup>).
     */
    protected long surfaceArea = -1; // km^2

    /**
     * The list of natural objects that orbit around PSO.
     */
    protected List<PlanetarySystemObject> satellites;

    /**
     * Absolute path to the object's image.
     */
    protected String path;

    /**
     * Code for quick search in arrays.
     */
    protected int code;

    /**
     * Make a HashMap with PSO info items in correct form.
     * @return map with info items
     */
    public HashMap<String, String> getObjectInfoMap(){
        HashMap<String, String> ido = new HashMap<>();

        ido.put(DataClass.INFO_TITLE, this.toString());
        /*if (type != null){
            ido.put(DataClass.INFO_OBJECT_TYPE, type.getRussianDescription());
        }*/
        if (equatorialRadius != -1){
            ido.put(DataClass.INFO_EQUATORIAL_RADIUS, DataClass.getDistance(equatorialRadius));
        }
        if (polarRadius != -1){
            ido.put(DataClass.INFO_POLAR_RADIUS, DataClass.getDistance(polarRadius));
        }
        if (meanRadius != -1){
            ido.put(DataClass.INFO_MEAN_RADIUS, DataClass.getDistance(meanRadius));
        }
        if (surfaceArea != -1){
            ido.put(DataClass.INFO_SURFACE_AREA, DataClass.getSurfaceArea(surfaceArea));
        }

        return ido;
    }

    /**
     * This is a general method returns a distance between an object and other objects which it orbits around of.
     * @return a distance in kilometers
     */
    public long getDistanceForComputing(){
        return 0L;
    }


    public Type getType() {
        return type;
    }

    protected void setType(Type type) {
        this.type = type;
    }

    public double getEquatorialRadius() {
        return equatorialRadius;
    }

    protected void setEquatorialRadius(double equatorialRadius) {
        this.equatorialRadius = equatorialRadius;
    }

    public double getPolarRadius() {
        return polarRadius;
    }

    protected void setPolarRadius(double polarRadius) {
        this.polarRadius = polarRadius;
    }

    public double getMeanRadius() {
        return meanRadius;
    }

    protected void setMeanRadius(double meanRadius) {
        this.meanRadius = meanRadius;
    }

    public long getSurfaceArea() {
        return surfaceArea;
    }

    protected void setSurfaceArea(long surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public List<PlanetarySystemObject> getSatellites() {
        return satellites;
    }

    protected void setSatellites(List<PlanetarySystemObject> satellites) {
        this.satellites = satellites;
    }

    public String getPath() {
        return path;
    }

    protected void setPath(String path) {
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Unnamed Planetary System Object";
    }
}
