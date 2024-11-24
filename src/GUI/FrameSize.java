package GUI;

public enum FrameSize {

    SMALL(8, 10), MEDIUM(15, 12), LARGE(20, 15);

    private final int numCols; // 按钮列数
    private final int numRows; // 按钮行数
    public final int buttonSize = 50; // 单个按钮的尺寸(像素)
    public final int STATUSPANEL_HEIGHT = 35; // 状态栏高度(像素)

    FrameSize(int numCols, int numRows) {
        this.numCols = numCols;
        this.numRows = numRows;
    }

    // 获取窗口宽度(像素)
    public int getWidth() {
        return numCols * buttonSize;
    }

    // 获取窗口高度(像素)
    public int getHeight() {
        return numRows * buttonSize;
    }

    // 返回网格矩阵
    public int[][] getGridMatrix() {
        return new int[numRows][numCols]; // 行数为第一维，列数为第二维
    }

    // 返回按钮列数
    public int getNumCols() {
        return numCols;
    }

    // 返回按钮行数
    public int getNumRows() {
        return numRows;
    }
}
