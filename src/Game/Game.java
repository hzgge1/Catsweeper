package Game;

import GUI.GUI;
import GUI.GameGrid;

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
	
	/**
	 * 游戏失败弹窗
	 */
	public void gameOver() {
		gui.timerStop();
		gui.throwDialog("游戏结束", "<html><h3>你死掉了</h3><p>你踩到猫, 被猫咪鲨掉了</p></html>");
	}
	
	/**
	 * 游戏获胜弹窗
	 */
	public void gameWin() {
		gui.timerStop();
		gui.throwDialog("游戏获胜", "<html><h3>获胜了</h3><p>恭喜你找到所有猫咪, 活了下来</p></html>");
		
	}

}
