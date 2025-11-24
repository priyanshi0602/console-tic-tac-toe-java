# console-tic-tac-toe-java
Console Tic-Tac-Toe game built in Java with player input validation. Two-player Tic-Tac-Toe game for the command line, featuring win detection and draw checking.
🎮 Console Tic-Tac-Toe Game

A simple, two-player command-line implementation of the classic Tic-Tac-Toe game, built in Java. It features robust input validation, win condition checking, and draw detection.

🚀 How to Run the Game

Prerequisites

Java Development Kit (JDK) 8 or newer installed on your system.

Steps

Clone the Repository (or Download the files):

git clone [https://github.com/priyanshi0602/console-tic-tac-toe-java.git]
cd console-tic-tac-toe


Compile the Code:
Use the Java compiler (javac) to compile the source file.

javac TicTacToe.java


Run the Game:
Execute the compiled class file using the Java runtime (java).

java TicTacToe


🕹️ How to Play

The game prompts the current player to enter their move using two numbers separated by a space: the Row and the Column.

The board is numbered as follows:

Row/Col

1

2

3

1

(1,1)

(1,2)

(1,3)

2

(2,1)

(2,2)

(2,3)

3

(3,1)

(3,2)

(3,3)

Example Move:

To place an 'X' in the center of the board (Row 2, Column 2), you would enter:

Player X, enter your move (row [1-3] and column [1-3], e.g., '1 2'):
2 2


The game automatically switches players between 'X' and 'O' and checks for a win condition (three in a row, column, or diagonal) or a draw.

📁 Project Structure

TicTacToe.java: Contains the complete source code for the game, including board initialization, game loop, input handling, and win logic.

README.md: This file, providing setup and playing instructions.

.gitignore: Specifies files (like compiled .class files) that should not be tracked by Git.

Link to Source Code: TicTacToe.java
