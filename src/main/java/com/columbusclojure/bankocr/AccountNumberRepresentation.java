package com.columbusclojure.bankocr;

import java.util.ArrayList;
import java.util.List;

public class AccountNumberRepresentation {
    private String line0;
    private String line1;
    private String line2;

    private boolean illegible;
    private boolean failedCheckSum;

    /*
     * The character width of a single number
     */
    private static final int DIGIT_WIDTH = 3;

    /*
     * The number of digits in an Account Number
     */
    public static final int ACCOUNT_WIDTH = 9;

    /*
     * List of DigitRepresentation in the account number
     */
    public List<DigitRepresentation> digits;

    /*
     * @param line0 The top line of the account number
     * @param line1 The middle line of the account number
     * @param line2 The bottom line of the account number
     */
    public AccountNumberRepresentation(String line0, String line1, String line2) {
        this.line0 = line0;
        this.line1 = line1;
        this.line2 = line2;

        parse();
        validate();
    }
    
    /*
     * This will fill this.digits with the DigitRepresentation found in the
     * account number
     */
    private void parse() {
        digits = new ArrayList<DigitRepresentation>();
        for (int index = 0; index < ACCOUNT_WIDTH; index++) {
            this.digits.add(getDigitRepresentationAtIndex(index));
        }
    }

    /*
     * This checks each digit in the Account Number is a valid digit
     * and checks the full Account Number against the CheckSumValidator
     */
    private void validate() {
        validateLegibility();

		// only need to checksum if the account number is legal
        if(!illegible) {
        	performCheckSum();
        }
    }

    /*
     * This will append ILL if any digit is illegible
     */
	private void validateLegibility() {
		for (DigitRepresentation d : this.digits) {
            if (!d.isValid() && !illegible) {
                illegible = true;
            }
        }
	}

    /*
     * This performs the CheckSumValidator on the account number.
     */
	private void performCheckSum() {
        failedCheckSum = !CheckSumValidator.isValid(toDigitString());
	}

    /*
     * @param index The index of the number in the account number we want to
     * return.
     *
     * For index = 5, we want substring(15, 18)
     */
    public DigitRepresentation getDigitRepresentationAtIndex(int index) {
        String line00 = this.line0.substring(index * DIGIT_WIDTH, index * DIGIT_WIDTH + DIGIT_WIDTH);
        String line01 = this.line1.substring(index * DIGIT_WIDTH, index * DIGIT_WIDTH + DIGIT_WIDTH);
        String line02 = this.line2.substring(index * DIGIT_WIDTH, index * DIGIT_WIDTH + DIGIT_WIDTH);
        return new DigitRepresentation(line00 + line01 + line02);
    }

    /*
     * We need both this method and toString in order to get the digit string
     * only as well as getting the account string with ILL/ERR appended.
     */
    public String toDigitString() {
        StringBuilder builder = new StringBuilder();
        for(DigitRepresentation d : this.digits) {
            builder.append(d.toChar());
        }

        return builder.toString();
    }

    /*
     * This will build the account number as a String with ILL/ERR
     */
    @Override
    public String toString () {
        String string = toDigitString();

        if (illegible) {
            string += " ILL";
        } else if (failedCheckSum) {
            string += " ERR";
        }
        return string;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountNumberRepresentation other = (AccountNumberRepresentation) obj;
		if (failedCheckSum != other.failedCheckSum)
			return false;
		if (illegible != other.illegible)
			return false;
		if (line0 == null) {
			if (other.line0 != null)
				return false;
		} else if (!line0.equals(other.line0))
			return false;
		if (line1 == null) {
			if (other.line1 != null)
				return false;
		} else if (!line1.equals(other.line1))
			return false;
		if (line2 == null) {
			if (other.line2 != null)
				return false;
		} else if (!line2.equals(other.line2))
			return false;
		return true;
	}
}
