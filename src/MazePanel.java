import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MazePanel extends JPanel{
	
	private Maze maze;
	private Color mazeColor;
	
	public MazePanel() {
		maze = new Maze();
		mazeColor = null;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		if(mazeColor != null)
			g.setColor(mazeColor);
		for(Wall w : maze) {
			if(mazeColor == null)
				g.setColor(w.getColor());
			g.fillPolygon(w);
		}
	}
	
	public void updateMaze(Maze maze) {
		this.maze = maze;
		repaint();
	}
	
	public void setMazeColor(Color color) {
		mazeColor = color;
	}
}
