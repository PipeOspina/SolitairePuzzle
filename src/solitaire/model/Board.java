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
    private int[][] emptyPos;
    private int[][] positions;
    private int[][] blankPos;
    private int[] highPos;
    private int[] initPos = new int[2];
    private int blankSize;
    private int max;
    private int size;
    private int type;
    
    public static final int DEFAULT = 0;
    public static final int CUSTOM = 1;

    public Board() {
        this(7, 2);
    }
    
    public Board(int[] initPos) {
        this();
        this.initPos = initPos;
    }
    
    public Board(int[] initPos, int[][] blankPos, int size) {
        this.size = size;
        this.positions = new int[size][size];
        this.initPos = initPos;
        this.blankPos = blankPos;
        this.size = size;
        this.type = CUSTOM;
    }
    
    public Board(int size, int blankSize) {
        this.size = size;
        this.blankSize = blankSize;
        this.positions = new int[size][size];
        this.initPos[0] = size / 2;
        this.initPos[1] = size / 2;
        this.type = DEFAULT;
    }
    
    public Board(int size, int blankSize, int[] initPos) {
        this(size, blankSize);
        this.initPos = initPos;
    }

    public int[][] getEmptyPos() {
        return emptyPos;
    }

    public void setEmptyPos(int[][] emptyPos) {
        this.emptyPos = emptyPos;
    }

    public int[][] getPositions() {
        return positions;
    }

    public void setPositions(int[][] positions) {
        this.positions = positions;
    }

    public int[] getHighPos() {
        return highPos;
    }

    public void setHighPos(int[] highPos) {
        this.highPos = highPos;
    }

    public int[] getInitPos() {
        return initPos;
    }

    public void setInitPos(int[] initPos) {
        this.initPos = initPos;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
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
    
    public boolean isOnBoard(int x, int y) {
        switch(this.type) {
            case CUSTOM:
                for (int i = 0; i < this.blankPos.length; i++) {
                    if(this.blankPos[i][0] == x && this.blankPos[i][1] == y) 
                        return false;
                }
                return true;
            default:
                if(x < this.blankSize && y < this.blankSize)
                    return false;
                else if(this.size - x <= this.blankSize && y < this.blankSize)
                    return false;
                else if(this.size - y <= this.blankSize && x < this.blankSize)
                    return false;
                else if(this.size - x <= this.blankSize && this.size - y <= this.blankSize)
                    return false;
                else
                    return true;
        }
    }
    
    public void buildPositions() {
        for (int i = 0; i < this.positions.length; i++) {
            for (int j = 0; j < this.positions[i].length; j++) {
                if(isOnBoard(i, j)) {
                    this.max = Math.abs(this.initPos[0] - i);
                    if(Math.abs(this.initPos[1] - j) > this.max)
                        max = Math.abs(this.initPos[1] - j);
                    this.positions[i][j] = this.max;
                    System.out.print(" " + this.positions[i][j]);
                } else {
                    this.positions[i][j] = -1;
                    System.out.print(this.positions[i][j]);
                }
            }
            System.out.println("");
        }
    }
    
    public void consoleDraw() {
        for (int i = 0; i < this.positions.length; i++) {
            for (int j = 0; j < this.positions[i].length; j++) {
                    switch(this.positions[i][j]) {
                        case -1:
                            System.out.print("  ");
                            break;
                        case 0:
                            System.out.print("  ");
                            break;
                        default:
                            System.out.print("* ");
                            break;
                    }
            }
            System.out.println("");
        }
    }
    
    @Override
    public String toString() {
        return "";
    }

    public int[][] getBlankPos() {
        return blankPos;
    }

    public void setBlankPos(int[][] blankPos) {
        this.blankPos = blankPos;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
