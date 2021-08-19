package 数据结构.图;

/*
将某种图的表示形式转换成我们熟悉的图的结构
 */

//转换器
public class GraphGenerator {
    /*将下面的图的描述转化成自己熟悉的图的描述
    matrix {权重，from，to}
    |{权重，from，to}|
    |{权重，from，to}|
    |{权重，from，to}|
    |{权重，from，to}|
     */

    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }


}
