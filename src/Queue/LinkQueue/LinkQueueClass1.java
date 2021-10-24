package Queue.LinkQueue;

import LinkNode.LinkNode;

public class LinkQueueClass1 <E> {
    LinkNode<E> rear;

    public LinkQueueClass1() {
        rear = null;
    }

    public boolean empty() {
        return rear == null;
    }

    public void push(E e) {
        LinkNode<E> s = new LinkNode<E>(e);
        if (rear == null) {
            s.next = s;
            rear = s;
        } else {
            s.next = rear.next; // 将s结点插入到rear结点之后
            rear.next = s;
            rear = s;   // 让rear指向s结点
        }
    }

    public E pop() throws Exception {
        E e;
        if (empty()) {
            throw new Exception("队空");
        }
        if (rear.next == rear) {    // 原链队只有一个结点
            e = (E)rear.next.data;
            rear = null;
        } else {
            e = (E)rear.next.data;  // 取队头结点
            rear.next = rear.next.next;
        }
        return e;
    }

    public E peek() throws Exception{
        E e;
        if (empty()) {
            throw new Exception("队空");
        }
        if (rear.next == rear) {
            e = rear.data;
        } else {
            e = rear.next.data;
        }
        return e;
    }
}
