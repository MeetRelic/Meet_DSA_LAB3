package com.lab3.Q2;

import java.util.*;

public class Q2FindSumPairInBst {

	static class Node {
		int data;
		Node leftNode, rightNode;
	};

	static Node NewNode(int nodeData)
	{
		Node temp = new Node();
		temp.data = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	public Node insert(Node root, int key)
	{
		if (root == null)
			return NewNode(key);
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findpairWithSum(Node root, int sum,
			HashSet<Integer> set)
	{
		if (root == null)
			return false;

		if (findpairWithSum(root.leftNode, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is ("
					+ (sum - root.data) + ", "
					+ root.data + ")");
			return true;

		}
		else {
			set.add(root.data);
		}
		return findpairWithSum(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairWithSum(root, sum, set))
			System.out.print("nodes are not found."
					+ "\n");

	}

	// Driver code
	public static void main(String[] args)
	{
		Node root = null;
		
		Q2FindSumPairInBst findSP = new Q2FindSumPairInBst();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		int sum = 130;
		findSP.findPairWithGivenSum(root, sum);
	}
}
