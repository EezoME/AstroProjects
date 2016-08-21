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
     * The time taken for PSO to make one complete orbit around another object.
     */
    protected long averageOrbitalPeriod; // sec
    /**
     * The speed at which PSO orbits around a more massive body.
     */
    protected double averageOrbitalSpeed; // km/sec
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
     * The list of natural objects that orbit around PSO.
     */
    protected List<PlanetarySystemObject> satellites;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getPericenter() {
        return pericenter;
    }

    public void setPericenter(long pericenter) {
        this.pericenter = pericenter;
    }

    public long getApocenter() {
        return apocenter;
    }

    public void setApocenter(long apocenter) {
        this.apocenter = apocenter;
    }

    public long getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(long semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public long getAverageOrbitalPeriod() {
        return averageOrbitalPeriod;
    }

    public void setAverageOrbitalPeriod(long averageOrbitalPeriod) {
        this.averageOrbitalPeriod = averageOrbitalPeriod;
    }

    public double getAverageOrbitalSpeed() {
        return averageOrbitalSpeed;
    }

    public void setAverageOrbitalSpeed(double averageOrbitalSpeed) {
        this.averageOrbitalSpeed = averageOrbitalSpeed;
    }

    public PlanetarySystemObject getaSatelliteOf() {
        return aSatelliteOf;
    }

    public void setaSatelliteOf(PlanetarySystemObject aSatelliteOf) {
        this.aSatelliteOf = aSatelliteOf;
    }

    public double getEquatorialRadius() {
        return equatorialRadius;
    }

    public void setEquatorialRadius(double equatorialRadius) {
        this.equatorialRadius = equatorialRadius;
    }

    public double getPolarRadius() {
        return polarRadius;
    }

    public void setPolarRadius(double polarRadius) {
        this.polarRadius = polarRadius;
    }

    public double getMeanRadius() {
        return meanRadius;
    }

    public void setMeanRadius(double meanRadius) {
        this.meanRadius = meanRadius;
    }

    public List<PlanetarySystemObject> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<PlanetarySystemObject> satellites) {
        this.satellites = satellites;
    }

    @Override
    public String toString() {
        return "Unnamed Planetary System Object";
    }
}
