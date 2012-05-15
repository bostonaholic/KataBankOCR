package com.columbusclojure.bankocr;

public class CheckSumValidator {

    /*
     * @about
     *      account number:   3  4  5  8  8  2  8  6  5
     *      position names:  d9 d8 d7 d6 d5 d4 d3 d2 d1
     *
     *      checksum calculation:
     *      (d1+2*d2+3*d3+..+9*d9) mod 11 = 0
     */
    public static boolean isValid(String account) {
        char[] chars = account.toCharArray();
        int sum = 0;
        for(int i = 1; i <= AccountNumberRepresentation.ACCOUNT_WIDTH; i++) {
            int value = Character.digit(chars[AccountNumberRepresentation.ACCOUNT_WIDTH-i], 10);
            sum += value * i;
        }
        return (sum % 11) == 0;
    }
}
