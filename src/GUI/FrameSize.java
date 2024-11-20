package GUI;

public enum FrameSize {
	
	SMALL(300,400),MEDIUM(800,500),LARGE(1000,800);
	
	private final int width;
	private final int hight;
	
	FrameSize(int width, int hight) {
		this.width = width;
		this.hight = hight;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHight() {
		return hight;
	}
	

}
