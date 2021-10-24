package PolyNode;

public class PolyClass {    // 多项式单链表类
    PolyNode head;  // 头结点

    public PolyClass() {
        this.head = new PolyNode(); // 建立头结点
    }

    // 创建多项式单链表
    public void createPoly(double a[],int b[],int n) {
        PolyNode s;
        PolyNode t = head;  // 始终指向尾结点
        for(int i = 0;i < n;i++) {  // 尾插法
            s = new PolyNode(a[i],b[i]);
            t.next = s;
            t = s;
        }
        t.next = null;
    }

    // 排序
    public void sort() {
        PolyNode p,pre,q;
        q = head.next;  // q指向开始结点
        if (q == null) {
            return; // 原单链表为空返回
        }
        p = head.next.next; // p指向q的后继结点
        if (p == null) {
            return; // 原单链表只有一个数据返回
        }
        q.next = null;  // 构造一个只有一个数据结点的链表
        while(p != null) {
            q = p.next; // q临时保存p结点后继结点
            pre = head; // pre从头结点开头
            while(pre.next != null && pre.next.exp > p.exp) {
                pre = pre.next; // 找到插入位置
            }
            p.next = pre.next;
            pre.next = p;   // pre后面插入p
            p = q;
        }
    }

    // 输出多项式单链表
    public void dispPloy() {
        boolean first = true;   // first为true表示是第一项
        PolyNode p = head.next;
        while(p != null) {
            if(first) {
                first = false;
            } else if(p.conf > 0) {
                System.out.print("+");
            }
            if(p.exp == 0) {
                System.out.print(p.conf);
            } else if (p.exp == 1) {
                System.out.print(p.conf + "x");
            } else {
                System.out.print(p.conf + "x" + p.exp);
            }
            p = p.next;
        }
        System.out.println();
    }

    // 加法
    public static PolyClass add(PolyClass l1,PolyClass l2) {
        PolyNode p,q,s,t;   // p控制l1,q控制l2,s控制中间变量结点,t控制l3
        PolyClass l3 = new PolyClass();
        t = l3.head;
        p = l1.head.next;
        q = l2.head.next;
        while(p != null && q != null) {
            if(p.exp > q.exp) {
                s = p;
                t.next = s;
                t = s;
                p = p.next;
            } else if (q.exp > p.exp) {
                s = q;
                t.next = s;
                t = s;
                q = q.next;
            } else {
                if ((p.conf + q.conf) != 0) {
                    s = new PolyNode(p.conf + q.conf,p.exp);
                    t.next = s;
                    t = s;
                }
                p = p.next;
                q = q.next;
            }
        }
        t.next = null;
        if (p != null) {
            t.next = p;
        }
        if (q != null) {
            t.next = q;
        }
        return l3;
    }
}
