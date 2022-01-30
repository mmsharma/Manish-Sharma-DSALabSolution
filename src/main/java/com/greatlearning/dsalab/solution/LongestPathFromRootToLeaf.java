package com.greatlearning.dsalab.solution;

import java.util.ArrayList;
import java.util.List;

public class LongestPathFromRootToLeaf {

	public static void main(String[] s) {
		Node root = new Node();
		root.key = 100;
		root.left = new Node();
		root.left.key = 20;
		root.left.right = new Node();
		root.left.right.key = 50;
		root.left.left = new Node();
		root.left.left.key = 10;
		root.left.left.left = new Node();
		root.left.left.left.key = 5;

		root.right = new Node();
		root.right.key = 130;
		root.right.left = new Node();
		root.right.left.key = 110;
		root.right.right = new Node();
		root.right.right.key = 140;

		List<Integer> longestPath = findLongestPath(root);
		StringBuilder sb = new StringBuilder();
		for (int count = longestPath.size() - 1; count >= 0; count--) {
			sb.append(longestPath.get(count)).append("->");
		}
		System.out.println("Longest path " + sb.delete(sb.length() - 2, sb.length()).toString());
	}

	private static List<Integer> findLongestPath(Node root) {

		if (null == root) {
			return new ArrayList<>();
		}

		List<Integer> rightNodes = findLongestPath(root.right);
		List<Integer> leftNodes = findLongestPath(root.left);

		if (leftNodes.size() > rightNodes.size()) {
			leftNodes.add(root.key);
		} else {
			rightNodes.add(root.key);
		}

		return leftNodes.size() > rightNodes.size() ? leftNodes : rightNodes;
	}

}

class Node {
	Node left;
	Node right;
	int key;
}
