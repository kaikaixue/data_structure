package BTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTreeClass {
    BTNode<Character> b;
    String bstr;

    public BTreeClass() {
        this.b = null;
    }

    /**
     * 创建二叉树
     * @param str
     */
    public void createBTree(String str) {
        Stack<BTNode> st = new Stack<>();
        BTNode<Character> p = null;
        boolean flag = true;
        char ch;
        int i = 0;
        while (i < str.length()) {
            ch = str.charAt(i);
            switch (ch) {
                case '(':
                    st.push(p);
                    flag = true;
                    break;
                case ')':
                    st.pop();
                    break;
                case ',':
                    flag = false;
                    break;
                default:
                    p = new BTNode<>(ch);
                    if (b == null) {
                        b = p;
                    } else {
                        if (flag) {
                            if (! st.empty()) {
                                st.peek().lChild = p;
                            }
                        } else {
                            if (! st.empty()) {
                                st.peek().rChild = p;
                            }
                        }
                    }
                    break;
            }
            i ++;
        }
    }

    /**
     * 层次遍历
     * @param bt
     */
    public void levelOrder(BTreeClass bt) {
        BTNode<Character> p;
        Queue<BTNode> qu = new LinkedList<>();
        qu.offer(bt.b);
        while(! qu.isEmpty()) {
            p = qu.poll();
            System.out.print(p.data + " ");
            if (p.lChild != null) {
                qu.offer(p.lChild);
            }
            if (p.rChild != null) {
                qu.offer(p.rChild);
            }
        }
    }

//    public static int kCount(BTreeClass bt, int k) {
//
//    }

    /**
     * 先序遍历
     * @param bt
     */
    public void preOrder(BTreeClass bt) {
        preOrder1(bt.b);
    }

    /**
     * 先序遍历
     * @param t
     */
    private void preOrder1(BTNode<Character> t) {
        if (t != null) {
            System.out.print(t.data + "");
            preOrder1(t.lChild);
            preOrder1(t.rChild);
        }
    }

    /**
     * 中序遍历
     * @param bt
     */
    public void inOrder(BTreeClass bt) {
        inOrder1(bt.b);
    }

    /**
     * 中序遍历
     * @param t
     */
    private void inOrder1(BTNode<Character> t) {
        if (t != null) {
            inOrder1(t.lChild);
            System.out.print(t.data + " ");
            inOrder1(t.rChild);
        }
    }

    public void postOrder(BTreeClass bt) {
        postOrder1(bt.b);
    }

    private void postOrder1(BTNode<Character> t) {
        if (t != null) {
            postOrder1(t.lChild);
            postOrder1(t.rChild);
            System.out.print(t.data + " ");
        }
    }

    /**
     * 求高
     * @return
     */
    public int height() {
        return height1(b);
    }

    /**
     * 求高
     * @param t
     * @return
     */
    private int height1(BTNode<Character> t) {
        int lChildH;
        int rChildH;
        if (t == null) {
            return 0;
        } else {
            lChildH = height1(t.lChild);
            rChildH = height1(t.rChild);
            return Math.max(lChildH, rChildH) + 1;
        }
    }

    /**
     * 先序遍历求结点个数
     * @param bt
     * @return
     */
    public static int nodeCount(BTreeClass bt) {
        return nodeCount1(bt.b);
    }

    /**
     * 先序遍历求结点个数
     * @param t
     * @return
     */
    private static int nodeCount1(BTNode<Character> t) {
        int m,n,k;
        if (t == null) {
            return 0;
        }
//        if (t.rChild == null && t.lChild == null) {
//            k = 1;
//        }
        k = 1;
        m = nodeCount1(t.lChild);
        n = nodeCount1(t.rChild);
        return k + m + n;
    }

    /**
     * 先序遍历所有叶子结点
     * @param bt
     */
    public static void displeaf(BTreeClass bt) {
        displeaf1(bt.b);
    }

    /**
     * 先序遍历所有叶子结点
     * @param t
     */
    private static void displeaf1(BTNode<Character> t) {
        int k = 1;
        if (t != null) {
            displeaf1(t.lChild);
            if (t.lChild == null && t.rChild == null) {
//                System.out.print(t.data + " ");
                k ++;
            }
            displeaf1(t.lChild);
            displeaf1(t.rChild);
        }
    }


    /**
     * 求x的层次
     * @param bt
     * @param x
     * @return
     */
    public static int level(BTreeClass bt, char x) {
        return level1(bt.b, x,1);
    }


    /**
     * 求x的层次
     * @param t
     * @param x
     * @param h
     * @return
     */
    private static int level1(BTNode<Character> t, char x, int h) {
        if (t == null) {
            return 0;   // 空树不能找到该结点
        } else if (t.data == x) {
            return h;
        } else {
            int l = level1(t.lChild,x, h+1);
            if (l != 0) {
                return l;
            } else {
                return(level1(t.rChild,x,h+1));
            }
        }
    }

    /**
     * 输出
     * @return
     */
    @Override
    public String toString() {
        bstr = "";
        toString1(b);
        return bstr;
    }

    public void toString1(BTNode<Character> t) {
        if (t != null) {
            bstr += t.data;
            if (t.lChild != null || t.rChild != null) {
                bstr += '(';
                toString1(t.lChild);
                if (t.rChild != null) {
                    bstr += ',';
                }
                toString1(t.rChild);
                bstr += ')';
            }
        }
    }
}
