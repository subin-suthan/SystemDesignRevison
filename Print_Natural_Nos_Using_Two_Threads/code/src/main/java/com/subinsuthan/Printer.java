package com.subinsuthan;

public class Printer implements Runnable {

    private final int step;
    private final PrinterType currPrinterType;
    private final PrinterType nextPrinterType;
    private int currentValue;
    private final State state;
    private final int maxValue;

    public Printer(int startValue, int step, PrinterType currPrinterType,
            PrinterType nexPrinterType, State state,
            int maxValue) {
        this.currentValue = startValue;
        this.step = step;
        this.state = state;
        this.currPrinterType = currPrinterType;
        this.nextPrinterType = nexPrinterType;
        this.maxValue = maxValue;

    }

    @Override
    public void run() {

        try {
            while (currentValue <= maxValue) {
                synchronized (state) {
                    while (this.currPrinterType != state.getNextToPrint()) {
                        state.wait();
                    }
                    System.out.println(currPrinterType.toString() + currentValue);
                    currentValue += step;
                    state.setNextToPrint(this.nextPrinterType);
                    state.notifyAll();


            }
        }
        } catch (Exception e) {

        }
    }

}
