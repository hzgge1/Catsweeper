package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameGrid {

	private GUI gui;
	private int[][] gameMatrix;
	private JPanel gridPanel;
	
	private ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("Image/caticon3-2.png"));
	private ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("Image/caticon2-2.jpg"));

	public GameGrid(GUI gui) {
		this.gui = gui;
		this.gameMatrix = gui.getFrameSize().getGridMatrix();
		this.gridPanel = new JPanel();

		// 设置网格布局，无间隙
		gridPanel.setLayout(new GridLayout(gameMatrix.length, gameMatrix[0].length, 0, 0)); // 设置行列间距为0
		addButtons();

		// 设置容器尺寸，确保按钮不被压缩
		int buttonSize = gui.getFrameSize().buttonSize;
		gridPanel.setPreferredSize(new Dimension(buttonSize * gameMatrix[0].length, // 宽度
				buttonSize * gameMatrix.length // 高度
		));
	}

	private void addButtons() {
		for (int i = 0; i < gameMatrix.length; i++) {
			for (int j = 0; j < gameMatrix[i].length; j++) {
				JButton button = getButton(i, j);
				// 设置按钮的大小为正方形
				button.setPreferredSize(new Dimension(gui.getFrameSize().buttonSize, gui.getFrameSize().buttonSize));
				gridPanel.add(button);
			}
		}
	}

	public JPanel getGridPanel() {
		return gridPanel;
	}

	private JButton getButton(int w, int h) {
		JButton button = new JButton();
		button.setName(w + "," + h);
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));		
		
		button.addMouseListener(new MouseAdapter() {
			int type = 1;

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) { // 判断右键
					if (type == 1) {
						button.setText("?");
						type++;
					} else if (type == 2) {
						button.setText(null);
						button.setIcon(icon1);
						type++;
					} else {
						button.setIcon(null);
						button.setText(null);
						type = 1;
					}
				}
			}
		});

		button.addActionListener(e -> buttonAction(button));
		return button;
	}

	private void buttonAction(JButton button) {
		button.setIcon(icon2);
		button.setPressedIcon(icon2); // 按下时的图标
        button.setDisabledIcon(icon2); // 禁用时保持按下图标的效果
		button.setEnabled(false); // 禁用按钮

//		button.setText(button.getName()); // 设置按钮文本
		// 移除所有鼠标监听器
	    for (MouseListener adapter : button.getMouseListeners()) {
	        button.removeMouseListener(adapter);
	    }

	}
}
