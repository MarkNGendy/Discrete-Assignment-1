package com.company;


public class Set {
    String[] elements;
    int size;

    public Set(int size) {
        elements = new String[size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean contains(String key) {
        for (int i = 0; i < size; i++) {
            if (elements[i].compareTo(key) == 0) return true;
        }
        return false;
    }

}
