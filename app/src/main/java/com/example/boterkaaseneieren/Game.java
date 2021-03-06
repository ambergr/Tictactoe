package com.example.boterkaaseneieren;
import java.io.Serializable;

public class Game implements Serializable {

    // maakt het bord, zorgt dat playerone aan de beurt is
    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    public Boolean gameOver;

    // als de geklikte knop blank is
    // als player one aan de beurt is dan, doe de geklikte knop naar circle en return
    public TileState choose(int row, int column) {
        if (board[row][column] == TileState.BLANK) {
            if (playerOneTurn) {
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = false;
                movesPlayed ++;
                return TileState.CIRCLE;
            } else {
                board[row][column] = TileState.CROSS;
                playerOneTurn = true;
                movesPlayed ++;
                return TileState.CROSS;
            }
        } else {
            board[row][column] = TileState.INVALID;
            return TileState.INVALID;
        }
    }

    // check if game is won
    public GameState won() {
        // loops over board, if horizontal, diagonal or vertical are all the same figure (x or o)
        // than the is won. Check if player one or player two has one.
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0]== board[i][2] && board[i][0] != TileState.BLANK) {
                gameOver = true;
                if (board[i][0] == TileState.CROSS) {
                    return GameState.PLAYER_TWO;
                } else {
                    return GameState.PLAYER_ONE;
                }
            } else if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != TileState.BLANK) {
                gameOver = true;
                if (board[0][i] == TileState.CROSS) {
                    return GameState.PLAYER_TWO;
                } else {
                    return GameState.PLAYER_ONE;
                }
            } else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0]!= TileState.BLANK
                    || board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0]!= TileState.BLANK) {
                gameOver = true;
                if (board[1][1] == TileState.CROSS) {
                    return GameState.PLAYER_TWO;
                } else {

                    return GameState.PLAYER_ONE;
                }
             // als er negen knoppen ingedrukt zijn dan is het een draw
            } else if (movesPlayed == 9) {
                gameOver = true;
                return GameState.DRAW;
            }
        }
        return GameState.IN_PROGRESS;
    }
}
