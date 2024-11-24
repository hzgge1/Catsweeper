package GUI;

public enum FrameSize {
	
	SMALL(350,420),MEDIUM(700,420),LARGE(1050,700);
	
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
	
	public int[][] getGridMatrix(){
		return new int[width/35][hight/35];
		
	}
	

}
