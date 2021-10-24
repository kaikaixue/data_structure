package PolyNode;

public class PolyNode { // 单链表结点类型
    public double conf;    // 系数
    public int exp;    // 指数
    public PolyNode next;  // 指针成员

    public PolyNode() {
        this.conf = 1;
        this.exp = 1;
        this.next = null;
    }

    public PolyNode(double conf,int exp) {
        this.conf = conf;
        this.exp = exp;
        this.next = null;
    }
}
