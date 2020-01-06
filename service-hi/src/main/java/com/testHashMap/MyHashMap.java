package com.testHashMap;

/**
 * @Project: joycloud
 * @Package: com.testHashMap
 * @Author: 冯前进
 * @Date: 2020-01-05 11:35
 * @Description: TODO
 **/
public class MyHashMap<K, V> {
    private int size;
    private static int initSize = 4;
    private MyEntry[] table;

    public MyHashMap() {
        this.table = new MyEntry[initSize];
    }

    public V put(K k, V v) {
        int hashcode = k.hashCode();
        int index = hashcode % initSize;
        for (MyEntry entry = table[index]; entry != null; entry = entry.next) {
            if (entry.getK().equals(k)) {
                V oldValue= (V) entry.v;
                entry.v=v;
                return oldValue;
            }
        }
        MyEntry myEntry = new MyEntry<>(k, v, table[index]);
        table[index] = myEntry;
        return null;
    }

    public V get(K k) {
        int hashcode = k.hashCode();
        int index = hashcode % initSize;
        for (MyEntry entry = table[index]; entry != null; entry = entry.next) {
            if (entry.getK().equals(k)) {
                return (V) entry.v;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
    public class MyEntry<K, V> {
        private K k;
        private V v;
        private MyEntry next;

        public MyEntry() {
        }

        public MyEntry(K k, V v,  MyEntry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public  MyEntry<K, V> getNext() {
            return next;
        }

        public void setNext( MyEntry<K, V> next) {
            this.next = next;
        }
    }

}
