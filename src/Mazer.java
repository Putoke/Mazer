import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Mazer {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setCloseKey(KeyEvent.VK_ESCAPE);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(mainFrame);
		
		mainFrame.setVisible(true);
	}
}
