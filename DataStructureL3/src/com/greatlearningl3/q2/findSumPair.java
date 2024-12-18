package com.greatlearningl3.q2;
import java.util.*;

public class findSumPair {
	// Node class for the Binary Search Tree
    static class Node {
        int nodeData;
        Node leftNode, rightNode;

        Node(int nodeData) {
            this.nodeData = nodeData;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    // Function to insert a new node in the BST
    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.nodeData) {
            root.leftNode = insert(root.leftNode, key);
        } else {
            root.rightNode = insert(root.rightNode, key);
        }
        return root;
    }

    // Utility function to find if a pair with the given sum exists
    private boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        // Traverse the left subtree
        if (findPairUtil(root.leftNode, sum, set)) {
            return true;
        }

        // Check if the complement exists in the set
        if (set.contains(sum - root.nodeData)) {
            System.out.println("Pair is found (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
            return true;
        } else {
            set.add(root.nodeData); // Add the current node value to the set
        }

        // Traverse the right subtree
        return findPairUtil(root.rightNode, sum, set);
    }

    // Function to find a pair with the given sum in the BST
    public void findPairWithGivenSum(Node root, int sum) {
        HashSet<Integer> set = new HashSet<>();
        if (!findPairUtil(root, sum, set)) {
            System.out.println("No pair exists with the given sum.");
        }
    }

    // Driver code
    public static void main(String[] args) {
        findSumPair findSP = new findSumPair();
        Node root = null;

        // Insert nodes into the BST
        root = findSP.insert(root, 40);
        root = findSP.insert(root, 20);
        root = findSP.insert(root, 60);
        root = findSP.insert(root, 10);
        root = findSP.insert(root, 30);
        root = findSP.insert(root, 50);
        root = findSP.insert(root, 70);

        int sum = 60;

        // Find the pair with the given sum
        findSP.findPairWithGivenSum(root, sum);
    }

}
