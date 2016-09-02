package org.astro.met;


import org.astro.met.model.abstracts.PlanetarySystemObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains info, constants and help methods for AstroProject.
 * Created by Eezo on 17.08.2016.
 */
public class DataClass {

    // ----------------------
    // | Distance atom - km |
    // | Time atom - sec    |
    // ----------------------


    // PUBLIC CONSTANTS

    /**
     * A number of seconds in a year.
     */
    public final static long YEAR_COEFF = 31557600L;

    /**
     * A number of seconds in a day.
     */
    public final static long DAY_COEFF = 60 * 60 * 24;

    /**
     * A number of seconds in an hour.
     */
    public final static long HOUR_COEFF = 60 * 60;

    /**
     * A number of seconds in a minute.
     */
    public final static long MINUTE_COEFF = 60L;

    /**
     * A basic unit - kilometer.
     */
    public final static long KM_COEFF = 1L;

    /**
     * A number of kilometers in a mile.
     */
    public static final double MILES_COEFF = 1.609345512783376231; // km = 1 mile

    /**
     * A number of kilometers in an astronomical unit.
     */
    public static final double AU_COEFF = 149598011.322; // km = 1 a.u.

    /**
     * A number of kilometers in a parsec.
     */
    public static final double PC_COEFF = 30856804799935.5; // km = 1 pc

    /**
     * A number of square miles in one square kilometer.
     */
    public static final double SQUARE_MILE_COEFF = 0.386102;

    /**
     * Kilometer order number.
     */
    public final static int KM = 0;

    /**
     * Mile order number.
     */
    public final static int MILE = 1;

    /**
     * Astronomic unit order number.
     */
    public final static int AU = 2;

    /**
     * Parsec order number.
     */
    public final static int PC = 3;

    public static final String PATH_TO_IMAGES_FOLDER = "D:\\IntellijProjects-16-08-16\\AstroMet\\src\\main\\resources\\images";

    // DEPRECATED DATA

    static final String[] GALAXIES = {"Млечный Путь"};
    @Deprecated
    static final String[] STAR_SYSTEMS = {"Солнечная система"};
    @Deprecated
    static final String[] SOLAR_SYSTEM_OBJECTS = {"Солнце", "Меркурий", "Венера", "Земля", "Марс", "Пояс астероидов (начало)",
            "Церера", "Пояс астероидов (конец)", "Юпитер", "Сатурн", "Уран", "Нептун", "Пояс Койпера (начало)", "Плутон",
            "Хаумеа", "Макемаке", "Пояс Койпера (конец)", "Эрида", "Облако Оорта"};

    /**
     * This array contains distances between Sun and other Solar System Objects (km).
     */
    @Deprecated
    static final long[] DISTANCES = {
            0L, // Sun
            57909227L, // Mercury
            108208930L, // Venus
            149598261L, // Earth
            227943820L, // Mars
            329100000L, // Asteroid Belt (begin)
            413767000L, // Ceres
            538600000L, // Asteroid Belt (end)
            778547200L, // Jupiter
            1433449370L, // Saturn
            2876679082L, // Uranus
            4503443661L, // Neptune
            4553946490L, // Kuiper Belt (begin)
            5906440634L, // Pluto
            6430452504L, // Haumea
            6797173882L, // Makemake
            8228000000L, // Kuiper Belt (end)
            10139890000L, // Eris
            11219800000000L // Oort cloud
    };

    // --- AstroMet data ---

    /**
     * This array contains description for speeds.
     */
    static final String[] SPEEDS_DESCRIPTION = {"Скорость света (СС)", "Скорость сигнала в кабеле (67% от СС)",
            "Американо-германский солнечный зонд «Гелиос-Б»", "«Пионер-10» на ракете-носителе «Атлас-SLV-3C»",
            "Самый быстрый самолёт", "Скорость звука", "Самай быстрый автомобиль", "Комфортная скорость автомобиля",
            "Рекорд для человека", "Обычная ходьба", "Скорость Джефа",};

    /**
     * This array contains speeds for different objects (km/s).
     */
    static final double[] SPEEDS = {
            299792.458, // speed of light
            200860.94686, // speed of the signal in a cable
            66.666667, // US-German solar probe "Helios-B"
            14.356111111, // "Pioneer-10" on the missile carrier "Atlas SLV-3C"
            3.373, // the fastest plain "Orbital Sciences Corporation Х-34"
            0.34029, // speed of sound
            0.123056, // the fastest car "SSC Ultimate Aero 6.3 V8"
            0.025, // comfortable car speed
            0.0122, // the fastest human
            0.001389, // normal walking speed
            7494.811 // Jefa speed
    };

    // ------------------

    // UNITS

    /**
     * String representation of units of distance (relative to constants KM | MILE | AU | PC).
     */
    static final String[] UNITS_DESCRIPTION = {"километры", "мили", "а.е.", "парсеки"};

    /**
     * An array of unit coefficients.
     * Relative to {@code UNITS_DESCRIPTION}.
     */
    @Deprecated
    public static final double[] UNITS = {
            1, // km
            MILES_COEFF,
            AU_COEFF,
            PC_COEFF
    };

    // METHODS

    /**
     * Returns a correct distance depending on the unit of distance.
     *
     * @param c    distance in kilometers
     * @param unit a unit of distance (one of KM | MILE | AU | PC)
     * @return correct distance representation
     */
    public static String formatDistance(long c, int unit) {
        if (c <= 0) {
            return "объекты идентичны";
        }
        if (unit == KM) {
            return getDigitIdents(c) + " км";
        }
        if (unit == MILE) {
            return getDigitIdents((int) (c / MILES_COEFF)) + " М";
        }
        if (unit == AU) {
            return (c / AU_COEFF) + " а.е.";
        }
        if (unit == PC) {
            return (c / PC_COEFF) + " пс";
        }
        return "-unknown unit-";
    }

    /**
     * Converts number of seconds in full-correct time readable form.
     *
     * @param seconds number of seconds
     * @return readable time representation
     */
    public static String formatTime(long seconds) {
        if (seconds <= 0) {
            return "0 с";
        }
        // 1 m = 60 s
        // 1 h == 60 m = 3600 s
        // 1 d == 24 h == 1440 m = 86400 s
        // 1 y == 365 d == 8760 h == 525600 m = 31536000 s
        String time = "";
        if (seconds >= YEAR_COEFF) {
            int i = (int) (seconds / YEAR_COEFF);
            time += i + " " + getRightDeclensionFor(i, YEAR) + " ";
            seconds -= i * YEAR_COEFF;
        }
        if (seconds >= DAY_COEFF) {
            int i = (int) (seconds / DAY_COEFF);
            time += i + " " + getRightDeclensionFor(i, DAY) + " ";
            seconds -= i * DAY_COEFF;
        }
        if (seconds >= HOUR_COEFF) {
            int i = (int) (seconds / HOUR_COEFF);
            time += i + " " + getRightDeclensionFor(i, HOUR) + " ";
            seconds -= i * HOUR_COEFF;
        }
        if (seconds >= MINUTE_COEFF) {
            int i = (int) (seconds / MINUTE_COEFF);
            time += i + " мин ";
            seconds -= i * MINUTE_COEFF;
        }
        if (seconds > 0) {
            time += seconds + " сек";
        }
        return time;
    }

    /**
     * Returns a string representation of surface area with spaces between digit groups (3 digit per group).
     *
     * @param distance a long number of distance
     * @return formatted number with correct unit
     */
    public static String getDistance(long distance) {
        return getDistance((double)distance);
    }

    /**
     * Returns a string representation of surface area with spaces between digit groups (3 digit per group).
     *
     * @param distance a double number of distance
     * @return formatted number with correct unit
     */
    public static String getDistance(double distance) {
        String stringDistance = getDigitIdents(distance / MainMetering.defaultUnit);
        if (MainMetering.defaultUnit == KM_COEFF) {
            return stringDistance + " км";
        } else {
            return stringDistance + " М";
        }
    }

    /**
     * Returns a string representation of speed.
     *
     * @param kmPerSeconds a double number of speed
     * @return formatted number with correct unit
     */
    public static String getSpeed(double kmPerSeconds) {
        if (MainMetering.defaultUnit == KM_COEFF) {
            return getRoundedDouble(kmPerSeconds) + " км/с";
        } else {
            double milesPerSeconds = kmPerSeconds / MILES_COEFF;
            return getRoundedDouble(milesPerSeconds) + " М/с";
        }
    }

    /**
     * Returns a string representation of surface area with spaces between digit groups (3 digit per group).
     *
     * @param area a long number of surface area
     * @return formatted number with correct unit
     */
    public static String getSurfaceArea(long area) {
        String stringDistance = "<html>";
        if (MainMetering.defaultUnit == KM_COEFF) {
            stringDistance += getDigitIdents(area);
            return stringDistance + " км<sup>2</sup>";
        } else {
            stringDistance += getDigitIdents((long) (area * SQUARE_MILE_COEFF));
            return stringDistance + " М<sup>2</sup>";
        }
    }

    /**
     * Returns a string represent of long number with spaces between digit groups (3 digit per group).
     *
     * @param number a long number
     * @return formatted number
     */
    public static String getDigitIdents(long number) {
        String stringNumber = String.valueOf(number);
        int pos = stringNumber.length() - 1;
        int counter = 0;
        while (pos >= 0) {
            if (stringNumber.charAt(pos) >= 48 && stringNumber.charAt(pos) <= 57) {
                counter++;
            }
            if (counter == 3) {
                String st1 = stringNumber.substring(0, pos);
                String st2 = stringNumber.substring(pos);
                stringNumber = st1 + " " + st2;
                counter = 0;
            }
            pos--;
        }
        return stringNumber;
    }

    /**
     * Returns a string represent of double number (rounded to 3 dig.) with spaces between digit groups (3 digit per group).
     *
     * @param number a double number
     * @return formatted number
     */
    public static String getDigitIdents(double number) {
        number = getRoundedDouble(number);
        String stringNumber = String.valueOf(number);
        int pos = stringNumber.indexOf('.');
        if (pos == -1) {
            pos = stringNumber.length() - 1;
        }
        String decimals = stringNumber.substring(pos);
        String digits = stringNumber.substring(0, pos);
        return getDigitIdents(Long.valueOf(digits)) + decimals;
    }

    /**
     * Makes a list of planetary system objects.
     *
     * @param objects a scroll of PSOs
     * @return a list of PSOs
     */
    public static List<PlanetarySystemObject> makeAList(PlanetarySystemObject... objects) {
        if (objects == null || objects.length == 0) {
            return null;
        }
        List<PlanetarySystemObject> list = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            list.add(objects[i]);
        }
        return list;
    }

    // PRIVATE METHODS

    private static final int YEAR = 1;
    private static final int DAY = 2;
    private static final int HOUR = 3;

    /**
     * Returns a unit of time in correct form.
     *
     * @param number a number to find out a correct form
     * @param unit   a unit of time
     * @return a unit of time in correct form (string representation)
     */
    private static String getRightDeclensionFor(int number, int unit) {
        while (number >= 100) {
            number -= 100;
        }
        if (number % 10 == 1 && number != 11) {
            if (unit == YEAR) {
                return "год";
            } else if (unit == DAY) {
                return "день";
            } else if (unit == HOUR) {
                return "час";
            } else {
                return "wrong unit type";
            }
        } else if (number % 10 == 2 && number != 12 || number % 10 == 3 && number != 13 || number % 10 == 4 && number != 14) {
            if (unit == YEAR) {
                return "года";
            } else if (unit == DAY) {
                return "дня";
            } else if (unit == HOUR) {
                return "часа";
            } else {
                return "wrong unit type";
            }
        } else {
            if (unit == YEAR) {
                return "лет";
            } else if (unit == DAY) {
                return "дней";
            } else if (unit == HOUR) {
                return "часов";
            } else {
                return "wrong unit type";
            }
        }
    }

    /**
     * Return a rounded double number (to 3 decimal).
     *
     * @param number a number to be rounded
     * @return rounded number
     */
    private static double getRoundedDouble(double number) {
        // by default it rounds to 3 decimal
        number = Math.round(number * 1000);
        return number / 1000;
    }

    // STRING REPRESENTATIONS OF INFORMATION ITEMS

    public static final String INFO_OBJECT_TYPE = "Тип: ";
    public static final String INFO_EQUATORIAL_RADIUS = "Экваториальный радиус: ";
    public static final String INFO_POLAR_RADIUS = "Полярный радиус: ";
    public static final String INFO_MEAN_RADIUS = "Средний радиус: ";
    public static final String INFO_SURFACE_AREA = "Площадь: ";
    public static final String INFO_PERICENTER = "Перицентр: ";
    public static final String INFO_APOCENTER = "Апоцентр: ";
    public static final String INFO_SEMI_MAJOR_AXIS = "Большая полуось: ";
    public static final String INFO_ORBITAL_ECCENTRICITY = "Эксцентриситет орбиты: ";
    public static final String INFO_AVERAGE_ORBITAL_PERIOD = "Сидерический период обращения: ";
    public static final String INFO_AVERAGE_ORBITAL_SPEED = "Орбитальная скорость: ";
    public static final String INFO_ROTATION_PERIOD = "Период вращения: ";
    public static final String INFO_A_SATELLITE_OF = "Вращается вокруг: ";
    public static final String INFO_HABITAT_AREA = "Находится в: ";
    public static final String INFO_DIMENSIONS = "Размеры: ";
    public static final String INFO_TITLE = "Название: ";
    public static final String INFO_INNER_RADIUS = "Внутрений радиус: ";
    public static final String INFO_OUTER_RADIUS = "Внешний радиус: ";
    public static final String INFO_DISTANCE_FROM_THE_CENTER_OF_THE_GALAXY = "Расстояние от центра галактики: ";
    public static final String INFO_DISTANCE_FROM_THE_GALACTIC_PLANE = "Расстояние от плоскости галактики: ";


    // CODES FOR PSOs

    public static final int SUN = 0;

    public static final int MERCURY = 1;
    public static final int VENUS = 2;
    public static final int EARTH = 3;
    public static final int MARS = 4;
    public static final int JUPITER = 5;
    public static final int SARUTN = 6;
    public static final int URANUS = 7;
    public static final int NEPTUNE = 8;

    public static final int CERES = 9;
    public static final int PLUTO = 10;
    public static final int HAUMEA = 11;
    public static final int MAKEMAKE = 12;
    public static final int ERIS = 13;

    public static final int ASTEROID_BELT = 20;
    public static final int KUIPER_BELT = 21;
    public static final int OORT_CLOUD = 22;

    public static final int MOON = 30;
    public static final int PHOBOS = 31;
    public static final int DEIMOS = 32;
    public static final int CALLISTO = 33;
    public static final int EUROPA = 34;
    public static final int GANYMEDE = 35;
    public static final int IO = 36;
    public static final int DIONE = 37;
    public static final int ENCELADUS = 38;
    public static final int JAPETUS = 39;
    public static final int MIMAS = 40;
    public static final int RHEA = 41;
    public static final int TEPHYS = 42;
    public static final int TITAN = 43;
    public static final int ARIEL = 44;
    public static final int MIRANDA = 45;
    public static final int OBERON = 46;
    public static final int TITANIA = 47;
    public static final int UMBRIEL = 46;
    public static final int NEREID = 49;
    public static final int TRITON = 50;
    public static final int CHARON = 51;
}
