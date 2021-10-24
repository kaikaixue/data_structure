package Complex;

public class Complex {
    // 实部
    private float real;
    // 虚部
    private float imag;

    // 无参构造
    public Complex () {
        this.real = 0;
        this.imag = 0;
    }

    // 有参构造
    public Complex (float real,float imag) {
        this.real = real;
        this.imag = imag;
    }

    // 加法
    public Complex add (Complex c) {
        this.real += c.real;
        this.imag += c.imag;
        return this;
    }

    // 减法
    public Complex sub (Complex c) {
        this.real -= c.real;
        this.imag -= c.imag;
        return this;
    }

    // 乘法
    public Complex mul (Complex c) {
        this.real = this.real * c.real - this.imag * c.imag;
        this.imag = this.imag * c.real + this.real * c.imag;
        return this;
    }

    // 除法
    public Complex div (Complex c) {
//        double x = Math.pow(c.real,2) + Math.pow(c.imag,2);
        float x = c.real * c.real + c.imag * c.imag;
        this.real = (this.real * c.real + this.imag * c.imag) / x;
        this.imag = (this.imag * c.real - this.real * c.imag) / x;
        return this;
    }

    @Override
    public String toString () {
        return "新的复数是" + this.real + '+' + this.imag + 'i';
    }
}
