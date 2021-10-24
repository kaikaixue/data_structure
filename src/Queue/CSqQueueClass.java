package Queue;

public class CSqQueueClass <E>{
    final int MAXSIZE = 100;
    private E[] data;
    private int front,rear;

    public CSqQueueClass() {
        data = (E[])new Object[MAXSIZE];
        front = 0;
        rear = 0;
    }

    public boolean empty() {
        return front == rear;
    }

    public void push(E e) throws Exception {
        if ((rear + 1) % MAXSIZE == front) {
            throw new Exception("队满");
        }
        rear = (rear + 1) % MAXSIZE;
        data[rear] = e;
    }

    public E pop() throws Exception {
        if (empty()) {
            throw new Exception("队空");
        }
        front = (front + 1) % MAXSIZE;
        return data[front];
    }

    public E peek() throws Exception {
        if (empty()) {
            throw new Exception("队空");
        }
        return data[(front + 1) % MAXSIZE];
    }

    public int size() {
        return (rear - front + MAXSIZE) % MAXSIZE;
    }
}
