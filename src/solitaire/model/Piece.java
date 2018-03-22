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
        this.position[0] = x;
        this.position[1] = y;
        this.buttonIn = buttonIn;
        this.inGame = inGame;
        
        if(buttonIn) {
            button = new Button(Button.REPOSE, this);
        }
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
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
        this.buttonIn = buttonIn;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
