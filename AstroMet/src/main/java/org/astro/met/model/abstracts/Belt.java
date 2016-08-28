package org.astro.met.model.abstracts;


import org.astro.met.DataClass;

import java.util.HashMap;
import java.util.List;

/**
 * This abstract class represents an PSO like belt or cloud.
 * Created by Eezo on 19.08.2016.
 */
public abstract class Belt extends PlanetarySystemObject {

    /**
     * Name of belt or cloud.
     */
    protected String title = "";

    /**
     * Distance between PS star and inner border of belt or cloud (km).
     */
    protected long innerRadius = -1;

    /**
     * Distance between PS star and outer border of belt of cloud (km).
     */
    protected long outerRadius = -1;

    /**
     * A list of PSO than belong to this belt or cloud.
     */
    protected List<PlanetarySystemObject> innerObjects = null;

    public Belt() {
        type = Type.BELT;
    }

    @Override
    public HashMap<String, String> getObjectInfoMap() {
        HashMap<String, String> ido = super.getObjectInfoMap();

        if (title != null && !title.isEmpty()){
            ido.put(DataClass.INFO_TITLE, title);
        }
        if (innerRadius != -1){
            ido.put(DataClass.INFO_INNER_RADIUS, DataClass.getDigitIdents(innerRadius) + " км");
        }
        if (outerRadius != -1){
            ido.put(DataClass.INFO_OUTER_RADIUS, DataClass.getDigitIdents(outerRadius) + " км");
        }

        return ido;
    }
    /**
     * @return name of belt or cloud
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title name of belt or cloud
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return distance between PS star and inner border of belt or cloud (km)
     */
    public long getInnerRadius() {
        return innerRadius;
    }

    /**
     * @param innerRadius distance between PS star and inner border of belt or cloud (km)
     */
    public void setInnerRadius(long innerRadius) {
        this.innerRadius = innerRadius;
    }

    /**
     * @return distance between PS star and outer border of belt or cloud (km)
     */
    public long getOuterRadius() {
        return outerRadius;
    }

    /**
     * @param outerRadius distance between PS star and outer border of belt or cloud (km)
     */
    public void setOuterRadius(long outerRadius) {
        this.outerRadius = outerRadius;
    }

    /**
     * @return a list of PSO than belong to this belt or cloud
     */
    public List<PlanetarySystemObject> getInnerObjects() {
        return innerObjects;
    }

    /**
     * @param innerObjects a list of PSO than belong to this belt or cloud
     */
    public void setInnerObjects(List<PlanetarySystemObject> innerObjects) {
        this.innerObjects = innerObjects;
    }

    @Override
    public String toString() {
        return "Unnamed Belt";
    }

    // NOT SUPPORTED FIELDS

    @Override
    public double getEquatorialRadius() {
        throw new UnsupportedOperationException("Field 'equatorialRadius' is not supported for that type of PSO.");
    }

    @Override
    public void setEquatorialRadius(double equatorialRadius) {
        throw new UnsupportedOperationException("Field 'equatorialRadius' is not supported for that type of PSO.");
    }

    @Override
    public double getPolarRadius() {
        throw new UnsupportedOperationException("Field 'polarRadius' is not supported for that type of PSO.");
    }

    @Override
    public void setPolarRadius(double polarRadius) {
        throw new UnsupportedOperationException("Field 'polarRadius' is not supported for that type of PSO.");
    }

    @Override
    public double getMeanRadius() {
        throw new UnsupportedOperationException("Field 'meanRadius' is not supported for that type of PSO.");
    }

    @Override
    public void setMeanRadius(double meanRadius) {
        throw new UnsupportedOperationException("Field 'meanRadius' is not supported for that type of PSO.");
    }

    @Override
    public List<PlanetarySystemObject> getSatellites() {
        throw new UnsupportedOperationException("Field 'satellites' is not supported for that type of PSO.");
    }

    @Override
    public void setSatellites(List<PlanetarySystemObject> satellites) {
        throw new UnsupportedOperationException("Field 'satellites' is not supported for that type of PSO.");
    }
}
