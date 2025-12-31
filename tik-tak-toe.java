 // Import Scanner class to take input from the user
import java.util.Scanner;

// Main class of the program
public class TicTacToe {

    // 2D character array to represent the 3x3 game board
    // ' ' (space) means the cell is empty
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    // Variable to store current player ('X' or 'O')
    // Game starts with player X
    static char currentPlayer = 'X';

    // Main method – program execution starts from here
    public static void main(String[] args) {

        // Scanner object to read input from keyboard
        Scanner sc = new Scanner(System.in);

        // Boolean variable to control the game loop
        // false means game is still running
        boolean gameOver = false;

        // Loop runs until the game is over (win or draw)
        while (!gameOver) {

            // Display the current state of the board
            printBoard();

            // Ask the current player for row and column
            System.out.println("Player " + currentPlayer +
                    ", enter row (1-3) and column (1-3): ");

            // Take row input and convert it to array index (0-2)
            int row = sc.nextInt() - 1;

            // Take column input and convert it to array index (0-2)
            int col = sc.nextInt() - 1;

            // Check if the selected cell is empty
            if (board[row][col] == ' ') {

                // Place the current player's symbol in the selected cell
                board[row][col] = currentPlayer;

                // Check if the current player has won
                if (checkWin()) {

                    // Print final board
                    printBoard();

                    // Display winning message
                    System.out.println("🎉 Player " + currentPlayer + " wins!");

                    // End the game
                    gameOver = true;

                }
                // Check if the game is a draw (board full, no winner)
                else if (checkDraw()) {

                    // Print final board
                    printBoard();

                    // Display draw message
                    System.out.println("😐 It's a draw!");

                    // End the game
                    gameOver = true;

                }
                // If no win or draw, switch the player
                else {

                    // Change player: X becomes O, O becomes X
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
            // If the selected cell is already occupied
            else {

                // Show error message and ask to try again
                System.out.println("❌ Cell already occupied. Try again.");
            }
        }

        // Close the scanner to free system resources
        sc.close();
    }

    // Method to print the Tic Tac Toe board
    static void printBoard() {

        // Print a new line for better formatting
        System.out.println();

        // Loop through each row
        for (int i = 0; i < 3; i++) {

            // Print the row with vertical separators
            System.out.println(" " + board[i][0] + " | " +
                               board[i][1] + " | " +
                               board[i][2]);

            // Print horizontal separator after each row except last
            if (i < 2)
                System.out.println("---|---|---");
        }

        // Print a new line after board
        System.out.println();
    }

    // Method to check if the current player has won
    static boolean checkWin() {

        // Check all rows and columns
        for (int i = 0; i < 3; i++) {

            // Check row win
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

            // Check column win
            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        // Check left diagonal win
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        // Check right diagonal win
        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        // Return false if no winning condition is met
        return false;
    }

    // Method to check if the game is a draw
    static boolean checkDraw() {

        // Loop through all cells of the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If any cell is empty, game is not a draw
                if (board[i][j] == ' ')
                    return false;
            }
        }

        // If all cells are filled and no winner, it's a draw
        return true;
    }
}
