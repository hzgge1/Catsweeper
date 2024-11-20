package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Game.Game;

public class GUI {
	
	private Game game;
	private JFrame frame;
	private final int Menu_hight = 20;
	private MenuBar menu;
	private StatusPanel status;
	private FrameSize frameSize = FrameSize.SMALL;
	
	public GUI(Game game) {
		this.game = game;
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		setDimension();
		addPanels();
	}
	
	private void addPanels() {
		menu = new MenuBar(this);
		frame.add(menu.getMenuBar(),BorderLayout.NORTH);
		
		status = new StatusPanel();
		frame.add(status.getStatusPanel(),BorderLayout.CENTER);
	}

	public void show(){
		this.frame.show();
	}
	
	private void setDimension() {
		this.setDimension(Menu_hight+frameSize.getWidth(), frameSize.getHight());
	}
	
	private void setDimension(int width, int hight) {
		frame.setSize(width, hight);
	}
	
	public JFrame getGUIFrame() {
		return frame;
	}
	
	public int getFrameWidth() {
		return frameSize.getWidth();
	}
	
	public void startNewGame() {
		game.newGame();
	}

	public void restart() {
		status.restart();
	}
}