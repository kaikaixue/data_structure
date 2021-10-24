package PolyNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("abc.in"));
        Scanner input = new Scanner(System.in);
//        System.setOut(new PrintStream("abc.out"));
        PolyClass l1 = new PolyClass();
        PolyClass l2 = new PolyClass();
        PolyClass l3;
        double a[] = new double[100];
        int b[] = new int[100];
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = input.nextDouble();
        }
        for (int i = 0;i < n;i++) {
            b[i] = input.nextInt();
        }
        l1.createPoly(a,b,n);
        System.out.print("第一个多项式： ");
        l1.dispPloy();
        l1.sort();
        System.out.print("排序后： ");
        l1.dispPloy();
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = input.nextDouble();
        }
        for (int i = 0;i < n;i++) {
            b[i] = input.nextInt();
        }
        l2.createPoly(a,b,n);
        System.out.print("第一个多项式： ");
        l2.dispPloy();
        l2.sort();
        System.out.print("排序后： ");
        l2.dispPloy();
        l3 = PolyClass.add(l1,l2);
        System.out.print("相加后： ");
        l3.dispPloy();
    }
}
