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
public class Piece {
    private int[] position = new int[2];
    private boolean buttonIn;
    private boolean inGame;
    private Button button;

    public Piece(int x, int y, boolean buttonIn, boolean inGame) {
        this.position[0] = y;
        this.position[1] = x;
        this.buttonIn = buttonIn;
        this.inGame = inGame;
        
        if(buttonIn) {
            this.button = new Button(Button.REPOSE, this);
        } else {
            this.button = null;
        }
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = y;
        this.position[1] = x;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isButtonIn() {
        return buttonIn;
    }

    public void setButtonIn(boolean buttonIn) {
        if(buttonIn)
            this.buttonIn = buttonIn;
        else
            this.button = null;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.buttonIn = button != null;
        this.button = button;
    }
}
