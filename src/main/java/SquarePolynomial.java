import java.util.Objects;

public class SquarePolynomial {                 //Создайте maven-проект. В нем создайте класс для хранения квадратного трехчлена с

    private double a, b, c;                     //методом решения соответствующего квадратного уравнения (параметров нет,
                                                //результат — массив корней). Напишите набор unit-тестов для этого класса.
    public SquarePolynomial() {
        this.a = this.b = this.c = 0;
    }
    public SquarePolynomial(SquarePolynomial sp) {
        this.a = sp.a;
        this.b = sp.b;
        this.c = sp.c;
    }

    public SquarePolynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] findRoots() {
        if (a == 0) {
            if (b == 0) {
                return null;                                //c=0
            }
            if (c == 0) {
                return new double[] { 0 };                  //bx=0
            }
            return new double[] { -c / b };                 //bx+c=0
        }

        double d = Math.sqrt(b * b - 4 * a * c),
                x1 = (-b + d) / (2 * a), x2 = (-b - d) / (2 * a);
        if ((Double.compare(x1, 0.0) == 0 && Double.compare(x2, -0.0) == 0) ||
                (Double.compare(x1, -0.0) == 0 && Double.compare(x2, 0.0) == 0 )) {
            return new double[] { 0 };
        }
        if (Double.isNaN(x1) && Double.isNaN(x2)) {
            return new double[] { };
        }
        return new double[] {x1, x2};
    }

    @Override
    public String toString() {
        return String.format("SquarePolynomial{%fx^2, %fx, %f}", a, b, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquarePolynomial that = (SquarePolynomial) o;
        return Double.compare(that.a, a) == 0 &&
                Double.compare(that.b, b) == 0 &&
                Double.compare(that.c, c) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b, c);
    }
}
