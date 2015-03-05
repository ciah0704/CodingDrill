package v2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SpreadsheetMain {

    Cell[][] cells;
    int rows;
    int cols;


    public SpreadsheetMain(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }


    public static void main(String[] args) {
        InputStream ins = null;
        try {
            ins = (args.length > 0) ? new FileInputStream(args[0]) : System.in;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(2);
        }
        try {
            SpreadsheetMain spreadsheet = (new SpreadsheetReader(ins)).read();
            spreadsheet.calculate();
            System.out.print(spreadsheet.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InvalidDataException e) {
            e.printStackTrace();
            System.exit(2);
        }


    }

    private void calculate() throws InvalidDataException {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                Cell cell = this.cells[r][c];
                if(cell.value == null) {
                    cell.evaluate();
                    System.out.println("");
                }
                System.out.println("");
            }
        }

    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(cols).append(" ").append(rows).append('\n');
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                builder.append(cells[r][c].formattedOutput()).append('\n');
            }
        }
        return builder.toString();
    }


}
