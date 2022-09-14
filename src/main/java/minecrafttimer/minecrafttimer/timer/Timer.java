package minecrafttimer.minecrafttimer.timer;

import minecrafttimer.minecrafttimer.MinecraftTimer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    // A simple timer for the challenge

    private boolean running;
    private int time;
    private boolean reverse;

    public Timer(boolean running, boolean reverse, int time) {
        // Constructor
        this.running = running;
        this.time = time;
        this.reverse = reverse;

        run();
    }

    // Getter & Setter Methods for the timer
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    // Sends the player the current time / timer status via. the Actionbar
    public void sendActionbar() {

        for (Player player: Bukkit.getOnlinePlayers()) {

            TimeFormatter formatter = new TimeFormatter(time);

            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.BLUE + "[Timer] "
                                + ChatColor.RED + "The timer is currently paused!"));
                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                    new TextComponent(ChatColor.BLUE + "[Timer] "
                            + ChatColor.GOLD + formatter.getHours(getTime())
                            + "h:"
                            + ChatColor.GOLD + formatter.getMinutes(getTime())
                            + "min:"
                            + ChatColor.GOLD + formatter.getSeconds(getTime()) + "sec"));

            // Checks if a countdown hit 0 or not + stops the timer
            if (getTime() < 0) {
                setRunning(false);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.BLUE + "[Timer] "
                                + ChatColor.GOLD + "The timer hit 0!"));
            }

        }

    }

    // Method to run the timer
    private void run() {

        new BukkitRunnable() {

            @Override
            public void run() {

                sendActionbar();

                if (!isRunning()) {
                    return;
                }

                // Check how the timer should behave (normal vs. countdown)
                if (isReverse()) {
                    setTime(getTime() - 1);
                } else {
                    setTime(getTime() + 1);
                }

            }

        }.runTaskTimer(MinecraftTimer.getMain(), 20, 20);

    }
}
