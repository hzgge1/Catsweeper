package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuBar {
	
	private JMenuBar menu;
	private GUI gui;
	
	public MenuBar(GUI gui) {
		this.gui = gui;
		this.menu = new JMenuBar();
		this.menu.setSize(gui.getFrameWidth(), gui.MENUBAR_HIGHT);
		creatButtons();
	}
	
	private void creatButtons() {
		JMenu option = new JMenu("菜单");
		JMenuItem newGame = new JMenuItem("新游戏");
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
		                null,
		                "你确定开始新的游戏吗?",
		                "新游戏",
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE
		        );
				if (result == JOptionPane.YES_OPTION) {
					gui.startNewGame();
				}				
			}
		});
		option.add(newGame);
		menu.add(option);
		
		JMenu help = new JMenu("帮助");
		JMenuItem about = new JMenuItem("关于");
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(gui.getGUIFrame(),"关于",true);
				dialog.setSize(200, 200);
				dialog.setLocationRelativeTo(null);
				
				JLabel label = new JLabel("<html><h3>扫猫</h3><p>版本 1.0<br>开发者: 小小王</p></html>", JLabel.CENTER);
				dialog.add(label, BorderLayout.CENTER);
				
				dialog.setVisible(true);
				
			}
		});
		help.add(about);
		menu.add(help);
	}
	
	public  JMenuBar getMenuBar() {
		return menu;
	}
	
	
	
	

}
