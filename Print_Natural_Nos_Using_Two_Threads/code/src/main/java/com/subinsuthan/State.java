package com.subinsuthan;
import lombok.Getter;

@Getter
@Setter
public class State {

    private final PrinterType nextToPrint;

    public State(PrinterType nextToPrint){

        this.nextToPrint=nextToPrint;

    }
    
}
