package gui.control;

import java.util.ArrayList;

import card.UnitCard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.Player;

public class CardPane extends HBox {
	private ArrayList<CardSquare> allCards;

	public CardPane(Player player) {
		this.setAllCards(new ArrayList<CardSquare>());
		this.setSpacing(3);
		this.setPadding(new Insets(3));
		this.setPrefWidth(340);
		this.setPrefHeight(80);
		this.setMaxWidth(340);
		this.setMaxHeight(80);
		this.setAlignment(Pos.CENTER);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTSLATEGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		for (int i = 0; i < player.getInventory().size(); i++) {
			CardSquare cSquare = new CardSquare(i, player.isPlayer1());
			this.getChildren().add(cSquare);
			allCards.add(cSquare);
		}
	}

	public ArrayList<CardSquare> getAllCards() {
		return allCards;
	}

	public void setAllCards(ArrayList<CardSquare> allCards) {
		this.allCards = allCards;
	}
}
