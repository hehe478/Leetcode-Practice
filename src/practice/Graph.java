package practice;

import java.util.*;

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

    public void topologicalSort(){
        int[] inDegree = new int[V];
        for(int u = 0; u < V; u++){
            for(Edge edge : adjacencyList.get(u)){
                inDegree[edge.to]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int u = queue.poll();
            result.add(u);
            for(Edge edge : adjacencyList.get(u)){
                int v = edge.to;
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        if(result.size() == V){
            System.out.print("不存在环");
        }else{
            System.out.print("存在环");
        }
    }

    public void dijkstra(int start){
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        class State implements Comparable<State>{
            int id;
            int distFromStart;

            public State(int id, int distFromStart){
                this.id = id;
                this.distFromStart = distFromStart;
            }

            public int compareTo(State other){
                return this.distFromStart - other.distFromStart;
            }
        }
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(start,0));

        boolean[] visited = new boolean[V];
        while(!pq.isEmpty()){
            State currState = pq.poll();
            int u = currState.id;
            if(visited[u]) continue;
            visited[u] = true;

            for(Edge edge : adjacencyList.get(u)){
                int v = edge.to;
                if(dist[v] > dist[u] + edge.weight){
                    dist[v] = dist[u] + edge.weight;
                    pq.offer(new State(v,dist[v]));
                }
            }
        }
        System.out.println("Dijkstra Shortest Path from Node " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To Node " + i + " -> " +
                    (dist[i] == Integer.MAX_VALUE ? "Unreachable" : dist[i]));
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

        Graph g1 = new Graph(6);

        // 注意：这里一定要设为 true (有向图)
        // addEdge(from, to, weight, directed)

        g1.addEdge(0, 1, 1, true); // 内裤 -> 裤子
        g1.addEdge(1, 3, 1, true); // 裤子 -> 鞋子
        g1.addEdge(2, 3, 1, true); // 袜子 -> 鞋子
        g1.addEdge(4, 5, 1, true); // 衬衫 -> 外套

        // 袜子(2)和衬衫(4)没有依赖，内裤(0)也没有依赖

        System.out.println("Running Topological Sort:");
        g1.topologicalSort();

        Graph g2 = new Graph(4);

        // 注意：这里是有向图 (directed = true)
        g2.addEdge(0, 1, 10, true);
        g2.addEdge(0, 2, 20, true);
        g2.addEdge(1, 3, 50, true); // 1到3 很远
        g2.addEdge(2, 1, 10, true); // 2还能绕回1
        g2.addEdge(2, 3, 5, true);  // 2到3 很近

        System.out.println("\nRunning Dijkstra...");
        g2.dijkstra(0);
    }
}
