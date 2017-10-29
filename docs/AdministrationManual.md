
# Administration manual
The following manual gives you both information about the software needed to download and play the game Tic Tac Toe as well as step-by-step instructions to do so.

## Software requirements
* Java 8+
* A tool to run shell scripts (e.g. git bash on Windows, built-in on Linux and macOS)
* Git
* Any web browser

## How to deploy, run and maintain on a fresh machine
1. To clone the repository, enter "git clone git@github.com:FlugfelagidBailAir/TicTacToe.git"
1. To run the web application locally.
	1. Enter command "./gradlew run" or "gradle run".
	1. In any web browser go to "hhtp://localhost:4567"
1. To run the console application locally.
	1. Enter command "gradle toJar" to create a runnable .jar file in the build/libs folder.
1. To deploy the application, simply push any changes onto the master branch of the github repository 
1. The web application is hosted on https://frozen-springs-99760.herokuapp.com/.

ToDo:
How to set it up and get it to run, also on a
fresh machine. How to install and run the program on clients machine
(in case of simple desktop program). How to deploy, run and maintain
in case of client/server or web application.
