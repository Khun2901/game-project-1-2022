package card;

public class CavalryCard extends UnitCard implements Useable {
	private int bonusSoldier;

	public CavalryCard() {
		super("Cavalry");
		this.setBonusSoldier(4);
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
