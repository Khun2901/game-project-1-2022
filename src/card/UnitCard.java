package card;

public class UnitCard {
	private String name;
	private boolean isInBonus;

	protected UnitCard(String name) {
		this.setName(name);
		this.setIsInBonus(isInBonus);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsInBonus() {
		return isInBonus;
	}

	public void setIsInBonus(boolean b) {
		this.isInBonus = b;
	}

}
