package BTree;

import java.util.Stack;

public class BTreeClass {
    BTNode<Character> b;
    String bstr;

    public BTreeClass() {
        this.b = null;
    }

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
