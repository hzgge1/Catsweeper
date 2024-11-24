package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Game.Game;

public class GUI {
	
	private Game game;
	private JFrame frame;
	public final int MENUBAR_HIGHT = 30; // 菜单高度固定30p
	public final int STATUSPANEL_HIGHT = 30; // 状态栏高度固定30p
	private MenuBar menu; // 菜单
	private StatusPanel status; // 状态栏
	private FrameSize frameSize = FrameSize.SMALL; // 游戏界面尺寸
	
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
		
		status = new StatusPanel(this);
		frame.add(status.getStatusPanel(),BorderLayout.CENTER);
	}

	public void show(){
		this.frame.show();
	}
	
	private void setDimension() {
		this.setDimension(MENUBAR_HIGHT+STATUSPANEL_HIGHT+frameSize.getWidth(), frameSize.getHight());
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