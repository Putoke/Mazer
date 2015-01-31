import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MainMenu extends JMenuBar{
	
	public MainMenu(final MazePanel mazePanel) {
		JMenu file = new JMenu("File");
		JMenu generateMaze = new JMenu("Generate new maze");
		JMenuItem justRandom = new JMenuItem("Just random");
		justRandom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		justRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mazePanel.updateMaze(MazeGenerator.justRandom());
			}
		});
		JMenuItem jogolMaze = new JMenuItem("Jogol Maze");
		jogolMaze.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
		jogolMaze.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mazePanel.updateMaze(MazeGenerator.jogolMaze());
			}
		});
		JMenuItem depthFirstMaze = new JMenuItem("Depth First Maze");
		depthFirstMaze.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		depthFirstMaze.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mazePanel.updateMaze(MazeGenerator.depthFirstMaze(10, 50));
			}
		});
		
		generateMaze.add(justRandom);
		generateMaze.add(jogolMaze);
		generateMaze.add(depthFirstMaze);
		file.add(generateMaze);
		add(file);
	}
	
}
