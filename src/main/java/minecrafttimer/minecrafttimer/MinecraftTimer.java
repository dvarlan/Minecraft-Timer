package minecrafttimer.minecrafttimer;

import minecrafttimer.minecrafttimer.commands.TimerCommand;
import minecrafttimer.minecrafttimer.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MinecraftTimer extends JavaPlugin {

    private static MinecraftTimer main;
    private Timer timer;

    @Override
    public void onEnable() {
        // Plugin startup logic

        main = this;
        timer = new Timer(false, false, 0);

        Objects.requireNonNull(getCommand("timer")).setExecutor(new TimerCommand());
        Bukkit.getLogger().info("Timer Plugin enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().info("Timer Plugin shutting down!");
    }

    public static MinecraftTimer getMain() {
        return main;
    }

    public Timer getTimer() {
        return timer;
    }
}
