package 数据结构.图;

import java.util.ArrayList;

public class Node {
    //节点编号
    public int id;
    //入度，直接和节点相连的入边
    public int in;
    //出度，直接和节点相连的出边
    public int out;
    //直接邻居，由该节点出发，能够直接到达的节点
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public Node(int id) {
        this.id = id;in = 0;
        out = 0;
        nexts = new ArrayList<>();edges = new ArrayList<>();
    }
}
