/*
 * String Scrambler
 * Sapayth Hossain
 */
package stringscrambler;

import java.util.Random;
import java.util.Scanner;

/**
 * @author sapayth
 */
public class StringScrambler {

    public static void main(String[] args) {
        Scramble scrabmle = new Scramble();
        scrabmle.runIt();
    }
}

class Scramble {

    Scanner input = new Scanner(System.in);

    public void runIt() {
        System.out.println("Input some texts to shuffle them: ");
        String sentence = input.nextLine();

        // first seperate Strings by space and save it in a array
        String[] words = sentence.split("[ ]");

        String scrambled = "";
        for (String word : words) {
            if (word.length() <= 3) {
                scrambled += word + " ";
            } else if (word.length() == 4 && word.charAt(1) == word.charAt(2)) {
                scrambled += word + " ";
            } else {
                char[] characters = word.toCharArray();
                characters[0] = word.charAt(0);
                if (word.charAt(word.length() - 1) == '.'
                        || word.charAt(word.length() - 1) == ','
                        || word.charAt(word.length() - 1) == '!'
                        || word.charAt(word.length() - 1) == '?'
                        || word.charAt(word.length() - 2) == '\'') {

                    // if .,' found end of a String, set last 2 character
                    characters[word.length() - 1] = word.charAt(word.length() - 1);
                    characters[word.length() - 2] = word.charAt(word.length() - 2);

                    // shuffle rest of the characters
                    shuffleChar(characters, characters.length - 3);
                } else {

                    // set the last character
                    characters[word.length() - 1] = word.charAt(word.length() - 1);

                    // shuffle rest of the characters
                    shuffleChar(characters, characters.length - 1);
                }
                scrambled += new String(characters) + " ";
            }
        }
        System.out.println(scrambled);
    } // end of method runIt

    public void shuffleChar(char[] c, int l) {
        for (int j = 1; j < l; j++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(c.length - 3) + 1;
            char temp = c[j];
            c[j] = c[randomIndex];
            c[randomIndex] = temp;
        }
    }

} // end of class Scramble

