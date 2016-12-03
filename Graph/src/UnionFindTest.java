public class UnionFindTest {
    public static void main(String args[]) {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 3);
        uf.union(3, 4);
        uf.union(5, 1);
        uf.union(7, 8);
        System.out.println("The representation of 4 is " + uf.find(4));
        System.out.println("The representation of 5 is " + uf.find(5));
        System.out.println("The weight of 3 is " + uf.find(3));
        System.out.println(uf.connected(1, 7));
        
    }
}
// test ver1.1 of unionfind