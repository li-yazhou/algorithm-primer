package algorithm.graph;

/**
 * Created by lah on 2017/4/9.
 *
 */

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int startVertex){
        marked = new boolean[graph.getVertexNum()];
        dfs(graph, startVertex);
    }

    private void dfs(Graph graph, int vertex){
        marked[vertex] = true;  // 将该点标记为已被访问过
        System.out.print(vertex + "-");
        count++;  // 统计已经访问过的节点个数
        for (int adjVertex : graph.getAdj(vertex)) // 遍历当前节点的邻居节点
            if (!marked[adjVertex]) {  // 如果该节点没有被访问过，则递归访问它
                dfs(graph, adjVertex);
            }
    }

    public boolean marked(int vertex){ return marked[vertex]; }

    public int getCount(){ return count; }


    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        // graph.addEdge(2,3);
        graph.addEdge(3,4);
        System.out.println("the procedure of accessing vertex: ");
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        System.out.println();
        for (int i = 0; i < graph.getVertexNum(); i++){
            System.out.println("vertex " + i + " isMarked = " + dfs.marked(i));
        }
        System.out.println("sum of visited vertex = " + dfs.getCount());
    }
}
