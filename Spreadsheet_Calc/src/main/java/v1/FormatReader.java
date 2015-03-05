package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads raw input and creates table with cells. Cells store unparsed data
 */
public class FormatReader {
    InputStream in;

    public FormatReader(InputStream in) {
        this.in = in;
    }

    public RawTable read() throws IOException {
        RawTable table = null;

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
            table = new RawTable(rows, cols);

        } else {
            throw new IOException("Unexpected end of file");
        }

        // Continue populating input table
        String line;
        for (int r = 0; r < table.rows; r++) {
            for (int c = 0; c < table.cols; c++) {
                line = br.readLine();
                if (line == null) {
                    throw new IOException("Unexpected end of file");
                }
                table.cells[r][c] = line;
            }
        }
        return table;
    }
}
