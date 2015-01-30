import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;


public class Mazer {
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setCloseKey(KeyEvent.VK_ESCAPE);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(mainFrame);
		
		mainFrame.setVisible(true);
	}
}
