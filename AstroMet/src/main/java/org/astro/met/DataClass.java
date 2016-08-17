package org.astro.met;

/**
 * Created by Eezo on 17.08.2016.
 */
public class DataClass {

    // OBJECTS

    public static final String[] GALAXIES = {"Млечный Путь"};
    public static final String[] STAR_SYSTEMS = {"Солнечная система"};
    public static final String[] SOLAR_SYSTEM_OBJECTS = {"Солнце", "Меркурий", "Венера", "Земля", "Марс", "Пояс астероидов (начало)",
            "Церера", "Пояс астероидов (конец)", "Юпитер", "Сатурн", "Уран", "Нептун", "Пояс Койпера (начало)", "Плутон",
            "Хаумеа", "Макемаке", "Пояс Койпера (конец)", "Эрида", "Облако Оорта"};

    // distance atom - km
    /**
     * This array contains distances between Sun and other Solar System Objects (km)
     */
    public static final long[] DISTANCES = {
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

    public static final String[] SPEEDS_DESCRIPTION = {"Скорость света", "Самый быстрый самолёт", "Скорость ракеты",
            "Скорость звука", "Самая быстрый автомобиль", "Комфортная скорость автомобиля", "Рекорд для человека",
            "Обычная ходьба", "Скорость Джефа",};
    /**
     * This array contains speeds for different objects (km/s).
     */
    public static final double[] SPEEDS = {
            299792.458, // speed of light
            3.373, // the fastest plain "Orbital Sciences Corporation Х-34"
            1.5914361, // the fastest rocket
            0.34029, // speed of sound
            0.123056, // the fastest car "SSC Ultimate Aero 6.3 V8"
            0.025, // comfortable car speed
            0.0122, // the fastest human
            0.001389, // normal walking speed
            7494.811 // Jefa speed
    };

    // UNITS

    public static final String[] UNITS_DESCRIPTION = {"км", "мили", "а.е.", "парсеки"};

    public static final double MILES_COEFF = 1.609345512783376231; // km = 1 mile
    public static final double AU_COEFF = 149598011.322; // km = 1 a.u.
    public static final double PC_COEFF = 30856804799935.5; // km = 1 pc

    public static final double[] UNITS = {
            1, // km
            MILES_COEFF,
            AU_COEFF,
            PC_COEFF
    };

    // METHODS

    public static String formatDistance(long c, int index){
        if (c <= 0){
            return "объекты идентичны";
        }
        if (index == 0){
            return c+" km";
        }
        if (index == 1){
            return (int)(c/MILES_COEFF)+" mile(s)";
        }
        if (index == 2){
            return (c/AU_COEFF)+" a.u.";
        }
        if (index == 3){
            return (c/PC_COEFF)+" pc";
        }
        return "-unknown unit-";
    }

    public static String formatSeconds(long s) {
        if (s <= 0) {
            return "0 s";
        }
        // 1 m = 60 s
        // 1 h == 60 m = 3600 s
        // 1 d == 24 h == 1440 m = 86400 s
        // 1 y == 365 d == 8760 h == 525600 m = 31536000 s
        String time = "";
        if (s >= 31536000L) {
            int i = (int) (s / 31536000L);
            time += i + " year(s) ";
            s -= i * 31536000L;
        }
        if (s >= 86400) {
            int i = (int) (s / 86400);
            time += i + " day(s) ";
            s -= i * 86400;
        }
        if (s >= 3600) {
            int i = (int) (s / 3600);
            time += i + " hrs ";
            s -= i * 3600;
        }
        if (s >= 60) {
            int i = (int) (s / 60);
            time += i + " min ";
            s -= i * 60;
        }
        if (s > 0) {
            time += s + " sec";
        }
        return time;
    }

}