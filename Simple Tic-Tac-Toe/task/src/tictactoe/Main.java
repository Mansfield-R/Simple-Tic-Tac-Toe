package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final String[] validNumbers = new String[] {"1", "2","3","4","5","6","7","8","9"};

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Create the empty game board:
        String[][] ticTacToeBoard = createBoard();
        // Display the game:
        displayBoard(ticTacToeBoard);
        // Play the game
        enterMoves(ticTacToeBoard);
    }

    private static void enterMoves(String[][] ticTacToeBoard) {
        
        int player = 0;

        boolean gameIsOver = false;

        while (!gameIsOver) {
            System.out.print("Enter the coordinates: ");
            scanner.useDelimiter("\n");
            String coordinates = scanner.next();
            String[] userInput = coordinates.split(" ");
            int[] coordinateArray = Arrays.stream(coordinates.split(" ")).mapToInt(Integer::parseInt).toArray();

            // If contains numbers:
            if (!Arrays.asList(validNumbers).contains(userInput[0]) && !Arrays.asList(validNumbers).contains(userInput[1]) ) {
                System.out.println("You should enter numbers!");
                Arrays.fill(userInput, null);
            } else if ((Arrays.asList(validNumbers).contains(userInput[0])
                    && (coordinateArray[0] < 1
                    || coordinateArray[0] > 3))
                    || (Arrays.asList(validNumbers).contains(userInput[1])
                    && (coordinateArray[1] < 1
                    || coordinateArray[1] > 3))) {
                System.out.println("Coordinates should be from 1 to 3!");
                Arrays.fill(userInput, null);
            } else if (!ticTacToeBoard[Integer.parseInt(userInput[0]) - 1][Integer.parseInt(userInput[1]) - 1].equals("_")) {
                System.out.println("This cell is occupied! Choose another one!");
                Arrays.fill(userInput, null);
            } else {
                // Loop to determine which player plays:
                if (player % 2 == 0) {
                    ticTacToeBoard[Integer.parseInt(userInput[0]) - 1][Integer.parseInt(userInput[1]) - 1] = "X";
                } else {
                    ticTacToeBoard[Integer.parseInt(userInput[0]) - 1][Integer.parseInt(userInput[1]) - 1] = "O";

                }
                player++;
                displayBoard(ticTacToeBoard);
                gameIsOver = analyzeBoard(ticTacToeBoard);
            }
        }
    }

    private static String[][] createBoard() {

        String[][] ticTacToeBoard = new String[3][3];
        for (String[] strings : ticTacToeBoard) {
            Arrays.fill(strings, "_");
        }
        return ticTacToeBoard;
    }

    private static boolean analyzeBoard(String[][] ticTacToeBoard) {

        boolean gameIsOver = false;

        int xWins = countTimesXWon(ticTacToeBoard);
        int oWins = countTimesOWon(ticTacToeBoard);
        int numberOfXs = countX(ticTacToeBoard);
        int numberOfOs = countO(ticTacToeBoard);
        int emptySpaces = countSpace(ticTacToeBoard);

        if (xWins == 1 && oWins == 0) {
            gameIsOver = true;
            System.out.println("X wins");
        } else if (oWins == 1 && xWins == 0) {
            gameIsOver = true;
            System.out.println("O wins");
        } else if (xWins == 0 && oWins == 0 && emptySpaces > 0) {
            gameIsOver = false;
        } else if (xWins == 0 && oWins == 0) {
            gameIsOver = true;
            System.out.println("Draw");
        }

        return gameIsOver;

    }

    private static int countSpace(String[][] ticTacToeBoard) {
        int numOfSpace = 0;
        for (int r = 0; r < ticTacToeBoard.length; r++) {
            for (int c = 0; c < ticTacToeBoard[r].length; c++) {
                if (ticTacToeBoard[r][c].equals(" ") || ticTacToeBoard[r][c].equals("_")) {
                    numOfSpace++;
                }
            }
        }
        return numOfSpace;

    }

    private static int countO(String[][] ticTacToeBoard) {
        int numOfOs = 0;
        for (int r = 0; r < ticTacToeBoard.length; r++) {
            for (int c = 0; c < ticTacToeBoard[r].length; c++) {
                if (ticTacToeBoard[r][c].equals("O")) {
                    numOfOs++;
                }
            }
        }
        return numOfOs;
    }

    private static int countX(String[][] ticTacToeBoard) {
        int numOfXs = 0;
        for (int r = 0; r < ticTacToeBoard.length; r++) {
            for (int c = 0; c < ticTacToeBoard[r].length; c++) {
                if (ticTacToeBoard[r][c].equals("X")) {
                    numOfXs++;
                }
            }
        }
        return numOfXs;
    }

    private static void displayBoard(String[][] ticTacToeBoard) {
        System.out.println("---------");
        System.out.print("| " + ticTacToeBoard[0][0] + " " + ticTacToeBoard[0][1] + " " + ticTacToeBoard[0][2] + " |\n");
        System.out.print("| " + ticTacToeBoard[1][0] + " " + ticTacToeBoard[1][1] + " " + ticTacToeBoard[1][2]+ " |\n");
        System.out.print("| " + ticTacToeBoard[2][0] + " " + ticTacToeBoard[2][1] + " " + ticTacToeBoard[2][2] + " |\n");
        System.out.println("---------");
    }

    private static int countTimesOWon(String[][] ticTacToeBoard) {
        int timesOWon = 0;
        // First Row Condition:
        if (ticTacToeBoard[0][0].equals("O") && ticTacToeBoard[0][1].equals("O") && ticTacToeBoard[0][2].equals("O")) {
            timesOWon++;
        }
        // Second Row Condition:
        if (ticTacToeBoard[1][0].equals("O") && ticTacToeBoard[1][1].equals("O") && ticTacToeBoard[1][2].equals("O")) {
            timesOWon++;
        }
        // Third Row Condition:
        if (ticTacToeBoard[2][0].equals("O") && ticTacToeBoard[2][1].equals("O") && ticTacToeBoard[2][2].equals("O")) {
            timesOWon++;
        }
        // First Column Condition:
        if (ticTacToeBoard[0][0].equals("O") && ticTacToeBoard[1][0].equals("O") && ticTacToeBoard[2][0].equals("O")) {
            timesOWon++;
        }
        // Second Column Condition:
        if (ticTacToeBoard[0][1].equals("O") && ticTacToeBoard[1][1].equals("O") && ticTacToeBoard[2][1].equals("O")) {
            timesOWon++;
        }
        // Third Column Condition:
        if (ticTacToeBoard[0][2].equals("O") && ticTacToeBoard[1][2].equals("O") && ticTacToeBoard[2][2].equals("O")) {
            timesOWon++;
        }
        // 1st Diagonal Condition:
        if (ticTacToeBoard[0][0].equals("O") && ticTacToeBoard[1][1].equals("O") && ticTacToeBoard[2][2].equals("O")) {
            timesOWon++;
        }
        // 2nd Diagonal Condition:
        if (ticTacToeBoard[2][0].equals("O") && ticTacToeBoard[1][1].equals("O") && ticTacToeBoard[0][2].equals("O")) {
            timesOWon++;
        }
        return timesOWon;
    }

    private static int countTimesXWon(String[][] ticTacToeBoard) {
        int timesXWon = 0;
        // First Row Condition:
        if (ticTacToeBoard[0][0].equals("X") && ticTacToeBoard[0][1].equals("X") && ticTacToeBoard[0][2].equals("X")) {
            timesXWon++;
        }
        // Second Row Condition:
        if (ticTacToeBoard[1][0].equals("X") && ticTacToeBoard[1][1].equals("X") && ticTacToeBoard[1][2].equals("X")) {
            timesXWon++;
        }
        // Third Row Condition:
        if (ticTacToeBoard[2][0].equals("X") && ticTacToeBoard[2][1].equals("X") && ticTacToeBoard[2][2].equals("X")) {
            timesXWon++;
        }
        // First Column Condition:
        if (ticTacToeBoard[0][0].equals("X") && ticTacToeBoard[1][0].equals("X") && ticTacToeBoard[2][0].equals("X")) {
            timesXWon++;
        }
        // Second Column Condition:
        if (ticTacToeBoard[0][1].equals("X") && ticTacToeBoard[1][1].equals("X") && ticTacToeBoard[2][1].equals("X")) {
            timesXWon++;
        }
        // Third Column Condition:
        if (ticTacToeBoard[0][2].equals("X") && ticTacToeBoard[1][2].equals("X") && ticTacToeBoard[2][2].equals("X")) {
            timesXWon++;
        }
        // 1st Diagonal Condition:
        if (ticTacToeBoard[0][0].equals("X") && ticTacToeBoard[1][1].equals("X") && ticTacToeBoard[2][2].equals("X")) {
            timesXWon++;
        }
        // 2nd Diagonal Condition:
        if (ticTacToeBoard[2][0].equals("X") && ticTacToeBoard[1][1].equals("X") && ticTacToeBoard[0][2].equals("X")) {
            timesXWon++;
        }
        return timesXWon;
    }

}
