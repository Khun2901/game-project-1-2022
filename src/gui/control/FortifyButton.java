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

public class FortifyButton extends StackPane implements ButtonHandler {

	private Pane innerButton;

	public FortifyButton() {
		innerButton = new Pane();
		innerButton.setPrefWidth(130);
		innerButton.setPrefHeight(60);
		innerButton.setMaxWidth(130);
		innerButton.setMaxHeight(60);
		innerButton
				.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));

		Text text = new Text("Fortify");
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
		
		ControlPane cp = GameLogic.getInstance().getControlPane();
		CountryPane pane1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane pane2 = GameLogic.getInstance().getChoosingCountry2();
		
		if(GameLogic.getInstance().isPlayer1Turn()) {
			GameLogic.getInstance().fortify(GameLogic.getInstance().getPlayer1(), pane1, pane2);
		}
		else {
			GameLogic.getInstance().fortify(GameLogic.getInstance().getPlayer2(), pane1, pane2);
		}
		int amtSoldier1 = GameLogic.getInstance().getChoosingCountry1().getCountry().getAmountSoldier();
		int amtSoldier2 = GameLogic.getInstance().getChoosingCountry2().getCountry().getAmountSoldier();
		String name1 = GameLogic.getInstance().getChoosingCountry1().getCountry().getName();
		String name2 = GameLogic.getInstance().getChoosingCountry2().getCountry().getName();
		pane1.setDetail(amtSoldier1 + "\n" + name1);
		pane2.setDetail(amtSoldier2 + "\n" + name2);
		cp.setGameText2("Fortify Complete!");
		
		pane1.getChildren().set(0, pane1.getDetail());
		pane2.getChildren().set(0, pane2.getDetail());
		pane1.setBGColor(pane1.getColor());
		pane2.setBGColor(pane2.getColor());
		GameLogic.getInstance().getControlPane().getChildren().set(2, cp.getGameText2());
		GameLogic.getInstance().getControlPane().getChildren().set(4, cp.getNextPhaseButton());
		GameLogic.getInstance().getControlPane().getChildren().remove(5);
		GameLogic.getInstance().setChoosingCountry1(null);
		GameLogic.getInstance().setChoosingCountry2(null);
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
