package Graph.Adjacency;

public class AdjGraphClass {
    final int MAXV = 100;   // 表示最多顶点个数
    final int INF = 0x3f3f3f3f; // 表示无穷
    VNode[] adjList;    // 邻接表头数组
    int n,e;    // 图中的顶点数和边数

    public AdjGraphClass() {
        adjList = new VNode[MAXV];
        for (int i = 0; i < MAXV; i++) {
            adjList[i] = new VNode();
        }
    }

    public void createAdjGraph(int[][] a, int n, int e) {
        this.n = n;
        this.e = e;
        ArcNode p;
        for (int i = 0; i < n; i++) {   // 将邻接表中所有头结点的指针置初值
            adjList[i].firstArc = null;
        }
        for (int i = 0;i < n; i ++) {   // 检查边数组a中的每个元素
            for (int j = n - 1; j >= 0; j--) {
                if (a[i][j] != 0 && a[i][j] != INF) {
                    p = new ArcNode();
                    p.adjvex = j;
                    p.weight = a[i][j];
                    p.nextarc = adjList[i].firstArc;    // 采用头插法
                    adjList[i].firstArc = p;
                }
            }
        }
    }

    public void dispAdjGraph() {    // 输出图的邻接表
        ArcNode p;
        for (int i = 0; i < n; i++) {
            System.out.printf("  [%d]", i);
            p = adjList[i].firstArc;    // p指向第一个邻接点
            while (p != null) {
                System.out.printf("->(%d,%d)", p.adjvex,p.weight);
                p = p.nextarc;  // p移向下一个邻接点
            }
            System.out.println("->^");
        }
    }
}
