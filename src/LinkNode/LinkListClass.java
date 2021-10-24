package LinkNode;

public class LinkListClass<E> {     // 单链表泛型类
    LinkNode<E> head;   // 存放头结点

    // 构造方法
    public LinkListClass() {
        this.head = new LinkNode<E>();  // 创建头节点
        head.next = null;   // 头结点的next设为null
    }

    /**
     * 头插法
     *
     * 因为一直都是往head之后的第一个结点插入，所以最后的次序会与数组a中的次序相反
     */
    public void createListF(E[] a) {
        LinkNode<E> s;
        for(int i = 0;i < a.length;i++) {   // 循环建立数据结点s
            s = new LinkNode<E>(a[i]);  // 实例化s，存放a[i]的元素结点s
            s.next = head.next; // 将现插入的结点s的下一个元素指向原结点head指向的下一个元素
            head.next = s;  // 将原节点指向现插入结点s
        }
    }

    /**
     * 尾插法
     *
     * 因为默认当前结点永远为尾结点，所以最后次序与数组a中的次序相同
     */
    public void createListR(E[] a) {
        LinkNode<E> s;
        LinkNode<E> t;  // 建立尾结点t，始终指向尾结点
        t = head;   // 开始是t指向头结点
        for(int i = 0;i < a.length;i++) {
            s = new LinkNode<E>(a[i]);
            t.next = s; // 先将t的下个结点指向s，实现插入s
            t = s;  // 再将t指向当前尾结点s
        }
        t.next = null;  // 将尾结点的next设为null
    }

    /**
     * getI()
     *
     * 返回序号为i的结点
     */
    public LinkNode<E> getI(int i) {
        LinkNode<E> p = head;   // 创建一个结点p来返回最终需要的结点
        int j = -1; // 定义j来控制查找
        while (j < i) {
            p = p.next; // 指针向后移
            j++;
        }
        return p;
    }

    /**
     * add()
     *
     * 将线性表的元素添加到末尾
     */
    public void add(E e) {
        LinkNode<E> s = new LinkNode<E>(e);  // 新建结点s
        LinkNode<E> p = head;
        while (p.next != null) {    // 查找尾结点
            p = p.next;
        }
        p.next = s; // 在尾结点之后插入s
    }

    /**
     * size()
     *
     * 求线性表的长度
     */
    public int size() {
        LinkNode<E> p = head;
        int count = 0;
        while (p.next != null) {
            p = p.next;
            count ++;
        }
        return count;
    }

    /**
     * setSize()
     *
     * 用于缩小线性表的长度
     */
    public void setSize(int len) {
        if (len < 0 || len > this.size()) {
            throw new IllegalArgumentException("Out of Index");
        }
        if (len == this.size()) {
            return;
        }
        LinkNode<E> p = getI(len - 1);  // 找到序号len-1的结点
        p.next = null;  // 将它的下个结点设为null
    }

    /**
     * getElem()
     *
     * 返回线性表序号为i的元素
     */
    public E getElem(int i) {
        if (i < 0 || i > this.size() - 1) {
            throw new IllegalArgumentException("Out of Index");
        }
        LinkNode<E> p = this.getI(i);   // 找到序号为i的结点
        return p.data;
    }

    /**
     * setElem()
     *
     * 设置序号为i的元素
     */
    public void setElem(int i,E e) {
        if (i < 0 || i > this.size() - 1) {
            throw new IllegalArgumentException("Out of Index");
        }
        LinkNode<E> p = this.getI(i);   // 找到序号为i的结点
        p.data = e;
    }

    /**
     * getNo()
     *
     * 求线性表中第一个值为e的元素的逻辑序号
     */
    public int getNo(E e) {
        int j = 0;
        LinkNode<E> p = head.next;
        while(p != null && !p.data.equals(e)) {
            j++;
            p = p.next;
        }
        if (p == null) {
            return -1;
        } else {
            return j;
        }
    }

    /**
     * swap()
     *
     * 交换序号i和j的元素
     */
    public void swap(int i,int j) {
        LinkNode<E> p = this.getI(i);
        LinkNode<E> q = this.getI(j);
        E temp = p.data;
        p.data = q.data;
        q.data = temp;
    }

    /**
     * insert()
     *
     * 插入e作为第i个元素
     */
    public void insert(int i,E e) {
        if (i < 0 || i > this.size()) {
            throw new IllegalArgumentException("Out of Index");
        }
        LinkNode<E> p = this.getI(i - 1);   // 找到要插入位置的前一个结点
        LinkNode<E> s = new LinkNode<E>(e); // 为插入元素定义新结点
        s.next = p.next;
        p.next = s;
    }

    /**
     * delete()
     *
     * 删除第i个元素
     */
    public void delete(int i) {
        if (i < 0 || i > this.size() - 1) {
            throw new IllegalArgumentException("Out of Index");
        }
        LinkNode<E> p = this.getI(i - 1);   // 找到要删除位置的前一个结点
        p.next = p.next.next;   // 跳过删除位置的结点，直接指向删除位置的下一个结点，达到删除效果
    }

    /**
     * @Override
     * toString()
     *
     * 将线性表转换为字符串
     */
    @Override
    public String toString() {
        String str = "";
        LinkNode<E> p = head.next;
        while(p != null) {
            str += p.data + " ";
            p = p.next;
        }
        return str;
    }
}
