package gui.control;

import gui.board.CountryPane;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import logic.Player;
import map.Country;

public class NextPhaseButton extends StackPane implements ButtonHandler{

	private Pane innerButton;

	public NextPhaseButton() {
		innerButton = new Pane();
		innerButton.setPrefWidth(130);
		innerButton.setPrefHeight(60);
		innerButton.setMaxWidth(130);
		innerButton.setMaxHeight(60);
		innerButton
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text("Next");
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
		if (GameLogic.getInstance().getPhase() == 1) {
			AttackButton ab = GameLogic.getInstance().getControlPane().getAttackButton();
			SkipButton skb = GameLogic.getInstance().getControlPane().getSkipButton();
			cp.getChildren().set(4, ab);
			cp.getChildren().add(skb);
			GameLogic.getInstance().setPhase(2);
			cp.setGameText2("Attack!!!");
			cp.getChildren().set(2, cp.getGameText2());
			if (pane1 != null) {
				pane1.setBGColor(pane1.getColor());
				pane1 = null;
			}
		} else if (GameLogic.getInstance().getPhase() == 2) {
			FortifyButton fb = GameLogic.getInstance().getControlPane().getFortifyButton();
			SkipButton skb = GameLogic.getInstance().getControlPane().getSkipButton();
			cp.getChildren().set(4, fb);
			cp.getChildren().add(skb);
			GameLogic.getInstance().setPhase(3);
			cp.setGameText2("Fortify Phase");
			cp.getChildren().set(2, cp.getGameText2());
			if (pane1 != null) {
				pane1.setBGColor(pane1.getColor());
				GameLogic.getInstance().setChoosingCountry1(null);
			}
			if (pane2 != null) {
				pane2.setBGColor(pane2.getColor());
				GameLogic.getInstance().setChoosingCountry2(null);
			}
		} else if (GameLogic.getInstance().getPhase() == 4) {
			Player player;
			if(GameLogic.getInstance().isPlayer1Turn()) {
				GameLogic.getInstance().changeTurn(GameLogic.getInstance().getPlayer1());
				GameLogic.getInstance().updateStartTurn(GameLogic.getInstance().getPlayer2());
				cp.setGameText("RED's Turn");
				cp.getChildren().set(1, cp.getGameText());
				player = GameLogic.getInstance().getPlayer2();
			}
			else {
				GameLogic.getInstance().changeTurn(GameLogic.getInstance().getPlayer2());
				GameLogic.getInstance().updateStartTurn(GameLogic.getInstance().getPlayer1());
				cp.setGameText("BLUE's Turn");
				cp.getChildren().set(1, cp.getGameText());
				player = GameLogic.getInstance().getPlayer1();
			}
			
			GameLogic.getInstance().getControlPane().setCardPane(player);
			GameLogic.getInstance().getControlPane().getChildren().set(3, GameLogic.getInstance().getControlPane().getCardPane());
			
			DeployButton db = GameLogic.getInstance().getControlPane().getDeployButton();
			cp.setGameText2("Troops got: " + player.getSoldierDeployable());
			cp.getChildren().set(2, cp.getGameText2());
			cp.getChildren().set(4, db);
			GameLogic.getInstance().setPhase(1);
			
		
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
