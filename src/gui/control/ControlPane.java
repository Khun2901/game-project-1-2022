package gui.control;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.Player;

public class ControlPane extends VBox {

	private Text gameText, gameText2, titleText;
	private SkipButton skipButton;
	private StartButton startButton;
	private NextPhaseButton nextPhaseButton;
	private DeployButton deployButton;
	private AttackButton attackButton;
	private FortifyButton fortifyButton;
	private CardPane cardPane;

	public ControlPane() {
		this.setPrefWidth(350);
		this.setPrefHeight(650);
		this.setMaxWidth(350);
		this.setMaxHeight(650);
		this.setSpacing(20);
		this.setPadding(new Insets(30, 0, 0, 0));
		this.initializeStartButton();
		this.initializeSkipButton();
		this.initializeNextPhaseButton();
		this.initializeDeployButton();
		this.initializeAttackButton();
		this.initializeFortifyButton();
		this.initializeTitleText();
		this.initializeGameText();
		this.initializeGameText2();
		this.getChildren().addAll(titleText, gameText, gameText2, startButton);
		this.setAlignment(Pos.TOP_CENTER);
		this.setBackground(
				new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void initializeTitleText() {
		Text text = new Text("SHEESH's\nGlobal\nDomination");
		text.setFont(Font.font("Cooper Black", FontWeight.NORMAL, 40));
		text.setTextAlignment(TextAlignment.CENTER);
		this.setTitleText(text);
	}

	public void initializeGameText() {
		Text text = new Text("");
		text.setFont(Font.font("Cloud Light", FontWeight.NORMAL, 30));
		text.setTextAlignment(TextAlignment.CENTER);
		this.setGameText(text);

	}

	public void initializeGameText2() {
		Text text = new Text("Press Start!");
		text.setFont(Font.font("Cloud Light", FontWeight.NORMAL, 25));
		text.setTextAlignment(TextAlignment.CENTER);
		this.setGameText2(text);

	}

	public void initializeStartButton() {
		StartButton sb = new StartButton();
		this.setStartButton(sb);
	}

	public void initializeNextPhaseButton() {
		NextPhaseButton nb = new NextPhaseButton();
		this.setNextPhaseButton(nb);
	}

	public void initializeDeployButton() {
		DeployButton db = new DeployButton();
		this.setDeployButton(db);
	}

	public void initializeAttackButton() {
		AttackButton ab = new AttackButton();
		this.setAttackButton(ab);
	}

	public void initializeFortifyButton() {
		FortifyButton fb = new FortifyButton();
		this.setFortifyButton(fb);
	}
	
	public void initializeSkipButton() {
		SkipButton skb = new SkipButton();
		this.setSkipButton(skb);
	}

	public StartButton getStartButton() {
		return startButton;
	}

	public void setStartButton(StartButton startButton) {
		this.startButton = startButton;
	}

	public NextPhaseButton getNextPhaseButton() {
		return nextPhaseButton;
	}

	public void setNextPhaseButton(NextPhaseButton nextPhaseButton) {
		this.nextPhaseButton = nextPhaseButton;
	}

	public DeployButton getDeployButton() {
		return deployButton;
	}

	public void setDeployButton(DeployButton deployButton) {
		this.deployButton = deployButton;
	}

	public AttackButton getAttackButton() {
		return attackButton;
	}

	public void setAttackButton(AttackButton attackButton) {
		this.attackButton = attackButton;
	}

	public FortifyButton getFortifyButton() {
		return fortifyButton;
	}

	public void setFortifyButton(FortifyButton fortifyButton) {
		this.fortifyButton = fortifyButton;
	}

	public SkipButton getSkipButton() {
		return skipButton;
	}

	public void setSkipButton(SkipButton skipButton) {
		this.skipButton = skipButton;
	}

	public Text getGameText() {
		return gameText;
	}

	public void setGameText(Text gameText) {
		this.gameText = gameText;
	}

	public void setGameText(String text) {
		Text t = new Text(text);
		t.setFont(Font.font("Cloud Light", FontWeight.NORMAL, 30));
		this.gameText = t;
	}

	public Text getTitleText() {
		return titleText;
	}

	public void setTitleText(Text titleText) {
		this.titleText = titleText;
	}

	public Text getGameText2() {
		return gameText2;
	}

	public void setGameText2(Text gameText2) {
		this.gameText2 = gameText2;
	}

	public void setGameText2(String text) {
		Text t = new Text(text);
		t.setFont(Font.font("Cloud Light", FontWeight.NORMAL, 25));
		this.gameText2 = t;
	}

	public CardPane getCardPane() {
		return cardPane;
	}

	public void setCardPane(CardPane cardPane) {
		this.cardPane = cardPane;
	}
	
	public void setCardPane(Player player) {
		CardPane cardp = new CardPane(player);
		this.setCardPane(cardp);
	}

}
