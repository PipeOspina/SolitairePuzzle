/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire.model;

/**
 *
 * @author felipe.ospinah
 */
public class Board {
    private Piece[][] pieces;
    private int[][] emptyPos;
    private int[][] outPos;
    private int[] winPos = new int[2];
    private int blankSize;
    private int size;
    private int type;
    
    public static final int DEFAULT =           0;
    public static final int SIMETRIC_CUSTOM =   1;
    public static final int CUSTOM =            2;
    
    public static final int UP =                0;
    public static final int DOWN =              1;
    public static final int RIGHT =             2;
    public static final int LEFT =              3;

    public Board() {
        this(7, 2);
    }
    
    public Board(int[] initPos) {
        this();
        this.winPos = initPos;
    }
    
    public Board(int[] initPos, int[][] blankPos, int size) {
        this.size = size;
        this.pieces = new Piece[size][size];
        this.winPos = initPos;
        this.outPos = blankPos;
        this.size = size;
        this.type = SIMETRIC_CUSTOM;
    }
    
    public Board(int size, int blankSize) {
        this.size = size;
        this.blankSize = blankSize;
        this.pieces = new Piece[size][size];
        this.winPos[0] = size / 2;
        this.winPos[1] = size / 2;
        this.type = DEFAULT;
    }
    
    public Board(int size, int blankSize, int[] initPos) {
        this(size, blankSize);
        this.winPos = initPos;
    }

    public int[][] getEmptyPos() {
        return emptyPos;
    }

    public void setEmptyPos(int[][] emptyPos) {
        this.emptyPos = emptyPos;
    }

    public int[] getInitPos() {
        return winPos;
    }

    public void setInitPos(int[] initPos) {
        this.winPos = initPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBlankSize() {
        return blankSize;
    }

    public void setBlankSize(int blankSize) {
        this.blankSize = blankSize;
    }

    public int[][] getBlankPos() {
        return outPos;
    }

    public void setBlankPos(int[][] blankPos) {
        this.outPos = blankPos;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }
    
    public void consoleDraw() {
        for (Piece[] piece : pieces) {
            for (Piece piece1 : piece) {
                if (piece1.isButtonIn() && piece1.isInGame()) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
    
    //********************** ToDo *******************************
    // - Make the "constructor" method for the default board
    
    @Override
    public String toString() {
        return "Holi :)";
    }
}
