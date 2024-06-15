package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JLabel label = new JLabel();
Stack<String> deleted = new Stack<>();

void setup() {
	frame.setVisible(true);
	frame.add(panel);
	panel.add(label);
	
	frame.setTitle("Text Editor");
	frame.addKeyListener(this);
	label.setText("Text");
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
}

@Override
public void keyPressed(KeyEvent e) {
if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	if (label.getText() != null) {
		deleted.push(label.getText().substring(label.getText().length() - 1));
		StringBuilder build = new StringBuilder(label.getText());
		build.replace(label.getText().length() - 1, label.getText().length(), "");
		label.setText(build.toString());
	}
} else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
	label.setText(label.getText() + deleted.pop());
} else {
	label.setText(label.getText() + String.valueOf(e.));
}
frame.pack();
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}
