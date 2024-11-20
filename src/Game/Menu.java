package Game;

public class Menu {
	
	private Game game;
	
	public Menu(Game game) {
		this.game = game;
	}
	
	/**
	 * 设置地雷数量,输入10到100之间的整数
	 * @param numberLandmines 地雷数量(必须在10到100之间)
	 */
	public void setNumberLandmines(int numberLandmines) {
		game.setNumberLandmines(numberLandmines);
	}

}
