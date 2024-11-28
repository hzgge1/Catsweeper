package Game;

import GUI.GUI;

public class Game {
	
	/**
	 * Method Main
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
	}
	
	private GUI gui;
	private GameMatrix gameMatrix; // 游戏矩阵
	private int numberCats = 10; // 猫咪数量, 起始为10
	
	
	public Game() {
		this.gui = new GUI(this);
		this.gameMatrix = new GameMatrix(this);
		gui.show();
	}
	
	/**
	 * 获取游戏界面
	 * @return 输出GUI类, 游戏界面
	 */
	public GUI getGUI() {
		return gui;
	}
	
	/**
	 * 创建新的游戏
	 */
	public void newGame() {
		gameMatrix.creatNewGameMatrix();
		gui.restart();
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
	 * 获取猫咪数量
	 * @return 输出Integer类, 猫咪的数量
	 */
	public int getNumberCats() {
		return numberCats;
	}
	
	/**
	 * 获取游戏矩阵
	 * @return 输出GameMatrix类, 游戏矩阵
	 */
	public GameMatrix getGameMatrix() {
		return gameMatrix;
	}

}
