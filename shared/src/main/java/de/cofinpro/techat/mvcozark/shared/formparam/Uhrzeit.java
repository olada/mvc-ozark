package de.cofinpro.techat.mvcozark.shared.formparam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by David Olah on 22.11.2017.
 */
public class Uhrzeit {
    private LocalTime time;

    public Uhrzeit(String string) {
        this.time = LocalTime.parse(string, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Uhrzeit{" +
                "time=" + time +
                '}';
    }
}
