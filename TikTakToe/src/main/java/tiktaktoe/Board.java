package tiktaktoe;

import java.util.Arrays;

public class Board {
    char[] board;

    public Board() {
        this.board = new char[3 * 3];
        Arrays.fill(board, ' ');
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-+-+-+\n");
        for (int i = 0; i < board.length; i++) {
            sb.append("|").append(board[i]);
//            sb.append("|").append(i);
            if (i > 0 && (i+1) % 3 == 0) {
                sb.append("|\n");
                sb.append("+-+-+-+\n");
            }
        }
        return sb.toString();
    }
}
