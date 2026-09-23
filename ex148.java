package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CountEqualPairsHash {
    public static long count(int[] a) {
        Map<Integer, Long> freqMap = new HashMap<>();
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0L) + 1);
        }
        long totalPairs = 0;
        for (long k : freqMap.values()) {
            if (k > 1) {
                totalPairs += (k * (k - 1)) / 2;
            }
        }

        return totalPairs;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long cnt = count(a);
        System.out.println("So cap so bang nhau: " + cnt);
    }
}