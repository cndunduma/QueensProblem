package queensproblem;

/**
 * @author Carolina Ndunduma
 */
public class QueensProblem {
    /**
     * @param args the command line arguments
     */
    
    private final int[][] board; //2D array for board
    private final int n; //Number of queens that will determine the board size
    private final int[] col; //Array that stores column number(s)
    private int sol; //Number of solutions

    public QueensProblem(int boardSize) {
        this.n = boardSize; //Sets boardSize with n
        this.board = new int[boardSize][boardSize]; //2D array of the board which is n x n
        this.col = new int[boardSize]; //Number of columns based on n
        this.sol = 0; //Sets number of solutions to 0
    }

    public void solution() {//Calls bactracking() function -1 so that it can start on the first row
        backtracking(-1);
        
        //Prints "no solution" if the number of solutions for n is 0 after tracking it in the backtracking function
        if (sol == 0) {
            System.out.println("No solution");
        }
    }
    
    private void backtracking(int row) {//Recursive function for queen placement
        /*
        *Runs checking function until n is reached for all possible placement options on the board
        */
        if (usable(row)) {//Runs check over board and determines if the last row has been reached
            if (row == n - 1) {
                sol++; //Increments +1 if a solution is found
                printing(); //Printing function if all queens have been placed
            } else {
                for (int i = 0; i < n; i++) {//Loops through each column of row until the last row is reached
                    col[row + 1] = i;
                    backtracking(row + 1); //Recursive call on itself
                }
            }
        }
    }

    
    private boolean usable(int row) {
        /*
        *Nested for loop that checks if a queen conflicts with another queen in the 
        *ith row, the jth column, or diagonal
        */
        for (int i = 0; i <= row; i++) {//Iterates over the rows
            for (int j = i + 1; j <= row; j++) {//Iterates over the columns
                //Checks if a queen is in the same column and row || checks if a queen is diagonal
                if (col[i] == col[j] || Math.abs(col[i] - col[j]) == j - i) {
                    //False is returned if any queens are found, no queen is placed
                    return false;
                }
            }
        }
        //If no queens are found, true is returned and a queen is placed in that position 
        return true;
    }

    /*
    *Printing board
    */
    
    private void printing() {
        for (int i = 0; i < n; i++) {//Looping through rows to find queens
            for (int j = 0; j < n; j++) {//Looping through columns to find queens
                if (col[i] == j) { //Places a 1 if a queen is present
                    board[i][j] = 1;
                } else {//If no queen is present a 0 is placed
                    board[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {//Iterates through rows
            for (int j = 0; j < n; j++) {//Iterates through columns
                System.out.print(board[i][j] + " "); //prints value of row and column
            }
            System.out.println(); //new line
        }
        System.out.println(); //new line to separate boards
    }

    public static void main(String[] args) {
        QueensProblem queensProblem = new QueensProblem(2); //Initializes QueensProblem class with an entered n board size
        queensProblem.solution();
    }
}
    

