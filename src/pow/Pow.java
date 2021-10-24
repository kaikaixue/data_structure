package pow;

public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2,10));
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double p = pow(x, n / 2);
        if (n % 2 == 1) {
            return x * p * p;
        } else {
            return p * p;
        }
    }
}
