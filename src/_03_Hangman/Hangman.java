package _03_Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements ActionListener, KeyListener {
JFrame frame;
JPanel panel;
JLabel label;
Stack<String> words = new Stack<>();
JButton button;

	void start() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		button = new JButton();
		
		frame.add(panel);
		panel.add(label);
		panel.add(button);
		
		button.setVisible(false);
		button.addActionListener(this);
		
		label.addKeyListener(this);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hangman");
		frame.pack();
		
		String answer = JOptionPane.showInputDialog(null, "How many words do you want to guess? (1-266)");
		
		for (int i = 0; i < Integer.valueOf(answer); i++) {
			String e = Utilities.readRandomLineFromFile("dictionary.txt");
			if (words.contains(e)) {
				while (words.contains(e)) {
					e = Utilities.readRandomLineFromFile("dictionary.txt");
				}
			}
			
			words.push(e);
		}
		newRound();
	}
	
	void newRound() {
		String word = words.pop();
		String text = word;
		
		label.setText("");
		
		//find a way to make text a bunch of -'s but with the length of the word
		
		if (!words.isEmpty()) {
			newRound();
		} else {
			gameWin();
		}
	}
	
	void gameOver() {
		label.setText("You lost all of your lives.");
		button.setText("Continue?");
		button.setVisible(true);
		frame.pack();
	}
	
	void gameWin() {
		label.setText("You won the game!");
		button.setText("New Game?");
		button.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
