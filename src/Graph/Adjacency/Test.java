package Graph.Adjacency;

public class Test {
    public static void main(String[] args) {
        AdjGraphClass adj = new AdjGraphClass();
        int[][] a = {{0,8,0,5,0},{0,0,3,0,0},{0,0,0,0,6},{0,0,9,0,0},{0,0,0,0,0}};
        adj.createAdjGraph(a,5,5);
        adj.dispAdjGraph();
    }
}
