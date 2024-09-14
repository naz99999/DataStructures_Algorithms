package trees;

public class SegmentTree {

    public static void main(String args[]) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree segmentTree = new SegmentTree(arr);
        //segmentTree.display();
        System.out.println(segmentTree.query(1, 5));
        segmentTree.update(5, -9);
        System.out.println(segmentTree.query(1, 5));
    }

    private SegmentTreeNode root;

    private static class SegmentTreeNode {
        int data;
        int startInterval;
        int endInterval;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public SegmentTree(int[] arr) {
        this.root = construct(arr, 0, arr.length - 1);
    }

    private SegmentTreeNode construct(int[] arr, int start, int end) {
        if (start == end) {
            //leaf node
            SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end);
            segmentTreeNode.data = arr[start];
            return segmentTreeNode;
        }

        //create a new node with index you are at
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end);

        int mid = (start + end) / 2;

        segmentTreeNode.left = construct(arr, start, mid);
        segmentTreeNode.right = construct(arr, mid + 1, end);

        segmentTreeNode.data = segmentTreeNode.left.data + segmentTreeNode.right.data;

        return segmentTreeNode;
    }

    public void display() {
        display(this.root);
    }

    private void display(SegmentTreeNode node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        //for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + "\n");

        //call recursion
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    //query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(SegmentTreeNode node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            //node is completely lying inside query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            //completely outside
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(SegmentTreeNode node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);

                node.data = leftAns + rightAns;
            }
            return node.data;
        }
        return node.data;
    }
}





















