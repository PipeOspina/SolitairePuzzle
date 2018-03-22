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
    private int[][] positions;
    private int[][] blankPos;
    private int[] highPos;
    private int[] initPos = new int[2];
    private int blankSize;
    private int max;
    private int size;
    private int type;
    
    public static final int DEFAULT =   0;
    public static final int CUSTOM =    1;
    
    public static final int UP =        0;
    public static final int DOWN =      1;
    public static final int RIGHT =     2;
    public static final int LEFT =      3;

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
        this.pieces = new Piece[size][size];
        this.initPos = initPos;
        this.blankPos = blankPos;
        this.size = size;
        this.type = CUSTOM;
    }
    
    public Board(int size, int blankSize) {
        this.size = size;
        this.blankSize = blankSize;
        this.positions = new int[size][size];
        this.pieces = new Piece[size][size];
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

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }
    
    public boolean isOnBoard(int x, int y) {
        switch(this.type) {
            case CUSTOM:
                for (int[] blankPo : this.blankPos) {
                    if (blankPo[0] == x && blankPo[1] == y) {
                        return false;
                    }
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
                    this.pieces[i][j] = new Piece(i, j, true, true);
                } else {
                    this.positions[i][j] = -1;
                    System.out.print(this.positions[i][j]);
                    this.pieces[i][j] = new Piece(i, j, false, false);
                }
            }
            System.out.println("");
        }
        this.pieces[this.initPos[0]][this.initPos[1]] = new Piece(this.initPos[0], this.initPos[1], false, true);
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
    
    public boolean isSolution() {
        for (int i = 0; i < this.positions.length; i++) {
            for (int j = 0; j < this.positions[i].length; j++) {
                if(this.positions[i][j] == 0 && isOnBoard(i, j)) {
                    if(i == this.initPos[0] && j == this.initPos[1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean validMove(Piece piece, Button button) {
        if(button != null) {
            int pieceX = piece.getPosition()[0];
            int pieceY = piece.getPosition()[1];
            int buttonX = button.getPiece().getPosition()[0];
            int buttonY = button.getPiece().getPosition()[1];
            if(piece.isInGame()) {
                if(!piece.isButtonIn()) {
                    if(pieceX == buttonX)
                        return (Math.abs(pieceY - buttonY) == 2);
                    else if(pieceY == buttonY)
                        return (Math.abs(pieceX - buttonX) == 2);
                    else
                        return false;
                }
            }
        }
        return false;
    }
    
    public boolean solveGame() {
        return solveGame(0, 0, 0);
    }
    
    public boolean solveGame(int i, int j, int k) {
        if(i < size && j < size) {
            if(k < 4) {
                switch(k) {
                    case UP:
                        System.out.println("Probando con UP...");
                        if(j >= 2) {
                            if(validMove(pieces[i][j - 2], pieces[i][j].getButton())) {
                                System.out.println("Se mueve la ficha de (" + i + ", " + j + ") a (" + i + ", " + (j - 2) + ") a");
                            } else
                                return solveGame(i, j, k + 1);
                        } else {
                            System.out.println("No se pudo mover la ficha con UP...");
                            return solveGame(i, j, k + 1);
                        }
                        break;
                    case DOWN:
                        if(j < size - 2) {
                            if(validMove(pieces[i][j + 2], pieces[i][j].getButton())) {
                                System.out.println("Se mueve la ficha de (" + i + ", " + j + ") a (" + i + ", " + (j + 2) + ") a");
                            } else
                                return solveGame(i, j, k + 1);
                        } else
                            return solveGame(i, j, k + 1);
                        break;
                    case RIGHT:
                        if(i >= 2) {
                            if(validMove(pieces[i - 2][j], pieces[i][j].getButton())) {
                                System.out.println("Se mueve la ficha de (" + i + ", " + j + ") a (" + (i - 2) + ", " + (j) + ") a");
                            } else
                                return solveGame(i, j, k + 1);
                        } else
                            return solveGame(i, j, k + 1);
                        break;
                    case LEFT:
                        if(i < size - 2) {
                            if(validMove(pieces[i + 2][j], pieces[i][j].getButton())) {
                                System.out.println("Se mueve la ficha de (" + i + ", " + j + ") a (" + (i + 2) + ", " + (j) + ") a");
                            } else
                                return solveGame(i, j, k + 1);
                        } else
                            return solveGame(i, j, k + 1);
                        break;
                    default:
                        System.out.println("No se pudo mover la ficha (" + i + ", " + j + ")");
                        break;
                }
            }
        }
        
        
        
        return true;
        
//        if(i >= size)
//            return solveGame(0, j + 1, 0);
//        else if(i < size)
//            return solveGame(i + 1, j, 0);
//        if(j >= size)
//            return solveGame(i + 1, 0, 0);
//        else if(j < size)
//            return solveGame(i, j + 1, 0);
//        if(i >= size && j >= size)
//            return true;
//        return true;
    }
    
    @Override
    public String toString() {
        return "Holi :)";
    }
}
