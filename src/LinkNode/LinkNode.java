package LinkNode;

public class LinkNode<E> {  // 单链表结点泛型类
    public E data; // 存储元素的数据成员
    public LinkNode<E> next;   // 存储后继节点的指针成员

    // 无参构造
    public LinkNode() {
        this.next = null;
    }

    // 带参构造
    public LinkNode(E data) {
        this.data = data;
        this.next = null;
    }
}
