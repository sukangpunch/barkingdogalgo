package barkingdog_youtube.data_structure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 트리 순회
public class b_1991_learn {

    static class Node {

        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static Node root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        root = new Node('A', null, null);

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            char start = s[0].charAt(0);
            char left = s[1].charAt(0);
            char right = s[2].charAt(0);

            insertNode(root, start, left, right);
        }

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        sb.append("\n");

        System.out.println(sb);
    }

    private static void insertNode(Node now, char start, char left, char right) {
        if (now.value == start) {
            now.left = (left == '.' ? null : new Node(left, null, null));
            now.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if(now.left != null){
                insertNode(now.left, start, left, right);
            }
            if(now.right != null){
                insertNode(now.right, start, left, right);
            }
        }
    }

    private static void preOrder(Node node){
        if(node == null){
            return;
        }
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    private static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
