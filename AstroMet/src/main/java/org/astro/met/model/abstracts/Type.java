package org.astro.met.model.abstracts;

/**
 * This enumeration contains PSO types like planet, dwarf planet, satellite,
 * comet, asteroid, belt and other.
 * Created by Eezo on 19.08.2016.
 */
public enum Type {
    STAR {
        @Override
        public String getRussianDescription() {
            return "звезда";
        }
    },
    PLANET {
        @Override
        public String getRussianDescription() {
            return "планета";
        }
    },
    DWARF_PLANET {
        @Override
        public String getRussianDescription() {
            return "карликовая планета";
        }
    },
    SATELLITE {
        @Override
        public String getRussianDescription() {
            return "спутник";
        }
    },
    COMET {
        @Override
        public String getRussianDescription() {
            return "комета";
        }
    },
    ASTEROID {
        @Override
        public String getRussianDescription() {
            return "астероид";
        }
    },
    BELT {
        @Override
        public String getRussianDescription() {
            return "пояс";
        }
    },
    OTHER {
        @Override
        public String getRussianDescription() {
            return "другое";
        }
    },;

    /**
     * Returns a description of type in Russian.
     * @return description in Russian
     */
    public abstract String getRussianDescription();
}
