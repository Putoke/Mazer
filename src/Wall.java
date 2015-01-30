import java.awt.Color;
import java.awt.Polygon;


public class Wall extends Polygon{
	
	private Color color;
	
	public Wall(int x, int y) {
		addPoint(x, y);
		addPoint(x + 25, y);
		addPoint(x + 25, y + 25);
		addPoint(x, y + 25);
		color = Color.BLACK;
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
