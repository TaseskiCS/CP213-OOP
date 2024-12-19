package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

	// your code here
	String check = "";

	for (char c : string.toLowerCase().toCharArray()) {
	    if (Character.isLetter(c)) {
		check += c;
	    }
	}

	int left = 0;
	int right = check.length() - 1;

	while (left <= right) {
	    if (check.charAt(left) != check.charAt(right)) {
		return false;
	    }
	    left++;
	    right--;
	}

	return true;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

	// your code here
	if (name.length() > 0) {
	    if ((name.charAt(0) == '_' && name.length() == 1) || Character.isDigit(name.charAt(0))) {
		return false;
	    }
	}

	return true;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

	if (VOWELS.indexOf(word.charAt(0)) != -1) {
	    return word + "way";
	}

	int firstVowelIndex = -1;
	for (int i = 0; i < word.length(); i++) {
	    char c = word.charAt(i);
	    // 'y' is treated as a consonant when it's the first letter, and as a vowel
	    // elsewhere
	    if (VOWELS.indexOf(c) != -1 || (c == 'y' && i != 0)) {
		firstVowelIndex = i;
		break;
	    }
	}

	if (firstVowelIndex == -1) {
	    firstVowelIndex = word.length();
	}
	String prefix = word.substring(0, firstVowelIndex);
	String restOfWord = word.substring(firstVowelIndex);

	if (Character.isUpperCase(word.charAt(0))) {
	    restOfWord = restOfWord.substring(0, 1).toUpperCase() + restOfWord.substring(1).toLowerCase();
	    prefix = prefix.toLowerCase();
	}

	return restOfWord + prefix + "ay";

    }

}
