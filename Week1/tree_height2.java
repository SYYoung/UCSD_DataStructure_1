package Week1;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		TreeNode[] myTree;
		TreeNode root;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}
		
		void build() {
			myTree = new TreeNode[n];
			for (int i=0; i<n; i++) {
				myTree[i] = new TreeNode(i);
			}
			for (int i=0; i<n; i++) {
				int par = parent[i];
				if (par == -1)
					root = myTree[i];
				else {
					myTree[par].addChild(myTree[i]);
				}
			}
		}
		
		void print() {
			for (int i=0; i<n; i++) {
				System.out.println("Tree node number" + myTree[i].nodeNum);
				System.out.println("\t" + "the children are:");
				myTree[i].print();
			}
		}

		int computeHeight1() {
                        // Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}
		
		int computeHeight() {
			int height = getHeightRecursive(root);
			return height;
		}
		int getHeightIteration(TreeNode curNode) {
			if (curNode == null)
				return 0;
			Queue<TreeNode> q = new LinkedList();
			q.add(root);
			int height = 0;
			
			while (true) {
				int nodeCount = q.size();
				if (nodeCount == 0)
					return height;
				height++;
				
				while (nodeCount >0) {
					TreeNode newNode = q.peek();
					q.remove();
					for (TreeNode child: newNode.children) 
						q.add(child);
					nodeCount--;
				}
			}
		}
		
		int getHeightRecursive(TreeNode curNode) {
			int levels = 0;
			if (curNode == null) {
				return levels;
			}
			if (curNode.children.isEmpty()) {
				return 1;
			}
			
			for (TreeNode child: curNode.children) {
				int childHeight = getHeightRecursive(child);
				if (childHeight > levels) {
					levels = childHeight;
				}
			}
			return levels+1;
		}
	}
	
	public class TreeNode {
		int	nodeNum;
		LinkedList<TreeNode> children;
		
		public TreeNode(int name) {
			this.nodeNum = name;
			children = new LinkedList<TreeNode>();
		}
		
		public void addChild(TreeNode childNode) {
			this.children.add(childNode);
		}
		
		public void print() {
			for (TreeNode node:this.children) {
				System.out.print("\t" + "," + node.nodeNum);
			}
			System.out.println();
		}
		
		public boolean isLeaf() {
			return (this.children.isEmpty());
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		tree.build();
		tree.print();
		System.out.println(tree.computeHeight());
	}
}
