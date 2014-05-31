/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.marcher.quarto.ui;

import dk.marcher.quarto.logic.*;
import dk.marcher.quarto.ui.listeners.*;

/**
 *
 * @author marcher89
 */
public class GamePanel extends javax.swing.JPanel {

    private final PoolListener poolListener;
    private final BoardListener boardListener;
    private int chosenPiece = -1;
    private Board board;

    /**
     * Creates new form GamePanel
     */
    public GamePanel() {
        this.poolListener = new PoolListener() {
            @Override
            public void pieceChosen(int piece) {
                System.out.println("Piece " + piece + " chosen.");
                if (chosenPiece > -1) {
                    return;
                }
                chosenPiece = piece;
                poolPanel.removePiece(piece);
                playerPanel.setPieceToPlace(piece);
            }
        };
        this.boardListener = new BoardListener() {
            @Override
            public void squareChosen(int x, int y) {
                System.out.println("Square [" + x + "," + y + "] chosen.");
                if (!board.validMove(x, y, chosenPiece)) {
                    return;
                }
                board.setPiece(x, y, chosenPiece);
                boardPanel.setPiece(x, y, chosenPiece);
                chosenPiece = -1;
                playerPanel.removePieceToPlace();
                if (board.hasQuarto()) {
                    System.out.println("QUARTO!!");
                    boardPanel.markQuarto(board.quartoSquares());
                }
            }
        };
        initComponents();
        newGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        poolPanel = new dk.marcher.quarto.ui.PoolPanel(poolListener);
        boardPanel = new dk.marcher.quarto.ui.BoardPanel(boardListener);
        playerPanel = new dk.marcher.quarto.ui.PlayerPanel();

        setLayout(new java.awt.BorderLayout());
        add(poolPanel, java.awt.BorderLayout.NORTH);
        add(boardPanel, java.awt.BorderLayout.CENTER);
        add(playerPanel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private dk.marcher.quarto.ui.BoardPanel boardPanel;
    private dk.marcher.quarto.ui.PlayerPanel playerPanel;
    private dk.marcher.quarto.ui.PoolPanel poolPanel;
    // End of variables declaration//GEN-END:variables

    final void newGame() {
        board = new Board();
        poolPanel.refillPool();
        boardPanel.clearBoard();
    }
}
