package concentration;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Class that creates the Card for the game. Makes the Cards a JButton to be
 * clicked. Sets the back of the card color to gray, and starts the card face
 * down so the gray is face all you see. Sets up the ability to have a face
 * color assigned. Keeps track if the card has been matched with an overridden
 * .equals() method.
 *
 */
@SuppressWarnings("serial")
public class Card extends JButton {
	// Properties
	private static int width = 50;
	private static int height = 100;
	private Color faceColor;
	private static Color backgroundColor = Color.gray;
	private boolean isFaceDown = true;

	private void changeColor(Color c) {
		// using JButton code to set the change color method
		setBackground(c);
		paintImmediately(0, 0, width, height);
	}

	// Behaviors
	public Card(Color faceColor) {
		setPreferredSize(new Dimension(width, height));
		this.faceColor = faceColor;
		// Creates a border around the cards
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		changeColor(backgroundColor);
	}

	public void faceUp() {
		isFaceDown = false;
		changeColor(faceColor);
	}

	public void faceDown() {
		isFaceDown = true;
		changeColor(backgroundColor);
	}

	public boolean equals(Object nextObject) {
		Card otherCard = (Card) nextObject;
		return faceColor.equals(otherCard.faceColor);
	}

	public boolean isFaceDown() {
		return isFaceDown;
	}
}
