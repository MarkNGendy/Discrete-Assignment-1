package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please Enter Universe size");
        Scanner in = new Scanner(System.in);
        int universeSize = in.nextInt();
        Set universe = new Set(universeSize);
        universe.setSize(0);
        for (int i = 0; i < universeSize; i++) {
            System.out.println("Please enter the element number " + (i + 1));
            String s = in.next();
            if (!universe.contains(s)) {
                universe.elements[universe.size] = s;
                universe.setSize(universe.size + 1);
            }
        }
        System.out.println("Please enter number of input sets");
        int noOfSets = in.nextInt();
        Set[] sets = new Set[noOfSets + 1];
        sets[0] = new Set(universeSize);
        sets[0] = universe;
        for (int i = 1; i < noOfSets + 1; i++) {
            System.out.println("Please enter set " + i + " size");
            int length = in.nextInt();
            while (length > universe.size || length < 0) {
                System.out.println("Please enter valid size smaller than universe size");
                length = in.nextInt();
            }
            sets[i] = new Set(length);
            sets[i] = Set.readSet(sets[i], universe);
        }
        int operation;
        while (true) {
            System.out.println("1- Intersection of 2 sets");
            System.out.println("2- Union of 2 sets");
            System.out.println("3- Complement of a set");
            System.out.println("4- exit");
            System.out.println("Please enter number of your choice");
            operation = in.nextInt();
            while (operation >= 5 || operation < 1) {
                System.out.println("please enter a valid choice");
                operation = in.nextInt();
            }
            Point choices;
            switch (operation) {
                case 1:
                     choices = getUserChoice(in, sets);
                    Set.intersection(sets[choices.x], sets[choices.y]);
                    break;
                case 2:
                    choices = getUserChoice(in, sets);
                    Set.union(sets[choices.x], sets[choices.y]);
                    break;
                case 3:
                    System.out.println("Enter the number of a set or zero for universe");
                    int set1 = in.nextInt();
                    while (set1 >= sets.length || set1 < 0) {
                        System.out.println("Please enter a number between 0 & " + (sets.length - 1));
                        set1 = in.nextInt();
                    }
                    Set.complement(universe, sets[set1]);
                    break;
                default:
                    return;
            }
        }
    }

    private static Point getUserChoice(Scanner in, Set[] sets) {
        Point choices = new Point();
        System.out.println("Enter the number of first set or zero for universe" );
        int set1 = in.nextInt();
        while (set1 >= sets.length || set1 < 0) {
            System.out.println("Please enter a number between 0 & " + (sets.length - 1));
            set1 = in.nextInt();
        }
        System.out.println("Enter the number of second set or zero for universe");
        int set2 = in.nextInt();
        while (set2 >= sets.length || set2 < 0) {
            System.out.println("Please enter a number between 0 & " + (sets.length - 1));
            set2 = in.nextInt();
        }
        choices.x = set1;
        choices.y = set2;
        return choices;
    }

}
