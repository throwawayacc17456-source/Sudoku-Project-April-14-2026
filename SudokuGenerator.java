import java.util.Random;

public class SudokuGenerator {
    private int[][] board = new int[9][9];
    private Random rand = new Random();

    public void generateBoard() {
        fillBoard(0, 0);
    }
    private boolean fillBoard(int row, int col) {
        if(row == 9){
            return true;
        }
        int nextRow;
        
        if (col == 8) {
            nextRow = row + 1;
        } 
        else {
            nextRow = row;
        }
        int nextCol = (col + 1) % 9;
        int[] numbers = shuffledNumbers();
        
        for (int num : numbers) {
            if (isValid(row, col, num)) {
                board[row][col] = num; 
                if (fillBoard(nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private int[] shuffledNumbers() {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++){
            nums[i] = i + 1;
        }
        for (int i = 8; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[startRow + r][startCol + c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0) {
               System.out.println("------+-------+------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}