package pers.cc.demo.leetcode.common;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestHashSet {

    public static void main(String[] args) {
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("1");
        System.out.println(hashSet.add("1"));
        System.out.println(hashSet);
        Thread thread=new Thread(()->{
            System.out.println("aa");
        });
        thread.start();
        thread.run();

    }


}
