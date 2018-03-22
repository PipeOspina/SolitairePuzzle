/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import solitaire.model.Board;

/**
 *
 * @author felipe.ospinah
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home/HomeView.fxml"));        
        Scene scene = new Scene(root);        
        primaryStage.setTitle("Sample Login - [http://www.jc-mouse.net/]");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Board b = new Board();
        b.buildPositions();
        b.consoleDraw();
        System.out.println(b.isSolution());
        b.solveGame();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
