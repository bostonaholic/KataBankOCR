package com.columbusclojure.bankocr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccountNumberRepresentationTest {
    
    @Test
    public void testGetDigitRepresentation_First() {
        String line0 = "    _  _     _  _  _  _  _ ";
        String line1 = "  | _| _||_||_ |_   ||_||_|";
        String line2 = "  ||_  _|  | _||_|  ||_| _|";

        String expected =
                "   " +
                "  |" +
                "  |";
        AccountNumberRepresentation ocr = new AccountNumberRepresentation(line0, line1, line2);
        assertEquals(expected, ocr.getDigitRepresentationAtIndex(0).toString());
    }

    @Test
    public void testGetDigitRepresentation_InMiddle() {
        String line0 = "    _  _     _  _  _  _  _ ";
        String line1 = "  | _| _||_||_ |_   ||_||_|";
        String line2 = "  ||_  _|  | _||_|  ||_| _|";

        String expected =
                " _ " +
                "|_ " +
                " _|";
        AccountNumberRepresentation ocr = new AccountNumberRepresentation(line0, line1, line2);
        assertEquals(expected, ocr.getDigitRepresentationAtIndex(4).toString());
    }

    @Test
    public void testGetDigitRepresentation_Last() {
        String line0 = "    _  _     _  _  _  _  _ ";
        String line1 = "  | _| _||_||_ |_   ||_||_|";
        String line2 = "  ||_  _|  | _||_|  ||_| _|";

        String expected =
                " _ " +
                "|_|" +
                " _|";
        AccountNumberRepresentation ocr = new AccountNumberRepresentation(line0, line1, line2);
        assertEquals(expected, ocr.getDigitRepresentationAtIndex(8).toString());
    }

    @Test
    public void testToDigitString() {
        String line0 = "    _  _     _  _  _  _  _ ";
        String line1 = "  | _| _||_||_ |_   ||_||_|";
        String line2 = "  ||_  _|  | _||_|  ||_| _|";
        assertEquals("123456789",new AccountNumberRepresentation(line0, line1, line2).toDigitString());
    }

    @Test
    public void testToString_NoModifiers() {
        String line0 = " _  _  _  _  _  _  _  _    ";
        String line1 = "| || || || || || || ||_   |";
        String line2 = "|_||_||_||_||_||_||_| _|  |";
        assertEquals("000000051",new AccountNumberRepresentation(line0, line1, line2).toString());
    }

    @Test
    public void testToString_Ill() {
        String line0 = " _  _  _  _  _  _  _  _  _ ";
        String line1 = " _| _| _| _| _| _| _| _||_|";
        String line2 = "|_ |_ |_ |_||_ |_ |_ |_ |_ ";
        assertEquals("222?2222? ILL",new AccountNumberRepresentation(line0, line1, line2).toString());
    }

    @Test
    public void testToString_Err() {
        String line0 = " _  _  _  _  _  _  _  _  _ ";
        String line1 = " _| _| _| _| _| _| _| _| _|";
        String line2 = " _| _| _| _| _| _| _| _| _|";
        assertEquals("333333333 ERR",new AccountNumberRepresentation(line0, line1, line2).toString());
    }
}
