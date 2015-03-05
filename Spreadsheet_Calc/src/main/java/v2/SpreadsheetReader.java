package v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads str input and creates table with cells. Cells store tokenized source strings
 */
public class SpreadsheetReader {
    InputStream in;

    public SpreadsheetReader(InputStream in) {
        this.in = in;
    }

    public SpreadsheetMain read() throws IOException, InvalidDataException {
        SpreadsheetMain spreadsheet = null;

        BufferedReader br =
                new BufferedReader(new InputStreamReader(this.in));

        // Reading first line,determine dimensions, create empty table
        String dimension = br.readLine();
        if (dimension != null) {
            String[] dims = dimension.split(" ");
            if (dims.length != 2) {
                throw new IOException("Invalid table dimension in first input line. Expecting 'n m'");
            }
            int rows = Integer.parseInt(dims[1]);
            int cols = Integer.parseInt(dims[0]);
            spreadsheet = new SpreadsheetMain(rows, cols);

        } else {
            throw new IOException("Unexpected end of file");
        }

        // Continue populating input table
        String cellStr;
        for (int r = 0; r < spreadsheet.rows; r++) {
            for (int c = 0; c < spreadsheet.cols; c++) {
                cellStr = br.readLine();
                if (cellStr == null) {
                    throw new IOException("Unexpected end of file");
                }
                spreadsheet.cells[r][c] = new Cell(spreadsheet, r, c, cellStr);
            }
        }
        return spreadsheet;
    }
}
