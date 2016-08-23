package org.astro.met.model.abstracts;

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
     * The minimal distance between the PSO and the object around which it rotates.
     * Computable.
     */
    protected long pericenter; // km

    /**
     * The maximal distance between the PSO and the object around which it rotates.
     * Computable.
     */
    protected long apocenter; // km

    /**
     * The average distance between the PSO and the object around which it rotates.
     */
    protected long semiMajorAxis; // km

    /**
     * A parameter that determines the amount by which its orbit around another body deviates from a perfect circle.
     */
    protected double orbitalEccentricity; // 0..1

    /**
     * The time taken for PSO to make one complete orbit around another object.
     */
    protected long averageOrbitalPeriod; // sec

    /**
     * The speed at which PSO orbits around a more massive body.
     */
    protected double averageOrbitalSpeed; // km/sec

    /**
     * The time that it takes to complete one revolution around its axis of rotation relative to the background stars.
     */
    protected long rotationPeriod; // sec

    /**
     * Tidal locking (also called gravitational locking or captured rotation) occurs
     * when, over the course of an orbit, there is no net transfer of angular momentum between
     * an astronomical body and its gravitational partner.
     * Tidal locking results in one hemisphere of the revolving object constantly facing its partner,
     * an effect known as synchronous rotation.
     */
    protected boolean isSynchronized;

    /**
     * Other PSO around which this PSO rotates.
     */
    protected PlanetarySystemObject aSatelliteOf;

    /**
     * The intersection of the surface of a rotating sphere with the plane that is perpendicular
     * to the sphere's axis of rotation and midway between its poles.
     */
    protected double equatorialRadius; // km

    /**
     * A geographical pole is either of the two points on a planet, dwarf planet or natural satellite,
     * or a "large" rotating body or sphere where the body's axis of rotation intersects its surface.
     */
    protected double polarRadius; // km

    /**
     * The mean radius of PSO.
     */
    protected double meanRadius; // km

    /**
     * The surface of PSO area (km^2).
     */
    protected long surfaceArea; // km^2

    /**
     * The list of natural objects that orbit around PSO.
     */
    protected List<PlanetarySystemObject> satellites;

    /**
     * Absolute path to the object's image.
     */
    protected String path;

    public Type getType() {
        return type;
    }

    protected void setType(Type type) {
        this.type = type;
    }

    public long getPericenter() {
        if (pericenter == -1){
            return (long)(semiMajorAxis * (1 - orbitalEccentricity));
        }
        return pericenter;
    }

    protected void setPericenter(long pericenter) {
        this.pericenter = pericenter;
    }

    public long getApocenter() {
        if (apocenter == -1){
            return (long)(semiMajorAxis * (1 + orbitalEccentricity));
        }
        return apocenter;
    }

    protected void setApocenter(long apocenter) {
        this.apocenter = apocenter;
    }

    public long getSemiMajorAxis() {
        return semiMajorAxis;
    }

    protected void setSemiMajorAxis(long semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getOrbitalEccentricity() {
        return orbitalEccentricity;
    }

    protected void setOrbitalEccentricity(double orbitalEccentricity) {
        this.orbitalEccentricity = orbitalEccentricity;
    }

    public long getAverageOrbitalPeriod() {
        return averageOrbitalPeriod;
    }

    protected void setAverageOrbitalPeriod(long averageOrbitalPeriod) {
        this.averageOrbitalPeriod = averageOrbitalPeriod;
    }

    public double getAverageOrbitalSpeed() {
        return averageOrbitalSpeed;
    }

    protected void setAverageOrbitalSpeed(double averageOrbitalSpeed) {
        this.averageOrbitalSpeed = averageOrbitalSpeed;
    }

    public long getRotationPeriod() {
        return rotationPeriod;
    }

    protected void setRotationPeriod(long rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public boolean isSynchronized() {
        return isSynchronized;
    }

    protected void setSynchronized(boolean aSynchronized) {
        isSynchronized = aSynchronized;
    }

    public PlanetarySystemObject getaSatelliteOf() {
        return aSatelliteOf;
    }

    protected void setaSatelliteOf(PlanetarySystemObject aSatelliteOf) {
        this.aSatelliteOf = aSatelliteOf;
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

    @Override
    public String toString() {
        return "Unnamed Planetary System Object";
    }
}
