public class MyProgram {
    public static void main(String[] args) {
        SudokuGenerator generator = new SudokuGenerator();
        generator.generateBoard();
        generator.printBoard();
    }
}