import java.awt.Color;


public class Wall extends MazeObject{
	
	private boolean removed;

	public Wall(int x, int y, int length, boolean horizontal) {
		color = Color.WHITE;
		addPoint(x, y);
		if(horizontal) {
			addPoint(x+length, y);
			addPoint(x+length, y+1);
			addPoint(x, y+1);
		} else {
			addPoint(x, y+length);
			addPoint(x+1, y+length);
			addPoint(x+1, y);
		}
		removed = false;
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
}
