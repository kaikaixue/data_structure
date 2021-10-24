package Queue;

public class SqQueueClass <E> {
    final int MAXSIZE = 100;    // 初始容量
    private E[] data;
    private int front,rear;

    public SqQueueClass() {
        data = (E[])new Object[MAXSIZE];
        this.front = -1;
        this.rear = -1;
    }

    public boolean empty() {
        return front == rear;
    }

    public void push(E e) {
        if (rear == MAXSIZE - 1) {
            throw new IllegalArgumentException("Out of Index");
        }
        rear = (rear + 1) % MAXSIZE;
        data[rear] = e;
    }

    public E pop() {
        if (this.empty()) {
            throw new IllegalArgumentException("Out of Index");
        }
        front = (front + 1) % MAXSIZE;
        return data[front];
    }

    public E peek() {
        if (this.empty()) {
            throw new IllegalArgumentException("Out of Index");
        }
        return data[front];
    }
}
