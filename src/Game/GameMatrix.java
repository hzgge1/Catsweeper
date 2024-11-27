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
	 * 在游戏内创建Game类的默认猫咪数
	 */
	private void creatCatInMatrix() {
		creatCatInMatrix(game.getNumberCats());
	}
	
	/**
	 * 为游戏矩阵里的每个不为猫咪的位置赋值
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
	
	/**
	 * 检查以矩阵的第i行第j列为中心不超过矩阵的九宫格内的猫咪数
	 * @param i 矩阵第i行
	 * @param j 矩阵第j列
	 * @return 输出Integer类, 以矩阵的第i行第j列为中心不超过矩阵的九宫格内的猫咪数(输出值为0-8)
	 */
	private int getNumberOfCatsInTheNineSquareGrid(int i, int j) {
		int count = 0;
		for (int k = Math.max(0, i-1); k <= Math.min(i+1, gameMatrix.length-1); k++) {
			for (int k2 = Math.max(0, j-1); k2 <= Math.min(k2+1, gameMatrix.length-1); k2++) {
				if(gameMatrix[k][k2]==-1) count++;
			}
		}
		return count;
	}
	
	/**
	 * 输出矩阵的第i行第j列是否为猫咪
	 * @param i 矩阵第i行
	 * @param j 矩阵第j列
	 * @return 输出boolean类, 如果是猫咪输出true, 反则输出false
	 */
	public boolean isCat(int i, int j) {
		return gameMatrix[i][j] == -1;
	}
	
	/**
	 * 输出矩阵的第i行第j列的值(-1为猫咪, 0为空, 1-8为当前位置为中心不超过矩阵范围的九宫格内猫咪数)
	 * @param i 矩阵第i行
	 * @param j 矩阵第j列
	 * @return 输出Integer类, 矩阵第i行第j列的值
	 */
	public int getNumberOfCatsInNineSquareGrid(int i, int j) {
		return gameMatrix[i][j];
	}

}
