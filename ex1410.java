package edu.princeton.cs.algs4;

import java.util.Scanner;

class BinarySearchFirstIndex {
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                result = mid;
                hi = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int key=sc.nextInt();
        int index = indexOf(a, key);
        System.out.println("Chi so nho nhat cua " + key + " la: " + index);
    }
}