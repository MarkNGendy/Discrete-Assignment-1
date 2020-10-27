package com.company;

import java.util.LinkedList;

public class Set {
    String[] set;
    int size;

    public Set(int size) {
        set = new String[size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean contains(String key) {
        for (int i = 0; i < size; i++) {
            if (set[i].compareTo(key) == 0) return true;
        }
        return false;
    }

}
