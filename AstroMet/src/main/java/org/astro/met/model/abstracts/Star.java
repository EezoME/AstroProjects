package org.astro.met.model.abstracts;

import java.util.List;

/**
 * This abstract class represents PS star.
 * Created by Eezo on 19.08.2016.
 */
public abstract class Star extends PlanetarySystemObject {

    /**
     * Distance form the center of the galaxy to the PS star (km).
     */
    protected long distanceFromTheCenterOfTheGalaxy; // km

    /**
     * Distance form the galactic pole to the PS star (km).
     */
    protected long distanceFromTheGalacticPlane; // km

    public Star() {
        type = Type.STAR;
        pericenter = -2;
        apocenter = -2;
        semiMajorAxis = -2;
        averageOrbitalPeriod = -2;
        averageOrbitalSpeed = -2;
        aSatelliteOf = null;

        equatorialRadius = -2;
        polarRadius = -2;
    }

    public long[] getDistancesToSSO() {
        List<PlanetarySystemObject> satellites = getSatellites();
        if (satellites == null || satellites.size() == 0) {
            return null;
        }
        long[] distances = new long[satellites.size()];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = satellites.get(i).semiMajorAxis;
        }
        return distances;
    }

    public long getDistanceFromTheCenterOfTheGalaxy() {
        return distanceFromTheCenterOfTheGalaxy;
    }

    public void setDistanceFromTheCenterOfTheGalaxy(long distanceFromTheCenterOfTheGalaxy) {
        this.distanceFromTheCenterOfTheGalaxy = distanceFromTheCenterOfTheGalaxy;
    }

    public long getDistanceFromTheGalacticPlane() {
        return distanceFromTheGalacticPlane;
    }

    public void setDistanceFromTheGalacticPlane(long distanceFromTheGalacticPlane) {
        this.distanceFromTheGalacticPlane = distanceFromTheGalacticPlane;
    }

    @Override
    public String toString() {
        return "Unnamed Star";
    }

    // NOT SUPPORTED FIELDS

    @Override
    public long getPericenter() {
        throw new UnsupportedOperationException("Field 'pericenter' is not supported for that type of SSO.");
    }

    @Override
    public void setPericenter(long pericenter) {
        throw new UnsupportedOperationException("Field 'pericenter' is not supported for that type of SSO.");
    }

    @Override
    public long getApocenter() {
        throw new UnsupportedOperationException("Field 'apocenter' is not supported for that type of SSO.");
    }

    @Override
    public void setApocenter(long apocenter) {
        throw new UnsupportedOperationException("Field 'apocenter' is not supported for that type of SSO.");
    }

    @Override
    public long getSemiMajorAxis() {
        throw new UnsupportedOperationException("Field 'semiMajorAxis' is not supported for that type of SSO.");
    }

    @Override
    public void setSemiMajorAxis(long semiMajorAxis) {
        throw new UnsupportedOperationException("Field 'semiMajorAxis' is not supported for that type of SSO.");
    }

    @Override
    public long getAverageOrbitalPeriod() {
        throw new UnsupportedOperationException("Field 'averageOrbitalPeriod' is not supported for that type of SSO.");
    }

    @Override
    public void setAverageOrbitalPeriod(long averageOrbitalPeriod) {
        throw new UnsupportedOperationException("Field 'averageOrbitalPeriod' is not supported for that type of SSO.");
    }

    @Override
    public double getAverageOrbitalSpeed() {
        throw new UnsupportedOperationException("Field 'averageOrbitalSpeed' is not supported for that type of SSO.");
    }

    @Override
    public void setAverageOrbitalSpeed(double averageOrbitalSpeed) {
        throw new UnsupportedOperationException("Field 'averageOrbitalSpeed' is not supported for that type of SSO.");
    }

    @Override
    public PlanetarySystemObject getaSatelliteOf() {
        throw new UnsupportedOperationException("Field 'aSatelliteOf' is not supported for that type of SSO.");
    }

    @Override
    public void setaSatelliteOf(PlanetarySystemObject aSatelliteOf) {
        throw new UnsupportedOperationException("Field 'aSatelliteOf' is not supported for that type of SSO.");
    }

    @Override
    public double getEquatorialRadius() {
        throw new UnsupportedOperationException("Field 'equatorialRadius' is not supported for that type of SSO.");
    }

    @Override
    public void setEquatorialRadius(double equatorialRadius) {
        throw new UnsupportedOperationException("Field 'equatorialRadius' is not supported for that type of SSO.");
    }

    @Override
    public double getPolarRadius() {
        throw new UnsupportedOperationException("Field 'polarRadius' is not supported for that type of SSO.");
    }

    @Override
    public void setPolarRadius(double polarRadius) {
        throw new UnsupportedOperationException("Field 'polarRadius' is not supported for that type of SSO.");
    }

}
