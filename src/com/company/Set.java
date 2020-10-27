package com.company;


import java.util.Scanner;

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
    public static void Union(Set s1 , Set s2){
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
        printSet(Union);
    }

    public static void Intersection (Set s1 , Set s2){
        Set Intersection = new Set(s2.size);
        Intersection.setSize(0);
        for (int i=0 ; i<s2.size ; i++){
            if (s1.contains(s2.elements[i])){
                Intersection.elements[Intersection.size] = s2.elements[i];
                Intersection.setSize(Intersection.size+1);
            }
        }
        printSet(Intersection);
    }


    public static Set readSet(Set set) {
        Scanner in = new Scanner(System.in);
        set.setSize(0);
        for (int i = 0; i < set.elements.length; i++) {
            String s = in.next();
            if (!set.contains(s)) {
                set.elements[set.size] = s;
                set.setSize(set.size + 1);
            }
        }
        return set;
    }

    public static void printSet(Set set) {
        System.out.print("\n" +  "{ ");
        for (int i = 0; i < (set.size - 1); i++) {
            System.out.print(set.elements[i] + " , ");
        }
        System.out.print(set.elements[set.size - 1] + " }");
    }
}
