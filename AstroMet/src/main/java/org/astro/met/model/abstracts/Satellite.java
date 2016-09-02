package org.astro.met.model.abstracts;

import org.astro.met.DataClass;

import java.util.HashMap;

/**
 * This template represents a satellite.
 * Created by Eezo on 28.08.2016.
 */
public abstract class Satellite extends Planet {

    /**
     * Tidal locking (also called gravitational locking or captured rotation) occurs
     * when, over the course of an orbit, there is no net transfer of angular momentum between
     * an astronomical body and its gravitational partner.
     * Tidal locking results in one hemisphere of the revolving object constantly facing its partner,
     * an effect known as synchronous rotation.
     * <br><br><i>by Wiki</i>
     */
    protected boolean isSynchronized = false;

    /**
     * This field show objects dimensions if object is not rounded.
     */
    protected String dimensions; // kms

    @Override
    public HashMap<String, String> getObjectInfoMap() {
        HashMap<String, String> ido = super.getObjectInfoMap();

        if (isSynchronized) {
            if (ido.replace(DataClass.INFO_ROTATION_PERIOD, "синхронизирован") == null){
                ido.put(DataClass.INFO_ROTATION_PERIOD, "синхронизирован");
            }
        }
        if (dimensions != null && dimensions.length() != 0){
            ido.put(DataClass.INFO_DIMENSIONS, dimensions + " км");
        }

        return ido;
    }


    public boolean isSynchronized() {
        return isSynchronized;
    }

    protected void setSynchronized(boolean aSynchronized) {
        isSynchronized = aSynchronized;
    }

    public String getDimensions() {
        return dimensions;
    }

    protected void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Unnamed Satellite";
    }
}
