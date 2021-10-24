package Complex;

import java.util.Scanner;

public class Test {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入第一个复数的实部和虚部：");
        int real = input.nextInt();
        int imag = input.nextInt();
        System.out.println();
        Complex c1 = new Complex(real,imag);
        System.out.print("请输入第二个复数的实部和虚部：");
        real = input.nextInt();
        imag = input.nextInt();
        Complex c2 = new Complex(real,imag);
        System.out.println();
        c1.add(c2);
        System.out.println(c1.toString());
//        Complex c1 = new Complex(1,1);
//        Complex c2 = new Complex(2,2);
//        c1.add(c2);
//        System.out.println(c1.toString());
//        c1.sub(c2);
//        System.out.println(c1.toString());
//        c1.mul(c2);
//        System.out.println(c1.toString());
//        c1.div(c2);
//        System.out.println(c1.toString());
    }
}
