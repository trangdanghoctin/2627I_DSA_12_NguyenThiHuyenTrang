import java.util.Scanner;

class CountingSort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int[] count = new int[100];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x >= 0 && x < 100) {
                count[x]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

        sc.close();
    }
}