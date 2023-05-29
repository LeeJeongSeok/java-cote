package me.jeongseok.cote.tree;

public class TreeSearch {

	static Node root;

	public static void dfs(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.data + " ");
			dfs(root.lt);
			dfs(root.rt);
		}
	}
	public static void main(String[] args) {
		root = new Node(1);
		root.lt = new Node(2);
		root.rt = new Node(3);
		root.lt.lt = new Node(4);
		root.lt.rt = new Node(5);
		root.rt.lt = new Node(6);
		root.rt.rt = new Node(7);

		dfs(root);
	}
}
