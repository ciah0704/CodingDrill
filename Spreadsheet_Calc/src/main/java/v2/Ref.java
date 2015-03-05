package v2;


public class Ref {
    String str;
    int row;
    int col;
    SpreadsheetMain table;

    Ref(SpreadsheetMain table, String strVal) throws InvalidDataException {
        this.table = table;
        this.str = strVal;
        this.row = (int) str.charAt(0) - (int) 'A';
        this.col = Integer.decode(str.substring(1, str.length())) - 1;
        if (row >= table.rows || col >= table.cols) {
            throw new InvalidDataException("Illegal reference, pointing outside table ");
        }
    }


    @Override
    public String toString() {
        return "Ref{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
