package v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Spreadsheet {
    Set<String> refChain = new HashSet<String>();

    public static void main(String[] args) {
        Spreadsheet app = new Spreadsheet();
        app.runMe(args);
    }

    private void runMe(String[] args) {
        InputStream ins = null;
        try {
            ins = (args.length > 0) ? new FileInputStream(args[0]) : System.in;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(2);
        }
        try {
            RawTable table = (new FormatReader(ins)).read();
            for (int r = 0; r < table.rows; r++) {
                for (int c = 0; c < table.cols; c++) {
                    calculateCell(table, new Ref(r, c, table));
                }
            }

            System.out.print(table.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InvalidDataException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private double calculateCell(RawTable table, Ref cell) throws InvalidDataException {
        String[] tokens = table.cells[cell.row][cell.col].split(" ");
        List<String> expression = new ArrayList<String>();
        for (String token: tokens) {
            if (isReference(token)) {
                Ref ref = Ref.makeRef(table, token);
                if (refChain.contains(ref.toString()))
                    throw new InvalidDataException("Circular reference: " + token);
                refChain.add(ref.toString());
                token = String.valueOf(calculateCell(table, ref));
                refChain.remove(ref.toString());
            }
            expression.add(token);
        }
        double result = RpnCalculator.calculate(expression);
        table.cells[cell.row][cell.col] = String.format("%.5f", result);
        return result;
    }

    private boolean isReference(String token) {
        return token.matches("[A-Z]\\d+");
    }

    private String join(String[] tokens) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<tokens.length; i++) {
            sb.append(tokens[i]);
            if( (i+1)<tokens.length )
                sb.append(" ");
        }
        return sb.toString();
    }
}
