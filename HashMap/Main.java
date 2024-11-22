package com.hackathon;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("A", "B");
        myHashMap.put("B", "C");
        System.out.println(myHashMap.get("A"));
        myHashMap.remove("A");
        System.out.println(myHashMap.get("A"));

    }
}
