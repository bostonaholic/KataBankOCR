package com.columbusclojure.bankocr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class AccountReader {
    private BufferedReader reader;

    public AccountReader(String string) {
        this.reader = new BufferedReader(new StringReader(string));
    }

    public AccountReader(File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file));
    }

    public AccountNumberRepresentation getNextAccount() throws IOException {
        String line0 = reader.readLine();
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        reader.readLine(); // read extra blank line
        return new AccountNumberRepresentation(line0, line1, line2);
    }

    public boolean ready() throws IOException {
        return reader.ready();
    }
}
