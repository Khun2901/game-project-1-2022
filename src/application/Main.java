package application;

import gui.MainPane;
import gui.board.BoardPane;
import gui.control.ControlPane;
import gui.control.StartButton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.Player;

public class Main extends Application {

	// ====================================================================

	// ====================================================================

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Clicking "New Game" button will start the game
		StackPane root = new StackPane();
		MainPane mp = new MainPane();
		//BoardPane bp = new BoardPane();
		//ControlPane cp = new ControlPane();
		//StartButton stb = new StartButton();
		
		root.setPrefWidth(1150);
		root.setPrefHeight(700);
		root.setMaxHeight(700);
		root.setMaxWidth(1150);
		root.getChildren().add(mp);
		root.setAlignment(Pos.CENTER);
		GameLogic.getInstance().setMainPane(mp);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Sheeshhhhhhhhhh's Global domination");
		
		primaryStage.show();
		
		
	}



	// ================================================================

}
