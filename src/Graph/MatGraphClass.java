package Graph;

public class MatGraphClass {
    final int MAXV = 100;   // 图邻接矩阵类
    final int INF = 0x3f3f3f3f; // 表示最多顶点个数
    int[][] edges;  // 表示
    int n,e;    // 顶点数和边数
    String[] vexs;  // 存放顶点信息

    public MatGraphClass() {
        edges = new int[MAXV][MAXV];
        vexs = new String[MAXV];
    }

    public void createMatGraph(int[][] a, int n, int e) {   // 建立图的邻接矩阵
        this.n = n;
        this.e = e;
        for (int i = 0; i<n; i++) {
            edges[i] = new int[n];
            for (int j = 0; j < n; j++) {
                edges[i][j] = a[i][j];
            }
        }
    }

    public void dispMatGraph() {
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (edges[i][j] == INF) {
                   System.out.printf("%4s","∞");
               } else {
                   System.out.printf("%5d", edges[i][j]);
               }
               System.out.println();
           }
       }
    }

    /**
     * 无向图的图
     * @param g
     * @param v
     * @return
     */
    public static int degree(MatGraphClass g, int v) {
        int d = 0;
        for (int j = 0; j < g.n; j ++) {
            if (g.edges[v][j] != 0 && g.edges[v][j] != g.INF) {
                d ++;
            }
        }
        return d;
    }

    public static int[] Degree1(MatGraphClass g, int v) {
        int[] ans = new int[2];
        ans[0] = 0; // 累计出度
        for (int j = 0; j < g.n; j++) {
            if (g.edges[v][j] != 0 && g.edges[v][j] != g.INF) {
                ans[0]++;
            }
        }
        ans[1] = 0;
        for (int i = 0; i < g.n; i++) {
            if (g.edges[i][v] != 0 && g.edges[i][v] != g.INF) {
                ans[1] ++;
            }
        }
        return ans;
    }
}
