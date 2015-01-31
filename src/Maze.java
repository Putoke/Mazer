import java.awt.Color;
import java.awt.Graphics;

public class Maze{

	private Cell[][] cells;
	private Wall[][][] walls;
	private int mazeSize, cellSize;
	
	public Maze(int cellSize, int mazeSize) {
		cells = new Cell[mazeSize][mazeSize];
		walls = new Wall[mazeSize][mazeSize][4];
		for(int x=0; x<mazeSize; x++) {
			for(int y=0; y<mazeSize; y++) {
				int xPos = x*cellSize, yPos = y*cellSize;
				cells[x][y] = new Cell(xPos, yPos, cellSize);
				
				if(x-1 < 0)
					walls[x][y][0] = new Wall(xPos, yPos, cellSize, false);
				else
					walls[x][y][0] = walls[x-1][y][2] = new Wall(xPos, yPos, cellSize, false);
				
				if(y-1 < 0)
					walls[x][y][1] = new Wall(xPos, yPos, cellSize, true);
				else
					walls[x][y][1] = walls[x][y-1][3] = new Wall(xPos, yPos, cellSize, true);
				
				if(x+1 >= mazeSize)
					walls[x][y][2] = new Wall(xPos+cellSize, yPos, cellSize, false);
				else
					walls[x][y][2] = walls[x+1][y][0] = new Wall(xPos+cellSize, yPos, cellSize, false);
				
				if(y+1 >= mazeSize)
					walls[x][y][3] = new Wall(xPos, yPos+cellSize, cellSize, true);
				else
					walls[x][y][3] = walls[x][y+1][1] = new Wall(xPos, yPos+cellSize, cellSize, true);
			}
		}
		this.mazeSize = mazeSize;
		this.cellSize = cellSize;
	}
	
	public int getMazeSize() {
		return mazeSize;
	}
	
	public int getCellSize() {
		return cellSize;
	}
	
	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
	
	public Wall getWall(int x, int y, int z) {
		return walls[x][y][z];
	}
	
	public void setCellColor(int x, int y, Color c) {
		cells[x][y].setColor(c);
	}
	
	public void removeWall(int x, int y, int z) {
		walls[x][y][z].remove();
	}
		
	public void printCells(Graphics g) {
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells[0].length; y++) {
				g.setColor(cells[x][y].getColor());
				g.fillPolygon(cells[x][y]);
			}
		}
	}
	
	public void printWalls(Graphics g) {
		for(int x=0; x<walls.length; x++){
			for(int y=0; y<walls[0].length; y++){
				for(int z=0; z<walls[0][0].length; z++){
					if(!walls[x][y][z].isRemoved()){
						g.setColor(walls[x][y][z].getColor());
						g.fillPolygon(walls[x][y][z]);
					}
				}
			}
		}
	}
	
}
