package Tree;
import java.io.*;
import java.util.*;

public class Main2 {

  static Map<Character, Node> tree = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char data = st.nextToken().charAt(0);
      char left = st.nextToken().charAt(0);
      char right = st.nextToken().charAt(0);

      // 현재 노드가 없으면 새로 생성
      tree.putIfAbsent(data, new Node(data));

      Node current = tree.get(data);

      if (left != '.') {
        tree.putIfAbsent(left, new Node(left));
        current.left = tree.get(left);
      }

      if (right != '.') {
        tree.putIfAbsent(right, new Node(right));
        current.right = tree.get(right);
      }
    }

    Node root = tree.get('A');
    StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
    System.out.println(sb.toString());

    sb.setLength(0);
    inOrder(root, sb);
    System.out.println(sb.toString());

    sb.setLength(0);
    postOrder(root, sb);
    System.out.println(sb.toString());
  }

  static void preOrder(Node node, StringBuilder sb) {
    if (node == null) return;
    sb.append(node.data);
    preOrder(node.left, sb);
    preOrder(node.right, sb);
  }

  static void inOrder(Node node, StringBuilder sb) {
    if (node == null) return;
    inOrder(node.left, sb);
    sb.append(node.data);
    inOrder(node.right, sb);
  }

  static void postOrder(Node node, StringBuilder sb) {
    if (node == null) return;
    postOrder(node.left, sb);
    postOrder(node.right, sb);
    sb.append(node.data);
  }
}

class Node {
  char data;
  Node left;
  Node right;

  Node(char data) {
    this.data = data;
  }
}
