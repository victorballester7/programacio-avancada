package java_programs.src;

public class Complex {
  double real = 0, imag = 0;

  Complex(double r, double i) {
    real = r;
    imag = i;
  }

  void conjugat() {
    imag = -imag;
  }

  void print() {
    if (imag < 0)
      System.out.println(real + "" + imag + "i");
    else
      System.out.println(real + "+" + imag + "i");
  }

  void add(Complex c) {
    real += c.real;
    imag += c.imag;
  }
}