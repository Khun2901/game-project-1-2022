package map;

import java.util.ArrayList;

public class Region {
	private String name;
	private int bonusSoldier;
	private ArrayList<Country> countryInRegion;

	public Region(String name, int bonusSoldier, ArrayList<Country> countryInRegion) {
		this.setName(name);
		this.setBonusSoldier(bonusSoldier);
		this.setCountryInRegion(countryInRegion);

	}

	public boolean isOnBonusPlayer1() {
		boolean onBonus = true;
		for (Country country : this.getCountryInRegion()) {
			if (!country.belongPlayer1()) {
				onBonus = false;
				break;
			}
		}
		return onBonus;
	}

	public boolean isOnBonusPlayer2() {
		boolean onBonus = true;
		for (Country country : this.getCountryInRegion()) {
			if (country.belongPlayer1()) {
				onBonus = false;
				break;
			}
		}
		return onBonus;
	}

	public boolean isInRegion(Country country) {
		return this.getCountryInRegion().contains(country);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBonusSoldier() {
		return this.bonusSoldier;
	}

	public void setBonusSoldier(int bonusSoldier) {
		this.bonusSoldier = bonusSoldier < 0 ? 0 : bonusSoldier;
	}

	public ArrayList<Country> getCountryInRegion() {
		return this.countryInRegion;
	}

	public void setCountryInRegion(ArrayList<Country> countryInRegion) {
		this.countryInRegion = countryInRegion;
	}

}
