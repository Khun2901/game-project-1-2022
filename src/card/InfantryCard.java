package card;

public class InfantryCard extends UnitCard implements Useable {
	private int bonusSoldier;

	public InfantryCard() {
		super("Infantry");
		this.setBonusSoldier(3);
	}

	public void use() {
		this.setIsInBonus(true);
	}

	public int getBonusSoldier() {
		return bonusSoldier;
	}

	public void setBonusSoldier(int bonusSoldier) {
		this.bonusSoldier = bonusSoldier;
	}

}
