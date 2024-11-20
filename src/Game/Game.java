package Game;

import GUI.GUI;

public class Game {
	
	/**
	 * Method Main
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	private GUI gui;
	private int numberLandmines = 10; // 地雷数量, 起始为10
	
	
	public Game() {
		this.gui = new GUI(this);
	}
	
	public void start() {
		gui.show();
	}
	
	/**
	 * 设置地雷数量,输入10到100之间的整数
	 * @param numberLandmines 地雷数量(必须在10到100之间)
	 */
	public void setNumberLandmines(int numberLandmines) {
		if(numberLandmines<=100 && numberLandmines>=10) {
			this.numberLandmines = numberLandmines;
		}
	}
	
	/**
	 * 
	 * @return 地雷的数量
	 */
	public int getNumberLandmines() {
		return numberLandmines;
	}

	public void newGame() {
		gui.restart();
	}

}
