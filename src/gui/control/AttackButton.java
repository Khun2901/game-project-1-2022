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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.GameLogic;

public class AttackButton extends StackPane implements ButtonHandler {

	private Pane innerButton;
	private AudioClip explosion = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());;

	public AttackButton() {
		innerButton = new Pane();
		innerButton.setPrefWidth(130);
		innerButton.setPrefHeight(60);
		innerButton.setMaxWidth(130);
		innerButton.setMaxHeight(60);
		innerButton
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text("Attack");
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
		if (GameLogic.getInstance().getChoosingCountry1() == null
				|| GameLogic.getInstance().getChoosingCountry2() == null) {
			return;
		}
		explosion.play();
		if (GameLogic.getInstance().isPlayer1Turn()) {
			GameLogic.getInstance().attackPhase(GameLogic.getInstance().getPlayer1(),
					GameLogic.getInstance().getChoosingCountry1(), GameLogic.getInstance().getChoosingCountry2());
			if(GameLogic.getInstance().getPlayer1().isAttackSuccess()) {
				GameLogic.getInstance().getControlPane().setGameText2("Attack Success!!!");
				GameLogic.getInstance().getChoosingCountry2().setColor(true);
			}
			else {
				GameLogic.getInstance().getControlPane().setGameText2("Too Bad!!!");
			}
		} else {
			GameLogic.getInstance().attackPhase(GameLogic.getInstance().getPlayer2(),
					GameLogic.getInstance().getChoosingCountry1(), GameLogic.getInstance().getChoosingCountry2());
			if(GameLogic.getInstance().getPlayer2().isAttackSuccess()) {
				GameLogic.getInstance().getControlPane().setGameText2("Attack Success!!!");
				GameLogic.getInstance().getChoosingCountry2().setColor(false);
			}
			else {
				GameLogic.getInstance().getControlPane().setGameText2("Too Bad!!!");
			}
		}
		GameLogic.getInstance().getControlPane().getChildren().set(2, GameLogic.getInstance().getControlPane().getGameText2());
		int amtsoldier1 = GameLogic.getInstance().getChoosingCountry1().getCountry().getAmountSoldier();
		int amtsoldier2 = GameLogic.getInstance().getChoosingCountry2().getCountry().getAmountSoldier();
		String name1 = GameLogic.getInstance().getChoosingCountry1().getCountry().getName();
		String name2 = GameLogic.getInstance().getChoosingCountry2().getCountry().getName();
		GameLogic.getInstance().getChoosingCountry1().setDetail(amtsoldier1 + "\n" + name1);
		GameLogic.getInstance().getChoosingCountry2().setDetail(amtsoldier2 + "\n" + name2);
		CountryPane cp1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane cp2 = GameLogic.getInstance().getChoosingCountry2();	
		GameLogic.getInstance().getChoosingCountry1().getChildren().set(0, cp1.getDetail());
		GameLogic.getInstance().getChoosingCountry2().getChildren().set(0, cp2.getDetail());
		GameLogic.getInstance().getChoosingCountry1().setBGColor(cp1.getColor());
		GameLogic.getInstance().getChoosingCountry1().setBDColor(cp1.getBorderColor());
		GameLogic.getInstance().getChoosingCountry2().setBGColor(cp2.getColor());
		GameLogic.getInstance().getChoosingCountry2().setBDColor(cp2.getBorderColor());
		GameLogic.getInstance().getControlPane().getChildren().set(4, GameLogic.getInstance().getControlPane().getNextPhaseButton());
		GameLogic.getInstance().getControlPane().getChildren().remove(5);
		
		if(GameLogic.getInstance().isPlayer1Turn() && GameLogic.getInstance().checkPlayer1Win()) {
			GameLogic.getInstance().getControlPane().setGameText("BLUE's WIN!!!");
			GameLogic.getInstance().getControlPane().getChildren().set(1, GameLogic.getInstance().getControlPane().getGameText());
			GameLogic.getInstance().getControlPane().setGameText2("Congratulations!!!");
			GameLogic.getInstance().getControlPane().getChildren().set(2, GameLogic.getInstance().getControlPane().getGameText2());
			GameLogic.getInstance().getControlPane().getChildren().remove(4);
		}
		else if(!GameLogic.getInstance().isPlayer1Turn() && GameLogic.getInstance().checkPlayer2Win()) {
			GameLogic.getInstance().getControlPane().setGameText("RED's WIN!!!");
			GameLogic.getInstance().getControlPane().getChildren().set(1, GameLogic.getInstance().getControlPane().getGameText());
			GameLogic.getInstance().getControlPane().setGameText2("Congratulations!!!");
			GameLogic.getInstance().getControlPane().getChildren().set(2, GameLogic.getInstance().getControlPane().getGameText2());
			GameLogic.getInstance().getControlPane().getChildren().remove(4);
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
