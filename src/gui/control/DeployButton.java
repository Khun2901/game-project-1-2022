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

public class DeployButton extends StackPane implements ButtonHandler{

	private Pane innerButton;

	public DeployButton() {
		innerButton = new Pane();
		innerButton.setPrefWidth(130);
		innerButton.setPrefHeight(60);
		innerButton.setMaxWidth(130);
		innerButton.setMaxHeight(60);
		innerButton
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text("Deploy");
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

	public void deployTroopsToCountry(CountryPane countryPane) {
//		int deploySoldier;
//		if (GameLogic.getInstance().isPlayer1Turn()) {
//			GameLogic.getInstance().getPlayer1().startTurn();
//			deploySoldier = GameLogic.getInstance().getPlayer1().getSoldierDeployable();
//		} else {
//			GameLogic.getInstance().getPlayer2().startTurn();
//			deploySoldier = GameLogic.getInstance().getPlayer2().getSoldierDeployable();
//		}
//
//		countryPane.getCountry().setAmountSoldier(countryPane.getCountry().getAmountSoldier() + deploySoldier);
//		countryPane.setDetail(countryPane.getCountry().getAmountSoldier() + "\n" + countryPane.getCountry().getName());
//		countryPane.getChildren().set(0, countryPane.getDetail());
		if (GameLogic.getInstance().isPlayer1Turn()) {
			GameLogic.getInstance().deployPhase(GameLogic.getInstance().getPlayer1(), countryPane);
		} else {
			GameLogic.getInstance().deployPhase(GameLogic.getInstance().getPlayer2(), countryPane);
		}
		countryPane.setDetail(countryPane.getCountry().getAmountSoldier() + "\n" + countryPane.getCountry().getName());
		countryPane.getChildren().set(0, countryPane.getDetail());

	}

	public void onMouseClickedHandler() {
		ControlPane cp = GameLogic.getInstance().getControlPane();
		NextPhaseButton np = cp.getNextPhaseButton();
		CountryPane countryPane = GameLogic.getInstance().getChoosingCountry1();
		if (countryPane == null)
			return;
		cp.getChildren().set(4, np);
		cp.setGameText2("Next Phase...");
		cp.getChildren().set(2, cp.getGameText2());
		deployTroopsToCountry(countryPane);
		countryPane.setBackground(
				new Background(new BackgroundFill(countryPane.getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		GameLogic.getInstance().setChoosingCountry1(null);
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
