import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Bai5_CheckBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(Scanner sc, int n) {
        if (n <= 0 || !sc.hasNextInt()) return null;
        int rootVal = sc.nextInt();
        if (rootVal == -1) return null;

        Node root = new Node(rootVal);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 1;
        while (!queue.isEmpty() && count < n) {
            Node curr = queue.poll();

            if (count < n && sc.hasNextInt()) {
                int leftVal = sc.nextInt();
                count++;
                if (leftVal != -1) {
                    curr.left = new Node(leftVal);
                    queue.add(curr.left);
                }
            }

            if (count < n && sc.hasNextInt()) {
                int rightVal = sc.nextInt();
                count++;
                if (rightVal != -1) {
                    curr.right = new Node(rightVal);
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }

    public static boolean checkBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValid(Node node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return isValid(node.left, min, node.data) &&
                isValid(node.right, node.data, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Node root = buildTree(sc, n);
        System.out.println(checkBST(root) ? "Yes" : "No");
        sc.close();
    }
}