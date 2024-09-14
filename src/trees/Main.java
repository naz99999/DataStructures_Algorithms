package trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        Scanner scanner = new Scanner(System.in);
//        binaryTree.populate(scanner);
//        binaryTree.prettyDisplay();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.insert(6);
//        binarySearchTree.insert(4);
//        binarySearchTree.insert(8);
//        binarySearchTree.insert(2);
//        binarySearchTree.insert(5);
//        binarySearchTree.insert(7);
//        binarySearchTree.insert(9);
//        binarySearchTree.display();
//        binarySearchTree.insert(10);
//        //binarySearchTree.insert(11);
//        binarySearchTree.display();
//        System.out.println(binarySearchTree.balancedOrNot());

//        binarySearchTree.populateSorted(new int[] {1,2,3,4,5,6,7,8,9,10});
//        binarySearchTree.display();

//        binarySearchTree.insert(15);
//        binarySearchTree.insert(12);
//        binarySearchTree.insert(10);
//        binarySearchTree.insert(13);
//        binarySearchTree.insert(20);
//        binarySearchTree.display();
//        binarySearchTree.preOrder();
//        System.out.println();
//        binarySearchTree.inOrder();
//        System.out.println();
//        binarySearchTree.postOrder();

//        AVLTree avlTree = new AVLTree();
//        for (int i=1; i<11; i++) {
//            avlTree.insert(i);
//        }
//        avlTree.prettyDisplay();


        //Breadth first Search tree
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.populate(scanner);
        binaryTree.prettyDisplay();
        binaryTree.breadthFirstSearch();
    }
}
