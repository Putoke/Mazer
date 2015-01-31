import java.awt.Color;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;

public class MazeGenerator {

	public static Maze justRandom() {
		int cellSize = 25, mazeSize = 20;
		Maze maze = new Maze(cellSize, mazeSize);
		int walls = new Random().nextInt(mazeSize*mazeSize+1);
		int[][][] positions = new int[mazeSize][mazeSize][4];
		for(int i=0; i<positions.length; i++)
			for(int j=0; j<positions[0].length; j++)
				for(int k=0; k<positions[0][0].length; k++)
					positions[i][j][k] = 0;
		for(int i=0; i<walls; i++){
			int x = new Random().nextInt(mazeSize), y = new Random().nextInt(mazeSize), z = new Random().nextInt(4);
			while(positions[x][y][z] == 1){
				x = new Random().nextInt(mazeSize);
				y = new Random().nextInt(mazeSize);
			}
			positions[x][y][z] = 1;
			maze.removeWall(x, y, z);
		}
		maze.getCell(new Random().nextInt(mazeSize), new Random().nextInt(mazeSize)).setColor(Color.ORANGE);;
		return maze;
	}
	
	public static Maze depthFirstMaze(int cellSize, int mazeSize) {
		Maze maze = new Maze(cellSize, mazeSize);
		Deque<Point> cellStack = new ArrayDeque<Point>();
		int totalCells = mazeSize*mazeSize;
		Point currentCell = new Point(new Random().nextInt(mazeSize), new Random().nextInt(mazeSize));
		int visitedCells = 1;
		maze.setCellColor(currentCell.x, currentCell.y, Color.ORANGE);
		
		while(visitedCells < totalCells) {
			ArrayList<Integer> wallsToNeighbours = new ArrayList<Integer>();
			
			int check = 0;
			for(int i=0; i<4; i++){
				if(currentCell.x-1 < 0 || maze.getWall(currentCell.x-1, currentCell.y, i).isRemoved())
					break;
				check++;
			}
			if(check == 4)
				wallsToNeighbours.add(0);

			check = 0;
			for(int i=0; i<4; i++){
				if(currentCell.y-1 < 0 || maze.getWall(currentCell.x, currentCell.y-1, i).isRemoved())
					break;
				check++;
			}
			if(check == 4)
				wallsToNeighbours.add(1);
			
			check = 0;
			for(int i=0; i<4; i++){
				if(currentCell.x+1 >= mazeSize || maze.getWall(currentCell.x+1, currentCell.y, i).isRemoved())
					break;
				check++;
			}
			if(check == 4)
				wallsToNeighbours.add(2);
			
			check = 0;
			for(int i=0; i<4; i++){
				if(currentCell.y+1 >= mazeSize || maze.getWall(currentCell.x, currentCell.y+1, i).isRemoved())
					break;
				check++;
			}
			if(check == 4)
				wallsToNeighbours.add(3);
			
			if(wallsToNeighbours.size() > 0) {
				Collections.shuffle(wallsToNeighbours);
				maze.removeWall(currentCell.x, currentCell.y, wallsToNeighbours.get(0));
				cellStack.push(new Point(currentCell.x, currentCell.y));
				switch (wallsToNeighbours.get(0)) {
				case 0:
					currentCell = new Point(currentCell.x-1, currentCell.y);
					break;
				case 1:
					currentCell = new Point(currentCell.x, currentCell.y-1);
					break;
				case 2:
					currentCell = new Point(currentCell.x+1, currentCell.y);
					break;
				case 3:
					currentCell = new Point(currentCell.x, currentCell.y+1);
					break;
				}
				visitedCells++;
			} else {
				currentCell = cellStack.pop();
			}
		}
		
		return maze;
	}
	
	public static Maze jogolMaze() {
		return new Maze(26, 20);
	}
	
}