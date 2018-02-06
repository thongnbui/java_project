package thong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph2 {
	private int nodeCounts;
	private List<Integer> edges[];
	/**
	 * Initialize storage space for graph of n nodes/vertices
	 * @param n
	 */
	public Graph2(int n) {
		nodeCounts = n;
		edges = new ArrayList[n];
		for (int i=0; i < n; i++) {
			edges[i] = new ArrayList<Integer>();
		}
	}
	/**
	 * add an edge between 2 vertices
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to) {
		edges[from].add(to);
	}

	/**
	 * Breath-First Search: starting from root node, traversing 1 layer at a time
	 * @param root
	 */
	public void BFS(int root) {
		// array of visited nodes
		// create queue to keep track of which ordered nodes visited
		boolean visited[] = new boolean[nodeCounts];
		LinkedList<Integer> queue = new LinkedList<Integer>();
				
		queue.add(root);
		visited[root] = true;
		
		while (queue.size() != 0) {
			// use poll() to dequeue
			int node = queue.poll();
			System.out.print(node + " ");
			
			// get its children and put them on queue
			// and mark them visited
			for (int child : edges[node]) {
				if (!visited[child]) {
					queue.add(child);
					visited[child] = true;
				}			
			}
		}		
	}
	/**
	 * Depth-First Search: starting from root node, go as deep as possible 1st
	 * @param node
	 * @param visited
	 */
	public void DFSTraverse(int node, boolean visited[]) {
		//System.out.println("DFSTraverse(" + node + "," + visited);
		if (!visited[node]) {
			System.out.print(node + " ");
			visited[node] = true;		
		}

		for (int child : edges[node]) {
			if (!visited[child])
				DFSTraverse(child, visited);
		}
	}
	
	public void DFS(int root) {
		// array of visited nodes: keep track of visited nodes
		boolean visited[] = new boolean[nodeCounts];

		DFSTraverse(root, visited);
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		Graph2 g = new Graph2(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 2);

		for (int i=0; i < 4; i++) {
			System.out.print("Following is Breadth First Traversal " + "(starting from vertex " + i + "): ");
			g.BFS(i);
			System.out.println();
			System.out.print("Following is Depth First Traversal " + "(starting from vertex " + i + "): ");
			g.DFS(i);
			System.out.println();
		}
	}
}
