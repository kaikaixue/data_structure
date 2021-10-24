package LinkString;

public class Test {
    public static void main(String[] args) {
        LinkStringClass l1 = new LinkStringClass();
        l1.createListR("abe");
        LinkStringClass l2 = new LinkStringClass();
        l2.createListR("cd");
        LinkStringClass l3 = l1.insStr(2,l2);
        System.out.println(l3.toString());
    }
}
