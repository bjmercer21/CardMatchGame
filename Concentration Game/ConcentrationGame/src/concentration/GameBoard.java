package concentration;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * Starts the game board by asking what number of pairs the user would like to
 * do. Then takes the number of pairs and sets up the game board with n*2 cards.
 * Adds the action listener to each card as it gets set up on the game board.
 * After the cards are placed on the board, and the face color is set to each,
 * it then shuffles the array of cards that have a color attached to the
 * faceColor variable of the card.
 *
 */

@SuppressWarnings("serial")
public class GameBoard extends JFrame {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of pairs you would like: ");
		int n = s.nextInt();
		s.close();

		new GameBoard(n);
	}

	@SuppressWarnings("unused")
	private int howManyPairs;
	@SuppressWarnings("unused")
	private Card arrayOfCards[];

	public GameBoard(int numberOfPairs) {
		howManyPairs = numberOfPairs;

		setTitle("Concentration Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(550, 550);

		// Adds a new card
		Container c = getContentPane();
		c.setLayout(new GridLayout(numberOfPairs / 2, numberOfPairs));

		Card cardArray[] = new Card[numberOfPairs * 2];
		Color colorArray[] = { Color.blue, Color.magenta, Color.yellow, Color.red, Color.orange, Color.green };
		Random rand = new Random();
		GameController gc = new GameController(numberOfPairs);

		for (int x = 0; x < numberOfPairs; x++) {

			cardArray[2 * x] = new Card(colorArray[x % 6]);
			cardArray[2 * x].addActionListener(gc);

			cardArray[2 * x + 1] = new Card(colorArray[x % 6]);
			cardArray[2 * x + 1].addActionListener(gc);

		}

		for (int x = 0; x < cardArray.length; x++) {
			Card temp = cardArray[x];
			int randIndex = rand.nextInt(numberOfPairs * 2);
			cardArray[x] = cardArray[randIndex];
			cardArray[randIndex] = temp;
		}

		for (Card thisCard : cardArray)
			c.add(thisCard);

		this.arrayOfCards = cardArray;
		setVisible(true);
	}

}