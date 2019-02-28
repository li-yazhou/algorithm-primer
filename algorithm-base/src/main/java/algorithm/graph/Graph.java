package algorithm.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lah on 2017/4/8.
 *
 */

/**
 * 图的顶点编号是 0 到 vertexNum-1
 */
public class Graph {
    private int vertexNum;  // 顶点数目
    private int edgeNum;   // 边的数目
    private List<Integer>[] adj;  // 顶点的邻接表

    public Graph(int vertexNum){
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        // this.adj = (List<Integer>[]) new LinkedList<Integer>()[vertexNum];
        // this.adj = new LinkedList[vertexNum];
        this.adj = (List<Integer>[]) new LinkedList[vertexNum];  // 创建邻接表
        for (int i = 0; i < vertexNum; i++){
            this.adj[i] = new LinkedList<Integer>();  // 将所有邻接链表初始为空
        }
    }

    public int getVertexNum(){
        return this.vertexNum;
    }

    public int getEdgeNum(){
        return this.edgeNum;
    }

    public void addEdge(int v, int w){
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.edgeNum += 1;
    }

    public Iterable<Integer> getAdj(int v){
        return this.adj[v];
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        for (int v = 0; v < this.vertexNum; v++){
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(v).append(" : ");
            for (int adjVertex : this.getAdj(v))
                sBuilder.append(adjVertex).append("-");
            string.append(sBuilder).append("\r\n");
        }
        return string.toString();
    }

    public static void main(String[] args){
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        System.out.println("vertexNum = " + graph.getVertexNum());
        System.out.println("edgeNum = " + graph.getEdgeNum());
        System.out.println("邻接表：");
        System.out.println(graph.toString());

    }
}
