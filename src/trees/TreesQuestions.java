package trees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TreesQuestions {
    private TreeNode root;

    public static void main(String[] args) {
//        TreesQuestions treesQuestions = new TreesQuestions();
//        Scanner scanner = new Scanner(System.in);
//        treesQuestions.populate(scanner);


        //treesQuestions.isCousins(treesQuestions.root, 5, 4);
        //treesQuestions.flatten(treesQuestions.root);
        //System.out.println(treesQuestions.kthSmallest2(treesQuestions.root, 3));
        //System.out.println(treesQuestions.serialize(treesQuestions.root));
        List<String> list = new ArrayList<>(); list.add("a"); list.add("b");list.add("c");
        System.out.println(list);
        System.out.println(ladderLength("a", "c", list));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the value of the Root Node :- ");
        int value = scanner.nextInt();
        root = new TreeNode(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, TreeNode Node) {
        System.out.println("Do you want a Left node of " + Node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the Left Node of " + Node.val);
            int value = scanner.nextInt();
            Node.left = new TreeNode(value);
            populate(scanner, Node.left);
        }

        System.out.println("Do you want a Right node of " + Node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the Right Node of " + Node.val);
            int value = scanner.nextInt();
            Node.right = new TreeNode(value);
            populate(scanner, Node.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public TreeNode correctBSTTwoNodesSwapped(TreeNode root) {
        if (root == null) {
            return null;
        }

        inOrderHelper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return root;
    }

    private void inOrderHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderHelper(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;

        inOrderHelper(root.right);
    }

    class LLNode {
        int val;
        LLNode prev;
        LLNode next;

        public LLNode(int val) {
            this.val = val;
        }
    }

    LLNode head;
    LLNode tail;
    public LLNode binaryTreeToDoublyLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }

        binaryTreeToDoublyLinkedListHelper(root);

        return head;
    }

    private void binaryTreeToDoublyLinkedListHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        binaryTreeToDoublyLinkedListHelper(root.left);

        LLNode newNode = new LLNode(root.val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }

        binaryTreeToDoublyLinkedListHelper(root.right);
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest4(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        kthSmallest4Helper(root, k, minHeap);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = minHeap.poll();
        }
        return ans;
    }

    private void kthSmallest4Helper(TreeNode root, int k, PriorityQueue<Integer> minHeap) {
        if (root == null) {
            return;
        }

        kthSmallest4Helper(root.left, k, minHeap);
        minHeap.offer(root.val);
        kthSmallest4Helper(root.right, k, minHeap);
    }

    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return findTargetHelper(root.left, k, set) || findTargetHelper(root.left, k, set);
    }

    //https://leetcode.com/problems/word-ladder/
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashTable = new HashSet<>(wordList);
        if (!hashTable.contains(endWord)) {return 0;}

        int seqNo = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            seqNo++;
            int currentLevel = queue.size();

            //Iterate for those level of words
            for (int i = 0; i < currentLevel; i++) {
                String currentNode = queue.poll();
                //return if newWord is endWord
                if (currentNode.equals(endWord)) {
                    return seqNo + 1;
                }

                //Iterate for every letter in that word
                for (int j = 0; j < currentNode.length(); j++) {
                    //Replace all alphabets in all indices to see if any wordList word is there
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] nodeCharArr = currentNode.toCharArray();
                        nodeCharArr[j] = ch;
                        String newWord = new String(nodeCharArr);

                        //add newWord in queue if it is present in wordList and is not visited already
                        if (hashTable.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();

        if (root == null) {
            return ans;
        }

        int currCol = 0;
        int minCol = 0;
        int maxCol = 0;

        queue.offer(new AbstractMap.SimpleEntry<>(root, currCol));
        while (!queue.isEmpty()) {
            TreeMap<Integer, List<Integer>> levelMap = new TreeMap<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Map.Entry<TreeNode, Integer> removed = queue.poll();
                TreeNode node = removed.getKey();
                currCol = removed.getValue();

                if (node != null) {
                    if (!levelMap.containsKey(currCol)) {
                        levelMap.put(currCol, new ArrayList<>());
                    }
                    levelMap.get(currCol).add(node.val);
                    Collections.sort(levelMap.get(currCol));
                }

                minCol = Math.min(minCol, currCol);
                maxCol = Math.max(maxCol, currCol);

                if (node.left != null) {
                    queue.offer(new AbstractMap.SimpleEntry<>(node.left, currCol - 1));
                }
                if (node.right != null) {
                    queue.offer(new AbstractMap.SimpleEntry<>(node.right, currCol + 1));
                }
            }

            //merge into main map
            levelMap.forEach((key, value) -> {
                if (map.containsKey(key)) {
                    map.get(key).addAll(value);
                } else {
                    map.put(key, value);
                }
            });
        }

        for (int i = minCol; i <= maxCol; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        verticalTraversalHelper(root, 0, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        map.forEach((col, nodeList) -> {
            Collections.sort(nodeList);
            ans.add(nodeList);
        });
        return ans;
    }

    private void verticalTraversalHelper(TreeNode root, int row, int col, TreeMap<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        List<Integer> nodeValues = map.getOrDefault(col, new ArrayList<>());
        nodeValues.add(root.val);
        map.put(col, nodeValues);

        verticalTraversalHelper(root.left, row + 1, col - 1, map);
        verticalTraversalHelper(root.left, row + 1, col + 1, map);
    }

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    int i = 0;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildTree2Helper(preorder, inorder, 0, preorder.length, inOrderIndexMap);
    }

    public TreeNode buildTree2Helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> inOrderMap) {
        if (left >= right) {
            return null;
        }

        int r = preorder[i++];
        int index = inOrderMap.getOrDefault(r, 0);

        TreeNode root = new TreeNode(r);

        root.left = buildTree2Helper(preorder, inorder, left, index, inOrderMap);
        root.right = buildTree2Helper(preorder, inorder, index + 1, right, inOrderMap);

        return root;
    }

    //KK EXPLICIT QUESTION 3
    public List<Integer> dfsFromStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    //KK EXPLICIT QUESTION 3
    public List<List<Integer>> pathExistsBinaryTreeAnyNodes(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathExistsBinaryTreeAnyNodesHelper(root, path, sum, paths);
        return paths;
    }

    private void pathExistsBinaryTreeAnyNodesHelper(TreeNode root, List<Integer> path, int sum, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        int localSum = 0;
        List<Integer> localPath = new ArrayList<>();

        ListIterator<Integer> iterator = path.listIterator(path.size());
        while (iterator.hasPrevious()) {
            localSum += iterator.previous();
            localPath.add(iterator.previous());
            if (localSum == sum) {
                paths.add(localPath);
            }
        }

        pathExistsBinaryTreeAnyNodesHelper(root.left, path, sum, paths);
        pathExistsBinaryTreeAnyNodesHelper(root.right, path, sum, paths);

        //Backtrack before returning
        path.remove(path.size() - 1);
    }

    //KK EXPLICIT QUESTION 2
    public int countPathExistsBinaryTreeAnyNodes(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        return countPathExistsBinaryTreeAnyNodesHelper(root, path, sum);
    }

    private int countPathExistsBinaryTreeAnyNodesHelper(TreeNode root, List<Integer> path, int sum) {
        if (root == null) {
            return 0;
        }

        path.add(root.val);
        int count = 0;
        int localSum = 0;

        //add up path sum from the back of the list because on the front, elements already traversed would exist
        ListIterator<Integer> iterator = path.listIterator(path.size());
        while (iterator.hasPrevious()) {
            localSum  = localSum + iterator.previous();

            if (localSum == sum) {
                count++;
            }
        }

        count += countPathExistsBinaryTreeAnyNodesHelper(root.left, path, sum) + countPathExistsBinaryTreeAnyNodesHelper(root.right, path, sum);

        //Backtrack before returning
        path.remove(path.size() - 1);

        return count;
    }

    //KK EXPLICIT QUESTION 1
    public boolean pathExistsBinaryTree(TreeNode root, int[] path) {
        return pathExistsBinaryTreeHelper(root, 0, path);
    }

    private boolean pathExistsBinaryTreeHelper(TreeNode root, int index, int[] path) {
        if (root == null) {
            return false;
        }

        if (index >= path.length || path[index] != root.val) {
            return false;
        }

        if (index == path.length - 1) {
            return true;
        }

        return pathExistsBinaryTreeHelper(root.left, index + 1, path) || pathExistsBinaryTreeHelper(root.right, index + 1, path);
    }

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/
    int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);

        int localMaxSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, localMaxSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers2(TreeNode root) {
        return sumNumbers2Helper(root, 0);
    }

    private int sumNumbers2Helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum*10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return sumNumbers2Helper(root.left, sum) + sumNumbers2Helper(root.right, sum);
    }

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {
        List<String> ans = new ArrayList<>();
        sumNumbersHelper(root, "", ans);
        int sum = 0;
        for (String an : ans) {
            sum += Integer.parseInt(an);
        }
        return sum;
    }

    private void sumNumbersHelper(TreeNode root, String path, List<String> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path += root.val;
            ans.add(path);
            return;
        }

        sumNumbersHelper(root.left, path + root.val, ans);
        sumNumbersHelper(root.right, path + root.val, ans);
    }

    //https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, targetSum);
    }

    public boolean hasPathSumHelper(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum = targetSum - root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }

        return hasPathSumHelper(root.left, targetSum) || hasPathSumHelper(root.right, targetSum);
    }

    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        List<String> comp = new ArrayList<>();
        serialize2Helper(root, comp);
        return String.join(",", comp);
    }

    private void serialize2Helper(TreeNode root, List<String> comp) {
        if (root == null) {
            comp.add("null");
            return;
        }
        comp.add(String.valueOf(root.val));
        serialize2Helper(root.left, comp);
        serialize2Helper(root.right, comp);
    }

    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] ans = data.split(",");
        List<String> deComp = new ArrayList<>(Arrays.asList(ans));
        Collections.reverse(deComp);
        return deserialize2Helper(deComp);
    }

    private TreeNode deserialize2Helper(List<String> deComp) {
        String value = deComp.removeLast();

        if (value.equalsIgnoreCase("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserialize2Helper(deComp);
        node.right = deserialize2Helper(deComp);

        return node;
    }

    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Encodes a tree to a single string.
    List<String> serializeString = new ArrayList<>();
    public String serialize(TreeNode root) {
        preOrder(root);
        inOrder(root);
        return serializeString.toString();
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        serializeString.add(String.valueOf(root.val));
        inOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        serializeString.add(String.valueOf(root.val));
        preOrder(root.left);
        preOrder(root.right);
    }


    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        int[] preOrder = new int[data.length()/2];
        int[] inOrder = new int[data.length()/2];
        for (int i = 0; i < data.length()/2; i++) {
            preOrder[i] = data.charAt(i);
        }
        for (int i = data.length()/2, j = 0; i < data.length(); i++, j++) {
            inOrder[j] = data.charAt(i);
        }

        return deserializeHelper(preOrder, inOrder);
    }

    private TreeNode deserializeHelper(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0) {
            return null;
        }

        int r = preOrder[0];
        TreeNode root = new TreeNode(r);
        int index = -1;

        for (int i = 0; i < inOrder.length; i++) {
            if (r == inOrder[i]) {
                index = i;
            }
        }

        root.left = deserializeHelper(Arrays.copyOfRange(preOrder, 1, index + 1), Arrays.copyOfRange(inOrder, 0, index));
        root.right = deserializeHelper(Arrays.copyOfRange(preOrder, index + 1, preOrder.length), Arrays.copyOfRange(inOrder, index + 1, inOrder.length));

        return root;
    }

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int r = preorder[0];
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(r);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    static int count = 0;
    public int kthSmallest3(TreeNode root, int k) {//DEALING WITH TREENODE INSTEAD OF INT LIKE BELOW
        return kthSmallest3helper(root, k).val;     //BECAUSE ANSWER GALAT AA RAHA THA PATA NAI KAISE
    }
    public TreeNode kthSmallest3helper(TreeNode root, int k) {//CONSTANT SPACE COMPLEXITY
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallest3helper(root.left, k);

        if (left != null) {
            return left;
        }

        count = count + 1;
        if (count == k) {
            return root;
        }

        TreeNode right = kthSmallest3helper(root.right, k);

        return right;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    public int kthSmallest2(TreeNode root, int k) {//CONSTANT SPACE COMPLEXITY
        if (root == null) {
            return -1;
        }

        int left = kthSmallest2(root.left, k);

        if (left != -1) {
            return left;
        }

        count = count + 1;
        if (count == k) {
            return root.val;
        }

        int right = kthSmallest2(root.right, k);

        return right;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    public int kthSmallest(TreeNode root, int k) {//USING EXTRA ARRAY SPACE
        List<Integer> ans = new ArrayList<>();
        kthSmallestHelper(root, k, ans);
        return ans.get(k - 1);
    }

    private void kthSmallestHelper(TreeNode root, int k, List<Integer> ans) {
        if (root == null) {
            return;
        }

        kthSmallestHelper(root.left, k, ans);
        ans.add(root.val);
        kthSmallestHelper(root.right, k, ans);
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {//DFS PRE ORDER -> 6MS
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }



    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//DFS POST ORDER -> 7MS
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (root == p || root == q) {
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    //https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST2(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        return isValidBSTHelper(node.left, low, node.val) && isValidBSTHelper(node.right, node.val, high);
    }

    //https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {// O(N^2) time complexity not good
        if (root == null) {
            return true;
        }
        
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        if (!isHighest(root.left, root.val) || !isLowest(root.right, root.val)) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isLowest(TreeNode right, int currVal) {
        if (right == null) {
            return true;
        }

        if (right.val <= currVal) {
            return false;
        }

        return isLowest(right.left, currVal) && isLowest(right.right, currVal);
    }

    private boolean isHighest(TreeNode left, int currVal) {
        if (left == null) {
            return true;
        }

        if (left.val >= currVal) {
            return false;
        }

        return isHighest(left.left, currVal) && isHighest(left.right, currVal);
    }

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten2(TreeNode root) {//KK SOL ITERATIVE
        if (root == null) {
            return;
        }

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {// NAZ MAST SOL RECURSIVE
        if (root == null) {
            return;
        }

        TreeNode actualRight = root.right;
        root.right = root.left;
        root.left = null;

        flatten(root.right);
        flatten(actualRight);

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = actualRight;
    }

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int s, int e) {
        if (s >= e) {
            return null;
        }

        int mid = (s + e) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBSTHelper(nums, s, mid);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, e);

        return node;
    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    //https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree2(TreeNode root) {
        return invertTreeHelper2(root);
    }

    private TreeNode invertTreeHelper2(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);

        node.right = left;
        node.left = right;

        return node;
    }

    //https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }

    private TreeNode invertTreeHelper(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.right = invertTree(left);
        node.left = invertTree(right);

        return node;
    }

    //https://leetcode.com/problems/diameter-of-binary-tree/
    int diameter = 0;
    public int diameterOfBinaryTree2(TreeNode root) { //0ms KK SOl
        heightAndDiameterUpdate(root);
        return diameter;
    }

    private int heightAndDiameterUpdate(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = heightAndDiameterUpdate(node.left);
        int right = heightAndDiameterUpdate(node.right);

        int dia = left + right;
        diameter = Math.max(dia, diameter);

        return Math.max(left, right) + 1;
    }

    //https://leetcode.com/problems/diameter-of-binary-tree/
    public int diameterOfBinaryTree(TreeNode root) {// NAZ SOL 190ms bad, because calling diameter and height separately.
        int diameter = 0;                           // KK vaale upar sol me ek func me dono kaam ho rahe.
        return diameterOfBinaryTreeHelper(root, diameter);
    }

    private int diameterOfBinaryTreeHelper(TreeNode node, int diameter) {
        if (node == null) {
            return 0;
        }

        int d1 = diameterOfBinaryTreeHelper(node.left, diameter);
        int d2 = diameterOfBinaryTreeHelper(node.right, diameter);

        int height1 = heightOfTree(node.left);
        int height2 = heightOfTree(node.right);

        if (height1 + height2 > diameter)
            diameter = height1 + height2;

        if (d1 > diameter)
            diameter = d1;

        if (d2 > diameter)
            diameter = d2;

        return diameter;
    }

    private int heightOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(heightOfTree(node.left), heightOfTree(node.right)) + 1;
    }

    //https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric2(TreeNode root) { //iterative
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null) {
                return false;
            } else if (node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    //https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) { //recursive
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
    }

    //https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean xFound = false;
        boolean yFound = false;
        int xParent = 0;
        int yParent = 0;
        int level = 0;
        int xLevel = 0;
        int yLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //iterating for that level based on the size of the queue, will always be equal to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                    if (currNode.left.val == x) {
                        xFound = true;
                        xParent = currNode.val;
                        xLevel = level;
                    }
                    if (currNode.left.val == y) {
                        yFound = true;
                        yParent = currNode.val;
                        yLevel = level;
                    }
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                    if (currNode.right.val == x) {
                        xFound = true;
                        xParent = currNode.val;
                        xLevel = level;
                    }
                    if (currNode.right.val == y) {
                        yFound = true;
                        yParent = currNode.val;
                        yLevel = level;
                    }
                }
            }
            if (xFound && yFound) {
                return xParent != yParent && xLevel == yLevel;
            }
            level++;
        }
        return false;
    }

    //https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //iterating for that level based on the size of the queue, will always be equal to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (i == levelSize - 1) {
                    ans.add(currNode.val);
                }

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect4(Node root) { //Approach not using queue iterative
        if (root == null) return null;

        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;

            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) { //for the rightmost node of the level
                    current.right.next = current.next.left;
                }

                current = current.next; //moving fwd in the level
            }
            leftMost = leftMost.left; //moving down by left side
        }
        return root;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect3(Node root) { //Approach not using queue recursive
        return helper2(root);
    }

    private Node helper2(Node node) {
        if (node == null) return null;

        if (node.left != null) {
            node.left.next = node.right;
        }
        if (node.next != null && node.right != null) {
            node.right.next = node.next.left;
        }

        node.left = helper2(node.left);
        node.right = helper2(node.right);

        return node;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    static List<List<Node>> ans;

    public Node connect2(Node root) { //Approach not using queue
        ans = new ArrayList<>();
        helper(root, 0);

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                if (j == ans.get(i).size() - 1) {
                    break;
                }
                ans.get(i).get(j).next = ans.get(i).get(j + 1);
            }
        }

        return root;
    }

    private void helper(Node node, int level) {
        if (node == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node);

        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            //iterating for that level based on the size of the queue, will always be equal to the current level
            for (int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();

                if (i == levelSize - 1) {
                    currNode.next = null;
                } else {
                    currNode.next = queue.peek();
                }

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
        }
        return root;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            //iterating for that level based on the size of the queue, will always be equal to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currentLevel.add(currNode.val);

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            ans.add(0, currentLevel);
        }
        //Collections.reverse(ans); //APPROACH 2 is to reverse the list after storing
        return ans;
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrderUsingDeque(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean normalOrder = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode;

                if (normalOrder) {
                    currNode = deque.removeFirst();
                    if (currNode.left != null)
                        deque.addLast(currNode.left);
                    if (currNode.right != null)
                        deque.addLast(currNode.right);
                } else {
                    currNode = deque.removeLast();
                    if (currNode.right != null)
                        deque.addFirst(currNode.right);
                    if (currNode.left != null)
                        deque.addFirst(currNode.left);
                }
                currentLevel.add(currNode.val);
            }
            normalOrder = !normalOrder;
            ans.add(currentLevel);
        }
        return ans;
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queueLeftToRight = new LinkedList<>();
        Queue<TreeNode> queueRightToLeft = new LinkedList<>();
        queueLeftToRight.offer(root);
        queueRightToLeft.offer(root);

        int alternateLevel = 0;

        while (!queueLeftToRight.isEmpty() && !queueRightToLeft.isEmpty()) {
            int levelSize = queueLeftToRight.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currLeftToRightNode = queueLeftToRight.poll();
                TreeNode currRightToLeftNode = queueRightToLeft.poll();

                if (currLeftToRightNode.left != null)
                    queueLeftToRight.offer(currLeftToRightNode.left);
                if (currLeftToRightNode.right != null)
                    queueLeftToRight.offer(currLeftToRightNode.right);

                if (currRightToLeftNode.right != null)
                    queueRightToLeft.offer(currRightToLeftNode.right);
                if (currRightToLeftNode.left != null)
                    queueRightToLeft.offer(currRightToLeftNode.left);

                if (alternateLevel % 2 != 0) {
                    currentLevel.add(currRightToLeftNode.val);
                } else {
                    currentLevel.add(currLeftToRightNode.val);
                }
            }
            alternateLevel++;
            ans.add(currentLevel);
        }
        return ans;
    }

    //Give the node right next to the one passed in the parameter, if it is the rightmost then the first one of the next level
    public TreeNode levelOrderSuccessorNode(TreeNode root, int givenNodeValue) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            if (currNode.left != null)
                queue.offer(currNode.left);
            if (currNode.right != null)
                queue.offer(currNode.right);

            //return the next right node from the queue
            if (currNode.val == givenNodeValue)
                return queue.peek();
        }
        return null;
    }

    //https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            //iterating for that level based on the size of the queue, will always be equal to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                levelSum += currNode.val;

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            BigDecimal avgValue = new BigDecimal(levelSum / levelSize).setScale(5, RoundingMode.HALF_UP);
            ans.add(avgValue.doubleValue());
        }
        return ans;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            //iterating for that level based on the size of the queue, will always be equal to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currentLevel.add(currNode.val);

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            ans.add(currentLevel);
        }
        return ans;
    }
}









