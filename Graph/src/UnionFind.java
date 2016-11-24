// This class represents a Union-Find data structure with
// a function of union two sets and finding the representation
// of a set.
// @author: Zhen Xu
// UnionFind v 1.0
// This version of UnionFind class use the basic array representation
// by marking the index with its parent index in an array. No optimization
// is implemented

public class UnionFind {
    private int[] parent;   // parent array
    
    // construct a parent array with size n,
    // n specify the total number of subset
    public UnionFind(int n) {
        parent = new int[n];
    }
    
    // Union two subset
    public void union(int a, int b) {
        parent[b] = a;
    }
    
    // find the parent of an index
    public int find(int index) {
        int parent = index;
        while(this.parent[parent] !=0) {
            parent = this.parent[parent];
        }
        return parent;
    }
    
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }   
}

