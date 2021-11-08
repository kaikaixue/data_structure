package Huffman;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanClass { // 哈夫曼树类
    final int MAXN = 100;   // 最多结点个数
    double[] w; // 权值数组
    String str; // 存放字符串
    int n0; // 权值个数
    HTNode[] ht;    // 存放哈夫曼树
    String[] hcd;   // 存放哈夫曼编码

    /**
     * 构造
     */
    public HuffmanClass() {
        ht = new HTNode[MAXN];
        hcd = new String[MAXN];
        w = new double[MAXN];
    }

    /**
     * 设置初始值
     * @param n0
     * @param w
     * @param str
     */
    public void setData(int n0, double[] w, String str) {   // 设置初始值
        this.n0 = n0;
        for (int i = 0; i < n0; i++) {
            this.w[i] = w[i];
        }
        this.str = str;
    }

    /**
     * 构造哈夫曼树
     */
    public void createHT() {
        Comparator<HTNode> priComparator = new Comparator<HTNode>() {
            @Override
            public int compare(HTNode o1, HTNode o2) {
                return (int)(o1.getWeight() - o2.getWeight());
            }
        };   // 定义 priComparator
        PriorityQueue<HTNode> pq = new PriorityQueue<>(MAXN, priComparator);    // 定义优先队列
        for (int i = 0; i < n0; i++) {  // 建立n0个叶子结点进队
            ht[i] = new HTNode();   // 建立 ht[i]结点
            ht[i].parent = null;    // 双亲设置为空
            ht[i].data = str.charAt(i);
            ht[i].weight = w[i];
            pq.offer(ht[i]);    // 进队
        }
        for (int i = n0; i < (2 * n0 - 1); i++) {   // n0-1次合并操作
            HTNode p1 = pq.poll();  // 出队两个权值最小的结点p1和p2
            HTNode p2 = pq.poll();
            ht[i] = new HTNode();   // 建立ht[i]结点
            p1.parent = ht[i];  // 建立p1和p2的双亲为ht[i]
            p2.parent = ht[i];
            ht[i].weight = p1.weight + p2.weight;   // 求权值和
            ht[i].lChild = p1;  // p1作为双亲ht[i]的左孩子
            p1.flag = true;
            ht[i].rChild = p2;  // p2作为双亲ht[i]的右孩子
            p2.flag = false;
            pq.offer(ht[i]);    // ht[i]结点进队
        }
    }
}
