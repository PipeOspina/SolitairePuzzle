/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire.model;

/**
 *
 * @author Pipe
 */
public class Game {
    
    public Board solveGame(Board board, int i, int j, int direction) {
//        Board auxBoard;
//        if(board.getPieces()[i][j].isInGame() && board.getPieces()[i][j].isButtonIn()) {
//            if(direction < 4) {
//                auxBoard = moveButton(board, board.getPieces()[i][j].getButton(), direction);
//                if(auxBoard != null) {
//                    auxBoard.consoleDraw2();
//                    return solveGame(auxBoard, 0, 0, Board.UP);
//                }
//                else
//                    return solveGame(board, i, j, direction + 1);
//            }
//        } 
//        
//        if(i < board.getSize() - 1)
//            return solveGame(board, i + 1, j, Board.UP);
//        else
//            if(j < board.getSize() - 1)
//                return solveGame(board, 0, j + 1, Board.UP);
//            else
                return null;
    }
    
    public Board moveButton(Board board, Button button, int direction) {
        if(button != null) {
            switch(direction) {
                case Board.UP:
                    return moveButtonUp(board, button);
                case Board.DOWN:
                    return moveButtonDown(board, button);
                case Board.RIGHT:
                    return moveButtonRight(board, button);
                case Board.LEFT:
                    return moveButtonLeft(board, button);
                default:
                    return null;
            }
        }
        return null;
    }
    
    public Board moveButtonUp(Board board, Button button) {
        int buttonX = button.getPiece().getPosition()[1];
        int buttonY = button.getPiece().getPosition()[0];
        Piece[][] pieces = board.getPieces();
        if( buttonY > 1 &&
            pieces[buttonY - 2][buttonX].isInGame() &&
            !pieces[buttonY - 2][buttonX].isButtonIn() &&
            pieces[buttonY - 1][buttonX].isInGame() &&
            pieces[buttonY - 1][buttonX].isButtonIn()) {
                pieces[buttonY - 2][buttonX].setButton(button);
                pieces[buttonY - 1][buttonX].setButton(null);
                pieces[buttonY][buttonX].setButton(null);
                board.setPieces(pieces);
                return board;
        }
        return null;
    }
    
    public Board moveButtonDown(Board board, Button button) {
        int buttonX = button.getPiece().getPosition()[1];
        int buttonY = button.getPiece().getPosition()[0];
        Piece[][] pieces = board.getPieces();
        if( buttonY < board.getSize() - 3 &&
            pieces[buttonY + 2][buttonX].isInGame() &&
            !pieces[buttonY + 2][buttonX].isButtonIn() &&
            pieces[buttonY + 1][buttonX].isInGame() &&
            pieces[buttonY + 1][buttonX].isButtonIn()) {
                pieces[buttonY + 2][buttonX].setButton(button);
                pieces[buttonY + 1][buttonX].setButton(null);
                pieces[buttonY][buttonX].setButton(null);
                board.setPieces(pieces);
                return board;
        }
        return null;
    }
    
    public Board moveButtonRight(Board board, Button button) {
        int buttonX = button.getPiece().getPosition()[1];
        int buttonY = button.getPiece().getPosition()[0];
        Piece[][] pieces = board.getPieces();
        if( buttonX < board.getSize() - 3 &&
            pieces[buttonY][buttonX + 2].isInGame() &&
            !pieces[buttonY][buttonX + 2].isButtonIn() &&
            pieces[buttonY][buttonX + 1].isInGame() &&
            pieces[buttonY][buttonX + 1].isButtonIn()) {
                pieces[buttonY][buttonX + 2].setButton(button);
                pieces[buttonY][buttonX + 1].setButton(null);
                pieces[buttonY][buttonX].setButton(null);
                board.setPieces(pieces);
                return board;
        }
        return null;
    }
    
    public Board moveButtonLeft(Board board, Button button) {
        int buttonX = button.getPiece().getPosition()[1];
        int buttonY = button.getPiece().getPosition()[0];
        Piece[][] pieces = board.getPieces();
        if( buttonX > 1 &&
            pieces[buttonY][buttonX - 2].isInGame() &&
            !pieces[buttonY][buttonX - 2].isButtonIn() &&
            pieces[buttonY][buttonX - 1].isInGame() &&
            pieces[buttonY][buttonX - 1].isButtonIn()) {
                pieces[buttonY][buttonX - 2].setButton(button);
                pieces[buttonY][buttonX - 1].setButton(null);
                pieces[buttonY][buttonX].setButton(null);
                board.setPieces(pieces);
                return board;
        }
        return null;
    }
}
