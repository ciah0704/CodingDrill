package tiktaktoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vkroz on 7/13/14.
 */
public class Human extends Player {
    public Human(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Enter your move (row,col):");
        int row = -1;
        int col = -1;

        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            while(! ( row >0 && row < 4 && col > 0 && col < 4) ) {
                String input = br.readLine();
                System.out.println(input);
                String[] pos = input.split(",");
                if(pos.length==2) {
                    row = Integer.valueOf(pos[0]);
                    col = Integer.valueOf(pos[1]);
                }
                else {
                    System.out.println("Invalid move");
                }
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
        /*  1 2 3
           -------
        1 - 0,1,2
        2 - 3,4,5
        3 - 6,7,8
         */
        int i = (row-1)*3 + (col-1);
        board.board[i] = mark;
    }
}
