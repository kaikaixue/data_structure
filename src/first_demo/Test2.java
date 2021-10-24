package first_demo;

public class Test2 {
    public static void main(String[] args) {
        Student2 head;			//学生单链表开始结点
        Student2 p1,p2,p3,p4,p5,p6,p7;
        p1=new Student2();
        p1.num=2018001; p1.name="王华"; p1.score=90;
        p2=new Student2();
        p2.num=2018010; p2.name="刘丽"; p2.score=62;
        p3=new Student2();
        p3.num=2018006; p3.name="陈明"; p3.score=54;
        p4=new Student2();
        p4.num=2018009; p4.name="张强"; p4.score=95;
        p5=new Student2();
        p5.num=2018007; p5.name="许兵"; p5.score=76;
        p6=new Student2();
        p6.num=2018012; p6.name="李萍"; p6.score=88;
        p7=new Student2();
        p7.num=2018005; p7.name="李英"; p7.score=82;

        head=p1;		//开始结点用head标识
        p1.next=p2;		//建立结点之间的关系
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        p6.next=p7;
        p7.next=null;
    }
}
