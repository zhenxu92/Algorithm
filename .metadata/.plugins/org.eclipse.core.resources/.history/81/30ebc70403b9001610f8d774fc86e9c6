// This class represents a Union-Find data structure with
// a function of union two sets and finding the representation
// of a set.
// @author: Zhen Xu
// UnionFind v 1.1
// This version of UnionFind class use the basic array representation
// by marking the index with its parent index in an array. Union-by-size
// optimization is implemented by specifying the weight of the representation.
import java.util.*;
public class UnionFind {
    private int[] parent;   // parent array
    
    // construct a parent array with size n,
    // n specify the total number of subset
    public UnionFind(int n) {
        parent = new int[n];
        // initialize an array filled with -1
        Arrays.fill(parent, -1);
    }
    
    // Union two subset
    public void union(int a, int b) {
        // a has a larger weight
        if(parent[find(a)] < parent[find(b)]) {
            int weight = parent[b];
            parent[b] = a;
            parent[find(a)] += weight;
        } else {
        // b has a larger weight
            int weight = parent[a];
            parent[a] = b;
            parent[find(b)] += weight;
        }
    }
    
    // find the parent of an index
    public int find(int index) {
        int parent = index;
        while(this.parent[parent] >= 0) {
            parent = this.parent[parent];
        }
        return parent;
    }
    
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }   
}
