package com.subinsuthan.cache;

public class Record<VALUE> implements Comparable<Record<VALUE>>{

   private final VALUE value;

    private long timestamp;

    private long accessCount;

    public Record(VALUE value){
        this.value=value;
    }

    @Override
    public int compareTo(Record record) {
        return (int)(timestamp=record.timestamp);


    }

    
    
}
