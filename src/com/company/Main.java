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
            sets[i] = Set.readSet(sets[i]);
        }
    }

}
