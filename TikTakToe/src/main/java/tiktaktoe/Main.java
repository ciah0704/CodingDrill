package tiktaktoe;

/**
 * Code assignment:
 * <p/>
 * - Implement Tic-tac-toe (http://en.wikipedia.org/wiki/Tic-tac-toe) in Java
 * - Deliver jar'ed source code to matthew.doucette@monster.com before their interview
 * - Indicate the name of the top-level class to run
 * - 3rd party jars are okay as long as you include them in jar and explain how/why you used them
 * - The interview will consist of a code review of submitted code
 * <p/>
 * Spec / Requirements:
 * <p/>
 * - 3x3 grid
 * - Human player (Xs) vs Computer player (Os)
 * - Human player always starts
 * - Each Human player turn:
 * - Program prompts human for cell to play
 * - Human player indicates cell to play by entering 1-9 (First row: 1-3, Second row: 4-6, Third row: 7-9)
 * - If the played cell is not available, program should display relevant message and prompt human for cell to play again
 * - If the played cell is available, display the current state of the board to the console and move on to Computer player turn.
 * - After human plays, Computer plays automatically according to a pluggable algorithm.
 * - At least implement a Computer Player that makes random but valid moves.
 * - After Computer player, display the current state of the board to the console and move on to Human player turn.
 * - The program detects when a game finishes and announces winner or tie.
 * <p/>
 * Extra Credit (Not required at all)
 * <p/>
 * Implement "better" Computer players by adding -some- intelligence to the player algorithm
 */
public class Main {
    int nextPlayer;
    Player[] players;
    Board board;

    public Main() {
        this.players = new Player[2];
        this.board = new Board();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.play();
    }

    private void play() {
        Player[] players = {
//                new Human('x'), new Machine('0')
                new Human("Human 1", 'x'), new Human("Second human", '0')
        };

        this.init(players);
        while (true) {
            this.drawBoard();
            Player nowPlayer = players[nextPlayer];
            nowPlayer.makeMove(board);
            if( this.gameOver(nowPlayer.mark) ) {
                this.printResult(nowPlayer);
                break;
            }
            nextPlayer = (nextPlayer == 0) ? 1 : 0;
        }

    }

    public void init(Player[] players) {
        nextPlayer = 0;
        this.players = players;
    }

    public boolean gameOver(char mark) {
        /*
        012
        345
        678
         */
        int[][] winPath = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for(int i=0; i<8; i++) {
            int winCond = 1; //to win it must be 3
            for(int j=0; j<3; j++) {
                if(this.board.board[winPath[i][j]]==mark)
                    winCond++;
            }
            if(winCond==3)
                return true;
        }
        /*
        +-+-+-+
        |x|x| |
        +-+-+-+
        | |x|0|
        +-+-+-+
        |0|x|0|
        +-+-+-+
         */
        return false;
    }

    public void drawBoard() {
        System.out.println(board.toString());
    }

    public void printResult(Player nowPlayer) {
        System.out.println("And the winner is: " + nowPlayer.name + "!!!!!2,2");
    }
}
