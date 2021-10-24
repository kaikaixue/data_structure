package LinkString;

public class LinkNode {
    char data;  // 存放一个字符
    LinkNode next;

    public LinkNode() {
        this.next = null;
    }

    public LinkNode(char ch) {
        data = ch;
        next = null;
    }
}
