/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.marcher.quarto.ui;

import dk.marcher.quarto.logic.Board;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author marcher89
 */
public class PieceUI {

    private static Image blankImg;
    private static Image[] pieceImgs;

    public static Image getBlankImage() {
        if (blankImg == null) {
            try {
                blankImg = ImageIO.read(PieceUI.class.getResource("../resources/blank.png").openStream());
            } catch (IOException ex) {
            }
        }
        return blankImg;
    }

    public static Image getPieceImage(int piece) {
        if (piece == -1) {
            return getBlankImage();
        }
        assert (Board.validPiece(piece));
        if (pieceImgs == null) {
            loadPieces();
        }

        return pieceImgs[piece];
    }

    public static Image[] getAllPieces() {
        if (pieceImgs == null) {
            loadPieces();
        }
        return pieceImgs;
    }

    private static void loadPieces() {
        pieceImgs = new Image[16];
        for (int i = 0; i < 16; i++) {

            try {
                pieceImgs[i] = ImageIO.read(PieceUI.class.getResource("../resources/" + Board.toBinaryString(i) + ".png").openStream());
            } catch (IOException ex) {
            }
        }
    }
}
