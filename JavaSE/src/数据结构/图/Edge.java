package 数据结构.图;

//边结构
public class Edge {
    //边的权重
    public int weight;
    //边的起点
    public Node from;
    //边的终点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
