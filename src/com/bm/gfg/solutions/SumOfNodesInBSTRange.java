//$Id$
package com.bm.gfg.solutions;

/**
 * Problem: Sum of Nodes in BST Range
 *
 * <p>
 * Given the root of a Binary Search Tree (BST) and two integers {@code l} and {@code r}, 
 * the task is to find the sum of all nodes that lie between {@code l} and {@code r}, 
 * including both {@code l} and {@code r}.
 * </p>
 *
 * <p>
 * Examples:
 * <pre>
 * Input: root = [22, 12, 30, 8, 20], l = 10, r = 22
 * Output: 54
 * Explanation: Nodes in range [10,22] are {12,20,22}. Sum = 12 + 20 + 22 = 54
 *
 * Input: root = [8, 5, 11, 3, 6, N, 20], l = 11, r = 15
 * Output: 11
 * Explanation: Node in range [11,15] is {11}. Sum = 11
 * </pre>
 * </p>
 *
 * <p>
 * Constraints:
 * <ul>
 *   <li>0 ≤ number of nodes ≤ 10^4</li>
 *   <li>0 ≤ node.data ≤ 10^4</li>
 *   <li>0 ≤ l ≤ r ≤ 10^4</li>
 * </ul>
 * </p>
 *
 * <p>
 * Expected Complexities:
 * <ul>
 *   <li>Time Complexity: O(n)</li>
 *   <li>Auxiliary Space: O(h), where h is the height of the BST</li>
 * </ul>
 * </p>
 *
 * <p>Topic Tags: Binary Search Tree, Data Structures, Algorithms</p>
 * 
 * @author Balamurugan M
 */

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class SumOfNodesInBSTRange {

    // Insert a value into BST
    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Build BST from array
    static Node buildBST(int[] arr) {
        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        return root;
    }

    // Inorder traversal to verify
    static void inorder(Node root) {
        if (root == null) { return; };
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    private static int sumOfNodes(Node root, int l , int r) {
    	int sum = 0;
		if (root == null) {
			return sum;
		}
		if(root.data >= l && root.data <= r) {
			sum+= root.data;
		}
		sum += sumOfNodes(root.left,l, r) + sumOfNodes(root.right, l, r);
		return sum;
	}
    
    public static void main(String[] args) {
        int[] arr = {8, 5, 11, 3, 6, 20};
        int l = 11;
        int r = 15;
        Node root = buildBST(arr);
        int sum = sumOfNodes(root, l, r);
        System.out.println(sum);
    }
}
