import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MazePanel extends JPanel{
	
	private Maze maze;
	private Color mazeColor;
	
	public MazePanel() {
		maze = new Maze(0, 0);
		mazeColor = Color.BLACK;//new Color(100, 149, 237);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(mazeColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		maze.printCells(g);
		maze.printWalls(g);
	}
	
	public void updateMaze(Maze maze) {
		this.maze = maze;
		repaint();
	}
	
	public void setMazeColor(Color color) {
		mazeColor = color;
	}
}
