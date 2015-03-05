package v1;

public class Ref {
    int row;
    int col;
    RawTable table;

    Ref(int row, int col, RawTable table) {
        this.row = row;
        this.col = col;
        this.table = table;
    }

    public static Ref makeRef(RawTable table, String token) throws InvalidDataException {
        int row = (int) token.charAt(0) - (int) 'A'; //rawDecode.get(token.substring(0,1));
        int col = Integer.decode(token.substring(1, token.length())) - 1;
        if (row >= table.rows || col >= table.cols) {
            throw new InvalidDataException("Illegal reference, pointing outside table ");
        }

        return new Ref(row, col, table);
    }

    public static Ref makeRef(RawTable table, int r, int c) {
        return new Ref(r, c, table);
    }

    public boolean isSimpleReference() {
        return getContent().matches("[A-Z]\\d+");
    }
    public boolean isExpression() {
        return getContent().contains(" ");
    }
    public String getContent() {
        return table.cells[row][col];
    }
    public void setContent(String content) {
        table.cells[row][col] = content;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    public String[] tokenize() {
        return this.table.cells[row][col].split(" ");
    }

}
