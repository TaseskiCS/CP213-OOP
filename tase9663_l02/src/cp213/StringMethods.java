package cp213;

/**
 * Sample string methods.
 *
 * @author your name, ID, and email here
 * @version 2022-05-06
 */
public class StringMethods {
    // Constants
    /**
     * String of vowels.
     */
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Counts the number of vowels in a string. Does not include 'y'.
     *
     * @param string A string.
     * @return Number of vowels in string.
     */
    public static int vowelCount(final String string) {
	int count = 0;

	for (int i = 0; i < string.length(); i++) {
	    char value = string.charAt(i);
	    if (VOWELS.indexOf(value) != -1) {
		count++;
	    }
	}

	return count;
    }

    /**
     * Counts the number of digits in a string.
     *
     * @param string A string.
     * @return Number of digits in string.
     */
    public static int digitCount(final String string) {
	int count = 0;

	for (int i = 0; i < string.length(); i++) {
	    char value = string.charAt(i);

	    if (Character.isDigit(value)) {
		count++;
	    }

	}

	return count;
    }

    /**
     * Totals the individual digits in a string.
     *
     * @param string A string.
     * @return The integer total of all individuals digits in string.
     */
    public static int totalDigits(final String string) {
	int total = 0;

	for (int i = 0; i < string.length(); i++) {
	    char value = string.charAt(i);

	    if (Character.isDigit(value)) {
		int num = Character.getNumericValue(value);
		total += num;
	    }
	}

	return total;
    }

    /**
     * Compares string1 and string2 and returns a comma-delimited concatenated
     * string consisting of the string that is first lexically followed by the
     * string that is second lexically. If the strings are equal, then only string1
     * is returned.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return A concatenation of string1 and string2 in order.
     */
    public static String pairs(String string1, String string2) {
	String line = null;
	int result = string1.compareTo(string2);

	if (result == 0) {
	    line = string1;
	} else if (result < 0) {
	    line = string1 + ',' + string2;
	} else if (result > 0) {
	    line = string2 + ',' + string1;
	}

	return line;
    }

    /**
     * Finds the distance between the s1 and s2. The distance between two strings of
     * the same length is the number of positions in the strings at which their
     * characters are different. If two strings are not the same length, the
     * distance is unknown (-1). If the distance is zero, then two strings are
     * equal.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return The distance between string1 and string2.
     */
    public static int stringDistance(String string1, String string2) {
	int distance = 0;
	int s1_length = string1.length();
	int s2_length = string2.length();

	if (s1_length == s2_length) {
	    for (int i = 0; i < s1_length; i++) {
		char str_val1 = string1.charAt(i);
		char str_val2 = string2.charAt(i);

		if (str_val1 != str_val2) {
		    distance++;
		}
	    }
	} else {
	    distance = -1;
	}

	// your code here

	return distance;
    }
}
