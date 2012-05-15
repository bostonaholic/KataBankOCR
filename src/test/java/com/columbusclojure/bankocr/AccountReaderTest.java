package com.columbusclojure.bankocr;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 *
 * @author Matthew Boston <matthew.boston@gmail.com>
 */
public class AccountReaderTest {
	private static String TEST_RESOURCES = "src/test/resources/";

    @Test
    public void testGetNextAccount() throws IOException {
        String line0 = " _  _  _  _  _  _  _  _    ";
        String line1 = "| || || || || || || ||_   |";
        String line2 = "|_||_||_||_||_||_||_| _|  |";
    	
        String input =
                line0 + '\n' +
                line1 + '\n' +
                line2 + '\n';
        
        AccountNumberRepresentation expected = new AccountNumberRepresentation(line0, line1, line2);
        
        AccountReader reader = new AccountReader(input);
    	assertEquals(expected, reader.getNextAccount());
    }

    @Test
    public void testGetNextAccount_UsingFile() throws IOException {
        String line0 = "    _  _     _  _  _  _  _ ";
        String line1 = "  | _| _||_||_ |_   ||_||_|";
        String line2 = "  ||_  _|  | _||_|  ||_| _|";
        AccountNumberRepresentation expected = new AccountNumberRepresentation(line0, line1, line2);
        
        AccountReader reader_file = new AccountReader(new File(TEST_RESOURCES + "123456789.txt"));
        assertEquals(expected, reader_file.getNextAccount());
    }
}