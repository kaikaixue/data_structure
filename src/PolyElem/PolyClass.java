package PolyElem;

import java.util.ArrayList;
import java.util.Comparator;

public class PolyClass {
    ArrayList<PolyElem> poly;

    public PolyClass() {
        poly = new ArrayList<>();
    }

    // 末尾添加元素
    public void add(PolyElem p) {
        poly.add(p);
    }

    // 创建多项式顺序表
    public void createPoly(double a[],int b[],int n) {
        for(int i = 0;i < n;i++) {
            poly.add(new PolyElem(a[i],b[i]));
        }
    }

    // 排序
    public void sort() {
        poly.sort(Comparator.comparing(PolyElem::getExp).reversed());
    }

    // 输出
    public void dispPoly() {
        boolean first = true;
        for(int i = 0;i < poly.size();i++) {
            PolyElem p = poly.get(i);
            if(first) {
                first = false;
            } else if(p.conf > 0) {
                System.out.print("+");
            }
            if(p.exp == 0) {
                System.out.print(p.conf);
            } else if(p.exp == 1) {
                System.out.print(p.conf + "x");
            } else {
                System.out.print(p.conf + "x" + p.exp);
            }
        }
        System.out.println();
    }

    // add
    public static PolyClass add(PolyClass l1,PolyClass l2) {
        int i = 0;
        int j = 0;
        PolyClass l3 = new PolyClass();
        while(i < l1.poly.size() && j < l2.poly.size()) {
            if(l1.poly.get(i).exp > l2.poly.get(j).exp) {
                l3.add(new PolyElem(l1.poly.get(i).conf,l1.poly.get(i).exp));
                i++;
            } else if(l1.poly.get(i).exp < l2.poly.get(j).exp) {
                l3.add(new PolyElem(l2.poly.get(j).conf,l2.poly.get(j).exp));
                j++;
            } else {
                if((l1.poly.get(i).conf + l2.poly.get(j).conf) != 0) {
                    l3.add(new PolyElem(l1.poly.get(i).conf + l2.poly.get(j).conf,l1.poly.get(i).exp));
                }
                i++;
                j++;
            }
        }
        while(i < l1.poly.size()) {
            l3.add(new PolyElem(l1.poly.get(i).conf,l1.poly.get(i).exp));
            i++;
        }
        while(j < l2.poly.size()) {
            l3.add(new PolyElem(l2.poly.get(j).conf,l2.poly.get(j).exp));
            j++;
        }
        return l3;
    }
}
