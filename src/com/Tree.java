package com;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree {
		static int idx = -1;

		public static Node buildTree(int[] nodes) {
			idx++;
			// Check if index is out of bounds or the node is marked as -1 (null).
			if (idx >= nodes.length || nodes[idx] == -1) {
				return null;
			}
			
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);	
			newNode.right = buildTree(nodes);	
			
			return newNode;
		}

		// Preorder traversal of the tree
		public static void preorder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data+" "); // Print current node
			preorder(root.left); // Traverse left subtree
			preorder(root.right); // Traverse right subtree
		}
		
		public static void inorder(Node root)
		{
			if(root == null)
			{
				return ;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		public static void postorder(Node root)
		{
			if(root==null)
			{
				return;
			}
			
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
		public static void levelOrder(Node root)
		{
			Queue<Node> q=new LinkedList<>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty())
			{
				Node currNode=q.remove();
				if(currNode == null)
				{
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		
		System.out.println("Preorder traversal of the binary tree:");
		tree.postorder(root); // Call preorder traversal with the root node
	}
}
