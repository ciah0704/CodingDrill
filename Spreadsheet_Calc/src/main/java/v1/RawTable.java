package v1;

public class RawTable {
    String[][] cells;
    int rows;
    int cols;

    public RawTable(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new String[rows][cols];
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(cols).append(" ").append(rows).append('\n');
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                builder.append(cells[r][c]).append('\n');
            }
        }
        return builder.toString();
    }
}
