package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Game.Game;

public class GUI {
	
	private Game game;
	private JFrame frame;
	private MenuBar menu; // 菜单
	private StatusPanel status; // 状态栏
	private GameGrid gameGrid; // 游戏界面
	private FrameSize frameSize = FrameSize.SMALL; // 游戏界面尺寸
	
	public GUI(Game game) {
		this.game = game;
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		setDimension();
		frame.setResizable(false);
		
	}
	
	private void addPanels() {
		menu = new MenuBar(this);
		frame.setJMenuBar(menu.getMenuBar());
		
		gameGrid = new GameGrid(this);
		frame.add(gameGrid.getGridPanel(),BorderLayout.CENTER);
		
		status = new StatusPanel(this);
		frame.add(status.getStatusPanel(),BorderLayout.SOUTH);
	}
	
	public Game getGame() {
		return game;
	}
	
	@SuppressWarnings("deprecation")
	public void show(){
		addPanels();
		this.frame.show();
	}
	
	private void setDimension() {
		this.setDimension(frameSize.getWidth(), frameSize.getHeight()+frameSize.STATUSPANEL_HEIGHT);
	}
	
	private void setDimension(int width, int height) {
		frame.setSize(width, height);
	}
	
	public JFrame getGUIFrame() {
		return frame;
	}
	
	public FrameSize getFrameSize() {
		return frameSize;
	}
	
	public void startNewGame() {
		game.newGame();
		status.restart();
	}

	public void restart() {
		status.restart();
	}
}