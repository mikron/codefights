package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 07/07/16.
 */
public class TournamentDay32 {

    private static int numberOfSolutions(int n) {

        int result = 0;
        for (int a = 2; a < n * n; a++) {
            if ((a * n) % (a + n) == 0) {
                result++;
            }
        }

        return result * 2 + 1;
    }

    /*private static int[] treeBottom(String tree) {

        class Node {
            int data;
            Node leftChild, rightChild;

            private Node(int data) {
                this.data = data;
                leftChild = rightChild = null;
            }

            private Node(int data, Node left, Node right) {
                this.data = data;
                this.leftChild = left;
                this.rightChild = right;
            }

            public int getData() {
                return data;
            }

            public Node getLeftChild() {
                return leftChild;
            }

            public void setLeftChild(Node leftChild) {
                this.leftChild = leftChild;
            }

            public Node getRightChild() {
                return rightChild;
            }

            public void setRightChild(Node rightChild) {
                this.rightChild = rightChild;
            }
        }

        class BinaryTree {

            private Node root = null;

            public Node getRoot() {
                return root;
            }

            void insertDataLeft(int data) {
                Node node=new Node(data,null,null);
                if (root == null) {
                    root = node;
                } else {
                    insertLeft(node, root);
                }
            }

            void insertDataRight(int data) {
                Node node=new Node(data,null,null);
                if (root == null) {
                    root = node;
                } else {
                    insertRight(node, root);
                }
            }

            private Node insertLeft(Node node, Node root1) {
                if (root1 == null) {
                    root1 = new Node(((Node) node).getData(), null, null);
                    if (this.root == null) {
                        this.root = root1;
                    }
                } else {
                    root1.setLeftChild(insertLeft(node, root1.getLeftChild()));
                }

                return root1;
            }

            private Node insertRight(Node node, Node root1) {
                if (root1 == null) {
                    root1 = new Node(((Node) node).getData(), null, null);
                    if (this.root == null) {
                        this.root = root1;
                    }
                } else {
                    root1.setRightChild(insertLeft(node, root1.getRightChild()));
                }

                return root1;
            }
        }

        BinaryTree binaryTree = new BinaryTree();

        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 1; i < tree.length(); i++) {
            c = tree.charAt(i);
            if (c != ' ') {
                if (c == '(') {
                    stack.push(c);
                    //binaryTree.insertLeft()

                } else if (c == ')')
                    if (stack.peek() == '(')
                        stack.pop();
            }
            if (stack.isEmpty())



        }

        return new int[]{0};
    }*/

    private static int[] fractionDivision(int[] A, int[] B) {

        class Helper {
            int gcdEuclid(int a, int b) {
                if (a == 0) {
                    return b;
                }
                return gcdEuclid(b % a, a);
            }
        }
        Helper h = new Helper();

        int[] C = {A[0] * B[1], A[1] * B[0]};
        int gcd = h.gcdEuclid(C[0], C[1]);

        C[0] /= gcd;
        C[1] /= gcd;

        return C;
    }

    private static boolean logicalNor(boolean a, boolean b) {
        return !a && !b;
    }

    //checks whether an int is prime or not.
    private static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static int greatestCommonPrimeDivisor(int a, int b) {
        int ans = -1;
        int min = Math.min(a, b);

        for (int i = 2; i <= min / 2; i++) {
            if (a % i == 0 && b % i == 0) {
                if (isPrime(i) && i > ans)
                    ans = i;
            }
        }

        if (a % min == 0 && b % min == 0) {
            if (isPrime(min) && ans > min)
                ans = min;
        }

        return ans;
    }


    public static void main(String[] args) {
        // System.out.println(numberOfSolutions(2));
        // System.out.println(numberOfSolutions(1));
        // System.out.println(numberOfSolutions(3));
        // System.out.println(Arrays.toString(treeBottom("(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))")));
        // System.out.println(Arrays.toString(fractionDivision(new int[]{2, 3}, new int[]{5, 6})));
        // System.out.println(logicalNor(true, false));
        System.out.println(greatestCommonPrimeDivisor(12, 18));
        System.out.println(greatestCommonPrimeDivisor(12, 13));
    }

}
