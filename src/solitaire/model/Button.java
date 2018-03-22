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
public class Button {
    private boolean state;
    private Piece piece;
    private int direction;
    
    public static final boolean REPOSE = false;
    public static final boolean SELECTED = true;
    
    public static final int VERTICAL =    0;
    public static final int HORIZONTAL =  1;

    public Button(boolean state, Piece piece) {
        this.state = state;
        this.piece = piece;
        this.direction = -1;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
