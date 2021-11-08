package Huffman;

public class HTNode {   // 哈夫曼树的节点类
    char data;  // 结点值，假设为单个字符
    double weight;  // 权值
    public HTNode parent;   // 双亲结点
    HTNode lChild;  // 左孩子结点
    HTNode rChild;  // 右孩子结点
    boolean flag;   // 标识是双亲的左还是右孩子

    /**
     * 构造
     */
    public HTNode() {
        parent = null;
        lChild = null;
        rChild = null;
    }


    /**
     * 返回结点的权值
     * @return
     */
    public double getWeight() {
        return this.weight;
    }
}
