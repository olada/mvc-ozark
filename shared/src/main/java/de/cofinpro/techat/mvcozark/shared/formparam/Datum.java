package de.cofinpro.techat.mvcozark.shared.formparam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by David Olah on 22.11.2017.
 */
public class Datum {
    private LocalDate date;

    public Datum(String string) {
        this.date = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "date=" + date +
                '}';
    }
}
