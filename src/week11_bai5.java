import java.util.*;

class Bai5_Cach1_HashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : b) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) - 1);
        }

        List<Integer> missing = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                missing.add(entry.getKey());
            }
        }

        Collections.sort(missing);
        StringBuilder sb = new StringBuilder();
        for (int x : missing) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
        sc.close();
    }
}