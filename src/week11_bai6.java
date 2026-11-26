import java.util.*;

class Bai6_RunningMedian {
    static class Element implements Comparable<Element> {
        int val;
        int id;

        Element(int val, int id) {
            this.val = val;
            this.id = id;
        }

        @Override
        public int compareTo(Element other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        TreeSet<Element> tree = new TreeSet<>();
        Element mid = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            Element curr = new Element(x, i);
            tree.add(curr);

            if (i == 1) {
                mid = curr;
            } else if (i % 2 == 0) {
                if (curr.compareTo(mid) < 0) {
                    mid = tree.lower(mid);
                }
            } else {
                if (curr.compareTo(mid) > 0) {
                    mid = tree.higher(mid);
                }
            }

            double median;
            if (i % 2 == 1) {
                median = mid.val;
            } else {
                Element nextMid = tree.higher(mid);
                median = (mid.val + nextMid.val) / 2.0;
            }
            sb.append(String.format(Locale.US, "%.1f", median)).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}