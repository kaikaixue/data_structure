package Stack.SqStack;

public class SqStackClass<E> {
    final int initCapacity = 10;    // 初始容量
    private int capacity;   // 容量
    private int top;    // 栈顶
    private E data[];   // 元素数组

    public SqStackClass() {
        this.data = (E[])new Object[this.initCapacity];
        this.capacity = this.initCapacity;
        this.top = -1;
    }

    // 扩容
    private void updateCapacity(int newCapacity) {
        E newData[] = (E[])new Object[newCapacity];
        for(int i = 0;i < top;i++) {
            newData[i] = this.data[i];
        }
        this.capacity = newCapacity;
        this.data = newData;
    }

    // 判空
    public boolean empty() {
        return this.top == -1;
    }

    // 入栈
    public void push(E e) {
        if(this.top == this.capacity-1) {
            this.updateCapacity(this.capacity * 2);
        }
        this.data[++this.top] = e;
    }

    // 出栈
    public E pop() {
        if(this.empty()) {
            throw new IllegalArgumentException("栈空");
        }
        return this.data[this.top--];
    }

    // 查栈顶元素
    public E peek() {
        if(this.empty()) {
            throw new IllegalArgumentException("栈空");
        }
        return this.data[this.top];
    }

    // 出栈是否匹配
    public static boolean isSerial1(int b[]) {
        int i,j;
        int n = b.length;
        int a[] = new int[n];
        SqStackClass<Integer> st = new SqStackClass<>();
        for(i = 0;i < n;i++) {
            a[i] = i + 1;
        }
        i = 0;
        j = 0;
        while(i < n) {
            st.push(a[i]);
            System.out.println("元素" + a[i] + "入栈");
            i++;
            while(!st.empty() && st.peek() == b[j]) {
                Integer e = st.pop();
                System.out.println("元素" + e + "出栈");
                j++;
            }
        }
        return st.empty();
    }
}
