package Stack.LinkStack;

public class LinkStackClass <E>{
    LinkNode<E> head;

    public LinkStackClass() {
        head = new LinkNode<>();
        head.next = null;
    }

    public boolean empty() {
        return head.next == null;
    }

    public void push(E e) {
        LinkNode<E> s = new LinkNode<>(e);
        s.next = head.next;
        head.next = s;
    }

    public E pop() throws Exception{
        if (empty()) {
           throw new Exception("栈空");
        }
        E e = head.next.data;
        head.next = head.next.next;
        return e;
    }

    public E peek() throws Exception{
        if (empty()) {
            throw new Exception("栈空");
        }
        return (E)head.next.next;
    }
}
