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
	private GameMatrix gameMatrix; // 游戏矩阵
	private int numberCats = 10; // 猫咪数量, 起始为10
	
	
	public Game() {
		this.gui = new GUI(this);
		this.gameMatrix = new GameMatrix(this);
		start();
	}
	
	public GUI getGUI() {
		return gui;
	}
	
	public void start() {
		gui.show();
	}
	
	public void newGame() {

	}
	
	/**
	 * 设置猫咪数量,输入10到100之间的整数
	 * @param numberCat 猫咪数量(必须在10到100之间)
	 */
	public void setNumberCat(int numberCat) {
		if(numberCat<=100 && numberCat>=10) {
			this.numberCats = numberCat;
		}
	}
	
	/**
	 * 
	 * @return 地雷的数量
	 */
	public int getNumberCats() {
		return numberCats;
	}

	public GameMatrix getGameMatrix() {
		return gameMatrix;
	}

}
