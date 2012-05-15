package com.columbusclojure.bankocr;

import java.io.File;
import java.io.FileNotFoundException;

public class BankOCR {

    public static void main(String[] args) {
        try {
            if(args.length == 1) {
                AccountReader reader = new AccountReader(new File(args[0]));
                while(reader.ready()) {
                    System.out.println(reader.getNextAccount().toString());
                }
            } else {
                System.out.println("Please provide only one file as input.\n");
                usage();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("The file you supplied could not be found.  Please try again.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.out.println("usage: ");
        System.out.println("    java KataBankOCR <accountList.txt>");
    }
}
