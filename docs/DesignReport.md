# Design Report
## Tic-Tac-Toe

The purpose of this document is to provide a description of the design of the project. First we elaborate the problem that was solved and then we describe the intital design. 

### Summary
In this project we programmed the well known game, Tic Tac Toe and to do so we used the programming language Java coupled with javascript and HTML. Tic Tac Toe is a two player game. The directions are, the first player has the symbol X and the latter player has the symbol O, the first player begins with placing an X into a tile on a 3x3 grid, the second player places an O into the same grid. Those two steps are repeated until the grid is full and there are no rows of the same symbol, which means a tie or either one of the players has a vertical, horizontal or diagonal row of 3 X’s or O’s, which implies a win for that player. As soon as the tiles have been filled with no rows of the same symbol, the game announces a tie, the same goes for if a player manages to fill a row with their symbol, the game announces a win for that player.

## Initial design
Initial design was supported by agile development. Were the infrastructure was built by using several assisting programming environments. Codebase was stored in source control system on GituHub. The system was set up with automatic build script which runs all the unit tests. The external server Heroku was implemented and of course test driven development was used as a good work method. Travis was implemented for automated continuous integration. Branches on github were six in the end and merged into one master. Database and scoreboard was implemented as a bonus features. Focused integration was set by selenium with a external staging server from Heroku. 

Thank you and we hope you will enjoy our program.  
