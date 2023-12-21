package logic;

import java.util.ArrayList;
import java.util.Random;

import card.ArsenalCard;
import card.CavalryCard;
import card.InfantryCard;
import card.UnitCard;
import card.Useable;
import map.Attackable;
import map.Country;
import map.Region;
import map.World;

public class Player implements Attackable {

	private String name;
	private boolean isPlayer1;
	private ArrayList<UnitCard> inventory;
	private int soldierDeployable;
	private boolean attackSuccess;

	public Player(String name, boolean isPlayer1) {
		this.setName(name);
		this.setPlayer1(isPlayer1);
		this.setInventory(new ArrayList<UnitCard>());
		this.setAttackSuccess(false);
	}

	public int countriesPossessing() {
		int countryCount = 0;
		for (Country country : World.getAllCountry()) {
			if (country.belongPlayer1() == this.isPlayer1()) {
				countryCount++;
			}
		}
		return countryCount;
	}

	public void startTurn() {

		int bonusCount = this.countriesPossessing() / 4;
		for (Region region : World.getAllRegion()) {
			if ((region.isOnBonusPlayer1() && this.isPlayer1()) || region.isOnBonusPlayer2() && !this.isPlayer1()) {
				bonusCount += region.getBonusSoldier();
			}
		}
		this.setSoldierDeployable(bonusCount);
	}

	public void markBonus() {
		int infantry = 0, cavalry = 0, arsenal = 0;
		for (UnitCard card : this.getInventory()) {
			if (card instanceof InfantryCard) {
				infantry++;
			} else if (card instanceof CavalryCard) {
				cavalry++;
			} else if (card instanceof ArsenalCard) {
				arsenal++;
			}
		}

		if (infantry < 3 && cavalry < 3 && arsenal < 3) {
			return;
		}

		String checker;
		if (infantry >= 3) {
			checker = "Infantry";
			this.setSoldierDeployable(this.getSoldierDeployable() + 3);
		} else if (cavalry >= 3) {
			checker = "Cavalry";
			this.setSoldierDeployable(this.getSoldierDeployable() + 4);
		} else {
			checker = "Arsenal";
			this.setSoldierDeployable(this.getSoldierDeployable() + 5);
		}

		int count = 3;
		for (UnitCard card : this.getInventory()) {
			if (count == 0) {
				break;
			}
			if (card.getName() == checker) {
				card.setIsInBonus(true);
				count--;
			}
		}

	}

	public void updateInventory() {
		ArrayList<UnitCard> newInventory = new ArrayList<UnitCard>();
		for (UnitCard card : this.getInventory()) {
			if (!card.getIsInBonus()) {
				newInventory.add(card);
			}
		}
		this.setInventory(newInventory);
	}

	public void deploy(Country country) {
		if (country.belongPlayer1() == this.isPlayer1()) {
			country.deploySoldier(this.getSoldierDeployable());
		}
	}

	@Override
	public void attack(Country country) {
		// TODO Auto-generated method stub
		if (country.belongPlayer1() == this.isPlayer1) {
			this.setAttackSuccess(true);
		}
	}

	public void fortify(Country country1, Country country2) {
		if (this.isPlayer1() == country1.belongPlayer1() && country1.isAdjacent(country2)) {
			country1.balanceSoldier(country2);
		}
	}

	public void endTurn() {
		if (this.isAttackSuccess()) {
			ArrayList<UnitCard> cardPools = new ArrayList<UnitCard>();
			cardPools.add(new InfantryCard());
			cardPools.add(new CavalryCard());
			cardPools.add(new ArsenalCard());

			Random random = new Random();
			UnitCard card = cardPools.get(random.nextInt(3));

			this.getInventory().add(card);
		}
		this.setAttackSuccess(false);
	}

	public boolean checkDominatedWorld() {
		for (Country country : World.getAllCountry()) {
			if (this.isPlayer1 != country.belongPlayer1()) {
				return false;
			}
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPlayer1() {
		return isPlayer1;
	}

	public void setPlayer1(boolean isPlayer1) {
		this.isPlayer1 = isPlayer1;
	}

	public ArrayList<UnitCard> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<UnitCard> inventory) {
		this.inventory = inventory;
	}

	public int getSoldierDeployable() {
		return soldierDeployable;
	}

	public void setSoldierDeployable(int soldierDeployable) {
		this.soldierDeployable = soldierDeployable;
	}

	public boolean isAttackSuccess() {
		return attackSuccess;
	}

	public void setAttackSuccess(boolean attackSuccess) {
		this.attackSuccess = attackSuccess;
	}

}
