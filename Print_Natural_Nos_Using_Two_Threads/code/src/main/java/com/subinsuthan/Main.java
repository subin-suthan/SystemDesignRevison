package com.subinsuthan;

public class Main {
    public static void main(String[] args) {

        final State state=new State(PrinterType.ODD);

        final Printer odd=new Printer(1,2,PrinterType.ODD,PrinterType.EVEN,state,50);
        final Printer even=new Printer(2,2,PrinterType.EVEN,PrinterType.ODD,state,50);

        final Thread oddThread=new Thread(odd);
        final Thread evenThread=new Thread(even);


        oddThread.start();
        evenThread.start();


    }
}