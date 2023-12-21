package gui.board;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;
import map.Country;

public class CountryPane extends StackPane {

	private Country country;

	private Text detail;

	private int xPos;
	private int yPos;
	private int xSpan;
	private int ySpan;
	private Color color;
	private Color borderColor;

	public CountryPane(Country country, int width, int height, int xPos, int yPos) {
		this.setCountry(country);
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setxSpan(width);
		this.setySpan(height);
		this.setPrefWidth(60 * width);
		this.setPrefHeight(60 * height);
		this.setMaxWidth(60 * width);
		this.setMaxHeight(60 * height);
		this.setColor(country.belongPlayer1());
		this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(
				new BorderStroke(borderColor, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setDetail(country.getAmountSoldier() + "\n" + country.getName());
		this.getChildren().add(detail);
		this.setAlignment(Pos.CENTER);
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

		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				onMouseClickedHandler();

			}

		});
	}

	public void onMouseClickedPhase1() {
		CountryPane cp = GameLogic.getInstance().getChoosingCountry1();
		if (cp != null) {
			cp.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		GameLogic.getInstance().setChoosingCountry1(this);
		this.setBackground(new Background(new BackgroundFill(borderColor, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void onMouseClickedPhase2() {
		CountryPane c1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane c2 = GameLogic.getInstance().getChoosingCountry2();
		if (c1 == null) {
			if (GameLogic.getInstance().isPlayer1Turn() == this.getCountry().belongPlayer1()) {
				GameLogic.getInstance().setChoosingCountry1(this);
				GameLogic.getInstance().getChoosingCountry1().setBGColor(borderColor);

			}
		} else {
			if (GameLogic.getInstance().isPlayer1Turn() == this.getCountry().belongPlayer1()) {
				GameLogic.getInstance().getChoosingCountry1().setBGColor(c1.getColor());
				GameLogic.getInstance().setChoosingCountry1(this);
				GameLogic.getInstance().getChoosingCountry1().setBGColor(this.getBorderColor());
				if (c2 != null) {
					GameLogic.getInstance().getChoosingCountry2().setBGColor(c2.getColor());
					GameLogic.getInstance().setChoosingCountry2(null);

				}

			} else {
				// System.out.println(c1.getCountry().isAdjacent(this.getCountry()));
				if (c1.getCountry().isAdjacent(this.getCountry())) {
					if (c2 != null) {
						GameLogic.getInstance().getChoosingCountry2().setBGColor(this.getColor());
					}
					GameLogic.getInstance().setChoosingCountry2(this);
					GameLogic.getInstance().getChoosingCountry2().setBGColor(this.getBorderColor());
				}

			}
		}

	}

	public void onMouseClickedPhase3() {
		if (this.getCountry().belongPlayer1() != GameLogic.getInstance().isPlayer1Turn())
			return;

		CountryPane c1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane c2 = GameLogic.getInstance().getChoosingCountry2();

		if (c1 == null) {
			GameLogic.getInstance().setChoosingCountry1(this);
			this.setBGColor(this.getBorderColor());

		} else {
			if (this.getCountry().isAdjacent(c1.getCountry())) {
				if (c2 != null) {
					c2.setBGColor(c2.getColor());
				}
				GameLogic.getInstance().setChoosingCountry2(this);
				this.setBGColor(this.getBorderColor());
			} else {
				c1.setBGColor(c1.getColor());
				if (c2 != null) {
					c2.setBGColor(c2.getColor());
					GameLogic.getInstance().setChoosingCountry2(null);
				}
				GameLogic.getInstance().setChoosingCountry1(this);
				GameLogic.getInstance().getChoosingCountry1().setBGColor(this.getBorderColor());
			}
		}
	}

	public void onMouseClickedHandler() {
		boolean p1 = GameLogic.getInstance().isPlayer1Turn();
		if (!GameLogic.getInstance().isGameStart())
			return;
		else if (GameLogic.getInstance().getPhase() == 1 && (p1 == this.getCountry().belongPlayer1()))
			onMouseClickedPhase1();
		else if (GameLogic.getInstance().getPhase() == 2)
			onMouseClickedPhase2();
		else if (GameLogic.getInstance().getPhase() == 3)
			onMouseClickedPhase3();

	}

	public void onMouseEnteredPhase1() {
		if (this.getCountry().belongPlayer1() == GameLogic.getInstance().isPlayer1Turn()) {
			this.setCursor(Cursor.HAND);
			this.setBGColor(this.getBorderColor());
		}
	}

	public void onMouseExitedPhase1() {
		if (this.getCountry().belongPlayer1() == GameLogic.getInstance().isPlayer1Turn()) {
			this.setCursor(Cursor.DEFAULT);
			if (this != GameLogic.getInstance().getChoosingCountry1()) {
				this.setBGColor(this.getColor());
			}
		}
	}

	public void onMouseEnteredPhase2() {
		if (this.getCountry().belongPlayer1() == GameLogic.getInstance().isPlayer1Turn()) {
			this.setCursor(Cursor.HAND);
			this.setBGColor(this.getBorderColor());
		} else if (GameLogic.getInstance().getChoosingCountry1() != null) {
			if (this.getCountry().belongPlayer1() != GameLogic.getInstance().isPlayer1Turn()
					&& this.getCountry().isAdjacent(GameLogic.getInstance().getChoosingCountry1().getCountry())) {
				this.setCursor(Cursor.HAND);
				this.setBGColor(this.getBorderColor());
			} else {
				this.setCursor(Cursor.DEFAULT);
			}
		}

	}

	public void onMouseExitedPhase2() {
		CountryPane cp1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane cp2 = GameLogic.getInstance().getChoosingCountry2();
		this.setCursor(Cursor.DEFAULT);
		if (this == cp1 || this == cp2)
			return;
		this.setBGColor(this.getColor());
	}

	public void onMouseExitedPhase3() {
		CountryPane cp1 = GameLogic.getInstance().getChoosingCountry1();
		CountryPane cp2 = GameLogic.getInstance().getChoosingCountry2();
		this.setCursor(Cursor.DEFAULT);
		if(this == cp1 || this == cp2)
			return;
		this.setBGColor(this.getColor());

	}

	public void onMouseEnteredHandler() {
		boolean p1 = GameLogic.getInstance().isPlayer1Turn();
		int phase = GameLogic.getInstance().getPhase();
		if (!GameLogic.getInstance().isGameStart()) {
			this.setCursor(Cursor.DEFAULT);
			return;
		} else if (phase == 1) {
			onMouseEnteredPhase1();

		} else if (phase == 2) {
			onMouseEnteredPhase2();

		} else if (phase == 3) {
			onMouseEnteredPhase1();

		}

	}

	public void onMouseExitedHandler() {
		boolean p1 = GameLogic.getInstance().isPlayer1Turn();
		int phase = GameLogic.getInstance().getPhase();
		if (!GameLogic.getInstance().isGameStart() || phase > 3)
			return;
		if (phase == 1) {
			onMouseExitedPhase1();

		} else if (phase == 2) {
			onMouseExitedPhase2();

		} else if (phase == 3) {
			onMouseExitedPhase3();

		}

	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxSpan() {
		return xSpan;
	}

	public void setxSpan(int xSpan) {
		this.xSpan = xSpan;
	}

	public int getySpan() {
		return ySpan;
	}

	public void setySpan(int ySpan) {
		this.ySpan = ySpan;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setColor(boolean isPlayer1) {
		if (isPlayer1) {
			this.color = Color.CADETBLUE;
			this.borderColor = Color.DARKBLUE;
		} else {
			this.color = Color.ROSYBROWN;
			this.borderColor = Color.BROWN;
		}
	}

	public void setBGColor(Color color) {
		this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setBDColor(Color bordercolor) {
		this.setBorder(new Border(
				new BorderStroke(borderColor, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	public Text getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		Text t = new Text(detail);
		t.setFont(Font.font("Cloud Light", FontWeight.BOLD, 15));
		t.setTextAlignment(TextAlignment.CENTER);
		this.detail = t;
	}

}
