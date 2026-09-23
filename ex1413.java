package edu.princeton.cs.algs4;

import java.util.Scanner;
class CommonElementsTwoPointers {
    public static void printIntersection(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                int val = a[i];
                while (i < a.length && a[i] == val) i++;
                while (j < b.length && b[j] == val) j++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int k = 0; k < n; k++) {
            a[k] = sc.nextInt();
        }
        for (int k = 0; k < n; k++) {
            b[k] = sc.nextInt();
        }
        printIntersection(a, b);
    }
}