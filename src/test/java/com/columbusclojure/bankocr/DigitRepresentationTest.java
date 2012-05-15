package com.columbusclojure.bankocr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DigitRepresentationTest {

    @Test
    public void testIsValid_false() {
        String invalid =
                " _ " +
                "|  " +
                "|_|";

        assertFalse(new DigitRepresentation(invalid).isValid());
    }
    
    @Test
    public void testIsValid_true() {
        String valid =
                " _ " +
                "  |" +
                "  |";

        assertTrue(new DigitRepresentation(valid).isValid());
    }

    @Test
    public void testToChar_0() {
        String ZERO =
            " _ " +
            "| |" +
            "|_|";
        assertEquals('0',new DigitRepresentation(ZERO).toChar());
    }

    @Test
    public void testToChar_1() {
        String ONE =
            "   " +
            "  |" +
            "  |";
        assertEquals('1',new DigitRepresentation(ONE).toChar());
    }

    @Test
    public void testToChar_2() {
        String TWO =
            " _ " +
            " _|" +
            "|_ ";
        assertEquals('2',new DigitRepresentation(TWO).toChar());
    }

    @Test
    public void testToChar_3() {
        String THREE =
            " _ " +
            " _|" +
            " _|";
        assertEquals('3',new DigitRepresentation(THREE).toChar());
    }

    @Test
    public void testToChar_4() {
        String FOUR =
            "   " +
            "|_|" +
            "  |";
        assertEquals('4',new DigitRepresentation(FOUR).toChar());
    }

    @Test
    public void testToChar_5() {
        String FIVE =
            " _ " +
            "|_ " +
            " _|";
        assertEquals('5',new DigitRepresentation(FIVE).toChar());
    }

    @Test
    public void testToChar_6() {
        String SIX =
            " _ " +
            "|_ " +
            "|_|";
        assertEquals('6',new DigitRepresentation(SIX).toChar());
    }

    @Test
    public void testToChar_7() {
        String SEVEN =
            " _ " +
            "  |" +
            "  |";
        assertEquals('7',new DigitRepresentation(SEVEN).toChar());
    }

    @Test
    public void testToChar_8() {
        String EIGHT =
            " _ " +
            "|_|" +
            "|_|";
        assertEquals('8',new DigitRepresentation(EIGHT).toChar());
    }

    @Test
    public void testToChar_9() {
        String NINE =
            " _ " +
            "|_|" +
            " _|";
        assertEquals('9',new DigitRepresentation(NINE).toChar());
    }

    @Test
    public void testToChar_Illegible() {
        String illegible =
                " _ " +
                "|  " +
                "|_|";
        assertEquals('?',new DigitRepresentation(illegible).toChar());
    }
    
    @Test
    public void testToString() {
        String NINE =
            " _ " +
            "|_|" +
            " _|";
        assertEquals(NINE,new DigitRepresentation(NINE).toString());
    }
}