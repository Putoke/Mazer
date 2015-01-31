import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class MainFrame extends JFrame implements KeyEventDispatcher{
	
	private int CLOSE_KEY = 0;
	private MazePanel mazePanel;
	private MainMenu mainMenu;
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//GUI
		mazePanel = new MazePanel();
		mainMenu = new MainMenu(mazePanel);
		setJMenuBar(mainMenu);		
		mazePanel.setPreferredSize(new Dimension(501, 501));
		setLayout(new BorderLayout());
		add(mazePanel);
		pack();
		
		//Do this last to center the frame.
		setLocationRelativeTo(null);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		if(e.getID() == KeyEvent.KEY_PRESSED) {
			if(e.getKeyCode() == CLOSE_KEY){
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}
		
		return false;
	}
	
	public void setCloseKey(int closeKey) {
		CLOSE_KEY = closeKey;
	}

}
