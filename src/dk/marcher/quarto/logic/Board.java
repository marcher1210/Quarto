/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.marcher.quarto.logic;

import java.util.*;

/**
 *
 * @author marcher89
 */
public class Board {

    private int[][] fields = new int[4][4];
    private int[][][] quartoChecksLines = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{1, 0}, {1, 1}, {1, 2}, {1, 3}},
        {{2, 0}, {2, 1}, {2, 2}, {2, 3}},
        {{3, 0}, {3, 1}, {3, 2}, {3, 3}},
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        {{0, 1}, {1, 1}, {2, 1}, {3, 1}},
        {{0, 2}, {1, 2}, {2, 2}, {3, 2}},
        {{0, 3}, {1, 3}, {2, 3}, {3, 3}},
        {{0, 0}, {1, 1}, {2, 2}, {3, 3}},
        {{0, 3}, {1, 2}, {2, 1}, {3, 0}}
    };
    private int[][][] quartoChecksSquares = {
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
        {{0, 1}, {0, 2}, {1, 1}, {1, 2}},
        {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
        {{1, 0}, {1, 1}, {2, 0}, {2, 1}},
        {{1, 1}, {1, 2}, {2, 1}, {2, 2}},
        {{1, 2}, {1, 3}, {2, 2}, {2, 3}},
        {{2, 0}, {2, 1}, {3, 0}, {3, 1}},
        {{2, 1}, {2, 2}, {3, 1}, {3, 2}},
        {{2, 2}, {2, 3}, {3, 2}, {3, 3}}
    };
    private int[][] quartoSquares;

    public Board() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                fields[x][y] = -1;
            }
        }
    }

    public boolean isFree(int x, int y) {
        if (x < 0 || x > 3 || y < 0 || y > 3) {
            return false;
        } else {
            return fields[x][y] == -1;
        }
    }

    public boolean onBoard(int piece) {
        assert (validPiece(piece)) : "The piece (" + piece + ") is not valid.";
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (fields[x][y] == piece) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validPiece(int piece) {
        return piece > -1 && piece < 16;
    }

    public boolean validMove(int x, int y, int piece) {
        return isFree(x, y) && validPiece(piece) && !onBoard(piece);
    }

    public boolean hasQuarto() {
        for (int[][] line : quartoChecksLines) {
            int[] pieces = new int[4];
            for (int i = 0; i < 4; i++) {
                pieces[i] = fields[line[i][0]][line[i][1]];
            }
            if (sameAttributes(pieces)) {
                quartoSquares = line;
                return true;
            }

        }
        return false;
    }
    
    public int[][] quartoSquares(){
        assert hasQuarto(): "There is no Quarto.";
        return quartoSquares;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                //b.append("["+fields[x][y]+"]");
                if (isFree(x, y)) {
                    b.append("[    ]");
                } else {
                    b.append("[" + toBinaryString(fields[x][y]) + "]");
                }
            }
            b.append("\n\r");
        }
        return b.toString();
    }

    public void setPiece(int x, int y, int piece) {
        assert (validMove(x, y, piece)) : "Piece (" + piece + ") at index [" + x + ", " + y + "] is not a valid move.";
        fields[x][y] = piece;
    }

    public int getPiece(int x, int y) {
        assert (!isFree(x, y)) : "There is no piece at index [" + x + ", " + y + "].";
        return fields[x][y];
    }

    public static String toBinaryString(int piece) {
        assert validPiece(piece) : "The piece (" + piece + ") is not valid.";
        String str = "0000" + Integer.toBinaryString(piece);
        return str.substring(str.length() - 4, str.length());
    }

    private boolean sameAttributes(int[] pieces) {
        for (int i : pieces) {
            if (i < 0) {
                return false;
            }
        }
        int or = pieces[0];
        for (int i = 1; i < pieces.length; i++) {
            or |= pieces[i];
        }
        int and = pieces[0];
        for (int i = 1; i < pieces.length; i++) {
            and &= pieces[i];
        }
        return (or != 15) || (and != 0);
    }

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);
        System.out.println("------------------------");
        b.setPiece(2, 1, 3);
        System.out.println(b);
        System.out.println("------------------------");
        b.setPiece(2, 2, 4);
        System.out.println(b);
        System.out.println("------------------------");
        b.setPiece(2, 1, 3);
        System.out.println(b);
    }
}
