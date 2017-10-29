
# Administration manual
The purpose of this document is to provide an administrator with information how to implement the project and run it in his environment. Administrator Manual guides administrators through the project and ensures satisfying experience. 

Here is information about the software needed to download and play the game Tic Tac Toe.

## Software requirements
* Java 8+
* A tool to run shell scripts (e.g. git bash on Windows, built-in on Linux and macOS)
* Git
* Any web browser

Here is step by step guide on how to run and maintain the project on a fresh machine. 
## How to deploy, run and maintain on a fresh machine
1. To clone the repository, enter "git clone git@github.com:FlugfelagidBailAir/TicTacToe.git"
1. To run the web application locally.
	1. Enter command "./gradlew run" or "gradle run".
	1. In any web browser go to "hhtp://localhost:4567"
1. To run the console application locally.
	1. Enter command "gradle toJar" to create a runnable .jar file in the build/libs folder.
1. To deploy the application, simply push any changes onto the master branch of the github repository 
1. The web application is hosted on https://frozen-springs-99760.herokuapp.com/.

Thank you and we hope you will enjoy the experience. 