import java.util.Random;


public class MazeGenerator {

	public static Maze justRandom() {
		Maze maze = new Maze();
		int walls = new Random().nextInt(401);
		int[][] positions = new int[20][20];
		for(int i=0; i<positions.length; i++) {
			for(int j=0; j<positions[0].length; j++) {
				positions[i][j] = 0;
			}
		}
		for(int i=0; i<walls; i++){
			int x = new Random().nextInt(20), y = new Random().nextInt(20);
			while(positions[x][y] == 1){
				x = new Random().nextInt(20);
				y = new Random().nextInt(20);
			}
			positions[x][y] = 1;
			maze.add(new Wall(x*25, y*25));
		}
		return maze;
	}
	
	public static Maze jogolMaze() {
		return new Maze();
	}
	
}