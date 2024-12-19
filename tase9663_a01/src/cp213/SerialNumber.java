package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

	for (int i = 0; i < str.length(); i++) {
	    char value = str.charAt(i);

	    if (!Character.isDigit(value)) {
		return false;
	    }
	}

	return true;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

	if (sn.length() != 11 && !sn.startsWith("SN/")) {
	    return false;
	}

	for (int i = 3; i <= 6; i++) {
	    char value = sn.charAt(i);

	    if (!Character.isDigit(value)) {
		return false;
	    }
	}

	if (sn.charAt(7) != '-') {
	    return false;
	}

	for (int i = 8; i < sn.length(); i++) {
	    char value = sn.charAt(i);

	    if (!Character.isDigit(value)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	while (fileIn.hasNextLine()) {
	    String line = fileIn.nextLine();

	    if (validSn(line) == true) {
		goodSns.println(line);
	    } else {
		badSns.println(line);
	    }
	}

	return;
    }

}
