package logic;

import java.util.Random;

import card.ArsenalCard;
import card.CavalryCard;
import card.InfantryCard;
import card.UnitCard;
import gui.MainPane;
import gui.board.BoardPane;
import gui.board.CountryPane;
import gui.control.ControlPane;
import map.Country;
import map.World;

public class GameLogic {

	private static GameLogic instance = null;
	private boolean isGameStart = false;
	private boolean isGameEnd;
	private boolean isPlayer1Turn;
	private int phase;
	private MainPane mainPane;
	private CountryPane choosingCountry1;
	private CountryPane choosingCountry2;
	private Player player1;
	private Player player2;

	private GameLogic() {
		this.setPlayer1(new Player("Player 1", true));
		this.setPlayer2(new Player("Player 2", false));
		this.setPhase(-1);

		this.newGame();
	}

	public void newGame() {

		this.setGameEnd(false);
		this.setPlayer1Turn(true);
		this.setPhase(0);
	}

	public void updateStartTurn(Player player) {
		// if (this.getPhase() == 0 || this.getPhase() == 4) {
		player.startTurn();
		player.markBonus();
		player.updateInventory();
		// }
		// this.setPhase(1);
	}

	public void deployPhase(Player player, CountryPane countryPane) {
		if (player.isPlayer1() == this.isPlayer1Turn() && this.getPhase() == 1) {
			player.deploy(countryPane.getCountry());
		}

		// this.setPhase(2);
	}

	public void attackPhase(Player player, CountryPane countryOnAttack, CountryPane countryOnDefense) {
		if (player.isPlayer1() == this.isPlayer1Turn() && this.getPhase() == 2
				&& countryOnAttack.getCountry().belongPlayer1() == player.isPlayer1()) {
			countryOnAttack.getCountry().attack(countryOnDefense.getCountry());
			player.attack(countryOnDefense.getCountry());
		}

		// this.setPhase(3);
	}

	public void fortify(Player player, CountryPane country1, CountryPane country2) {
		if (player.isPlayer1() == this.isPlayer1Turn() && this.getPhase() == 3) {
			player.fortify(country1.getCountry(), country2.getCountry());
		}

		this.setPhase(4);
	}

	public void changeTurn(Player player) {
		if (player.isPlayer1() == this.isPlayer1Turn() && this.getPhase() == 4) {
			player.endTurn();
		}
		this.setPlayer1Turn(!this.isPlayer1Turn());
		// this.setPhase(0);
	}

	public void startGame() {
		this.setGameStart(true);
		this.setPhase(1);
	}

	public boolean checkPlayer1Win() {
		if (this.getPlayer1().checkDominatedWorld()) {
			this.setGameEnd(true);
			return true;
		}
		return false;
	}

	public boolean checkPlayer2Win() {
		if (this.getPlayer2().checkDominatedWorld()) {
			this.setGameEnd(true);
			return true;
		}
		return false;
	}

	public static GameLogic getInstance() {
		if (instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public MainPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(MainPane mainPane) {
		this.mainPane = mainPane;
	}

	public ControlPane getControlPane() {
		return this.getMainPane().getControlPane();
	}

	public BoardPane getBoardPane() {
		return this.getMainPane().getBoardPane();
	}

	public boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}

	public void setPlayer1Turn(boolean isPlayer1Turn) {
		this.isPlayer1Turn = isPlayer1Turn;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public CountryPane getChoosingCountry1() {
		return choosingCountry1;
	}

	public void setChoosingCountry1(CountryPane choosingCountry1) {
		this.choosingCountry1 = choosingCountry1;
	}

	public CountryPane getChoosingCountry2() {
		return choosingCountry2;
	}

	public void setChoosingCountry2(CountryPane choosingCountry2) {
		this.choosingCountry2 = choosingCountry2;
	}

	public boolean isGameStart() {
		return isGameStart;
	}

	public void setGameStart(boolean isGameStart) {
		this.isGameStart = isGameStart;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}
