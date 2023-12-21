package gui.control;

import card.ArsenalCard;
import card.CavalryCard;
import card.InfantryCard;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;

public class CardSquare extends Pane {
	private final String infantryURL;
	private final String cavalryURL;
	private final String arsenalURL;
	private int index;
	private boolean isInPlayer1;

	public CardSquare(int index, boolean isInPlayer1) {
		this.infantryURL = "Infantry.png";
		this.cavalryURL = "Cavalry.png";
		this.arsenalURL = "Arsenal.png";
		this.setPrefWidth(46);
		this.setPrefHeight(68);
		this.setMaxWidth(46);
		this.setMaxHeight(68);
		this.setIndex(index);
		this.setInPlayer1(isInPlayer1);
		this.drawCardType();

	}

	private void drawCardType() {
		if (GameLogic.getInstance().isPlayer1Turn() && this.inPlayer1()
				&& GameLogic.getInstance().getPlayer1().getInventory().size() > this.getIndex()) {

			if (GameLogic.getInstance().getPlayer1().getInventory().get(this.getIndex()) instanceof InfantryCard) {
				Image image = new Image(infantryURL);
				this.draw(image, Color.AZURE);
			} else if (GameLogic.getInstance().getPlayer1().getInventory()
					.get(this.getIndex()) instanceof CavalryCard) {
				Image image = new Image(cavalryURL);
				this.draw(image, Color.AZURE);
			} else if (GameLogic.getInstance().getPlayer1().getInventory()
					.get(this.getIndex()) instanceof ArsenalCard) {
				Image image = new Image(arsenalURL);
				this.draw(image, Color.AZURE);
			}

		} else if (!GameLogic.getInstance().isPlayer1Turn() && !this.inPlayer1()
				&& GameLogic.getInstance().getPlayer2().getInventory().size() > this.getIndex()) {
			if (GameLogic.getInstance().getPlayer2().getInventory().get(this.getIndex()) instanceof InfantryCard) {
				Image image = new Image(infantryURL);
				this.draw(image, Color.PALEVIOLETRED);
			} else if (GameLogic.getInstance().getPlayer2().getInventory()
					.get(this.getIndex()) instanceof CavalryCard) {
				Image image = new Image(cavalryURL);
				this.draw(image, Color.PALEVIOLETRED);
			} else if (GameLogic.getInstance().getPlayer2().getInventory()
					.get(this.getIndex()) instanceof ArsenalCard) {
				Image image = new Image(arsenalURL);
				this.draw(image, Color.PALEVIOLETRED);
			}
		}
	}

	private void draw(Image image, Color backgroundColor) {

		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(46, 68, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		this.setBackground(new Background(bgFillA, bgImgA));
	}

	public int getIndex() {
		return index;
	}

	public boolean inPlayer1() {
		return isInPlayer1;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setInPlayer1(boolean isInPlayer1) {
		this.isInPlayer1 = isInPlayer1;
	}

}
