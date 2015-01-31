import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MazePanel extends JPanel{
	
	private Maze maze;
	private Color mazeColor;
	private MainFrame mainFrame;
	
	public MazePanel(MainFrame mainFrame) {
		maze = new Maze(0, 0);
		mazeColor = Color.BLACK;//new Color(100, 149, 237);
		this.mainFrame = mainFrame;
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
		setPreferredSize(new Dimension(maze.getMazeSize()*maze.getCellSize()+1, maze.getMazeSize()*maze.getCellSize()+1));
		mainFrame.pack();
	}
	
	public void setMazeColor(Color color) {
		mazeColor = color;
	}
	
	public void saveImage() {
		BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		paintComponent(g);
		g.dispose();
		try {
			ImageIO.write(bi, "png", new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
