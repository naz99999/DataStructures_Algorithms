package trees;

public class AVLTree {
    public AVLTree() {
    }

    private class AVLTreeNode {
        int value;
        AVLTreeNode left;
        AVLTreeNode right;
        int height;

        public AVLTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public int height(AVLTreeNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private AVLTreeNode root;

    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        if (root == null) {
            root = new AVLTreeNode(value);
        } else {
            root = insert(root, value);
        }
    }
    private AVLTreeNode insert(AVLTreeNode node, int value) {
        if (node == null) {
            AVLTreeNode newNode = new AVLTreeNode(value);
            return newNode;
        }

        if (value <= node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node); //self-balancing step
        //return node;
    }

    private AVLTreeNode rotate(AVLTreeNode node) {
        //left heavy
        if (height(node.left) - height(node.right) > 1) {
            //left left case
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            //left right case
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //right heavy
        if (height(node.left) - height(node.right) < -1) {
            //right right case
            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
            //right left case
            if (height(node.right.left) - height(node.right .right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private AVLTreeNode leftRotate(AVLTreeNode c) {
        AVLTreeNode p = c.right;
        AVLTreeNode t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    private AVLTreeNode rightRotate(AVLTreeNode p) {
        AVLTreeNode c = p.left;
        AVLTreeNode t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    public void preOrder() {
        System.out.println("Pre Order :- ");
        preOrder(root);
    }

    private void preOrder(AVLTreeNode node) {
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

    private void inOrder(AVLTreeNode node) {
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

    private void postOrder(AVLTreeNode node) {
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

    private void display(AVLTreeNode bstNode, String text) {
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

    private void prettyDisplay(AVLTreeNode bstNode, int level) {
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

    private boolean balancedOrNot(AVLTreeNode node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balancedOrNot(node.left) && balancedOrNot(node.right);
    }
}
