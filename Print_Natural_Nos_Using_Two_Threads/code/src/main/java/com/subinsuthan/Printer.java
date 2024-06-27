package com.subinsuthan;

public class Printer implements Runnable{

    private final int step;
    private final PrinterType currPrinterType;
    private final PrinterType nextPrinterType;
    private final int currentValue;
    private final State state;
    private final int maxValue;


    public Printer(int startValue,int step,PrinterType currPrinterType,
                   PrinterType nexPrinterType, int currentValue, State state,
                   int maxValue){
                    this. currentValue=startValue;
                    this.step=step;
                    this.state=state;
                    this.currPrinterType=currPrinterType;
                    this.nextPrinterType=nexPrinterType;
                    this.maxValue=maxValue;

    }






    
    @Override
    public void run(){

        while(currentValue<=maxValue){
            synchronized(state){

            }

            
        }

    }
    
}
