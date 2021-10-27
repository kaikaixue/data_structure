package LinkNode;

public class LinkTools {
    /**
     * 逆置
     */
    public static void reverse(LinkListClass<Integer> L) {
        LinkNode<Integer> p = L.head.next;
        LinkNode<Integer> q;
        L.head.next = null;
        while (p != null) {
            q = p.next;
            p.next = L.head.next;
            L.head.next = p;
            p = q;
        }
    }

    /**
     * 归并
     */
    public static LinkListClass<Integer> merge2(LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkNode<Integer> p = A.head.next;
        LinkNode<Integer> q = B.head.next;
        LinkListClass<Integer> C = new LinkListClass<Integer>();
        LinkNode<Integer> t = C.head;
        while (p != null && q != null) {
            if (p.data < q.data) {
                t.next = p;
                t = p;
                p = p.next;
            } else {
                t.next = q;
                t = q;
                q = q.next;
            }
        }
        t.next = null;
        if (p != null) {
            t.next = p;
        }
        if (t != null) {
            t.next = q;
        }
        return C;
    }

    /**
     *归并(重复的只插入一次)
     */
    public static LinkListClass<Integer> merge3(LinkListClass<Integer> A,LinkListClass<Integer> B) {
        LinkNode<Integer> p = A.head.next;
        LinkNode<Integer> q = B.head.next;
        LinkListClass<Integer> C = new LinkListClass<Integer>();
        LinkNode<Integer> t = C.head;
        while (p != null && q != null) {
            if(p.data < q.data) {
                t.next = p;
                t = p;
                p = p.next;
            } else if(p.data > q.data) {
                t.next = q;
                t = q;
                q = q.next;
            } else {
                t.next = p;
                t = p;
                p = p.next;
                q = q.next;
            }
        }
        return C;
    }

    /**
     * 归并相同元素
     */
    public static LinkListClass<Integer> commnodes(LinkListClass<Integer> A,LinkListClass<Integer> B) {
        LinkListClass<Integer> C = new LinkListClass<Integer>();
        LinkNode<Integer> p = A.head.next;
        LinkNode<Integer> q = B.head.next;
        LinkNode<Integer> t = C.head;
        while (p != null && q != null) {
            if (p.data == q.data) {
                t.next = p;
                t = p;
                p = p.next;
                q = q.next;
            } else if (p.data < q.data){
                p = p.next;
            } else {
                q = q.next;
            }
        }
        t.next = null;
        return C;
    }

    /**
     * 插入
     */
    public static void merge1(LinkListClass<Integer> A,LinkListClass<Integer> B) {
        LinkNode<Integer> p = A.head.next;
        LinkNode<Integer> q = B.head.next;
        LinkNode<Integer> t = B.head.next;
        int count = 0;
        while (q != null) {
            while(p != null) {
                if (q.data < p.data) {
                    t = q.next;
                    A.insert(count,q.data);
//                    q.next = p.next;
//                    p.next = q;
                    break;
                }
                p = p.next;
                count ++;
            }
            count = 0;
            p = A.head.next;
            q = t;
        }
    }

    public static int sum(LinkNode<Integer> p) {
        if (p == null)
            return 0;
        else {
            if (p.data == null) {
                return (0 + p.data);
            } else {
                return (p.data + sum(p.next));
            }
        }
    }

    public static int Min(int[] a, int i) {
        if (i == 0)            // 递归出口
            return a[0];
        else                // 递归体
        {
            int min = Min(a, i - 1);
            if (min > a[i]) return (a[i]);
            else return min;
        }
    }

    public static void delDuplicate(LinkListClass<Integer> a) {
        LinkNode<Integer> pre = a.head;
        LinkNode<Integer> cur = a.head.next;
        LinkNode<Integer> next;
        boolean flag = false;

        while (cur != null) {
            flag = false;
            next = cur.next;
            while (next.data == cur.data && next != null) {
                pre.next = next;
                cur = next;
                next = cur.next;
                flag = true;
            }
            if (flag) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
    }
}
