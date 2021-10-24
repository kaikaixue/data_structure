package LinkNode;

public class Test {
    public static void main(String[] args) {
        LinkListClass link1 = new LinkListClass();
        Integer a[] = {1,3,5};
        link1.createListR(a);
//        LinkListClass link2 = new LinkListClass();
//        Integer b[] = {2,4};
//        link2.createListR(b);
//        System.out.println(LinkTools.commnodes(link1,link2).toString());
//        LinkTools.merge1(link1,link2);
        System.out.println(LinkTools.sum(link1.head.next));
//        System.out.println(link1.toString());
    }
}
