package trees;

import org.w3c.dom.Node;

public class BinarySearchTree {

    public BinarySearchTree() {
    }

    private class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;
        int height;

        public BSTNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public int height(BSTNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private BSTNode root;

    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        if (root == null) {
            root = new BSTNode(value);
        } else {
            root = insert(root, value);
        }
    }
    private BSTNode insert(BSTNode node, int value) {
        if (node == null) {
            BSTNode newNode = new BSTNode(value);
            return newNode;
        }

        if (value <= node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void preOrder() {
        System.out.println("Pre Order :- ");
        preOrder(root);
    }

    private void preOrder(BSTNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        System.out.println("In Order :- ");
        inOrder(root);
    }

    private void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " -> ");
        inOrder(node.right);
    }

    public void postOrder() {
        System.out.println("Post Order :- ");
        postOrder(root);
    }

    private void postOrder(BSTNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " -> ");
    }
    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end)/2;
        insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public void display() {
        display(root, "Root Node is : ");
    }

    private void display(BSTNode bstNode, String text) {
        if (bstNode == null) {
            return;
        }

        System.out.println(text + bstNode.value);
        display(bstNode.left, "Left Child of " + bstNode.value + " is : ");
        display(bstNode.right, "Right Child of " + bstNode.value + " is : ");
    }
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(BSTNode bstNode, int level) {
        if (bstNode == null) {
            return;
        }

        prettyDisplay(bstNode.right, level + 1);

        if (level == 0) {
            System.out.println(bstNode.value);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + bstNode.value);
        }

        prettyDisplay(bstNode.left, level + 1);
    }

    public boolean balancedOrNot() {
        return balancedOrNot(root);
    }

    private boolean balancedOrNot(BSTNode node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balancedOrNot(node.left) && balancedOrNot(node.right);
    }
}
