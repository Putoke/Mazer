import java.util.Random;


public class MazeGenerator {

	public static Maze justRandom() {
		int wallSize = 25, mazeSize = 20;
		Maze maze = new Maze();
		int walls = new Random().nextInt(mazeSize*mazeSize+1);
		int[][] positions = new int[mazeSize][mazeSize];
		for(int i=0; i<positions.length; i++) {
			for(int j=0; j<positions[0].length; j++) {
				positions[i][j] = 0;
			}
		}
		for(int i=0; i<walls; i++){
			int x = new Random().nextInt(mazeSize), y = new Random().nextInt(mazeSize);
			while(positions[x][y] == 1){
				x = new Random().nextInt(mazeSize);
				y = new Random().nextInt(mazeSize);
			}
			positions[x][y] = 1;
			maze.add(new Wall(x*wallSize, y*wallSize, wallSize));
		}
		return maze;
	}
	
	public static Maze jogolMaze() {
		return new Maze();
	}
	
}