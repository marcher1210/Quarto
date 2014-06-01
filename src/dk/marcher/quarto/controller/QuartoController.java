/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.marcher.quarto.controller;

import dk.marcher.quarto.logic.*;
import dk.marcher.quarto.ui.*;
import java.util.Random;

/**
 *
 * @author marcher89
 */
public class QuartoController {

    private final GamePanel gamePanel;
    private int chosenPiece = -1;
    private Board board = new Board();
    private boolean gameOver = false;
    private boolean p1Turn;
    private Random r;

    public QuartoController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.r = new Random(System.currentTimeMillis());
    }

    public void newGame() {
        gamePanel.getPoolPanel().refillPool();
        gamePanel.getBoardPanel().clearBoard();
        gamePanel.getPlayerPanel().removePieceToPlace();

        board = new Board();
        chosenPiece = -1;
        gameOver = false;
        p1Turn = new Random().nextBoolean();
        gamePanel.getPlayerPanel().setTurn(p1Turn, false);
    }

    public void squareChosen(int x, int y) {
        if (gameOver || !board.validMove(x, y, chosenPiece)) {
            return;
        }
        board.setPiece(x, y, chosenPiece);
        gamePanel.getBoardPanel().setPiece(x, y, chosenPiece);
        chosenPiece = -1;
        gamePanel.getPlayerPanel().removePieceToPlace();
        gamePanel.getPlayerPanel().setTurn(p1Turn, false);
        if (board.hasQuarto()) {
            gameOver();
        }
    }

    public void pieceChosen(int piece) {
        if (gameOver || chosenPiece > -1) {
            return;
        }
        chosenPiece = piece;
        p1Turn = !p1Turn;
        gamePanel.getPoolPanel().removePiece(piece);
        gamePanel.getPlayerPanel().setPieceToPlace(piece);
        gamePanel.getPlayerPanel().setTurn(p1Turn, true);
    }

    private void gameOver() {
        gameOver = true;
        gamePanel.getBoardPanel().markQuarto(board.quartoSquares());
        gamePanel.getPlayerPanel().setWinner(p1Turn);
    }
}
