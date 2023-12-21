package map;

import java.util.ArrayList;
import java.util.Random;

public class Country implements Attackable {
	private String name;
	private int amountSoldier;
	private boolean isBelongPlayer1;
	private ArrayList<Country> adjacencyCountry;

	public Country(String name, boolean isBelongPlayer1, ArrayList<Country> adjacencyCountry) {
		this.setName(name);
		this.setBelongPlayer1(isBelongPlayer1);
		this.setAdjacencyCountry(adjacencyCountry);
		Random r = new Random();
		amountSoldier = r.nextInt(4) + 2;
		this.setAmountSoldier(amountSoldier);
	}

	public void deploySoldier(int amountSoldier) {
		this.setAmountSoldier(this.getAmountSoldier() + amountSoldier);
	}

	public boolean isAdjacent(Country country) {
		return this.getAdjacencyCountry().contains(country);
	}

	public void balanceSoldier(Country country) {
		if (country.belongPlayer1() == this.belongPlayer1() && this.isAdjacent(country)) {
			int summation = this.getAmountSoldier() + country.getAmountSoldier();
			int parameter = summation / 2;
			this.setAmountSoldier(parameter);
			country.setAmountSoldier(summation - parameter);
		}
	}

	public void attack(Country country) {
		if (this.belongPlayer1() != country.belongPlayer1() && this.isAdjacent(country)
				&& this.getAmountSoldier() > 1) {
			double randomVariable = Math.random();
			int loseAmount;
			if (this.getAmountSoldier() < country.getAmountSoldier()) {
				loseAmount = (int) (randomVariable * this.getAmountSoldier());
				this.setAmountSoldier(1);
				country.setAmountSoldier(country.getAmountSoldier() - loseAmount);
			} else if (this.getAmountSoldier() < country.getAmountSoldier() + 3) {
				Random randomWin = new Random();
				int rate = (this.getAmountSoldier() - country.getAmountSoldier() + 1) * 2 + 1;
				if (randomWin.nextInt(10) < rate) {
					country.setBelongPlayer1(!country.belongPlayer1());
					country.setAmountSoldier(
							randomWin.nextInt(this.getAmountSoldier() - country.getAmountSoldier() + 1) + 1);
				} else {
					if (this.getAmountSoldier() == country.getAmountSoldier()) {
						country.setAmountSoldier(2);
					} else {
						country.setAmountSoldier(1);
					}
				}
				this.setAmountSoldier(1);

			} else {
				loseAmount = (int) (randomVariable * country.getAmountSoldier());
				country.setAmountSoldier(this.getAmountSoldier() - loseAmount - 1);
				this.setAmountSoldier(1);
				country.setBelongPlayer1(!country.belongPlayer1());
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmountSoldier() {
		return this.amountSoldier;
	}

	public void setAmountSoldier(int amountSoldier) {
		this.amountSoldier = amountSoldier < 1 ? 1 : amountSoldier;
	}

	public boolean belongPlayer1() {
		return this.isBelongPlayer1;
	}

	public void setBelongPlayer1(boolean isBelongPlayer1) {
		this.isBelongPlayer1 = isBelongPlayer1;
	}

	public ArrayList<Country> getAdjacencyCountry() {
		return this.adjacencyCountry;
	}

	public void setAdjacencyCountry(ArrayList<Country> adjacencyCountry) {
		this.adjacencyCountry = adjacencyCountry;
	}

}
