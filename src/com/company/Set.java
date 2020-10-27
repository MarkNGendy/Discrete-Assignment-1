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
    static void Union(Set s1 , Set s2){
        Set Union = new Set(s1.size + s2.size);
        Union.setSize(0);
        for (int i=0 ; i<s1.size ; i++){
            Union.elements[i] = s1.elements[i];
            Union.setSize(Union.size+1);
        }
        for (int i=0 ; i<s2.size ; i++){
            if (!Union.contains(s2.elements[i])){
                Union.elements[Union.size] = s2.elements[i];
                Union.setSize(Union.size+1);
            }
        }
    }

}
