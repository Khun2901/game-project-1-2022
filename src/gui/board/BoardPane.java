package gui.board;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import map.Country;
import map.World;

public class BoardPane extends GridPane {

	World world;
	ArrayList<CountryPane> allCountryPane;

	public BoardPane() {
		world = new World();
		this.setPrefWidth(700);
		this.setPrefHeight(650);
		this.setMaxWidth(700);
		this.setMaxHeight(650);
		this.setPadding(new Insets(0));
		this.setHgap(0);
		this.setVgap(0);
		this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.initializeWorldMap();
		this.initialzeWaterPane();
		this.setAlignment(Pos.CENTER);
		
	}

	private void initialzeWaterPane() {
		// TODO Auto-generated method stub
		this.add(new WaterPane(), 0, 0);
		this.add(new WaterPane(), 1, 0);
		this.add(new WaterPane(), 3, 0);
		this.add(new WaterPane(), 8, 0);
		this.add(new WaterPane(), 9, 0);
		this.add(new WaterPane(), 10, 0);
		this.add(new WaterPane(), 5, 1);
		
		
	}

	public void initializeWorldMap() {
		// TODO Auto-generated method stub
		allCountryPane = new ArrayList<CountryPane>();
		ArrayList<Country> allCT = World.getAllCountry();

		allCountryPane.add(new CountryPane(allCT.get(0), 1, 2, 1, 1));  //D
		allCountryPane.add(new CountryPane(allCT.get(1), 1, 1, 2, 0));
		allCountryPane.add(new CountryPane(allCT.get(2), 1, 2, 2, 1));
		allCountryPane.add(new CountryPane(allCT.get(3), 1, 1, 2, 3));
		allCountryPane.add(new CountryPane(allCT.get(4), 2, 1, 1, 4));
		allCountryPane.add(new CountryPane(allCT.get(5), 1, 1, 1, 8));  //P
		allCountryPane.add(new CountryPane(allCT.get(6), 1, 2, 0, 5));
		allCountryPane.add(new CountryPane(allCT.get(7), 1, 1, 1, 5));
		allCountryPane.add(new CountryPane(allCT.get(8), 2, 2, 1, 6));
		allCountryPane.add(new CountryPane(allCT.get(9), 4, 1, 4, 0));  //G
		allCountryPane.add(new CountryPane(allCT.get(10), 2, 2, 3, 1));
		allCountryPane.add(new CountryPane(allCT.get(11), 1, 2, 7, 1));
		allCountryPane.add(new CountryPane(allCT.get(12), 2, 1, 3, 3)); //B
		allCountryPane.add(new CountryPane(allCT.get(13), 1, 1, 4, 4));
		allCountryPane.add(new CountryPane(allCT.get(14), 2, 1, 4, 5));
		allCountryPane.add(new CountryPane(allCT.get(15), 2, 2, 5, 3));
		allCountryPane.add(new CountryPane(allCT.get(16), 2, 2, 7, 3));
		allCountryPane.add(new CountryPane(allCT.get(17), 2, 1, 6, 5));
		allCountryPane.add(new CountryPane(allCT.get(18), 2, 2, 3, 6)); //R
		allCountryPane.add(new CountryPane(allCT.get(19), 2, 1, 4, 8));
		allCountryPane.add(new CountryPane(allCT.get(20), 1, 2, 6, 7));
		allCountryPane.add(new CountryPane(allCT.get(21), 1, 1, 10, 1));//Y
		allCountryPane.add(new CountryPane(allCT.get(22), 2, 1, 8, 1));
		allCountryPane.add(new CountryPane(allCT.get(23), 1, 1, 9, 2)); //C
		allCountryPane.add(new CountryPane(allCT.get(24), 1, 2, 9, 3));
		allCountryPane.add(new CountryPane(allCT.get(25), 1, 1, 10, 4));
		allCountryPane.add(new CountryPane(allCT.get(26), 1, 2, 9, 5)); //W
		allCountryPane.add(new CountryPane(allCT.get(27), 3, 1, 7, 7));
		allCountryPane.add(new CountryPane(allCT.get(28), 1, 1, 10, 6));
		allCountryPane.add(new CountryPane(allCT.get(29), 1, 1, 10, 7));
		

		for (CountryPane cp : allCountryPane) {
			this.add(cp, cp.getxPos(), cp.getyPos(), cp.getxSpan(), cp.getySpan());

		}

	}

}
