public class UnionFind {

    private int[] parent;  // parent[i] = parent of i
    
    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int index) {
        int pt = index;
        while(parent[pt] != pt) {
            pt = parent[pt];   
        }
        return pt;
    }
    
    public void union(int a, int b) {
        parent[b] = a;
    }
    
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}