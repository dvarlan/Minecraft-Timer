# Minecraft-Timer
 A simple timer plugin for Minecraft 1.19 that also features a countdown.
 
## Usage / Commands
 
 The timer will be paused until the user starts it with an command like e.g. `/timer resume`.

 - `/timer`: Shows command overview / usage (will be displayed if an invalid timer-command is entered by the user)
 - `/timer resume`: Starts or resumes the timer after it has been paused, reset etc.
 - `/timer pause`: Pauses the timer.
 - `/timer time <time>`: Allows the user to set the time of the timer (The new time value has to be entered in ms).
 - `/timer countdown <time>`: Set a countdown for the time value (The time value has to be entered in ms).
 - `/timer reset`: Resets the current timer to 0.
 
 \
 **Remember:** A running timer will reset if the server is restartet / shut down. You can set it back to the original value with the `/timer time` command.

## Screenshots
Examples of how the timer will look ingame.

![2022-09-14_20 04 54](https://user-images.githubusercontent.com/95964411/190229884-e044757d-cadc-44d4-b010-dc611af2cb43.png) \
\
**The timer**
\
\
![javaw_GtXk3qXFJp](https://user-images.githubusercontent.com/95964411/190231299-15912dea-cf8b-40cd-b852-8fc3dd330de4.png) \
\
**The output of `/timer`**
