package BTree;

public class Test {
    public static void main(String[] args) {
        BTreeClass bTreeClass = new BTreeClass();
        bTreeClass.createBTree("A(B(D(,G)),C(E,F)");
        System.out.println(bTreeClass.toString());
    }
}
