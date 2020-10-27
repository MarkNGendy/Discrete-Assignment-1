package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please Enter Universe size\n");
        Scanner in = new Scanner(System.in);
        int universeSize = in.nextInt();
        Set universe = new Set(universeSize);
        System.out.println("Please enter number of input sets\n");
        int noOfSets = in.nextInt();
        Set[] sets = new Set[noOfSets + 1];
        for (int i = 1; i < noOfSets + 1; i++) {
            System.out.println("Please enter set size\n");
            int length = in.nextInt();
            sets[i] = new Set(length);
            sets[i] = readSet(sets[i]);
        }
        printSet(sets[1]);
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
