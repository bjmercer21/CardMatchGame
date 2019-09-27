package concentration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

//sets up the clicking on a JButton we created called card

public class GameController implements ActionListener {

	private int pairsMatched = 0;
	private int numberOfClicks = 0;
	private int numberOfPairs;
	private Card card1 = null;
	private Timer t;
	private boolean nextCard = true;
	private static final int TIME_DELAY = 500;

	public GameController(int totalPairs) {
		numberOfPairs = totalPairs;
	}

	/**
	 * This GameController keeps track of the cards that are put on the board. Keeps
	 * track of the number of pairs that are on the board initaly, how many have
	 * been found already, how many clicks have been used, then when both numbers
	 * are equal, calls the isGameOver() method and ends the game and displays the
	 * number of clicks that where used to get there.
	 *
	 */
	public void actionPerformed(ActionEvent arg0) {

		Card temp = (Card) arg0.getSource();
		if (temp.isFaceDown() && nextCard) {
			temp.faceUp();
			numberOfClicks++;
			if (card1 == null) {
				card1 = temp;
			} else {
				if (card1.equals(temp)) {
					pairsMatched++;
					isGameOver();
				} else {
					// Timer delay
					t = new Timer(TIME_DELAY, new delayTimer(card1, temp));
					nextCard = false;
					t.setRepeats(false);
					t.start();
				}
				card1 = null;
			}

		}
	}

	// method to check if game is over and shows the number of clicks that were used
	private void isGameOver() {
		if (numberOfPairs == pairsMatched)
			System.out.println(numberOfClicks);
	}

	// Private class that implements the action listener. used to set up the delay
	// timer to show the cards face color before turning them face down again.
	private class delayTimer implements ActionListener {

		private Card card1, card2;

		public delayTimer(Card c1, Card c2) {
			card1 = c1;
			card2 = c2;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			card1.faceDown();
			card2.faceDown();
			nextCard = true;
		}

	}
}
