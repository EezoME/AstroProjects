package org.astro.met.model.abstracts;

import org.astro.met.DataClass;

import java.util.HashMap;

/**
 * This template represents a dwarf planet.
 * Created by Eezo on 28.08.2016.
 */
public abstract class DwarfPlanet extends Planet {

    /**
     * This field indicates dwarf planet habitat area.
     */
    protected PlanetarySystemObject habitatArea = null;

    @Override
    public HashMap<String, String> getObjectInfoMap() {
        HashMap<String, String> ido = super.getObjectInfoMap();

        if (habitatArea != null){
            ido.put(DataClass.INFO_HABITAT_AREA, habitatArea.toString());
        }

        return ido;
    }


    public PlanetarySystemObject getHabitatArea() {
        return habitatArea;
    }

    protected void setHabitatArea(PlanetarySystemObject habitatArea) {
        this.habitatArea = habitatArea;
    }

    @Override
    public String toString() {
        return "Unnamed Dwarf Planet";
    }
}
