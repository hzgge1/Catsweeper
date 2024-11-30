package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StatusPanel {

	private JPanel status;
	private int counter = 600;

	public StatusPanel(GUI gui) {
		this.status = new JPanel();
		status.setSize(gui.getFrameSize().getWidth(), gui.getFrameSize().STATUSPANEL_HEIGHT);
		creatStatus();
	}
	
	/**
	 * 创建状态栏
	 */
	private void creatStatus() {
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
