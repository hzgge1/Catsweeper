package Game;

public class GameMatrix {

	private Game game;
	private int[][] gameMatrix;

	public GameMatrix(Game game) {
		this.game = game;
		this.gameMatrix = game.getGUI().getFrameSize().getGridMatrix();
		creatCatInMatrix();
		putNumberOfCatsInTheNineSquareGrid();
	}

	/**
	 * 在游戏界面内随机创建numberCat数量的猫咪
	 * @param numberCat 创建的猫咪数量
	 */
	private void creatCatInMatrix(int numberCat) {
		while(numberCat > 0) {
			int i = (int)Math.random()*(gameMatrix.length-1);
			int j = (int)Math.random()*(gameMatrix[0].length-1);
			if(gameMatrix[i][j]!=-1) {
				gameMatrix[i][j] = -1; // 起始0为空, 创建猫咪为-1
				numberCat--;
			}
		}
	}
	
	/**
	 * 
	 */
	private void putNumberOfCatsInTheNineSquareGrid(){
		for (int i = 0; i < gameMatrix.length; i++) {
			for (int j = 0; j < gameMatrix[i].length; j++) {
				if(!isCat(i, j)) {
					gameMatrix[i][j] = getNumberOfCatsInTheNineSquareGrid(i,j);
				}
			}
		}
	}

	private int getNumberOfCatsInTheNineSquareGrid(int i, int j) {
		int count = 0;
		for (int k = Math.max(0, i-1); k <= Math.min(i+1, gameMatrix.length-1); k++) {
			for (int k2 = Math.max(0, j-1); k2 <= Math.min(k2+1, gameMatrix.length-1); k2++) {
				if(gameMatrix[k][k2]==-1) count++;
			}
		}
		return count;
	}

	private void creatCatInMatrix() {
		creatCatInMatrix(game.getNumberCats());
	}
	
	public boolean isCat(int i, int j) {
		return gameMatrix[i][j] == -1;
	}
	
	public int getNumberOfCatsInNineSquareGrid(int i, int j) {
		return gameMatrix[i][j];
	}

}
