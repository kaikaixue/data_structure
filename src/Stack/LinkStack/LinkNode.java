package Stack.LinkStack;

public class LinkNode<E> {
    E data;
    LinkNode<E> next;

    public LinkNode() {
        next = null;
    }

    public LinkNode(E data) {
        this.data = data;
        next = null;
    }
}
