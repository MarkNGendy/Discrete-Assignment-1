package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please Enter Universe size");
        Scanner in = new Scanner(System.in);
        int universeSize = in.nextInt();
        Set universe = new Set(universeSize);

        System.out.println("Please enter number of input sets");
        int noOfSets = in.nextInt();
        Set[] sets = new Set[noOfSets + 1];
        for (int i = 1; i < noOfSets + 1; i++) {
            sets[i] = readSet(sets[i]);
        }
    }

    public static Set readSet(Set set) {
        Scanner in = new Scanner(System.in);
        set.setSize(0);
        for (int i = 0; i < set.size; i++) {
            String s = in.next();
            if (!set.contains(s)) {
                set.set[set.size] = s;
                set.setSize(set.size + 1);
            }
        }
        return set;
    }
}
