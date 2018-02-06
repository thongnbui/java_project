package thong;

//Java program to print BFS traversal from a given source vertex.
//BFS(int s) traverses vertices reachable from s.
import java.util.*;

//This class represents a directed graph using adjacency list
//representation
class Graph
{
	private int V;   // No. of vertices
	private List<Integer> adj[]; //Adjacency Lists

	// Constructor
	Graph(int v)
	{
		V = v;
		adj = new ArrayList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new ArrayList<Integer>();
	}

	// Function to add an edge into the graph
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}

	/**
	 * prints BFS traversal from a given source s
	 * @param s
	 */
	void BFS(int s)
	{
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s]=true;
		queue.add(s);

		while (queue.size() != 0)
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s+" ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			for (int adjItem : adj[s])
			{
				if (!visited[adjItem])
				{
					visited[adjItem] = true;
					queue.add(adjItem);
				}
			}
		}
		System.out.println();
	}

	/**
	 * Depth-First-Search
	 * @param v
	 * @param visited
	 */
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        for (int n : adj[v])
        {
            if (!visited[n])
                DFSUtil(n, visited);
        }
		System.out.println();
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
	
	/** 
	 * 
	 * @param args
	 */
	// Driver method to
	public static void main(String args[])
	{
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 2);

		for (int i=0; i < 4; i++) {
			System.out.print("Following is Breadth First Traversal " + "(starting from vertex " + i + "): ");
			g.BFS(i);
			System.out.print("Following is Depth First Traversal " + "(starting from vertex " + i + "): ");
			g.DFS(i);

		}
	}
}
//This code is contributed by Aakash Hasija