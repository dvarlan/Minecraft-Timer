package minecrafttimer.minecrafttimer.timer;

public class TimeFormatter {

    // Returns the "time" from the "Time" Class in hours, minutes & seconds

    int time;
    int hours = 0;
    int minutes = 0;
    int seconds = 0;

    public TimeFormatter(int time) {
        this.time = time;
    }

    public int getHours(int time) {
        hours = time / 3600;
        return hours;
    }

    public int getMinutes(int time) {
        time -= hours * 3600;
        minutes = time / 60;
        return minutes;
    }

    public int getSeconds(int time) {
        time -= hours * 3600;
        time -= minutes * 60;
        seconds = time;
        return seconds;
    }
}
