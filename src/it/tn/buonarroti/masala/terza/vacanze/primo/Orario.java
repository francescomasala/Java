package it.tn.buonarroti.masala.terza.vacanze.primo;

public class Orario {
    private final int hours;
    private final int minutes;
    private final int seconds;

    public Orario() {
        hours = java.time.LocalTime.now().getHour();
        minutes = java.time.LocalTime.now().getMinute();
        seconds = java.time.LocalTime.now().getSecond();
    }

    public int HoursAfterMidnight() {
        int totaltime = hours;

        return totaltime;
    }

    public int MinutesAfterMidnight() {
        int totaltime = (hours * 60) + minutes;

        return totaltime;
    }

    public int printSecondsAfterMidnight() {
        int totaltime = this.MinutesAfterMidnight() + seconds;

        return totaltime;
    }


}
