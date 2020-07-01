/*
 * Allison Snipes
 * Course 605.201.81 Summer 2020
 * Module 5 Question 1
 * 
 * Application Requirements:
 * This project involves writing a program to translate Morse code into English and English into Morse code.
 * Your program shall prompt the user to specify the desired type of translation, input a string of Morse code 
 * characters or English characters, then display the translated results. The Morse code pattern and English 
 * letter translations must be kept and processed using either two one-dimensional or one two-dimensional 
 * arrays.
 * 
 * When you input Morse code, separate each letter/digit with a single space, and delimit multiple words with a “|”. 
 * For example, - --- | -... . would be the Morse code input for the sentence “to be”. Your program only needs to 
 * handle a single sentence and can ignore punctuation symbols. When you input English, separate each word with 
 * a blank space.
*/

import java.util.Scanner;

public class DecryptEncryptMorse {

	/*
	 * Main class of the application. Here global variables are initialized and the
	 * control flow of the program resides. The arrays of the Alphabet and the Morse
	 * Code counterpart is initialized and/or declared. Basic error handling is also
	 * used for user's input when gathered.
	 */

	public static void main(String[] args) {

		headerMessage();

		Scanner input = new Scanner(System.in);
		System.out.println("Make your selection: ");
		int userChoice = input.nextInt();

		switch (userChoice) {

			case 0:
				System.out.println("\nThank you for using the application!");
				break;

			case 1:
				System.out.println("\nEnter your Morse Code: ");
				morseCode();

				break;

			case 2:
				System.out.println("\nEnter your sentence: ");
				englishCode();

				break;

			default:
				System.out.println("\nAn unknown error has occured, please try again.");
				break;
		}

	}

	/*
	 * Needed to display the welcome message to the user and explain how the
	 * application should be used.
	 */

	private static void headerMessage() {
		System.out.println("\n");
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("|                              Welcome User,                             |");
		System.out.println("|         This application will translate your sentence from either      |");
		System.out.println("|       Morse Code into English, and vise-versa (English to Morse Code). |");
		System.out.println("|                                                                        |");
		System.out.println("| Press (0): To Quit the application.                                    |");
		System.out.println("| Press (1): To translate your Morse Code sentence into English.         |");
		System.out.println("| Press (2). To translate your English sentence into Morse Code.         |");
		System.out.println("|                              Let's start!                              |");
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("\n");
	}

	/*
	 * This is the coding block that is responsible for translating Morse code
	 * sentence into English based on the entry from the user.
	 * 
	 * Difference between .next() and .nextLine():
	 * https://www.geeksforgeeks.org/difference-between-next-and-nextline-methods-in-java/
	 * 
	 * 1. .nextLine(): can read input until the line change or new line
	 * 2. .next(): can only read input until it encounters a space
	 * 
	 * Steps in this coding block: 
	 * 
	 * 1. Initialize a new empty string variable that will serve to display the translated
	 *    message to the user. 
	 * 2. Utilize a for loop to translate the Morse phrase into English sentence. 
	 * 
	 *    For loop logic:
	 *    Take the user's input string and the Morse alphabet string and iterate over both strings 
	 *    comparing each character, save each match to the translate string along with the english code match.
	 */

	private static void morseCode() {
		char[] english = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		String[] morse = { "|", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
				"...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----" };

		Scanner input = new Scanner(System.in);
		String userPhrase1 = input.nextLine();
		String translatedStr = " ";
		
		do {
			for (int i = 0; i < userPhrase1.length(); i++) {
				for (int j = 0; j < morse.length; j++ ) {	
					if (morse[j].equals(userPhrase1)) {
						translatedStr = english[i] + "|";
					} 
				}
				
			}
			System.out.println("\nHere is your code in Morse Code:\n" + translatedStr);
		} while (input.nextLine() != null);
	}
		

	/*
	 * This is the coding block that is responsible for translating the English
	 * sentence into Morse code based on the entry from the user.
	 * 
	 * Steps in this coding block: 
	 * 1. Initialize a new empty string variable that will serve to display the translated 
	 *    message to the user. 
	 * 2. Utilize a for loop to translate the Morse code into English. 
	 *    For loop logic: Take the user's input string and the English alphabet string and iterate 
	 *    over both strings comparing each character, save each match to the translated string along 
	 *    with the morse code match.
	 */

	private static void englishCode() {

		char[] english = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		String[] morse = { "|", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
				"...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----" };		
		
		Scanner input = new Scanner(System.in);
		String userPhrase1 = input.nextLine().toUpperCase();
		char[] userInputChar = userPhrase1.toCharArray();
		String translatedStr = " ";

		
		do {
			for (int i = 0; i < userInputChar.length; i++) {
				for (int j = 0; j < english.length; j++) {
					if (english[j] == userInputChar[i]) {
						translatedStr = translatedStr + morse[j] + " ";
						
					}
				}

			}
			System.out.println("\nHere is your code in Morse Code:\n" + translatedStr);
		} while (input.nextLine() != null);
		
	}

}
