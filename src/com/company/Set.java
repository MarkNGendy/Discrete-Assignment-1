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
    public static void union(Set s1 , Set s2){
        Set union = new Set(s1.size + s2.size);
        union.setSize(0);
        if(s1.size == 0) {
            printSet(s2);
            return;
        } else if (s2.size == 0) {
            printSet(s1);
            return;
        }
        for (int i = 0; i < s1.size; i++){
            union.elements[i] = s1.elements[i];
            union.setSize(union.size + 1);
        }
        for (int i = 0; i < s2.size; i++){
            if (!union.contains(s2.elements[i])){
                union.elements[union.size] = s2.elements[i];
                union.setSize(union.size + 1);
            }
        }
        printSet(union);
    }

    public static void intersection(Set s1, Set s2){
        if(s1.size == 0 || s2.size == 0) {
            printSet(new Set(0));
            return;
        }
        Set intersection = new Set(s2.size);
        intersection.setSize(0);
        for (int i = 0; i < s2.size; i++){
            if (s1.contains(s2.elements[i])){
                intersection.elements[intersection.size] = s2.elements[i];
                intersection.setSize(intersection.size + 1);
            }
        }
        printSet(intersection);
    }

    public static void complement(Set universe, Set set) {
        Set complement = new Set(universe.size);
        if (set.size == universe.size) {
            printSet(new Set(0));
            return;
        } else if (set.size == 0) {
            printSet(universe);
            return;
        }
        for (int i = 0; i < universe.size; i++) {
            if (!(set.contains(universe.elements[i]))) {
                complement.elements[complement.size] = universe.elements[i];
                complement.setSize(complement.size + 1);
            }
        }
        printSet(complement);
    }


    public static Set readSet(Set set, Set universe) {
        Scanner in = new Scanner(System.in);
        set.setSize(0);
        for (int i = 0; i < set.elements.length; i++) {
            System.out.println("Please enter the element number " + (i + 1));
            String s = in.next();
            while (!universe.contains(s)) {
                System.out.println("Please enter elements that belong to universe");
                s = in.next();
            }
            if (!set.contains(s)) {
                set.elements[set.size] = s;
                set.setSize(set.size + 1);
            }
        }
        return set;
    }

    public static void printSet(Set set) {
        if (set.size == 0) {
            System.out.println("Null");
            return;
        }
        System.out.print("\n" +  "{ ");
        for (int i = 0; i < (set.size - 1); i++) {
            System.out.print(set.elements[i] + " , ");
        }
        System.out.print(set.elements[set.size - 1] + " }\n");
    }
}
