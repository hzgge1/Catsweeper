package GUI;

public class GameGrid {
	
	private GUI gui;
	private int[][] gameMatrix;
	
	
	public GameGrid(GUI gui) {
		this.gui = gui;
		this.gameMatrix = gui.getFrameSize().getGridMatrix();
	}

}
