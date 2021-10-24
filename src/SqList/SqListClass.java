package SqList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SqListClass<E> {
    final int initCapacity = 10;    // 顺序表的初始容量
    private E[] data;   // 存放顺序表的数据
    private int size;   // 存放顺序表的长度
    private int capacity;   // 存放顺序表的容量

    public SqListClass() {
        data = (E[]) new Object[initCapacity];
        this.capacity = this.initCapacity;
        this.size = 0;
    }

    public void createList(E[] a) {
        int k = 0;
        for(int i = 0;i < a.length;i++) {
            if(this.size == this.capacity) {
                updateCapacity(2 * this.size);
            }
            data[k++] = a[i];
        }
        this.size = k;
    }

    public void updateCapacity(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0;i < this.size;i++) {
            newData[i] = this.data[i];
        }
        this.capacity = newCapacity;
        this.data = newData;
    }

    public void add(E e) {
        if (this.size == this.capacity) {
            this.updateCapacity(this.capacity * 2);
        }
        this.data[size++] = e;
    }

    public int size() {
        return this.size;
    }

    public void setSize(int len) {
        this.size = len;
    }

    public E GetElem(int i) throws Exception {
        if (i < 0 || i >= size) {
            throw new Exception("Out of index");
        } else {
            return data[i];
        }
    }

    public void setElem(int i,E e) throws Exception {
        if (i < 0 || i >= capacity) {
            throw new Exception("Out of index");
        } else {
            this.data[i] = e;
        }
    }

    public int GetNo(E e) {
        for(int i =0; i < size;i++) {
            if(this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void swap(int i,int j) {
        E e = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = e;
    }

    public void insert(int i,E e) throws Exception{
        if(i < 0 || i >= size) {
            throw new Exception("Out of index");
        }
        if(this.size == this.size) {
            this.updateCapacity(2 * this.size);
        }
        for(int j = this.size;j > i;j--) {
            this.data[j] = this.data[j-1];
        }
        this.data[i] = e;
    }

    public void delete(int i) throws Exception{
        if(i < 0 || i >= capacity) {
            throw new Exception("Out of index");
        }
        for(int j = i;j < this.size;j++) {
            this.data[j] = this.data[j + 1];
        }
    }

    @Override
    public String toString() {
        String re = "";
        for(int i = 0;i < this.size;i++) {
            try {
                System.out.print(this.GetElem(i) + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return re;
    }
}
