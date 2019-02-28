package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lah on 2017/4/9.
 *
 */
public class BreadthFirstPaths {
    private boolean[] marked;  // 到达该顶点的最短路径已知吗
    private int[] edgeTo;  // 到达该顶点的已知路径上的最后一个顶点（父节点）
    private final int source;  // 起点


    public BreadthFirstPaths(Graph graph, int source){
        marked = new boolean[graph.getVertexNum()];
        edgeTo = new int[graph.getVertexNum()];
        this.source = source;
        bfs(graph, source);
    }


    /**
     * 广度优先搜索，记录各个点的父节点
     * @param graph 图
     * @param source 起点
     */
    public void bfs(Graph graph, int source){
        Queue<Integer> queue = new LinkedList<Integer>();
        marked[source] = true;
        queue.offer(source);  // 将起点添加到队列末尾，初始化队列
        while(!queue.isEmpty()){
            int vertex = queue.poll(); // 返回并删除
            for (int adjVertex : graph.getAdj(vertex)){  // 当前节点的所有邻居节点
                if (!marked[adjVertex]){   // 对于没有标记的相邻节点
                    marked[adjVertex] = true;  // 已经得到该点的最短路径
                    edgeTo[adjVertex] = vertex;  // 保存最短路径的最后一条边（当前节点的父节点）
                    queue.offer(adjVertex);  // 将当前点添加到队列末尾
                }
            }
        }
    }


    public boolean hasPathTo(int vertex){ return marked[vertex]; }


    /**
     * 返回 source 到 vertex 的最短路径
     * @param vertex 顶点
     * @return source 到 vertex的最短路径
     */
    public Iterable<Integer> pathTo(int vertex){
        if (!hasPathTo(vertex)) return null;
        LinkedList<Integer> stackPath = new LinkedList<Integer>();
        for (int parent = vertex; parent != source; parent = edgeTo[parent])
            stackPath.push(parent);  // 入栈，出栈是 pop()
        stackPath.push(source);
        return stackPath;
    }


    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        Iterable<Integer> path =  bfp.pathTo(5);
        System.out.println("hasPathTo(5) = " + bfp.hasPathTo(5));
        System.out.print("shortest path of 0 to 5 is: ");
        for(int ele : path) System.out.print(ele + "-");
    }
}
