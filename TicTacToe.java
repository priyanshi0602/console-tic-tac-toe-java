import java.util.Scanner;

/**
 * A simple, console-based Tic-Tac-Toe game written in Java.
 * This class contains the main game loop, board handling, and win condition logic.
 */
public class TicTacToe {
    // 3x3 array to represent the game board
    private char[][] board;
    // Current player, starts with 'X'
    private char currentPlayer;
    // Scanner for reading player input
    private Scanner scanner;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
        initializeBoard();
    }

    /**
     * Initializes the 3x3 board with empty spaces represented by ' '.
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Prints the current state of the board to the console, showing row and column numbers.
     */
    private void printBoard() {
        System.out.println("-------------");
        // Print column numbers
        System.out.println("  1 | 2 | 3");
        for (int i = 0; i < 3; i++) {
            // Print row number
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                // Display the content of the cell
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    /**
     * Handles the current player's move, including robust input validation.
     * The player is prompted to enter two numbers (row and column) separated by a space.
     * @return true if the game is over (win or draw), false otherwise.
     */
    public boolean placeMove() {
        int row = -1, col = -1;
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3], e.g., '1 2'):");
            
            // Read the entire line of input
            if (!scanner.hasNextLine()) {
                // If no line is available (e.g., input stream closed), break the loop
                break; 
            }
            String inputLine = scanner.nextLine().trim();
            // Split the input by one or more spaces
            String[] tokens = inputLine.split("\\s+"); 

            if (tokens.length != 2) {
                System.out.println("Invalid format. Please enter exactly two numbers separated by a space (row and column).");
                continue;
            }

            try {
                // Convert 1-based input to 0-based array index
                row = Integer.parseInt(tokens[0]) - 1; 
                col = Integer.parseInt(tokens[1]) - 1; 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Both inputs must be valid integers.");
                continue;
            }

            // 1. Check if the row and column are within bounds (0-2)
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                // 2. Check if the spot is already taken
                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    validMove = true;
                } else {
                    System.out.println("That spot is already taken. Try again.");
                }
            } else {
                System.out.println("Invalid row or column. Must be between 1 and 3.");
            }
        }

        // Check for win or draw after the move is placed
        if (checkForWin()) {
            System.out.println("Player " + currentPlayer + " wins! Congratulations!");
            return true;
        } else if (checkForDraw()) {
            System.out.println("It's a draw! Nobody wins.");
            return true;
        }

        // Switch to the next player
        changePlayer();
        return false;
    }

    /**
     * Switches the current player from 'X' to 'O' or 'O' to 'X'.
     */
    private void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    /**
     * Checks if all spots on the board are filled, resulting in a draw.
     * @return true if the board is full, false otherwise.
     */
    private boolean checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Found an empty spot, not a draw yet
                }
            }
        }
        return true; // All spots are filled
    }

    /**
     * Checks if the current player has won by checking rows, columns, and diagonals.
     * @return true if the current player has won, false otherwise.
     */
    private boolean checkForWin() {
        // Check Rows and Columns
        for (int i = 0; i < 3; i++) {
            // Check Row i: (i,0), (i,1), (i,2)
            if (checkLine(board[i][0], board[i][1], board[i][2])) return true;
            // Check Column i: (0,i), (1,i), (2,i)
            if (checkLine(board[0][i], board[1][i], board[2][i])) return true;
        }

        // Check Diagonals
        // Main diagonal: (0,0), (1,1), (2,2)
        if (checkLine(board[0][0], board[1][1], board[2][2])) return true;
        // Anti-diagonal: (0,2), (1,1), (2,0)
        if (checkLine(board[0][2], board[1][1], board[2][0])) return true;

        return false;
    }

    /**
     * Helper method to check if three spots form a winning line.
     * @param c1 The character at spot 1.
     * @param c2 The character at spot 2.
     * @param c3 The character at spot 3.
     * @return true if all three are the same character and not empty.
     */
    private boolean checkLine(char c1, char c2, char c3) {
        return (c1 != ' ') && (c1 == c2) && (c2 == c3);
    }

    /**
     * The main entry point for the game application.
     */
    public void start() {
        System.out.println("Welcome to Console Tic-Tac-Toe!");
        boolean gameFinished = false;

        while (!gameFinished) {
            printBoard();
            gameFinished = placeMove();
        }

        // Print final board state one last time
        printBoard();
        System.out.println("Game over. Thanks for playing!");
    }

    /**
     * Main method to instantiate and run the game.
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
        // It's good practice to close the scanner when the application ends,
        // although System.in is a special case.
        // game.scanner.close(); 
    }
}