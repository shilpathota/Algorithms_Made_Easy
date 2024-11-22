package com.hackathon;

import java.util.Objects;

public class MyHashMap<K,V> {
/*
*
* Define the constants -> LOAD_FACTOR,CAPACITY,
* Define the Global Variable for storing the values and size
* Constructor for initializing the Hashmap
* Entry Static Class which is the linked list and represent each bucket
* methods - get put, remove, getBucketIndex, size, resize, isempty
*
* */
    //constants
    private static final int CAPACITY=16;
    private static final float LOAD_FACTOR = 0.75f;
    private MyEntry[] table;
    private int size;
    private static class MyEntry<K,V> {
        final K key;
        V value;
        MyEntry<K,V> next;
        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
            next=null;
        }
    }

    public MyHashMap(){
       this.table = new MyEntry[CAPACITY];
       this.size=0;
    }

    private int getBucketIndex(K key){
        int hash = key ==null?0:key.hashCode();
        return hash%CAPACITY;
    }
    public void put(K key,V value){
        int index = getBucketIndex(key);
        MyEntry<K,V> head = table[index];
        while(head!=null){
            if(Objects.equals(head.key,key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        MyEntry<K,V> newEntry=new MyEntry<>(key,value);
        newEntry.next=head;
        table[index]=newEntry;
        size++;
    }

    public V get(K key){
        int index = getBucketIndex(key);
        MyEntry<K,V> head = table[index];
        while(head!=null){
            if(Objects.equals(head.key,key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int index = getBucketIndex(key);
        MyEntry<K,V> head = table[index];
        MyEntry<K,V> prev = null;
        while(head!=null){

            if(Objects.equals(head.key,key)){
                if(prev!=null){
                    prev.next=head.next;
                }else {
                    table[index] = head.next;
                }
                size--;
                return head.value;
            }
            prev=head;
            head=head.next;
        }
        return null;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

}
