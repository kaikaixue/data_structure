package PolyElem;

public class PolyElem {
    double conf;    // 系数
    int exp;    // 指数

    public PolyElem(double conf,int exp) {
        this.conf = conf;
        this.exp = exp;
    }

    public int getExp() {
        return this.exp;
    }
}
