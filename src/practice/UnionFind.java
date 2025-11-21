package practice;

public class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int count;

    public UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        count = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i){
        if(parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
    public void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);

        if(rootI == rootJ) return;
        if(rank[i] > rank[j]) parent[rootJ] = rootI;
        else if (rank[j] > rank[i]) parent[rootI] = rootJ;
        else {
            parent[rootI] = rootJ;
            rank[rootJ]++;
        }
        count--;
    }

    public boolean isConnected(int i, int j){
        return find(i) == find(j);
    }

    public int count(){
        return count;
    }
}
