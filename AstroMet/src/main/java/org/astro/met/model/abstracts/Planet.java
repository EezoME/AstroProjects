package org.astro.met.model.abstracts;

import org.astro.met.DataClass;

import java.util.HashMap;

/**
 * This template represents a planet.
 * Created by Eezo on 28.08.2016.
 */
public abstract class Planet extends PlanetarySystemObject {

    /**
     * The shortest distance between the PSO and the object it orbits of.
     */
    protected long pericenter = -1; // km

    /**
     * The longest distance between the PSO and the object it orbits of.
     * Computable.
     */
    protected long apocenter = -1; // km

    /**
     * The average distance between the PSO and the object it orbits of.
     */
    protected long semiMajorAxis = -1; // km

    /**
     * A parameter that determines the amount by which its orbit around another body deviates from a perfect circle.
     * <br><br> By Wiki
     */
    protected double orbitalEccentricity = -1; // 0..1

    /**
     * The time taken for PSO to make one complete orbit around another object.
     */
    protected long averageOrbitalPeriod = -1; // sec

    /**
     * The speed at which PSO orbits around a more massive body.
     */
    protected double averageOrbitalSpeed = -1; // km/sec

    /**
     * The time that it takes to complete one revolution around its axis of rotation relative to the background stars.
     */
    protected long rotationPeriod = -1; // sec

    /**
     * Other PSO around which this PSO rotates.
     */
    protected PlanetarySystemObject aSatelliteOf = null;

    @Override
    public HashMap<String, String> getObjectInfoMap() {
        HashMap<String, String> ido = super.getObjectInfoMap();

        if (pericenter != -1) {
            ido.put(DataClass.INFO_PERICENTER, DataClass.getDistance(pericenter));
        }
        if (apocenter != -1) {
            ido.put(DataClass.INFO_APOCENTER, DataClass.getDistance(apocenter));
        }
        if (semiMajorAxis != -1) {
            ido.put(DataClass.INFO_SEMI_MAJOR_AXIS, DataClass.getDistance(semiMajorAxis));
        }
        if (orbitalEccentricity != -1) {
            ido.put(DataClass.INFO_ORBITAL_ECCENTRICITY, String.valueOf(orbitalEccentricity));
        }
        if (averageOrbitalPeriod != -1) {
            ido.put(DataClass.INFO_AVERAGE_ORBITAL_PERIOD, DataClass.formatTime(averageOrbitalPeriod));
        }
        if (averageOrbitalSpeed != -1) {
            ido.put(DataClass.INFO_AVERAGE_ORBITAL_SPEED, DataClass.getSpeed(averageOrbitalSpeed));
        }
        if (rotationPeriod != -1) {
            ido.put(DataClass.INFO_ROTATION_PERIOD, DataClass.formatTime(rotationPeriod));
        }
        if (aSatelliteOf != null) {
            ido.put(DataClass.INFO_A_SATELLITE_OF, aSatelliteOf.toString());
        }

        return ido;
    }

    @Override
    public long getDistanceForComputing() {
        return getSemiMajorAxis();
    }


    /**
     * Returns a pericenter of an object (the shortest distance to object it orbits of).<br>
     * Note: if {@code pericenter} is -1, it calculates manually using {@code orbitalEccentricity}.
     *
     * @return a shortest distance to object it orbits of
     */
    public long getPericenter() {
        if (pericenter == -1) {
            return (long) (semiMajorAxis * (1 - orbitalEccentricity));
        }
        return pericenter;
    }

    /**
     * Note: you can set the <code>semiMajorAxis</code> and <code>orbitalEccentricity</code> instead of this.
     *
     * @param pericenter a shortest distance to object it orbits of
     */
    protected void setPericenter(long pericenter) {
        this.pericenter = pericenter;
    }

    /**
     * Returns a apocenter of an object (the longest distance to object it orbits of).<br>
     * Note: if {@code apocenter} is -1, it calculates manually using {@code orbitalEccentricity}.
     *
     * @return a longest distance to object it orbits of
     */
    public long getApocenter() {
        if (apocenter == -1) {
            return (long) (semiMajorAxis * (1 + orbitalEccentricity));
        }
        return apocenter;
    }

    /**
     * Note: you can set the <code>semiMajorAxis</code> and <code>orbitalEccentricity</code> instead of this.
     *
     * @param apocenter a longest distance to object it orbits of
     */
    protected void setApocenter(long apocenter) {
        this.apocenter = apocenter;
    }

    /**
     * Returns an average distance to object it orbits of.<br>
     * Note: if {@code semiMajorAxis} is -1, it calculates manually as average between {@code pericenter} and {@code apocenter}.
     * <br> NOTE: this value is equal to distance for computing.
     *
     * @return average distance to object it orbits of
     */
    public long getSemiMajorAxis() {
        if (semiMajorAxis == -1) {
            return (pericenter + apocenter) / 2;
        }
        return semiMajorAxis;
    }

    /**
     * Note: you can set the <code>apocenter</code> and <code>pericenter</code> instead of this.
     *
     * @param semiMajorAxis average distance to object it orbits of
     */
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

    public PlanetarySystemObject getaSatelliteOf() {
        return aSatelliteOf;
    }

    protected void setaSatelliteOf(PlanetarySystemObject aSatelliteOf) {
        this.aSatelliteOf = aSatelliteOf;
    }

    @Override
    public String toString() {
        return "Unnamed Planet";
    }
}
