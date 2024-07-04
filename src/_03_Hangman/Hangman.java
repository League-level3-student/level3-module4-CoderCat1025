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
	Stack<String> words;
	JButton button;
	String answer;
	String word;
	StringBuilder text;
	int lives;

	void start() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		button = new JButton();
		words = new Stack<>();

		lives = 10;

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

		answer = "0";

		while (Integer.valueOf(answer) < 1 || Integer.valueOf(answer) > 266) {
			answer = JOptionPane.showInputDialog(null, "How many words do you want to guess? (1-266)");
		}

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
		word = words.pop();
		text = new StringBuilder(word);

		text.replace(0, text.length()-1, "-");

		label.setText(String.valueOf(text));

		while (String.valueOf(text).contains("-")) {

		}


		if (!words.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You guessed the hidden word!");
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
		if (word.contains(String.valueOf(e.getKeyChar()))) {

		} else {
			lives--;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
