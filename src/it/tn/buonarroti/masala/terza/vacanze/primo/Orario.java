package it.tn.buonarroti.masala.terza.vacanze.primo;

import lombok.Getter;
import lombok.Setter;

public class Orario {
    @Getter
    @Setter
    private int hours;
    @Getter
    @Setter
    private int minutes;
    @Getter
    @Setter
    private int seconds;

    public Orario() {
        hours = java.time.LocalTime.now().getHour();
        minutes = java.time.LocalTime.now().getMinute();
        seconds = java.time.LocalTime.now().getSecond();
    }

    public int HoursAfterMidnight() {
        int totaltime;
        totaltime = hours;
        return totaltime;
    }

    public int MinutesAfterMidnight() {
        int totaltime;
        totaltime = (hours * 60) + minutes;

        return totaltime;
    }

    public int printSecondsAfterMidnight() {
        int totaltime;
        totaltime = (this.MinutesAfterMidnight() * 60) + seconds;

        return totaltime;
    }


}
