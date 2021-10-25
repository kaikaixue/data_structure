package BTree;

public class BTNode <E>{
    E data;
    BTNode<E> lChild;
    BTNode<E> rChild;

    public BTNode() {
        this.lChild = null;
        this.rChild = null;
    }

    public BTNode(E data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }
}
