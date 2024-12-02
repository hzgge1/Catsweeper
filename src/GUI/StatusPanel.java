package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StatusPanel {

	private GUI gui;
	private JPanel status;
	private int counter = 600;

	public StatusPanel(GUI gui) {
		this.gui = gui;
		creatStatus();
	}
	
	/**
	 * 创建状态栏
	 */
	public void creatStatus() {
		this.status = new JPanel();
		status.setSize(gui.getFrameSize().getWidth(), gui.getFrameSize().STATUSPANEL_HEIGHT);
		
		status.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel times = new JLabel("剩余时间:" + counter);
		status.add(times);

		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter--;
				times.setText("剩余时间:" + counter);
			}
		});
		timer.start();
		
		JLabel pWin = new JLabel("地雷数量:"+gui.getGame().getNumberCats()+" 游戏难度:"+getGameLevel());
		status.add(pWin);
		
	}
	
	/**
	 * 为游戏计算难度
	 * @return 输出String类, 游戏难度
	 */
	private String getGameLevel() {
		double p = gui.getGame().getNumberCats() / (gui.getFrameSize().getNumCols()*gui.getFrameSize().getNumRows());
		if(p <= 0.10) return "简单";
		else if(p <= 0.20) return "中等";
		else if(p <= 0.30) return "困难";
		else if(p <= 0.5) return "极难";
		else return "小子你不行的 两个中至少有一个是";
	}
	
	/**
	 * 获取状态栏
	 * @return 输出JPanel类, 状态栏
	 */
	public JPanel getStatusPanel() {
		return status;
	}

	/**
	 * 重置计时时间
	 */
	public void restart() {
		counter = 601;
	}
}
