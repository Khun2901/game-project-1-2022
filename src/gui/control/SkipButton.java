package gui.control;

import gui.board.CountryPane;
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
import map.Country;

public class SkipButton extends StackPane implements ButtonHandler {

	private Pane innerButton;

	public SkipButton() {
		innerButton = new Pane();
		innerButton.setPrefWidth(130);
		innerButton.setPrefHeight(60);
		innerButton.setMaxWidth(130);
		innerButton.setMaxHeight(60);
		innerButton
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text("Skip");
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
		CountryPane pane1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane pane2 = GameLogic.getInstance().getChoosingCountry2();
		
		if(GameLogic.getInstance().getChoosingCountry1() != null) {
			pane1.setBGColor(pane1.getColor());
			GameLogic.getInstance().setChoosingCountry1(null);
		}
		if(GameLogic.getInstance().getChoosingCountry2() != null) {
			pane2.setBGColor(pane2.getColor());
			GameLogic.getInstance().setChoosingCountry2(null);
		}
		
		if(GameLogic.getInstance().getPhase() == 2) {
			cp.setGameText2("Skipped Attack Phase...");
			cp.getChildren().remove(5);
			cp.getChildren().set(4, cp.getNextPhaseButton());
			cp.getChildren().set(2, cp.getGameText2());
		}
		else if(GameLogic.getInstance().getPhase() == 3) {
			GameLogic.getInstance().setPhase(4);
			cp.setGameText2("Skipped Fortify Phase...");
			cp.getChildren().remove(5);
			cp.getChildren().set(4, cp.getNextPhaseButton());
			cp.getChildren().set(2, cp.getGameText2());
		}
		
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
