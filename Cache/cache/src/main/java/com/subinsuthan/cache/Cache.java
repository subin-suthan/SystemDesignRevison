package com.subinsuthan.cache;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class Cache<KEY, VALUE> {

    private final WritePolicy writePolicy;
    private final EvictionAlgo evictionAlgo;

    private final Map<KEY, Record<VALUE>> map;

    private final DataSource<KEY, VALUE> dataSource;

    private final Integer expiryTime;

    private static final Integer THRESHOLD_SIZE = 1000;

    public Cache(WritePolicy writePolicy, EvictionAlgo evictionAlgo, DataSource<KEY, VALUE> dataSource,Integer expiryTime) {
        this.writePolicy = writePolicy;
        this.evictionAlgo = evictionAlgo;
        this.dataSource = dataSource;
        this.expiryTime=expiryTime;
        map = new ConcurrentHashMap<>();
    }

    public CompletableFuture<VALUE> get(KEY key) {

        if (map.containsKey(key) && map.get(key).getTimestamp()>=System.currentTimeMillis()-expiryTime) {

              return CompletableFuture.completedFuture(map.get(key)).thenApply(Record::getValue);
        } else {
            return dataSource.get(key).thenCompose(value->set(key,value).thenApply(__->value));

        }

    }

    public Future<Void> set(KEY key, VALUE value) {

        if (!map.containsKey(key) && map.size() >= THRESHOLD_SIZE) {

            if(evictionAlgo.equals(EvictionAlgo.LRU)){

            }



        }

        if (writePolicy == WritePolicy.WRITE_THROUGH) {
            return dataSource.persist(key, value).thenAccept(__ -> map.put(key, value));
        } else {
            map.put(key, value);
            dataSource.persist(key, value);
            return CompletableFuture.completedFuture(null);
        }

        TreeMap<KEY,Record<VALUE>> treeMap=new TreeMap<>();
        treeMap.firstEntry();

    }

}
