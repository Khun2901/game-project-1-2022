package gui.control;

import gui.board.BoardPane;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.GameLogic;

public class StartButton extends StackPane implements ButtonHandler {

	private Pane innerButton;

	public StartButton() {
		innerButton = new Pane();
		innerButton.setPrefWidth(130);
		innerButton.setPrefHeight(60);
		innerButton.setMaxWidth(130);
		innerButton.setMaxHeight(60);
		innerButton
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text("START!");
		text.setFont(Font.font("Cloud Light", FontWeight.BOLD, 30));

		this.setPrefHeight(70);
		this.setPrefWidth(140);
		this.setMaxHeight(70);
		this.setMaxWidth(140);
		this.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		this.getChildren().addAll(innerButton, text);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				onMouseClickedHandler();
			}
		});

		this.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				onMouseEnteredHandler();
			}
		});

		this.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				onMouseExitedHandler();

			}
		});
	}

	public void onMouseClickedHandler() {
		ControlPane cp = GameLogic.getInstance().getControlPane();
		BoardPane bp = GameLogic.getInstance().getBoardPane();
		DeployButton dp = cp.getDeployButton();
		cp.getChildren().remove(3);
		cp.getChildren().add(dp);
		cp.setGameText("BLUE's Turn");
		cp.getChildren().set(1, cp.getGameText());
		GameLogic.getInstance().startGame();
		GameLogic.getInstance().updateStartTurn(GameLogic.getInstance().getPlayer1());
		cp.setGameText2("Troops got: " + GameLogic.getInstance().getPlayer1().getSoldierDeployable());
		cp.getChildren().set(2, cp.getGameText2());
		cp.setCardPane(GameLogic.getInstance().getPlayer1());
		cp.getChildren().add(3, GameLogic.getInstance().getControlPane().getCardPane());
	}

	public void onMouseEnteredHandler() {
		this.setCursor(Cursor.HAND);
		this.getInnerButton()
				.setBackground(new Background(new BackgroundFill(Color.ROSYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void onMouseExitedHandler() {
		this.getInnerButton()
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public Pane getInnerButton() {
		return innerButton;
	}

	public void setInnerButton(Pane innerButton) {
		this.innerButton = innerButton;
	}

}
