package com.subinsuthan.cache;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;


public class Cache<KEY,VALUE> {

    private final WritePolicy writePolicy;

    private final Map<KEY,VALUE> map;

    private final DataSource<KEY,VALUE> dataSource;


    public Cache(WritePolicy writePolicy,DataSource dataSource){
        this.writePolicy=writePolicy;
        this.dataSource=dataSource;
        map=new ConcurrentHashMap<>();
    }

    public Future<VALUE> get(KEY key){

        if (map.containsKey(key)){
            return  CompletableFuture.completedFuture(map.get(key));
        }
        else{
            return dataSource.get(key);
        }

    }

    public Future<Void> set(KEY key,VALUE value){

        if (map.containsKey(key)){

            if(writePolicy==WritePolicy.WRITE_THROUGH){
                  return dataSource.persist(key, value).thenAccept(__->map.put(key, value));
            }

        }else{

        }

    }
    
}
