package com.greatlearing.services;

class Node {
	int value;
	Node left, right;

	Node(int item) {
		value = item;
		left = right = null;
	}
}

class MNC {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void ToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}

		if (order > 0) {
			ToSkewed(root.right, order);
		} else {
			ToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			ToSkewed(leftNode, order);
		} else {
			ToSkewed(rightNode, order);
		}
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {

		MNC tree = new MNC();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);

		int order = 0;
		ToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}
