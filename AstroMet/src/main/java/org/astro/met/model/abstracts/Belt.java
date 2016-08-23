package org.astro.met.model.abstracts;


import java.util.List;

/**
 * This abstract class represents an PSO like belt or cloud.
 * Created by Eezo on 19.08.2016.
 */
public abstract class Belt extends PlanetarySystemObject {

    /**
     * Name of belt or cloud.
     */
    protected String title;

    /**
     * Distance between PS star and inner border of belt or cloud (km).
     */
    protected long innerRadius;

    /**
     * Distance between PS star and outer border of belt of cloud (km).
     */
    protected long outerRadius;

    /**
     * A list of PSO than belong to this belt or cloud.
     */
    protected List<PlanetarySystemObject> innerObjects;

    public Belt() {
        type = Type.BELT;
        pericenter = -2;
        apocenter = -2;
        semiMajorAxis = -2;
        averageOrbitalPeriod = -2;
        averageOrbitalSpeed = -2;

        equatorialRadius = -2;
        polarRadius = -2;
        meanRadius = -2;
        satellites = null;
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
    public long getPericenter() {
        throw new UnsupportedOperationException("Field 'pericenter' is not supported for that type of PSO.");
    }

    @Override
    public void setPericenter(long pericenter) {
        throw new UnsupportedOperationException("Field 'pericenter' is not supported for that type of PSO.");
    }

    @Override
    public long getApocenter() {
        throw new UnsupportedOperationException("Field 'apocenter' is not supported for that type of PSO.");
    }

    @Override
    public void setApocenter(long apocenter) {
        throw new UnsupportedOperationException("Field 'apocenter' is not supported for that type of PSO.");
    }

    @Override
    public long getSemiMajorAxis() {
        throw new UnsupportedOperationException("Field 'semiMajorAxis' is not supported for that type of PSO.");
    }

    @Override
    public void setSemiMajorAxis(long semiMajorAxis) {
        throw new UnsupportedOperationException("Field 'semiMajorAxis' is not supported for that type of PSO.");
    }

    @Override
    public long getAverageOrbitalPeriod() {
        throw new UnsupportedOperationException("Field 'averageOrbitalPeriod' is not supported for that type of PSO.");
    }

    @Override
    public void setAverageOrbitalPeriod(long averageOrbitalPeriod) {
        throw new UnsupportedOperationException("Field 'averageOrbitalPeriod' is not supported for that type of PSO.");
    }

    @Override
    public double getAverageOrbitalSpeed() {
        throw new UnsupportedOperationException("Field 'averageOrbitalSpeed' is not supported for that type of PSO.");
    }

    @Override
    public void setAverageOrbitalSpeed(double averageOrbitalSpeed) {
        throw new UnsupportedOperationException("Field 'averageOrbitalSpeed' is not supported for that type of PSO.");
    }

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
