package org.example.sync;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadDemo4 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        Vector<Object> objects1 = new Vector<>();


        List<Object> list = Collections.synchronizedList(new ArrayList<>());

        CopyOnWriteArrayList<Object> objects2 = new CopyOnWriteArrayList<>();

        HashSet set = new HashSet();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        CopyOnWriteArraySet<Object> objects3 = new CopyOnWriteArraySet<>();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();


    }
}
