import java.awt.Color;

public class Cell extends MazeObject{
		
	public Cell(int x, int y, int size) {
		addPoint(x, y);
		addPoint(x + size, y);
		addPoint(x + size, y + size);
		addPoint(x, y + size);
		color = new Color(0, 0, 0, 0);
	}
	
}
