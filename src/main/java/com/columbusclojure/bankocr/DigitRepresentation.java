package com.columbusclojure.bankocr;

public class DigitRepresentation {
    private String digitGraph;

    public DigitRepresentation(String graph) {
        this.digitGraph = graph;
    }

    public boolean isValid() {
        return this.toChar() != '?';
    }

	public char toChar() {
        // We must use a unique int to represent each number.  Since the
        // digitGraph is a String, we must hash it to find it's unique int
        // code to use in the switch.
        int hash = digitGraph.hashCode();
        
        switch(hash) {
            case -2021980254:
                return '0';
            case 1511113376:
                return '1';
            case -302713119:
                return '2';
            case -302801439:
                return '3';
            case -91790205:
                return '4';
            case -1966627615:
                return '5';
            case -1966539203:
                return '6';
            case -360985215:
                return '7';
            case -1963798431:
                return '8';
            case -1963886843:
                return '9';
        }
        return '?';
    }

    @Override
    public String toString() {
        return this.digitGraph;
    }
}
