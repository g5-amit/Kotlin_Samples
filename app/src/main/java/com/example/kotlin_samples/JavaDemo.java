package com.example.kotlin_samples;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class JavaDemo {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){

        //HashMap
        HashMap<String, Integer> hashMap =  new HashMap();
        hashMap.put("abc",1);

        for(String key : hashMap.keySet()){
            System.out.println(key);
            System.out.println(hashMap.get(key));
        }

        hashMap.forEach((k,v)->{
            System.out.println(hashMap.get(k));
            System.out.println(hashMap.get(v));
        });

        LinkedHashMap


            PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] arr = {1,2,6,8,3,2,5,6};
        Arrays.stream

    }


}
