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
    // time atom - sec
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

    public static final String[] SPEEDS_DESCRIPTION = {"Скорость света (СС)", "Скорость сигнала в кабеле (67% от СС)",
            "Самый быстрый самолёт", "Скорость ракеты", "Скорость звука", "Самая быстрый автомобиль",
            "Комфортная скорость автомобиля", "Рекорд для человека", "Обычная ходьба", "Скорость Джефа",};
    /**
     * This array contains speeds for different objects (km/s).
     */
    public static final double[] SPEEDS = {
            299792.458, // speed of light
            200860.94686, // speed of the signal in a cable
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

    public static final String[] UNITS_DESCRIPTION = {"километры", "мили", "а.е.", "парсеки"};

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

    public static String formatDistance(long c, int index) {
        if (c <= 0) {
            return "объекты идентичны";
        }
        if (index == 0) {
            return getDigitIdents(c) + " км";
        }
        if (index == 1) {
            return getDigitIdents((int)(c / MILES_COEFF)) + " М";
        }
        if (index == 2) {
            return (c / AU_COEFF) + " а.е.";
        }
        if (index == 3) {
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
        if (s >= 31536000L) {
            int i = (int) (s / 31536000L);
            time += i + " " + getRightDeclensionFor(i, YEAR) + " ";
            s -= i * 31536000L;
        }
        if (s >= 86400) {
            int i = (int) (s / 86400);
            time += i + " " + getRightDeclensionFor(i, DAY) + " ";
            s -= i * 86400;
        }
        if (s >= 3600) {
            int i = (int) (s / 3600);
            time += i + " " + getRightDeclensionFor(i, HOUR) + " ";
            s -= i * 3600;
        }
        if (s >= 60) {
            int i = (int) (s / 60);
            time += i + " мин ";
            s -= i * 60;
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

    private static String getDigitIdents(long number) {
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
}
