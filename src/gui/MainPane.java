package gui;

import gui.board.BoardPane;
import gui.control.ControlPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MainPane extends HBox {

	private BoardPane boardPane;
	private ControlPane controlPane;

	public MainPane() {
		this.initializeBoardPane();
		this.initializeControlPane();

		this.setSpacing(30);
		this.getChildren().addAll(this.getBoardPane(), this.getControlPane());

		this.setAlignment(Pos.CENTER);
		this.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void initializeBoardPane() {
		BoardPane bp = new BoardPane();
		this.setBoardPane(bp);
	}

	public void initializeControlPane() {
		ControlPane cp = new ControlPane();
		this.setControlPane(cp);
	}

	public BoardPane getBoardPane() {
		return boardPane;
	}

	public void setBoardPane(BoardPane boardPane) {
		this.boardPane = boardPane;
	}

	public ControlPane getControlPane() {
		return controlPane;
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}

}
