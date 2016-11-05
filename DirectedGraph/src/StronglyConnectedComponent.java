/**
 * This program finds out the strongly connected components in a 
 * directed graph.
 * @author zhenxu
 *
 */

import java.util.*;

public class StronglyConnectedComponent {
	// data field
	int length;
	boolean visited[];
	DirectedGraphCreater g;
	List<Integer> order;
	
	
	// Constructor
	public StronglyConnectedComponent(DirectedGraphCreater g) {
		length = g.length();
		visited = new boolean[length];
		this.g = g;
		order = new ArrayList<Integer>();
	}
	
	public void dfs(int[][] graph, boolean[] visited, List<Integer> order, int u) {
		visited[u] = true;
		// graph[u].length can be replaced by length
		for(int i = 0; i < graph[u].length; i++) {
			if(graph[u][i] == 1) {
				if(!visited[i]) {
					dfs(g.returnGraph(), visited, order, i);
				}
			}
		}
		order.add(u);
	}
	
	public List<List<Integer>> find() {
		
		// first DFS
		for(int i = 0; i < length; i++) {
			if(!visited[i]) {
				this.dfs(g.returnGraph(), visited, order, i);
			}
		}
		
		// re-initialize
		List<List<Integer>> components = new ArrayList<List<Integer>>();
		Arrays.fill(visited, false);
		Collections.reverse(order);
		
		// second DFS
		for(int i : order) {
			if(!visited[i]) {
				List<Integer> component = new ArrayList<Integer>();
				this.dfs(g.transpose(), visited, component, i);
				components.add(component);
			}
		}
		components.remove(components.size() - 1);
		return components;
		
	}
}