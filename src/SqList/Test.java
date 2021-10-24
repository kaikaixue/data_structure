package SqList;

public class Test {
    public static void main(String[] args) throws Exception {
        SqListClass<Integer> s1 = new SqListClass<>();
        s1.add(1);
        s1.add(3);
        s1.add(5);
        SqListClass<Integer> s2 = new SqListClass<>();
        s2.add(2);
        s2.add(4);
//        SqTools.Merge1(s1,s2);
//        System.out.println(SqTools.Reverse(s1));
        System.out.println(SqTools.Merge2(s1,s2));
        System.out.println(SqTools.Merge1(s1,s2));
//        System.out.println(s1.toString());
    }
}
