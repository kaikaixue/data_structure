package LinkString;

public class LinkStringClass {
    LinkNode head;
    int size;

    public LinkStringClass() {
        this.head = new LinkNode();
        this.size = 0;
    }

    public void createListR(String a) {
        this.size = a.length();
        LinkNode s;
        LinkNode t;  // 建立尾结点t，始终指向尾结点
        t = head;   // 开始是t指向头结点
        for(int i = 0;i < a.length();i++) {
            s = new LinkNode(a.charAt(i));
            t.next = s; // 先将t的下个结点指向s，实现插入s
            t = s;  // 再将t指向当前尾结点s
        }
        t.next = null;  // 将尾结点的next设为null
    }

    public LinkStringClass insStr(int i, LinkStringClass t) {
        LinkStringClass s = new LinkStringClass();
        if (i < 0 || i > size) {
            return s;
        }
        LinkNode p = head.next;
        LinkNode p1 = t.head.next;
        LinkNode q,r;
        r = s.head;
        for (int k = 0; k < i; k++) {
            q = new LinkNode(p.data);
            r.next = q;
            r = q;
            p = p.next;
        }
        while (p1 != null) {
            q = new LinkNode(p1.data);
            r.next = q;
            r = q;
            p1 = p1.next;
        }
        while (p != null) {
            q = new LinkNode(p.data);
            r.next = q;
            r = q;
            p = p.next;
        }
        s.size = this.size + t.size;
        r.next = null;
        return s;
    }

    @Override
    public String toString() {
        String str = "";
        LinkNode p = head.next;
        while (p != null) {
            str += p.data;
            p = p.next;
        }
        return str;
    }
}
