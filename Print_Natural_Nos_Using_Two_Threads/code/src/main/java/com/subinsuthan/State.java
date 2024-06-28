package com.subinsuthan;

public class State {

    private PrinterType nextToPrint;

    public PrinterType getNextToPrint() {

        return nextToPrint;

    }

    public void setNextToPrint(PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;

    }

    public State(PrinterType nextToPrint) {

        this.nextToPrint = nextToPrint;

    }

}
