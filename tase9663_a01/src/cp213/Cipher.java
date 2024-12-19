package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(final String s, final int n) {

	// your code here
	// Normalize n to be within the bounds of 0-25
	int effectiveShift = n % ALPHA_LENGTH;
	String result = "";

	for (char c : s.toCharArray()) {
	    // Check if the character is a letter
	    if (Character.isLetter(c)) {
		// Convert to upper case to match ALPHA
		char upperChar = Character.toUpperCase(c);
		// Find the index of the character in the alphabet
		int originalIndex = ALPHA.indexOf(upperChar);
		// Calculate new index with wrapping using modulo
		int newIndex = (originalIndex + effectiveShift) % ALPHA_LENGTH;
		// Get the new character and concatenate it to the result
		result += ALPHA.charAt(newIndex);
	    } else {
		// Non-letters remain unchanged
		result += c;
	    }
	}

	return result;

    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {

	String result = "";

	// Loop through each character in the input string
	for (char c : s.toCharArray()) {
	    // Check if the character is a letter
	    if (Character.isLetter(c)) {
		// Convert to upper case to match the ciphertext
		char upperChar = Character.toUpperCase(c);
		// Find the index in the standard alphabet
		int index = ALPHA.indexOf(upperChar);
		// If the character is a valid letter, get the corresponding ciphertext
		// character
		if (index != -1) {
		    result += Character.toUpperCase(ciphertext.charAt(index));
		}
	    } else {
		// Non-letters remain unchanged
		result += c;
	    }
	}

	return result;
    }

}
