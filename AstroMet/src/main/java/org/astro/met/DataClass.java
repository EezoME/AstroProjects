package org.astro.met;


import org.astro.met.model.abstracts.PlanetarySystemObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains info for GUI v1.0 and some constants and help methods.
 * Created by Eezo on 17.08.2016.
 */
public class DataClass {

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
    public final static long MINUTE_COEFF = 60;

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

    public static final String PATH_TO_IMAGES_FOLDER = "D:\\IntellijProjects-16-08-16\\AstroMet\\src\\main\\resources\\images";

    // OBJECTS

    static final String[] GALAXIES = {"Млечный Путь"};
    static final String[] STAR_SYSTEMS = {"Солнечная система"};
    static final String[] SOLAR_SYSTEM_OBJECTS = {"Солнце", "Меркурий", "Венера", "Земля", "Марс", "Пояс астероидов (начало)",
            "Церера", "Пояс астероидов (конец)", "Юпитер", "Сатурн", "Уран", "Нептун", "Пояс Койпера (начало)", "Плутон",
            "Хаумеа", "Макемаке", "Пояс Койпера (конец)", "Эрида", "Облако Оорта"};

    // distance atom - km
    // time atom - sec
    /**
     * This array contains distances between Sun and other Solar System Objects (km)
     */
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

    // SPEEDS (km/s)

    /**
     * This array contains description for speeds.
     */
    static final String[] SPEEDS_DESCRIPTION = {"Скорость света (СС)", "Скорость сигнала в кабеле (67% от СС)",
            "Американо-германский солнечный зонд «Гелиос-Б»", "«Пионер-10» на ракете-носителе «Атлас-SLV-3C»",
            "Самый быстрый самолёт", "Скорость звука", "Самая быстрый автомобиль", "Комфортная скорость автомобиля",
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

    // UNITS

    static final String[] UNITS_DESCRIPTION = {"километры", "мили", "а.е.", "парсеки"};


    public static final double[] UNITS = {
            1, // km
            MILES_COEFF,
            AU_COEFF,
            PC_COEFF
    };

    // METHODS
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

    public static String formatTime(long s) {
        if (s <= 0) {
            return "0 с";
        }
        // 1 m = 60 s
        // 1 h == 60 m = 3600 s
        // 1 d == 24 h == 1440 m = 86400 s
        // 1 y == 365 d == 8760 h == 525600 m = 31536000 s
        String time = "";
        if (s >= YEAR_COEFF) {
            int i = (int) (s / YEAR_COEFF);
            time += i + " " + getRightDeclensionFor(i, YEAR) + " ";
            s -= i * YEAR_COEFF;
        }
        if (s >= DAY_COEFF) {
            int i = (int) (s / DAY_COEFF);
            time += i + " " + getRightDeclensionFor(i, DAY) + " ";
            s -= i * DAY_COEFF;
        }
        if (s >= HOUR_COEFF) {
            int i = (int) (s / HOUR_COEFF);
            time += i + " " + getRightDeclensionFor(i, HOUR) + " ";
            s -= i * HOUR_COEFF;
        }
        if (s >= MINUTE_COEFF) {
            int i = (int) (s / MINUTE_COEFF);
            time += i + " мин ";
            s -= i * MINUTE_COEFF;
        }
        if (s > 0) {
            time += s + " сек";
        }
        return time;
    }

    // units
    private static final int YEAR = 1;
    private static final int DAY = 2;
    private static final int HOUR = 3;

    static String getRightDeclensionFor(int number, int unit) {
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

    static String getDigitIdents(long number) {
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

    static String getDigitIdents(double number) {
        String stringNumber = String.valueOf(number);
        int pos = stringNumber.indexOf('.');
        if (pos == -1) {
            pos = stringNumber.length() - 1;
        }
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

    public static List<PlanetarySystemObject> makeAList(PlanetarySystemObject... objects){
        if (objects == null || objects.length == 0){
            return null;
        }
        List<PlanetarySystemObject> list = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            list.add(objects[i]);
        }
        return list;
    }

}
