package youtubeCourse.ExerciseAndUdemy.Arrays;

import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[3][3];
        System.out.println("Let's play tic tac toe");

        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }

        printBoard(board);
        takeTurn(board, scanner);

    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
}

    public static void takeTurn(char[][] arrayParam, Scanner scanner) {
        for (int i = 0; i < 9; i++) {
            System.out.println("Round: " + i);
            if (i % 2 == 0) {
                int row = askUserForRow(scanner);
                int column = askUserForColumn(scanner);
                while (arrayParam[row][column] == 'X' || arrayParam[row][column] == 'O') {
                    System.out.println("there is X or O already");
                    row = askUserForRow(scanner);
                    column = askUserForColumn(scanner);

                }
                arrayParam[row][column] = 'X';
                printBoard(arrayParam);
            }
            else {
                int row = askUserForRow(scanner);
                int column = askUserForColumn(scanner);
                while (arrayParam[row][column] == 'X' || arrayParam[row][column] == 'O') {
                    System.out.println("there is X or O already");
                    row = askUserForRow(scanner);
                    column = askUserForColumn(scanner);
                }
                arrayParam[row][column] = 'O';

                printBoard(arrayParam);

            }

            if (checkRows(arrayParam)) {
                if (i % 2 == 0) {
                    System.out.println("PLAYER WITH X WINS !!");
                    break;
                }
                else {
                    System.out.println("PLAYER WITH O WINS !!");
                    break;
                }
            }

            if (checkColumns(arrayParam)) {
                if (i % 2 == 0) {
                    System.out.println("PLAYER WITH X WINS !!");
                    break;
                }
                else {
                    System.out.println("PLAYER WITH O WINS !!");
                    break;
                }
            }

            if (checkLeft(arrayParam)) {
                if (i % 2 == 0) {
                    System.out.println("PLAYER WITH X WINS !!");
                    break;
                }
                else {
                    System.out.println("PLAYER WITH O WINS !!");
                    break;
                }
            }

            if (checkRight(arrayParam)) {
                if (i % 2 == 0) {
                    System.out.println("PLAYER WITH X WINS !!");
                    break;
                }
                else {
                    System.out.println("PLAYER WITH O WINS !!");
                    break;
                }
            }



        }
        if (!checkRight(arrayParam)) {
            if (!checkLeft(arrayParam)) {
                if (!checkColumns(arrayParam)) {
                    if (!checkRows(arrayParam)) {
                        System.out.println("It's a TIE !");
                    }
                }
            }
        }

    }

    public static int askUserForRow ( Scanner scanner) {
        System.out.println("Pick a row and column");
        System.out.print("row: ");
        return scanner.nextInt();
    }
    public static int askUserForColumn(Scanner scanner) {
        System.out.print("column: ");
        return scanner.nextInt();
    }


    /**
     * method name checkRows
     * method is checking if there are 3 X's or O's in a row
     * @param board two-dimensional char array
     * @return boolean
     */
    public static boolean checkRows(char[][] board) {
        int count = 0;
        boolean trueOrFalse = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count += 1;
                    if (count == 3) {
                        trueOrFalse = true;
                    }
                }
                else {
                    count = 0;
                }
            }
        }

        return trueOrFalse;
    }

    /**
     * method name checkColumns
     * method is checking if there are three X's or O's in column
     * @param board two-dimensional char array
     * @return boolean
     */
    public static boolean checkColumns(char[][] board) {
        int count = 0;
        boolean trueOrFalse = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == 'X') {
                    count += 1;
                    if (count == 3) {
                        trueOrFalse = true;
                    }
                }
                else {
                    count = 0;
                }
            }
        }

        return trueOrFalse;
    }

    /**
     * method name checkLeft
     * method is checking the player or computer won with X's or O's diagonally from left to right
     * @param board two-dimensional char array
     * @return boolean
     */
    public static boolean checkLeft(char[][] board) {
        int count = 0;
        boolean trueOrFalse;

        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
                    count = 3;
                    break;
                }
                    }
                }

        if (count == 3) {
            trueOrFalse = true;
        } else {
            trueOrFalse = false;
        }

        return trueOrFalse;
    }

    /**
     * method name checkRight
     * method is checking the player or computer won with X's or O's diagonally from right to left
     * @param board two-dimensional char array
     * @return boolean
     */
    public static boolean checkRight(char[][] board) {
        int count = 0;
        boolean trueOrFalse;

        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
                    count = 3;
                    break;
                }
            }
        }

        if (count == 3) {
            trueOrFalse = true;
        } else {
            trueOrFalse = false;
        }

        return trueOrFalse;
    }





}
