import java.awt.Color;
import java.awt.Polygon;


public class Wall extends Polygon{
	
	private Color color;
	
	public Wall(int x, int y, int size) {
		addPoint(x, y);
		addPoint(x + size, y);
		addPoint(x + size, y + size);
		addPoint(x, y + size);
		color = Color.BLACK;
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
