class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        return divide(x, n);
    }

    private double divide(double x, int n) {
        if(n == 0) {
            return 1.0d;
        }
        double a = divide(x, n / 2);
        return (n & 1) == 0 ? a * a : a * a * x;
    }
}