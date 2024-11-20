package GUI;

import javax.swing.JFrame;

public class GUI {
	
	private JFrame frame;
	private final int Menu_hight = 20;
	private FrameSize frameSize = FrameSize.SMALL;
	
	public GUI() {
		this.frame = new JFrame();
		setDimension();
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

}
