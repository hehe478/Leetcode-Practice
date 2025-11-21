package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    private final ArrayList<ArrayList<Edge>> adjacencyList;
    private final int V;

    public Graph(int v){
        this.V = v;
        adjacencyList = new ArrayList<>(v);
        for(int i = 0; i < v; i++){
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int weight, boolean directed){
        adjacencyList.get(from).add(new Edge(to,weight));
        if(!directed) adjacencyList.get(to).add(new Edge(from,weight));
    }

    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.print("Node" + i + " connected to:");
            for(Edge edge : adjacencyList.get(i)){
                System.out.print("[" + edge.to + ",w=" + edge.weight + "]");
            }
            System.out.println();
        }
    }

    public int getV(){
        return V;
    }

    public List<Edge> getNeighbors(int from){
        return adjacencyList.get(from);
    }

    public void bfs(int startNode){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        visited[startNode] = true;

        System.out.println("BFS Starting From:" + startNode);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr + " ");
            for(Edge edge : adjacencyList.get(curr)){
                int neighbor = edge.to;
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startNode){
        boolean[] visited = new boolean[V];
        System.out.println("DFS Starting From" + startNode);
        dfsRecursive(startNode,visited);
        System.out.println();
    }
    private void dfsRecursive(int curr, boolean[] visited){
        System.out.print(curr + " ");
        visited[curr] = true;
        for(Edge edge : adjacencyList.get(curr)){
            int neighbor = edge.to;
            if(!visited[neighbor]) dfsRecursive(neighbor,visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        // 构建上面的图 (无向)
        g.addEdge(0, 1, 1, false);
        g.addEdge(0, 2, 1, false);
        g.addEdge(1, 3, 1, false);
        g.addEdge(2, 3, 1, false);
        g.addEdge(2, 4, 1, false);

        System.out.println("Graph Structure:");
        g.printGraph();
        System.out.println("----------------");

        // 预期 BFS (从0开始): 0 -> 1, 2 -> 3, 4
        // 解释: 0的邻居是1和2(第一层)，然后才是1和2的邻居3和4(第二层)
        g.bfs(0);

        // 预期 DFS (从0开始): 0 -> 1 -> 3 -> 2 -> 4 (这只是一种可能，取决于邻接表的顺序)
        // 解释: 0走到1，1走到3，3走到2，2走到4... 一条龙走到底
        g.dfs(0);
    }
}
