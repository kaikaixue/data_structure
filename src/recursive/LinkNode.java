package recursive;

class LinkNode<E>        //单链表结点泛型类
{
    E data;
    LinkNode<E> next;        //下一个结点的指针

    public LinkNode()        //构造方法
    {
        next = null;
    }

    public LinkNode(E d)        //重载构造方法
    {
        data = d;
        next = null;
    }
}

