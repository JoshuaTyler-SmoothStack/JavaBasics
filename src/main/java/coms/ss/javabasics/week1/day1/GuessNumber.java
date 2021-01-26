package coms.ss.javabasics.week1.day1;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A guessing game which assigns a random int 1-100 and gives the user 5
 * attempts to guess correctly.
 * 
 * @author Joshua Tyler
 */
public class GuessNumber {
  public static Integer randomNum;
  public static Integer guessesRemaining = 5;
  public static GUI inputGUI;

  /**
   * Sets the random value and instantiates the GUI
   * 
   * @param args - unused
   */
  public static void main(String[] args) {
    Random numGen = new Random();
    randomNum = numGen.nextInt(100) + 1;
    inputGUI = new GUI();
  }

  /**
   * Compares the user's input value. Checks that it is a valid int and is within
   * the range of 1-100. Determines if the input is correct, close, or far off
   * enough for a hint. If the user has no guesses remaing, reports correct
   * answer.
   * 
   * @param userInput - string parsed as an int to compare against randomly
   *                  generated value
   */
  public static String compareGuessToRandom(String userInput) {

    // Try ParseInt - notifying user if invalid input
    Integer inputInt = null;
    try {
      inputInt = Integer.parseInt(userInput);
    } catch (NumberFormatException error) {
      return "Please guess whole numbers 1-100.";
    }

    // Check that the input is within the bounds of 1-100
    if (inputInt < 1 || inputInt > 100) {
      return "Please guess whole numbers 1-100.";
    }

    // Reduce the user's number of guesses
    guessesRemaining -= 1;

    // Determine how far off the guess is
    Integer offset = inputInt - randomNum;

    // User guessed correctly
    if (offset == 0) {
      return "Winner! - " + randomNum;
    }

    // Check if the user has guesses remaining
    else if (guessesRemaining > 0) {

      // User guessed within 10 digits
      if (Math.abs(offset) < 11) {
        return "You are very close! - " + randomNum;
      }

      // User did not guess within 10 digits
      else {
        String hint = (offset > 0) ? "lower." : "higher.";
        return "Not quite, guess " + hint;
      }
    }

    // User has run out of guess attempts
    else {
      return "Sorry. Number was: " + randomNum;
    }
  }

  /**
   * Instantiates a GUI to inform the user of the game's state and to receive
   * input from the user
   */
  public static class GUI implements ActionListener {
    final Integer frameHeight = 200;
    final Integer frameWidth = 300;
    final Integer textInputHeight = 30;
    final Integer textInputWidth = 100;

    JButton button;
    JFrame frame;
    JLabel label;
    JPanel panel;
    JTextField textInput;

    /**
     * Constructs the GUI elements
     */
    public GUI() {

      // Label
      label = new JLabel("Guess A Number 1-100!");

      // Text Field
      textInput = new JTextField(20);
      Integer textInputOffsetX = (int) ((frameWidth - textInputWidth) * 0.5);
      Integer textInputOffsetY = 0;
      textInput.setBounds(textInputOffsetX, textInputOffsetY, textInputWidth, textInputHeight);

      // Button
      button = new JButton("Submit");
      button.addActionListener(this);

      // Panel
      panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder((int) (frameHeight * 0.5), (int) (frameWidth * 0.5),
          (int) (frameHeight * 0.5), (int) (frameWidth * 0.5)));
      panel.setLayout(new GridLayout(0, 1));
      panel.add(label);
      panel.add(textInput);
      panel.add(button);

      // Frame
      frame = new JFrame();
      frame.add(panel, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Guess A Number");
      frame.pack();
      frame.setVisible(true);
    }

    /**
     * Listens to Action from the GUI, calls the textInput to be processed, and
     * update the GUI layout to inform the user of the game's state
     * 
     * @param e - the ActionEvent passed fropm submit button's ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      String newLabel = compareGuessToRandom(textInput.getText());
      if (newLabel.startsWith("Winner") || newLabel.startsWith("Sorry") || 
          newLabel.startsWith("You are very close")) {
        panel.remove(textInput);
        panel.remove(button);
      }
      label.setText(newLabel);
    }
  }
}
