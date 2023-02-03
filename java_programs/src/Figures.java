// package java_programs.src;

import java.util.ArrayList;

abstract class Figura { // No es poden crear objectes d'una classe abstracta.
  int x, y;

  public Figura(int x, int y) {
    this.x = x;
    this.y = y;
  }

  abstract double area();

}

class Rectangle extends Figura {
  int ample, alt;

  Rectangle(int x, int y, int ample, int alt) {
    super(x, y);
    this.ample = ample;
    this.alt = alt;
  }

  double area() {
    return ample * alt;
  }
}

class Cercle extends Figura {
  int radi;

  public Cercle(int x, int y, int radi) {
    super(x, y);
    this.radi = radi;
  }

  double area() {
    return Math.PI * radi * radi;
  }
}

public class Figures {
  public static void main(String[] args) {
    // Figura f[] = new Figura[3];
    ArrayList<Figura> f = new ArrayList<Figura>();
    f.add(new Rectangle(20, 20, 20, 30));
    f.add(new Cercle(40, 40, 3));
    f.add(new Cercle(60, 60, 5));
    for (int i = 0; i < f.size(); i++) {
      System.out.println(f.get(i).area());
    }

    for (Figura fig : f) {
      System.out.println(fig.area());
    }

    // f[0] = new Rectangle(20, 20, 20, 30);
    // f[1] = new Cercle(40, 40, 3);
    // f[2] = new Cercle(60, 60, 5);

    // for (int i = 0; i < f.length; i++) {
    // System.out.println(f[i].area());
    // }
  }
}

/*
 * public static void main(String[] args) {
 * Rectangle r[] = new Rectangle[3];
 * Cercle c[] = new Cercle[3];
 * r[0] = new Rectangle(20, 20, 20, 30);
 * c[0] = new Cercle(40, 40, 3);
 * 
 * for(int i=0;i<c.length;i++)
 * System.out.println(c[i].area());
 * }
 */