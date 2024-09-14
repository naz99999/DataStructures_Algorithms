package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    private BinaryTreeNode root;
    public BinaryTree() {
    }

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the value of the Root Node :- ");
        int value = scanner.nextInt();
        root = new BinaryTreeNode(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, BinaryTreeNode binaryTreeNode) {
        System.out.println("Do you want a Left node of " + binaryTreeNode.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the Left Node of " + binaryTreeNode.value);
            int value = scanner.nextInt();
            binaryTreeNode.left = new BinaryTreeNode(value);
            populate(scanner, binaryTreeNode.left);
        }

        System.out.println("Do you want a Right node of " + binaryTreeNode.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the Right Node of " + binaryTreeNode.value);
            int value = scanner.nextInt();
            binaryTreeNode.right = new BinaryTreeNode(value);
            populate(scanner, binaryTreeNode.right);
        }
    }

    public void display() {
        display(root, "");
    }
    public void display(BinaryTreeNode binaryTreeNode, String indent) {
        if (binaryTreeNode == null) {
            return;
        }

        System.out.println(indent + binaryTreeNode.value);
        display(binaryTreeNode.left, indent + "\t");
        display(binaryTreeNode.right, indent + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }
    public void prettyDisplay(BinaryTreeNode binaryTreeNode, int level) {
        if (binaryTreeNode == null) {
            return;
        }

        prettyDisplay(binaryTreeNode.right, level + 1);

        if (level == 0) {
            System.out.println(binaryTreeNode.value);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + binaryTreeNode.value);
        }

        prettyDisplay(binaryTreeNode.left, level + 1);
   }

   public void breadthFirstSearch() {
       Queue<BinaryTreeNode> queue = new LinkedList<>();
       queue.add(root);
       bfs(root, queue);
   }

    private void bfs(BinaryTreeNode node, Queue<BinaryTreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }

        System.out.print(queue.remove().value + " -> ");
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
        bfs(queue.peek(), queue);
    }
}
