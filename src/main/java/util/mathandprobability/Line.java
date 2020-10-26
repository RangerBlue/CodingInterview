package util.mathandprobability;

public class Line {
    public static double epsilon = 0.000001;
    public double A;
    public double B;

    public Line(double a, double b) {
        A = a;
        B = b;
    }

    public boolean isIntersected(Line line1){
        return Math.abs(line1.A - this.A) > epsilon ||
                Math.abs(line1.B - this.B) < epsilon ;
    }
}
