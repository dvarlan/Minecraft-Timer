package minecrafttimer.minecrafttimer.commands;

import minecrafttimer.minecrafttimer.MinecraftTimer;
import minecrafttimer.minecrafttimer.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimerCommand implements CommandExecutor {
    // Allows the player to manipulate the timer with commands

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check if the entered command is valid / has at least 1 argument
        if (args.length == 0) {
            sendUsage(sender);
            return true;
        }

        // Functionality of the different arguments / timer commands
        switch (args[0].toLowerCase()) {
            case "resume": {

                Timer timer = MinecraftTimer.getMain().getTimer();

                if (timer.isReverse()) {
                    timer = MinecraftTimer.getMain().getTimer();
                    timer.setReverse(true);
                }

                if (timer.isRunning()) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.RED + "Timer already running!");
                    break;
                }

                timer.setRunning(true);
                sender.sendMessage(ChatColor.BLUE + "[Timer] "
                        + ChatColor.GRAY + "Started the timer!");

                break;
            }
            case "pause": {
                Timer timer = MinecraftTimer.getMain().getTimer();

                if (!timer.isRunning()) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.RED + "Timer is paused already!");
                    break;
                }

                timer.setRunning(false);
                sender.sendMessage(ChatColor.BLUE + "[Timer] "
                        + ChatColor.GRAY + "Stopped the timer!");

                break;
            }
            case "time": {
                // Checks if the user specified a new time for the timer
                if (args.length != 2|| args[1].isEmpty()) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.GRAY + "Usage: "
                            + ChatColor.BLUE + "/timer time <time>");
                }

                try {
                    Timer timer = MinecraftTimer.getMain().getTimer();

                    timer.setRunning(false);
                    timer.setTime(Integer.parseInt(args[1]));

                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.GRAY + "Timer was set to: " + args[1] + "!");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.RED + "Your second parameter has to be a number!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.RED + "Your second parameter cannot be empty!");
                }

                break;
            }
            case "countdown": {
                // Checks if the user specified a new time for the countdown
                if (args.length != 2 || args[1].isEmpty()) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.GRAY + "Usage: "
                            + ChatColor.BLUE + "/timer countdown <time>");
                }

                try {
                    Timer timer = MinecraftTimer.getMain().getTimer();

                    timer.setReverse(true);
                    timer.setTime(Integer.parseInt(args[1]));

                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.GRAY + "Countdown was set to: " + args[1] + "!");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.RED + "Your second parameter has to be a number!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    sender.sendMessage(ChatColor.BLUE + "[Timer] "
                            + ChatColor.RED + "Your second parameter cannot be empty!");
                }

                break;
            }
            case "reset": {
                Timer timer = MinecraftTimer.getMain().getTimer();

                timer.setRunning(false);
                timer.setReverse(false);
                timer.setTime(0);

                sender.sendMessage(ChatColor.BLUE + "[Timer] "
                        + ChatColor.GRAY + "Timer has been reset!");

                break;
            }
            default:
                sendUsage(sender);
        }

        return false;
    }

    // Displays the command usage
    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.BLUE + "[Timer] "
                + ChatColor.GRAY + "Usage: "
                + ChatColor.BLUE
                + "/timer resume, /timer pause, /timer time <time>, /timer countdown <time>, /timer reset");
    }
}
