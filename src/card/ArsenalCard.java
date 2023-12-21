package card;

public class ArsenalCard extends UnitCard implements Useable {
	private int bonusSoldier;

	public ArsenalCard() {
		super("Arsenal");
		this.setBonusSoldier(5);
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
