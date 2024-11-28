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
	private JButton[][] buttonMatrix;
	private JPanel gridPanel;
	
	private ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("Image/caticon3-2.png"));
	private ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("Image/caticon2-2.jpg"));

	public GameGrid(GUI gui) {
		this.gui = gui;
		this.gameMatrix = gui.getFrameSize().getGridMatrix();
		this.buttonMatrix = new JButton[gameMatrix.length][gameMatrix[0].length];
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
		for (int i = 0; i < buttonMatrix.length; i++) {
			for (int j = 0; j < buttonMatrix[i].length; j++) {
				JButton button = getButton(i, j);
				// 设置按钮的大小为正方形
				button.setPreferredSize(new Dimension(gui.getFrameSize().buttonSize, gui.getFrameSize().buttonSize));
				gridPanel.add(button);
				buttonMatrix[i][j] = button;
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
	                    handleRightClick(button, type);
	                    type = (type == 3) ? 1 : type + 1;
	                }
	            }

	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (e.getButton() == MouseEvent.BUTTON1) { // 判断左键
	                    handleLeftClick(button);
	                }
	            }
	        });

	        return button;
	    }

	 private void handleLeftClick(JButton button) {
	        button.setEnabled(false); // 禁用按钮
	        int i = Integer.parseInt(button.getName().split(",")[0]); // 获取按钮所处位置的行
	        int j = Integer.parseInt(button.getName().split(",")[1]); // 获取按钮所处位置的列

	        if (gui.getGame().getGameMatrix().isCat(i, j)) {
	            button.setIcon(icon2);
	            button.setPressedIcon(icon2); // 按下时的图标
	            button.setDisabledIcon(icon2); // 禁用时保持按下图标的效果
	        } else {
	            int x = gui.getGame().getGameMatrix().getNumberOfCatsInNineSquareGrid(i, j);
	            if (x == 0) {
	                ClickTheNineSquareButtons(i, j);
	            } else {
	                button.setText(String.valueOf(x));
	            }
	        }

	        removeAllMouseListeners(button);
	    }

	    private void handleRightClick(JButton button, int type) {
	        switch (type) {
	            case 1 -> button.setText("?");
	            case 2 -> {
	                button.setText(null);
	                button.setIcon(icon1);
	            }
	            case 3 -> {
	                button.setIcon(null);
	                button.setText(null);
	            }
	        }
	    }

	    private void ClickTheNineSquareButtons(int i, int j) {
	        // 标记按钮已处理
	        JButton button = buttonMatrix[i][j];
	        button.setEnabled(false);

	        int value = gui.getGame().getGameMatrix().getNumberOfCatsInNineSquareGrid(i, j);

	        if (value == 0) {
	            button.setText(""); // 值为 0 显示为空
	        } else {
	            button.setText(String.valueOf(value)); // 显示周围猫的数量
	        }

	        // 检查九宫格的所有邻居
	        for (int dx = -1; dx <= 1; dx++) {
	            for (int dy = -1; dy <= 1; dy++) {
	                int newI = i + dx;
	                int newJ = j + dy;

	                // 确保新的坐标在范围内且按钮未被处理
	                if (newI >= 0 && newI < buttonMatrix.length &&
	                        newJ >= 0 && newJ < buttonMatrix[0].length &&
	                        buttonMatrix[newI][newJ].isEnabled()) {

	                    int neighborValue = gui.getGame().getGameMatrix().getNumberOfCatsInNineSquareGrid(newI, newJ);

	                    if (neighborValue == 0) {
	                        ClickTheNineSquareButtons(newI, newJ); // 递归处理值为 0 的邻居
	                    } else {
	                        revealButton(newI, newJ); // 仅揭示邻居，不递归
	                    }
	                }
	            }
	        }
	    }

	    private void revealButton(int i, int j) {
	        JButton button = buttonMatrix[i][j];
	        int value = gui.getGame().getGameMatrix().getNumberOfCatsInNineSquareGrid(i, j);

	        if (value == 0) {
	            button.setText(""); // 显示为空
	        } else {
	            button.setText(String.valueOf(value)); // 显示数字
	        }

	        button.setEnabled(false); // 禁用按钮
	        removeAllMouseListeners(button);
	    }

	    private void removeAllMouseListeners(JButton button) {
	        // 移除所有鼠标监听器
	        for (MouseListener listener : button.getMouseListeners()) {
	            button.removeMouseListener(listener);
	        }

	    }
}
